
package com.example.abhishekkoranne.engineersbook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishekkoranne.engineersbook.Activity.ApprovalActivity;
import com.example.abhishekkoranne.engineersbook.Activity.ArticleActivity;
import com.example.abhishekkoranne.engineersbook.Activity.ProfileActivity;
import com.example.abhishekkoranne.engineersbook.Fragment.ArticlesFragment;
import com.example.abhishekkoranne.engineersbook.R;
import com.example.abhishekkoranne.engineersbook.model.Article;
import com.google.gson.JsonElement;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abhishek Koranne on 26-11-2017.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {
    Context cont;
    /*String[] user_name;
    String[] time_stamp;
    String[] text_post;
    String[] no_of_comments;
    String[] no_of_shares;
    int[] images;*/

    Object[] no_of_comments;
    ArrayList<Article> articleList = new ArrayList<>();
    DisplayImageOptions options;
    ImageLoader imgloader;
    static int i,j=0;


    public ArticlesAdapter(Context cont, ArrayList<Article> articleList, Object no_of_comments,int size) {
        this.cont = cont;
        /*this.images = images;
        this.user_name = user_name;
        this.time_stamp = time_stamp;
        this.no_of_comments = no_of_comments;
        this.no_of_shares = no_of_shares;
        this.text_post = text_data;*/
        this.articleList = articleList;
        this.no_of_comments=new Object[size];
        this.no_of_comments[i] = no_of_comments;
        Log.d("error","he"+this.no_of_comments[i]);
        i++;
        options = new DisplayImageOptions.Builder().build();
        imgloader = ImageLoader.getInstance();
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(cont);
        View myView = myInflater.inflate(R.layout.articles_item, parent, false);
        return new ArticlesViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(final ArticlesViewHolder holder, final int position) {
        /*holder.profile_pic.setImageResource(images[position]);
        holder.image_post.setImageResource(images[position]);
        holder.user_name.setText(user_name[position]);
        holder.timestamp.setText(time_stamp[position]);
        holder.text_post.setText(text_post[position]);
        holder.no_of_comments.setText(no_of_comments[position]);
        holder.no_of_shares.setText(no_of_shares[position]);*/

        //     String userName = articleList.get(position).getUser().getFirstName().toString() + " " + articleList.get(position).getUser().getLastName().toString();
        /*Date date=new Date(articleList.get(position).getTime());
        SimpleDateFormat dateFormat=new SimpleDateFormat();*/

        Date date = new Date(articleList.get(position).getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);


        imgloader.displayImage("http://dl.glitter-graphics.com/pub/844/844251efzrltedz0.gif", holder.profile_pic, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        imgloader.displayImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRB_tFJKizaWI-ABoGZmkAIU6x3IEJqAu-Tve8JaUF3mq1gIwTOQw", holder.image_post, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        holder.user_name.setText(articleList.get(position).getUser().getFirstName().toString() + " " + articleList.get(position).getUser().getLastName().toString());
        holder.timestamp.setText(strDate);
        int midOfTextPost = articleList.get(position).getArticle_text_post().length() / 2;
        holder.text_post.setText("" + articleList.get(position).getArticle_text_post().substring(0, midOfTextPost) + " ...see more");


        // JsonElement[] elements=new JsonElement[arr1.];
 /*       String noOfComments=""+no_of_comments[j];
        int dot=noOfComments.indexOf('.');
        noOfComments=noOfComments.substring(0,dot);
 */     //  j++;


        holder.no_of_comments.setText("" +no_of_comments[j] + " comments");
        j++;

        holder.no_of_likes.setText("" + articleList.get(position).getLikes() + " likes");

        holder.button_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout_article_item.performClick();
            }
        });

        holder.button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.layout_article_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(cont, ArticleActivity.class);
                ii.putExtra("article_object", articleList.get(position));
                cont.startActivity(ii);
            }
        });
        holder.profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.startActivity(new Intent(cont, ProfileActivity.class));
            }
        });

        holder.user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont.startActivity(new Intent(cont, ProfileActivity.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {
        ImageView profile_pic, image_post;
        TextView user_name, timestamp, text_post, no_of_comments, no_of_likes;
        Button button_comment, button_share;
        LinearLayout layout_article_item;

        public ArticlesViewHolder(View itemView) {
            super(itemView);
            layout_article_item = (LinearLayout) itemView.findViewById(R.id.layout_article_item);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            profile_pic = (ImageView) itemView.findViewById(R.id.profile_pic);
            image_post = (ImageView) itemView.findViewById(R.id.image_post);
            text_post = (TextView) itemView.findViewById(R.id.text_post);
            no_of_comments = (TextView) itemView.findViewById(R.id.no_of_comments);
            no_of_likes = (TextView) itemView.findViewById(R.id.no_of_likes);
            button_comment = (Button) itemView.findViewById(R.id.button_comment);
            button_share = (Button) itemView.findViewById(R.id.button_share);
        }
    }
}
