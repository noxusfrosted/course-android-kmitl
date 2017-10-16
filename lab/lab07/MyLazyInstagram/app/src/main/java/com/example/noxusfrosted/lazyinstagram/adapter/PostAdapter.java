package com.example.noxusfrosted.lazyinstagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.noxusfrosted.lazyinstagram.R;
import com.example.noxusfrosted.lazyinstagram.model.PostModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noxusfrosted on 10/10/2017.
 */

class Holder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView textLike;
    public TextView textComment;


    public Holder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        textLike = itemView.findViewById(R.id.textLike);
        textComment = itemView.findViewById(R.id.textComment);


    }
}

public class PostAdapter  extends RecyclerView.Adapter<Holder> {

    private Activity activity;
    private List<PostModel> data;
    private String layoutType;

    public PostAdapter(Activity activity) {
        this.activity = activity;
        data = new ArrayList<>();
    }

    public void setData(List<PostModel> data) {
        this.data = data;
    }


    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (layoutType.equals("grid")) {
            view = inflater.inflate(R.layout.grid_item, null, false);
            Holder holder = new Holder(view);
            return holder;
        } else {
            view = inflater.inflate(R.layout.list_item, null, false);
            Holder holder = new Holder(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String imageUrl = data.get(position).getUrl();
        Glide.with(activity).load(imageUrl).into(holder.image);
        holder.textLike.setText("Like : " + Integer.toString(data.get(position).getLike()));
        holder.textComment.setText("Comment : " + Integer.toString(data.get(position).getComment()));
    }
    @Override

    public int getItemCount() {
        return data.size();
    }


}
