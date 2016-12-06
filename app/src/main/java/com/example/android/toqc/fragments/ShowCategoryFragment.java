package com.example.android.toqc.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.toqc.R;
import com.example.android.toqc.adapters.CategoryAdapter;
import com.example.android.toqc.helpers.TransitionHelper;
import com.example.android.toqc.models.ShowCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjawal on 3/12/16.
 */

public class ShowCategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ShowCategory> categoryList;
    private View rootview;
    private CategoryAdapter mAdapter;

    public ShowCategoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_show_category, container, false);

        categoryList = new ArrayList<>();
        mAdapter = new CategoryAdapter(getContext(), categoryList);

        initRecyclerView();
        prepareCategory();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            setRecyclerAdapter(recyclerView);
        }
        else {
            setRecyclerAdapter(recyclerView);
            recyclerView.scheduleLayoutAnimation();
        }
        return rootview;

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) rootview.findViewById(R.id.categories);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }

    private void setRecyclerAdapter(RecyclerView recyclerView) {
        mAdapter = new CategoryAdapter(getContext(), categoryList);
        mAdapter.setOnItemClickListener(
                new CategoryAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(View v, int position) {
                        Activity activity = getActivity();
                        startQuizActivityWithTransition(activity,
                                v.findViewById(R.id.title),
                                mAdapter.getItem(position));
                    }
                });
        recyclerView.setAdapter(mAdapter);
    }

      private void startQuizActivityWithTransition(Activity activity, View toolbar,
                                                 ShowCategory category) {
    
    }



    private void prepareCategory() {
        int[] covers = new int[]{
                R.drawable.icon_category_leaderboard_raster,
                R.drawable.icon_category_science_raster,
                R.drawable.icon_category_history_raster,
                R.drawable.icon_category_geography_raster,
                R.drawable.icon_category_sports_raster,
                R.drawable.icon_category_music_raster,
                R.drawable.icon_category_entertainment_raster,
                R.drawable.icon_category_tvmovies_raster,
                R.drawable.icon_category_food_raster,
                R.drawable.icon_category_knowledge_raster,
        };

        int[] imageBackgrounds = new int[] {
                R.color.colorOrangeLight,
                R.color.colorGreenLight,
                R.color.colorBlueLight,
                R.color.colorYellowLight,
                R.color.colorPurpleLight,
                R.color.colorPinkLight,
                R.color.colorOrangeLight,
                R.color.colorGreenLight,
                R.color.colorGreenLight,
                R.color.colorBlueLight
        };

        int[] textBackgrounds = new int[] {
                R.color.colorOrangeDark,
                R.color.colorGreenDark,
                R.color.colorBlueDark,
                R.color.colorYellowDark,
                R.color.colorPurpleDark,
                R.color.colorPinkDark,
                R.color.colorOrangeDark,
                R.color.colorGreenDark,
                R.color.colorGreenDark,
                R.color.colorBlueDark
        };
        ShowCategory a = new ShowCategory("TOQC Live", imageBackgrounds[0], textBackgrounds[0], covers[0]);
        categoryList.add(a);

        a = new ShowCategory("Science", imageBackgrounds[1], textBackgrounds[1], covers[1]);
        categoryList.add(a);

        a = new ShowCategory("History", imageBackgrounds[2], textBackgrounds[2],covers[2]);
        categoryList.add(a);

        a = new ShowCategory("Geography",  imageBackgrounds[3], textBackgrounds[3], covers[3]);
        categoryList.add(a);


        a = new ShowCategory("Sports", imageBackgrounds[4], textBackgrounds[4],  covers[4]);
        categoryList.add(a);

        a = new ShowCategory("Music", imageBackgrounds[5], textBackgrounds[5], covers[5]);
        categoryList.add(a);

        a = new ShowCategory("Entertainment", imageBackgrounds[6], textBackgrounds[6], covers[6]);
        categoryList.add(a);

        a = new ShowCategory("Movies", imageBackgrounds[7], textBackgrounds[7], covers[7]);
        categoryList.add(a);

        a = new ShowCategory("Food", imageBackgrounds[8], textBackgrounds[8], covers[8]);
        categoryList.add(a);

        a = new ShowCategory("Random", imageBackgrounds[9], textBackgrounds[9], covers[9]);
        categoryList.add(a);

        mAdapter.notifyDataSetChanged();
    }
}
