package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teste1.fragments.PageFragment1;
import com.example.teste1.fragments.PageFragment10;
import com.example.teste1.fragments.PageFragment11;
import com.example.teste1.fragments.PageFragment12;
import com.example.teste1.fragments.PageFragment2;
import com.example.teste1.fragments.PageFragment3;
import com.example.teste1.fragments.PageFragment4;
import com.example.teste1.fragments.PageFragment5;
import com.example.teste1.fragments.PageFragment6;
import com.example.teste1.fragments.PageFragment7;
import com.example.teste1.fragments.PageFragment8;
import com.example.teste1.fragments.PageFragment9;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ActivityTabela extends AppCompatActivity{

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragment4());
        list.add(new PageFragment5());
        list.add(new PageFragment6());
        list.add(new PageFragment7());
        list.add(new PageFragment8());
        list.add(new PageFragment9());
        list.add(new PageFragment10());
        list.add(new PageFragment11());
        list.add(new PageFragment12());
        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePageAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);

        Button Botao = findViewById(R.id.button8);
        Botao.setVisibility(View.VISIBLE);
        Button BotaoCal = findViewById(R.id.button6);
        BotaoCal.setVisibility(View.VISIBLE);

    }

    public void abrirActivity_Menu(View view){
            Intent intent = new Intent(getApplicationContext(), Activity4.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
    }
    public void abrirActivity_Calendario(View view){
        Intent intent = new Intent(getApplicationContext(), Activity_Calendario.class);
        startActivity(intent);
    }
}
