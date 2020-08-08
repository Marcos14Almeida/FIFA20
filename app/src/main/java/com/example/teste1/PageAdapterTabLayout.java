package com.example.teste1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class PageAdapterTabLayout extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();

    public PageAdapterTabLayout(FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int i){
        switch (i){
            case 0:
                return new FragmentTab1();
            case 1:
                return new FragmentTab2();
            case 2:
                return new FragmentTab3();
            case 3:
                return new FragmentTab4();
            case 4:
                return new FragmentTab5();
            case 5:
                return new FragmentTab6();
            default:
                return null;
        }
    }


    public int getCount(){
        return fragments.size();
    }
    public void add(Fragment fr, String str){
        fragments.add(fr);
        strings.add(str);
    }

    public CharSequence getPageTitle(int position){
        return strings.get(position);
    }



}
