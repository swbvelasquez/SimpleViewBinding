package com.tutoriales.simpleviewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tutoriales.simpleviewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        activityMainBinding.btnOpenFragment.setOnClickListener(this);
        activityMainBinding.tvTitle.setText("View Binding Title Activity");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==activityMainBinding.btnOpenFragment.getId()){

            openHomeFragment();
            Toast.makeText(this,"Clicked Button On ViewBindActivity by - " + activityMainBinding.etName.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void openHomeFragment(){
        try {
            HomeFragment homeFragment = HomeFragment.newInstance("p1", "p2");
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(activityMainBinding.lyContent.getId(), homeFragment, HomeFragment.TAG);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}