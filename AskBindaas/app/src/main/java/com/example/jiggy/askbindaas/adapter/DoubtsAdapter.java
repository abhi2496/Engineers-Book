package com.example.jiggy.askbindaas.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiggy.askbindaas.R;
import com.example.jiggy.askbindaas.activity.DoubtsQuestionActivity;
import com.example.jiggy.askbindaas.activity.ProfileActivity;
import com.example.jiggy.askbindaas.model.Doubt;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jiggy on 06-12-2017.
 */

public class DoubtsAdapter extends RecyclerView.Adapter<DoubtsAdapter.DoubtsViewHolder> {

    Context cont;

    ArrayList<Doubt> doubtList = new ArrayList<>();
    DisplayImageOptions options;
    ImageLoader imgloader;

    public DoubtsAdapter(Context cont, ArrayList<Doubt> doubtList) {
        this.cont = cont;
        this.doubtList = doubtList;
        options = new DisplayImageOptions.Builder().build();
        imgloader = ImageLoader.getInstance();
    }

    @Override
    public DoubtsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(cont);
        View myView = myInflater.inflate(R.layout.doubts_item, parent, false);
        return new DoubtsViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(final DoubtsAdapter.DoubtsViewHolder holder, final int position) {

        final Date date = new Date(doubtList.get(position).getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);

        imgloader.displayImage("https://goo.gl/images/4BDHri", holder.profile_pic, new ImageLoadingListener() {
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


        holder.user_name.setText(doubtList.get(position).getUser().getFirstName().toString() + " " + doubtList.get(position).getUser().getLastName().toString());
        holder.timestamp.setText(strDate);

        holder.no_of_upvotes.setText("" + doubtList.get(position).getUpVote());
        holder.no_of_answers.setText("" + doubtList.get(position).getAnswerList().size());
        holder.no_of_downvotes.setText("" + doubtList.get(position).getDownVote());
        holder.doubt_question.setText(doubtList.get(position).getDoubt());


        String doubtTags = "";
        final ArrayList<String> doubtTagsList = doubtList.get(position).getDoubtTagsList();
        for (int i = 0, n = doubtTagsList.size(); i < n; i++) {
            doubtTags = doubtTags.concat(doubtTagsList.get(i) + "   ");
        }

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

        holder.doubt_question_tag.setText(doubtTags);
        holder.layout_doubt_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(cont, DoubtsQuestionActivity.class);
                ii.putExtra("doubt_object", doubtList.get(position));
                cont.startActivity(ii);
            }
        });

    }

    @Override
    public int getItemCount() {
        return doubtList.size();
    }

    public class DoubtsViewHolder extends RecyclerView.ViewHolder/* implements View.OnClickListener*/ {

        /*Context context;*/
        LinearLayout layout_doubt_item;
        ImageView profile_pic;
        TextView user_name, no_of_upvotes, no_of_downvotes, no_of_answers, doubt_question, doubt_question_tag, timestamp;


        public DoubtsViewHolder(View itemView) {
            super(itemView);
            layout_doubt_item = (LinearLayout) itemView.findViewById(R.id.layout_doubt_item);
            profile_pic = (ImageView) itemView.findViewById(R.id.profile_pic);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            no_of_upvotes = (TextView) itemView.findViewById(R.id.no_of_upvotes);
            no_of_downvotes = (TextView) itemView.findViewById(R.id.no_of_downvotes);
            no_of_answers = (TextView) itemView.findViewById(R.id.no_of_answers);
            doubt_question = (TextView) itemView.findViewById(R.id.doubt_question);
            doubt_question_tag = (TextView) itemView.findViewById(R.id.doubt_question_tag);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);

/*            context=itemView.getContext();
            itemView.setOnClickListener(this);*/
        }

     /*   @Override
        public void onClick(View v) {
            Intent ii=new Intent(context, DoubtsQuestionActivity.class);
            Bundle extras=new Bundle();
            extras.putString("no_of_upvotes",no_of_upvotes.getText().toString());
            extras.putString("doubt_question",doubt_question.getText().toString());
            extras.putString("doubt_question_tag",doubt_question_tag.getText().toString());
            ii.putExtras(extras);
            context.startActivity(ii);
        }*/
    }
}
