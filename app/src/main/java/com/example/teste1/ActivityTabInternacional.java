package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ActivityTabInternacional extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_internacional_activity);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        PageAdapterTabLayout adapter = new PageAdapterTabLayout(getSupportFragmentManager());
        adapter.add(new FragmentTab1(),"Champions");
        adapter.add(new FragmentTab2(),"Jogos");
        adapter.add(new FragmentTab3(),"Mata-Mata");
        adapter.add(new FragmentTab4(),"Libertadores");
        adapter.add(new FragmentTab5(),"Jogos");
        adapter.add(new FragmentTab6(),"Mata-Mata");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
