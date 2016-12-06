package com.example.android.toqc.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.toqc.R;
import com.example.android.toqc.models.ShowCategory;

import java.util.List;

/**
 * Created by ujjawal on 3/12/16.
 */

public class ShowCategoryAdapter extends RecyclerView.Adapter<ShowCategoryAdapter.MyViewHolder> {

    private Context mContext;
    private Activity mActivity;
    private String mPackageName;
//    private Resources mResources;
//    private final LayoutInflater mLayoutInflater;
    private List<ShowCategory> categoryList;
    private OnItemClickListener mOnItemClickListener;

    public ShowCategoryAdapter(Activity activity) {
        mActivity = activity;
//        mResources = mActivity.getResources();
        mPackageName = mActivity.getPackageName();
//        mLayoutInflater = LayoutInflater.from(activity.getApplicationContext());
//        updateCategories(activity);
    }

     public interface OnItemClickListener {
        void onClick(View view, int position);
    }


    public ShowCategoryAdapter(Context mContext,List<ShowCategory> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

     @Override
     public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(v, );
            }
        }

        );
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShowCategory category = categoryList.get(position);
        holder.text.setText(category.getText());
        holder.text.setBackgroundResource(category.getTextBackground());
        holder.thumbnail.setImageBitmap(null);
        holder.thumbnail.setBackgroundResource(category.getImageBackground());
//        Picasso.with(holder.image.getContext()).load(item.getImage()).into(holder.image);
        Glide.with(mContext).load(category.getThumbnail()).into(holder.thumbnail);
        holder.itemView.setTag(category);
    }
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public ShowCategory getItem(int position) {
        return categoryList.get(position);
    }


    @Override
    public void onClick(final View v) {
        onItemClickListener.onItemClick(v, (ShowCategory) v.getTag());
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);

        }
    }

        public interface OnItemClickListener {

        void onItemClick(View view, ShowCategory showCategory);

    }


}
