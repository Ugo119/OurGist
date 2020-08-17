package com.example.ourgist.adapter.entertainment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgist.R;
import com.example.ourgist.model.entertainment.EntertainmentNews;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EntertainmentAdapter extends RecyclerView.Adapter<EntertainmentAdapter.EntertainmentViewHolder> {
    Context mContext;
    private static EntertainmentAdapter.ClickListener clickListener;

    public static class EntertainmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ConstraintLayout newsLayout;
        public TextView newsTitle;
        public TextView date;
        public TextView author;
        public ImageView newsImage;

        public EntertainmentViewHolder(@NonNull View itemView) {
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
    public void setOnItemClickListener(EntertainmentAdapter.ClickListener clickListener) {
        EntertainmentAdapter.clickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public List<EntertainmentNews> entertainmentNews;


    public EntertainmentAdapter(Context mContext, List<EntertainmentNews> entertainmentNews) {
        this.mContext = mContext;
        this.entertainmentNews = entertainmentNews;
    }
    @NonNull
    @Override
    public EntertainmentAdapter.EntertainmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newsView = inflater.inflate(R.layout.list_item_news,parent, false);
//        View view = LayoutInflater.from(parent.getContext()).inflate(
//                R.layout.list_item_news, parent, false);
        return new EntertainmentViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull EntertainmentAdapter.EntertainmentViewHolder holder, int position) {
        final EntertainmentNews news = entertainmentNews.get(position);

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

    }

    @Override
    public int getItemCount() {
        return entertainmentNews.size();
    }
}
