package com.dragonize.opendating.vh.main;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dragonize.opendating.R;

public class Profile extends RecyclerView.ViewHolder {

    public ImageView profile_picture;
    public RelativeLayout profile_detail_layout;
    public TextView question, answer;
    public int price;

    public Profile(View view) {
        super(view);

        profile_picture = view.findViewById(R.id.id_profile_picture);
        profile_detail_layout = view.findViewById(R.id.id_profile_detail_layout);
//        question = view.findViewById(R.id.id_question);
//        answer = view.findViewById(R.id.id_answer);
    }
}