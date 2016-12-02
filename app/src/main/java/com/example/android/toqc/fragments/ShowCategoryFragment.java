package com.example.android.toqc.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.toqc.R;
import com.example.android.toqc.adapters.ShowCategoryAdapter;
import com.example.android.toqc.models.ShowCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjawal on 3/12/16.
 */

public class ShowCategoryFragment extends Fragment implements ShowCategoryAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private List<ShowCategory> categoryList;
    private View rootview;
    private ShowCategoryAdapter adapter;

    public ShowCategoryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_show_category, container, false);

        categoryList = new ArrayList<>();
        adapter = new ShowCategoryAdapter(getContext(), categoryList);

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
        recyclerView = (RecyclerView) rootview.findViewById(R.id.show_category_recycler_fragment);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }

    private void setRecyclerAdapter(RecyclerView recyclerView) {
        ShowCategoryAdapter adapter = new ShowCategoryAdapter(getContext(), categoryList);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void prepareCategory() {
        int[] covers = new int[]{
                R.drawable.icon_category_history_raster,
                R.drawable.icon_category_geography_raster,
                R.drawable.icon_category_science_raster,
                R.drawable.icon_category_sports_raster,
                R.drawable.icon_category_music_raster,
                R.drawable.icon_category_entertainment_raster,
                R.drawable.icon_category_tvmovies_raster,
                R.drawable.icon_category_food_raster,
                R.drawable.icon_category_leaderboard_raster,
                R.drawable.icon_category_knowledge_raster,
                };

        ShowCategory a = new ShowCategory("History", covers[0]);
        categoryList.add(a);

        a = new ShowCategory("Geography",covers[1]);
        categoryList.add(a);

        a = new ShowCategory("Science",covers[2]);
        categoryList.add(a);

        a = new ShowCategory("Sports", covers[3]);
        categoryList.add(a);

        a = new ShowCategory("Music",covers[4]);
        categoryList.add(a);

        a = new ShowCategory("Entertainment",covers[5]);
        categoryList.add(a);

        a = new ShowCategory("Movies",covers[6]);
        categoryList.add(a);

        a = new ShowCategory("Food",covers[7]);
        categoryList.add(a);

        a = new ShowCategory("Leaderboard",covers[8]);
        categoryList.add(a);

        a = new ShowCategory("Knowledge",covers[9]);
        categoryList.add(a);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, ShowCategory showCategory) {
//        DetailActivity.navigate(this, view.findViewById(R.id.image), showCategory);
    }




}
