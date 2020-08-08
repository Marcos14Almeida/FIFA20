package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_Calendario extends AppCompatActivity {

    int max,max2,rodada,posicao,campeonato;
    String meutime;
    ArrayList<String> times = new ArrayList<>();
    ArrayList<String> timesOrdem = new ArrayList<>();
    ArrayList<Integer> chave = new ArrayList<>();
    ImageView imageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__calendario);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        times = globalVariable.SaberTimes();
        meutime = globalVariable.Sabermeutime();
        rodada = globalVariable.SaberRodada();
        campeonato = globalVariable.SaberCampeonato();
        posicao = globalVariable.SaberPosicao();
        max = globalVariable.SaberMax();
        max2 = globalVariable.SaberMax2();
        timesOrdem = globalVariable.SabertimesOrdem();

        for(int j=1;j<max;j++) {
            if(campeonato>=2 && campeonato<10){imageLogo = findViewById(R.id.imageView16);
                                               imageLogo.setImageResource(R.drawable.championsleague);}
            if(j==1)imageLogo = findViewById(R.id.imageView1);
            if(j==2)imageLogo = findViewById(R.id.imageView2);
            if(j==3)imageLogo = findViewById(R.id.imageView3);
            if(j==4)imageLogo = findViewById(R.id.imageView4);
            if(j==5)imageLogo = findViewById(R.id.imageView5);
            if(j==6)imageLogo = findViewById(R.id.imageView6);
            if(j==7)imageLogo = findViewById(R.id.imageView7);
            if(j==8)imageLogo = findViewById(R.id.imageView8);
            if(j==9)imageLogo = findViewById(R.id.imageView9);
            if(j==10)imageLogo = findViewById(R.id.imageView10);
            if(j==11)imageLogo = findViewById(R.id.imageView11);
            if(j==12)imageLogo = findViewById(R.id.imageView12);
            if(j==13)imageLogo = findViewById(R.id.imageView13);
            if(j==14)imageLogo = findViewById(R.id.imageView14);
            if(j==15)imageLogo = findViewById(R.id.imageView15);
            chave = ObterChave(j);
            String adversario="";
            for( int i=1; i<=max; i=i+2){
                if(chave.get(i)==posicao) {adversario=times.get((max * (campeonato - 1)) + chave.get(i+1));}}
            for( int i=2; i<=max; i=i+2){
                if(chave.get(i)==posicao) {adversario=times.get((max * (campeonato - 1)) + chave.get(i-1));}}
            int posicaoAdversario = timesOrdem.indexOf(adversario)%max;
            if(posicaoAdversario==0){posicaoAdversario=max;}
            globalVariable.imageLogo(adversario,imageLogo);
            if(j<rodada){
                imageLogo.setBackgroundColor(Color.GRAY);
            }
            TextView textoCalendario = findViewById(R.id.textoCalendario);
            textoCalendario.setText("Calendário - Rodada "+rodada);
        }




    }

    public void abrirActivityMenu(View view){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public ArrayList<Integer> ObterChave(Integer rodada){
        ArrayList<Integer> chave = new ArrayList<>();
        int chave1=0,chave2=0,chave3=0,chave4=0,chave5=0,chave6=0,chave7=0,chave8=0,chave9=0,chave10=0,chave11=0,chave12=0,chave13=0,chave14=0,chave15=0,chave16=0;
        if(rodada==1){//verifica o numero do meu time e ve qual a posição dele
            chave1= 1;chave2=2;               chave3= 3;chave4=4;             chave5= 5;chave6=6;            chave7= 7;chave8=8;
            chave9= 9;chave10=10;             chave11= 11;chave12=12;         chave13= 13;chave14=14;        chave15= 15;chave16=16;        }
        if(rodada==2){
            chave1= 1;chave2=6;               chave3= 3;chave4=14;             chave5= 5;chave6=4;            chave7= 7;chave8=12;
            chave9= 11;chave10=8;             chave11= 13;chave12=10;         chave13= 15;chave14=2;        chave15= 9;chave16=16;           }
        if(rodada==3){
            chave1= 1;chave2=10;               chave3= 2;chave4=3;             chave5= 4;chave6=11;            chave7= 5;chave8=16;
            chave9= 6;chave10=7;             chave11= 8;chave12=12;         chave13= 9;chave14=14;        chave15= 13;chave16=15;            }
        if(rodada==4){
            chave1= 1;chave2=11;               chave3= 2;chave4=8;             chave5= 3;chave6=15;            chave7= 4;chave8=6;
            chave9= 5;chave10=14;             chave11= 7;chave12=16;         chave13= 9;chave14=13;        chave15= 10;chave16=12;            }
        if(rodada==5){
            chave1= 1;chave2=13;               chave3= 2;chave4=16;             chave5= 3;chave6=5;            chave7= 4;chave8=9;
            chave9= 6;chave10=8;             chave11= 7;chave12=11;         chave13= 15;chave14=12;        chave15= 10;chave16=14;            }
        if(rodada==6){
            chave1= 1;chave2=14;               chave3= 2;chave4=13;             chave5= 3;chave6=7;            chave7= 4;chave8=16;
            chave9= 6;chave10=12;             chave11= 5;chave12=11;         chave13= 9;chave14=8;        chave15= 10;chave16=15;            }
        if(rodada==7){
            chave1= 1;chave2=15;               chave3= 2;chave4=7;             chave5= 3;chave6=8;            chave7= 4;chave8=12;
            chave9= 6;chave10=13;             chave11= 5;chave12=9;         chave13= 16;chave14=14;        chave15= 10;chave16=11;            }
        if(rodada==8){
            chave1= 1;chave2=9;               chave3= 2;chave4=5;             chave5= 3;chave6=12;            chave7= 4;chave8=8;
            chave9= 6;chave10=10;             chave11= 7;chave12=13;         chave13= 15;chave14=14;        chave15= 16;chave16=11;            }
        if(rodada==9){
            chave1= 1;chave2=5;               chave3= 2;chave4=14;             chave5= 3;chave6=6;            chave7= 4;chave8=7;
            chave9= 8;chave10=10;             chave11= 11;chave12=13;         chave13= 15;chave14=9;        chave15= 16;chave16=12;            }
        if(rodada==10){
            chave1= 1;chave2=7;               chave3= 2;chave4=6;             chave5= 3;chave6=13;            chave7= 4;chave8=10;
            chave9= 8;chave10=16;             chave11= 11;chave12=9;         chave13= 5;chave14=15;        chave15= 14;chave16=12;            }
        if(rodada==11){
            chave1= 1;chave2=4;               chave3= 2;chave4=12;             chave5= 3;chave6=9;            chave7= 5;chave8=13;
            chave9= 8;chave10=15;             chave11= 11;chave12=14;         chave13= 6;chave14=16;        chave15= 7;chave16=10;            }
        if(rodada==12){
            chave1= 1;chave2=12;               chave3= 2;chave4=4;             chave5= 3;chave6=16;            chave7= 5;chave8=10;
            chave9= 8;chave10=13;             chave11= 11;chave12=15;         chave13= 6;chave14=14;        chave15= 7;chave16=9;             }
        if(rodada==13){
            chave1= 1;chave2=8;               chave3= 2;chave4=11;             chave5= 3;chave6=10;            chave7= 4;chave8=14;
            chave9= 16;chave10=13;             chave11= 9;chave12=12;         chave13= 6;chave14=15;        chave15= 7;chave16=5;            }
        if(rodada==14){
            chave1= 1;chave2=3;               chave3= 2;chave4=9;             chave5= 5;chave6=12;            chave7= 4;chave8=13;
            chave9= 16;chave10=10;             chave11= 8;chave12=14;         chave13= 6;chave14=11;        chave15= 7;chave16=15;            }
        if(rodada==15){
            chave1= 1;chave2=16;               chave3= 2;chave4=10;             chave5= 5;chave6=8;            chave7= 4;chave8=15;
            chave9= 6;chave10=9;             chave11= 12;chave12=13;         chave13= 3;chave14=11;        chave15= 7;chave16=14;            }

        if(rodada==16){chave1= 1;chave2=2;               chave3= 3;chave4=4;         }
        if(rodada==17){chave1= 1;chave2=3;               chave3= 4;chave4=2;         }
        if(rodada==18){chave1= 1;chave2=4;               chave3= 3;chave4=2;         }
        if(rodada==19){chave1= 1;chave2=2;               chave3= 3;chave4=4;         }
        if(rodada==20){chave1= 1;chave2=3;               chave3= 4;chave4=2;         }
        if(rodada==21){chave1= 1;chave2=4;               chave3= 3;chave4=2;         }

        chave.add(0);
        chave.add(chave1);chave.add(chave2);chave.add(chave3);chave.add(chave4);
        if(rodada<max){
            chave.add(chave5);chave.add(chave6);chave.add(chave7);chave.add(chave8);
            chave.add(chave9);chave.add(chave10);chave.add(chave11);chave.add(chave12);
            chave.add(chave13);chave.add(chave14);chave.add(chave15);chave.add(chave16);}

        return chave; //lista dos adversario
    }
}
