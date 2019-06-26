package com.example.sunshine.blooddonation;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.sunshine.blooddonation.intro.LoginFragment;
import com.example.sunshine.blooddonation.intro.SignUpFragment;
import com.example.sunshine.blooddonation.intro.introActivity;

public class UtiltyClass {
    //click for skip button.
    public  void SkipOnclick(View view) {
        introActivity introActivity = (introActivity)view.getContext();
        FragmentTransaction fragmentTransaction = introActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left,R.anim.outright);
        fragmentTransaction.replace(R.id.IntroContainer, new LoginFragment());
        fragmentTransaction.commit();

    }
    public void SignUpOnClick(View view)
    {
        introActivity introActivity = (introActivity)view.getContext();
        FragmentTransaction fragmentTransaction = introActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left,R.anim.outright);
        fragmentTransaction.replace(R.id.LoginContainer, new SignUpFragment());
        //this is for whenever user wanted to back to previous fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
