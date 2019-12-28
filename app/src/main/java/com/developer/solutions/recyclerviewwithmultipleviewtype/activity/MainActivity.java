package com.developer.solutions.recyclerviewwithmultipleviewtype.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.developer.solutions.recyclerviewwithmultipleviewtype.R;
import com.developer.solutions.recyclerviewwithmultipleviewtype.adapter.MultiViewTypeAdapter;
import com.developer.solutions.recyclerviewwithmultipleviewtype.model.MyModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Mukesh on 3/8/17.
 * himky02@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    Activity mActivity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    Unbinder mUnbinder;
    ArrayList<String> pos1;
    ArrayList<String> pos2;
    ArrayList<String> pos3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //((TextView) findViewById(R.id.tv)).setText("Welcome user");
        mUnbinder = ButterKnife.bind(this);

        pos1 = new ArrayList<>();
        pos1.add(0, "http://cdn.collider.com/wp-content/uploads/avengers-movie-banner-scarlett-johansson-jeremy-renner.jpg");
        pos1.add(1, "http://www.officialterridwyer.com/wp-content/uploads/2015/04/Disneys-Cinderella-2015-Movie-Banner.jpg");


        pos2 = new ArrayList<>();
        pos2.add(0, "http://igmedia.blob.core.windows.net/igmedia/hindi/gallery/movies/raabta/main1.jpg");
        pos2.add(1, "http://fantoosy.com/wp-content/uploads/2015/11/tamasha.jpg");


        pos3 = new ArrayList<>();
        pos3.add(0, "http://www.officialterridwyer.com/wp-content/uploads/2015/04/Disneys-Cinderella-2015-Movie-Banner.jpg");


        ArrayList<MyModel> list = new ArrayList<>();
        list.add(new MyModel(1, "Hello", pos1));
        list.add(new MyModel(2, "Hello2", pos2));
        list.add(new MyModel(3, "Hello3", pos3));


        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list, this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) mUnbinder.unbind();
    }


}
