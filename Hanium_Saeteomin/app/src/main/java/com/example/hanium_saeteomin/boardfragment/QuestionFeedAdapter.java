package com.example.hanium_saeteomin.boardfragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hanium_saeteomin.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuestionFeedAdapter extends BaseAdapter {
    private  ArrayList<FeedData> questionFeedDataList = new ArrayList<FeedData>();
    TimeConverter timeConverter = new TimeConverter();

    public QuestionFeedAdapter(){

    }

    @Override
    public int getCount() {
        return questionFeedDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionFeedDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public ArrayList<FeedData> getQuestionFeedDataList() {
        return questionFeedDataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.question_all_feed_layout, parent, false);
        }

        ImageView imgProfile = (ImageView)convertView.findViewById(R.id.profileImg);
        TextView userName = (TextView)convertView.findViewById(R.id.name);
        TextView timeLine = (TextView)convertView.findViewById(R.id.timeline);
        TextView tvContent = (TextView)convertView.findViewById(R.id.question);
        TextView likeCount = (TextView)convertView.findViewById(R.id.favorite);
        TextView commentCount = (TextView)convertView.findViewById(R.id.chatNum);

        FeedData questionFeedData = questionFeedDataList.get(position);

        imgProfile.setBackground(new ShapeDrawable(new OvalShape()));
        imgProfile.setClipToOutline(true);

        Glide.with(context).load(questionFeedData.getImg_url()).into(imgProfile);
        userName.setText(questionFeedData.getUser_name());
        timeLine.setText(timeConverter.toFormat(questionFeedData.getWrite_date()));
        tvContent.setText(questionFeedData.getContent());
        likeCount.setText(String.valueOf(questionFeedData.getGood_count()));
        commentCount.setText(String.valueOf(questionFeedData.getComment_number()));

        return convertView;
    }

//    public void addItem(String profile_img, String name, String timeline, String question, int favorite, int chatnum){
//        FeedData questionFeedData = new FeedData();
//
//        questionFeedData.setImg_url(profile_img);
//        questionFeedData.setUser_name(name);
//        questionFeedData.setWrite_date(timeline);
//        questionFeedData.setContent(question);
//        questionFeedData.setGood_count(favorite);
//        questionFeedData.setComment_number(chatnum);
//
//        questionFeedDataList.add(questionFeedData);
//    }

        public void addItem(ArrayList<FeedData> FeedList){
//        FeedData questionFeedData = new FeedData();

//        questionFeedData.setImg_url(profile_img);
//        questionFeedData.setUser_name(name);
//        questionFeedData.setWrite_date(timeline);
//        questionFeedData.setContent(question);
//        questionFeedData.setGood_count(favorite);
//        questionFeedData.setComment_number(chatnum);

        questionFeedDataList = FeedList;
    }
}
