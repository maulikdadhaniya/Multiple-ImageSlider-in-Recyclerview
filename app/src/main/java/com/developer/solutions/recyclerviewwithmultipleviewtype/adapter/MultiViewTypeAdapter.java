package com.developer.solutions.recyclerviewwithmultipleviewtype.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.developer.solutions.recyclerviewwithmultipleviewtype.R;
import com.developer.solutions.recyclerviewwithmultipleviewtype.model.MyModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mukesh on 3/8/17.
 * himky02@gmail.com
 */
public class MultiViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MyModel> dataSet;
    Context mContext;
    int total_types;
    ArrayList<String> slider_image_list;
    int page = 0;

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_dots)
        LinearLayout ll_dots;
        @BindView(R.id.vp_slider)
        ViewPager mvViewPager;

        public TextTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public MultiViewTypeAdapter(ArrayList<MyModel> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager, parent, false);
        return new TextTypeViewHolder(view);


    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        MyModel object = dataSet.get(listPosition);
        if (object != null) {

            slider_image_list = object.getSliderImages();


            final SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter((Activity) mContext, slider_image_list);
            ((TextTypeViewHolder) holder).mvViewPager.setAdapter(sliderPagerAdapter);

            ((TextTypeViewHolder) holder).mvViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    // addBottomDots(position, ((TextTypeViewHolder) holder).ll_dots);

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            addBottomDots(0, ((TextTypeViewHolder) holder).ll_dots);


        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    //showing dots on screen
    private void addBottomDots(int currentPage, LinearLayout ll_dots) {
        TextView[] dots = new TextView[slider_image_list.size()];
        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(mContext);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#343434"));
            ll_dots.addView(dots[i]);
        }

        dots[currentPage].setTextColor(Color.parseColor("#A2A2A2"));
    }

}
