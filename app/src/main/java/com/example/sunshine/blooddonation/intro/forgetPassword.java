package com.example.sunshine.blooddonation.intro;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunshine.blooddonation.R;
import com.example.sunshine.blooddonation.UtiltyClass;
import com.example.sunshine.blooddonation.databinding.FragmentForgetPasswordBinding;
import com.example.sunshine.blooddonation.databinding.FragmentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class forgetPassword extends Fragment {


    public forgetPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentForgetPasswordBinding fragmentForgetPasswordBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_forget_password,container,false);
        fragmentForgetPasswordBinding.setClick(new UtiltyClass());
        return fragmentForgetPasswordBinding.getRoot();    }

}
