package com.example.teste1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SlidePageAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public SlidePageAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
    }

    public Fragment getItem(int position){
        return fragmentList.get(position);
    }
    public int getCount(){
        return fragmentList.size();
    }
}
