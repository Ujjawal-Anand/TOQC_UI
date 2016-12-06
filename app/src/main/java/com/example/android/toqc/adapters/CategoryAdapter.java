package com.example.android.toqc.adapters;

/**
 * Created by ujjawal on 6/12/16.
 */

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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private Activity mActivity;
    private String mPackageName;
//    private Resources mResources;
//    private final LayoutInflater mLayoutInflater;
    private List<ShowCategory> categoryList;
    private OnItemClickListener mOnItemClickListener;

    public CategoryAdapter(Activity activity) {
        mActivity = activity;
//        mResources = mActivity.getResources();
        mPackageName = mActivity.getPackageName();
//        mLayoutInflater = LayoutInflater.from(activity.getApplicationContext());
//        updateCategories(activity);
    }

     public interface OnItemClickListener {
        void onClick(View view, int position);
    }


    public CategoryAdapter(Context mContext,List<ShowCategory> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;

    }


     @Override
     public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ShowCategory category = categoryList.get(position);
        holder.text.setText(category.getText());
        holder.text.setBackgroundResource(category.getTextBackground());
        holder.thumbnail.setImageBitmap(null);
        holder.thumbnail.setBackgroundResource(category.getImageBackground());
//        Picasso.with(holder.image.getContext()).load(item.getImage()).into(holder.image);
        Glide.with(mContext).load(category.getThumbnail()).into(holder.thumbnail);
        holder.itemView.setTag(category);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(v, holder.getAdapterPosition());
            }
        });
    }
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public ShowCategory getItem(int position) {
        return categoryList.get(position);
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

     public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }



    }

