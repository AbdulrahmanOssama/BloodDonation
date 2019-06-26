package com.example.sunshine.blooddonation.intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.sunshine.blooddonation.R;

import java.util.ArrayList;

public class imageDotPagerAdapter extends PagerAdapter {
    Context context;
    //list of images to be replaced in intro page
    ArrayList<Integer>IntroImages;

    public imageDotPagerAdapter(Context context,ArrayList<Integer>IntoImages)
    {
        this.context=context;
        this.IntroImages=IntoImages;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View IntroView=inflater.inflate(R.layout.intro_image_placeholder,container,false);
        ImageView ImagePlaceHolder=IntroView.findViewById(R.id.IntroImage);
        ImagePlaceHolder.setImageDrawable(ContextCompat.getDrawable(context,IntroImages.get(position)));
        container.addView(IntroView,0);
        return IntroView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return IntroImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
