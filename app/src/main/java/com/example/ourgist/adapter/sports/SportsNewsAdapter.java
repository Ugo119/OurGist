package com.example.ourgist.adapter.sports;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgist.R;
import com.example.ourgist.model.sports.SportsNews;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SportsNewsAdapter extends RecyclerView.Adapter<SportsNewsAdapter.NewsViewHolder> {
    public static final String TAG = "com.ugo.ErrorCheck";
    Context mContext;
    private static ClickListener clickListener;
    //public static final String IMAGE_URL_BASE_PATH = RetrofitFactory.getImageUrlBasePath();

    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ConstraintLayout newsLayout;
        public TextView newsTitle;
        public TextView date;
        public TextView author;
        public ImageView newsImage;

        public NewsViewHolder(View itemView) {
            super(itemView);

            newsLayout = itemView.findViewById(R.id.news_layout);
            newsImage = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            author = itemView.findViewById(R.id.author);
            itemView.setOnClickListener(this);

        }

        private String getFormattedDate(Date date) {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d, yy", Locale.UK);
            return formatter.format(date);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

   }

    public void setOnItemClickListener(ClickListener clickListener) {
        SportsNewsAdapter.clickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public List<SportsNews> mNews;


    public SportsNewsAdapter(Context mContext, List<SportsNews> mNews) {
        this.mContext = mContext;
        this.mNews = mNews;

    }



    @NotNull
    @Override
    public SportsNewsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        final View newsView = inflater.inflate(R.layout.list_item_news,parent, false);

//        View view = LayoutInflater.from(parent.getContext()).inflate(
//                R.layout.list_item_news, parent, false);
        return new NewsViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(SportsNewsAdapter.NewsViewHolder holder, final int position) {
        final SportsNews news = mNews.get(position);

       //String image_url =  mNews.get(position).getUrlToImage();
       // String image_url =  news.getUrlToImage();

        Picasso.get()
                .load(news.getUrlToImage())
                .centerCrop()
                .resize(63,58)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.newsImage);

        holder.newsTitle.setText(news.getTitle());
        holder.date.setText(holder.getFormattedDate(news.getPublishedAt()));
        holder.author.setText(news.getAuthor());
        //holder.bind(news);


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mNews.size());
        return mNews.size();
        //return mNews == null ? 0 : mNews.size();

    }
}
