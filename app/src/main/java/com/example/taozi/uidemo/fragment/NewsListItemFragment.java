package com.example.taozi.uidemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taozi.uidemo.R;
import com.example.taozi.uidemo.adapter.MyRecycleAdapter;
import com.example.taozi.uidemo.util.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taozi on 2016/5/31.
 */
public class NewsListItemFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<String> mDatas;
    private RecyclerView mRecyclerView;
    private MyRecycleAdapter myRecycleAdapter;
    private SwipeRefreshLayout mSwipeRefresh;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newslist_content,container,false);
        initData(view);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setColorSchemeResources(R.color.red,R.color.blue,R.color.yellow,R.color.green);
        mSwipeRefresh.setOnRefreshListener(this);
        return view;
    }

    protected void initData(View view) {
        mDatas = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            mDatas.add("" + i);
        }
        myRecycleAdapter = new MyRecycleAdapter(mDatas);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(myRecycleAdapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL));
        myRecycleAdapter.setOnItemClickListener(new MyRecycleAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                mSwipeRefresh.setRefreshing(false);
            }
        }, 5000);
    }
}
