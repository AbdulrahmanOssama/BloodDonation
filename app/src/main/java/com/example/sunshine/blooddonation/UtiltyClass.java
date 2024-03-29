package com.example.sunshine.blooddonation;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;

import com.example.sunshine.blooddonation.intro.LoginFragment;
import com.example.sunshine.blooddonation.intro.SignUpFragment;
import com.example.sunshine.blooddonation.intro.forgetPassword;
import com.example.sunshine.blooddonation.intro.forgetPasswordCode;
import com.example.sunshine.blooddonation.intro.introActivity;

public class UtiltyClass {
    //click for skip button.
    public  void SkipListener(View view) {
        Log.v("skipButton","skup button done");
        introActivity introActivity = (introActivity)view.getContext();
        FragmentTransaction fragmentTransaction = introActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left,R.anim.outright);
        fragmentTransaction.replace(R.id.IntroContainer, new LoginFragment());
        fragmentTransaction.commit();
        view.clearAnimation();


    }
    public void SignUpListener(View view)
    {
        introActivity introActivity = (introActivity)view.getContext();
        FragmentTransaction fragmentTransaction = introActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left,R.anim.outright);
        fragmentTransaction.replace(R.id.LoginContainer, new SignUpFragment());
        //this is for whenever user wanted to back to previous fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //view.setVisibility(View.GONE);


    }
    public void forgetPasswordListner(View view)
    {
        introActivity introActivity = (introActivity)view.getContext();
        FragmentTransaction fragmentTransaction = introActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left,R.anim.outright);
        fragmentTransaction.replace(R.id.LoginContainer, new forgetPassword());
        //this is for whenever user wanted to back to previous fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //view.setVisibility(View.GONE);


    }
    public void SendListner(View view)
    {
        introActivity introActivity = (introActivity)view.getContext();
        FragmentTransaction fragmentTransaction = introActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left,R.anim.outright);
        fragmentTransaction.replace(R.id.forgetPasswordContainer, new forgetPasswordCode());
        //this is for whenever user wanted to back to previous fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //view.setVisibility(View.GONE);


    }


}
