package com.example.sunshine.blooddonation.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.sunshine.blooddonation.R;
import com.example.sunshine.blooddonation.UtiltyClass;
import com.example.sunshine.blooddonation.databinding.ActivityIntroBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class introActivity extends AppCompatActivity {

    Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_intro);
        ActivityIntroBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_intro);
        //binding.setActivityContext(this);
       // binding.setContext(this);
        binding.setClick(new UtiltyClass());
        /**
         * Todo create array list of drawble id like below to be replaced in view pager.
         */
        ArrayList<Integer>images=new ArrayList<>();
        images.add(R.drawable.intro);
        images.add(R.drawable.intro2);
        imageDotPagerAdapter sectionsPagerAdapter = new imageDotPagerAdapter(this,images);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager,true);

    }

}
