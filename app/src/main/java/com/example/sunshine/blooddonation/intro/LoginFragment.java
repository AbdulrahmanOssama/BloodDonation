package com.example.sunshine.blooddonation.intro;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunshine.blooddonation.R;
import com.example.sunshine.blooddonation.UtiltyClass;
import com.example.sunshine.blooddonation.databinding.FragmentLoginBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLoginBinding fragmentLoginBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        fragmentLoginBinding.setClick(new UtiltyClass());
        return fragmentLoginBinding.getRoot();
    }


}
