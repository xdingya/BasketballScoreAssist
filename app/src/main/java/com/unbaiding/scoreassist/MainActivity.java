package com.unbaiding.scoreassist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.unbaiding.scoreassist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myviewModel;
    ActivityMainBinding binding;
    public final  static  String KEY_NUMBER_A = "score_numberA";
    public final  static  String KEY_NUMBER_B = "score_numberB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myviewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.setData(myviewModel);
        binding.setLifecycleOwner(this);

    }

}