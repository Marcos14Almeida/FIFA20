package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper viewFlipper0,viewFlipper1,viewFlipper2,viewFlipper3,viewFlipper4,viewFlipper5,viewFlipper6,viewFlipper7,viewFlipper8,viewFlipper9,viewFlipper10,viewFlipper11,viewFlipper12,viewFlipper13,viewFlipper14,viewFlipper15,viewFlipper16;
    Button botaoDepois,botaoDepois2;
    Button botaoAntes,botaoAntes2;
    Button botaoSelecao;
    Button botaoTime;
    ListView listaTimes;
    TextView nomeTime;
    int posicao=1, max=16;
    int posicaoPais=1, max2;
    int PtsEquipeInicial;
    final ArrayList<String> times = new ArrayList<>();
    final ArrayList<String> pais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GLOBAL
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        max= globalVariable.SaberMax();
        max2=globalVariable.SaberMax2();
        pais.add("");
        pais.add("Brasileirão");
        pais.add("Premier League");
        pais.add("Serie A TIM");
        pais.add("La Liga");
        pais.add("Bundesliga");
        pais.add("Ligue 1");
        pais.add("Liga Europeia");
        pais.add("Leste Europeu");
        pais.add("Championship");
        pais.add("Brasileirao - Série B");
        pais.add("Campeonato Argentino");
        pais.add("Sul Americano");
        pais.add("Liga Colombia MX");

        Nomestimes();

        nomeTime = findViewById(R.id.nomeTime);
        nomeTime.setText(times.get(posicao+(max*(posicaoPais-1))));

        viewFlipper0 = (ViewFlipper) findViewById(R.id.viewFlipper0);
        viewFlipper1 = (ViewFlipper) findViewById(R.id.viewFlipper1);
        viewFlipper2 = (ViewFlipper) findViewById(R.id.viewFlipper2);
        viewFlipper3 = (ViewFlipper) findViewById(R.id.viewFlipper3);
        viewFlipper4 = (ViewFlipper) findViewById(R.id.viewFlipper4);
        viewFlipper5 = (ViewFlipper) findViewById(R.id.viewFlipper5);
        viewFlipper6 = (ViewFlipper) findViewById(R.id.viewFlipper6);
        viewFlipper7 = (ViewFlipper) findViewById(R.id.viewFlipper7);
        viewFlipper8 = (ViewFlipper) findViewById(R.id.viewFlipper8);
        viewFlipper9 = (ViewFlipper) findViewById(R.id.viewFlipper9);
        viewFlipper10 = (ViewFlipper) findViewById(R.id.viewFlipper10);
        viewFlipper11 = (ViewFlipper) findViewById(R.id.viewFlipper11);
        viewFlipper12 = (ViewFlipper) findViewById(R.id.viewFlipper12);
        viewFlipper13 = (ViewFlipper) findViewById(R.id.viewFlipper13);
        viewFlipper14 = (ViewFlipper) findViewById(R.id.viewFlipper14);
        viewFlipper15 = (ViewFlipper) findViewById(R.id.viewFlipper13);
        viewFlipper16 = (ViewFlipper) findViewById(R.id.viewFlipper13);

        botaoAntes = (Button) findViewById(R.id.botaoAntes);
        botaoDepois = (Button) findViewById(R.id.botaoDepois);
        botaoTime = (Button) findViewById(R.id.botaoTime);
        botaoAntes.setOnClickListener(this);
        botaoDepois.setOnClickListener(this);
        botaoTime.setOnClickListener(this);

        botaoAntes2 = (Button) findViewById(R.id.botaoAntes2);
        botaoDepois2 = (Button) findViewById(R.id.botaoDepois2);
        botaoAntes2.setOnClickListener(this);
        botaoDepois2.setOnClickListener(this);


        botaoSelecao = (Button) findViewById(R.id.botaoSelecao);
        botaoSelecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivity2();
            }
        });

   }

   public void abrirActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
   }

   public void onClick(View v){
        if (v==botaoDepois){
            if (posicaoPais == 1) {                viewFlipper1.showNext();    }
            if (posicaoPais == 2) {                viewFlipper2.showNext();    }
            if (posicaoPais == 3) {                viewFlipper3.showNext();   }
            if (posicaoPais == 4) {                viewFlipper4.showNext();   }
            if (posicaoPais == 5) {                viewFlipper5.showNext();   }
            if (posicaoPais == 6) {                viewFlipper6.showNext();   }
            if (posicaoPais == 7) {                viewFlipper7.showNext();   }
            if (posicaoPais == 8) {                viewFlipper8.showNext();   }
            if (posicaoPais == 9) {                viewFlipper9.showNext();   }
            if (posicaoPais == 10) {                viewFlipper10.showNext();   }
            if (posicaoPais == 11) {                viewFlipper11.showNext();   }
            if (posicaoPais == 12) {                viewFlipper12.showNext();   }
            if (posicaoPais == 13) {                viewFlipper13.showNext();   }
            if (posicaoPais == 14) {                viewFlipper14.showNext();   }
            if (posicaoPais == 15) {                viewFlipper15.showNext();   }
            if (posicaoPais == 16) {                viewFlipper16.showNext();   }
            posicao++;
            if(posicao>max){posicao=1;}
            nomeTime.setText(times.get(posicao+(max*(posicaoPais-1))));
        }
       else if (v==botaoAntes){
            if (posicaoPais == 1) {                viewFlipper1.showPrevious();       }
            if (posicaoPais == 2) {                viewFlipper2.showPrevious();    }
            if (posicaoPais == 3) {                viewFlipper3.showPrevious();      }
            if (posicaoPais == 4) {                viewFlipper4.showPrevious();   }
            if (posicaoPais == 5) {                viewFlipper5.showPrevious();   }
            if (posicaoPais == 6) {                viewFlipper6.showPrevious();   }
            if (posicaoPais == 7) {                viewFlipper7.showPrevious();   }
            if (posicaoPais == 8) {                viewFlipper8.showPrevious();   }
            if (posicaoPais == 9) {                viewFlipper9.showPrevious();   }
            if (posicaoPais == 10) {                viewFlipper10.showPrevious();   }
            if (posicaoPais == 11) {                viewFlipper11.showPrevious();   }
            if (posicaoPais == 12) {                viewFlipper12.showPrevious();   }
            if (posicaoPais == 13) {                viewFlipper13.showPrevious();   }
            if (posicaoPais == 14) {                viewFlipper14.showPrevious();   }
            if (posicaoPais == 15) {                viewFlipper15.showPrevious();   }
            if (posicaoPais == 16) {                viewFlipper16.showPrevious();   }
            posicao--;
            if(posicao<1){posicao=max;}
            nomeTime.setText(times.get(posicao+(max*(posicaoPais-1))));
       }
       if (v==botaoDepois2){
           viewFlipper0.showNext();
           posicaoPais++;
           if(posicaoPais>max2){posicaoPais=1;}
           if (posicaoPais == 1) {               viewFlipper1.setVisibility(View.VISIBLE);viewFlipper13.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper13.showPrevious();posicao--;}}
           if (posicaoPais == 2) {               viewFlipper2.setVisibility(View.VISIBLE);viewFlipper1.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper1.showPrevious();posicao--;}}
           if (posicaoPais == 3) {               viewFlipper3.setVisibility(View.VISIBLE);viewFlipper2.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper2.showPrevious();posicao--;}}
           if (posicaoPais == 4) {               viewFlipper4.setVisibility(View.VISIBLE);viewFlipper3.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper3.showPrevious();posicao--;}}
           if (posicaoPais == 5) {               viewFlipper5.setVisibility(View.VISIBLE);viewFlipper4.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper4.showPrevious();posicao--;}}
           if (posicaoPais == 6) {               viewFlipper6.setVisibility(View.VISIBLE);viewFlipper5.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper5.showPrevious();posicao--;}}
           if (posicaoPais == 7) {               viewFlipper7.setVisibility(View.VISIBLE);viewFlipper6.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper6.showPrevious();posicao--;}}
           if (posicaoPais == 8) {               viewFlipper8.setVisibility(View.VISIBLE);viewFlipper7.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper7.showPrevious();posicao--;}}
           if (posicaoPais == 9) {               viewFlipper9.setVisibility(View.VISIBLE);viewFlipper8.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper8.showPrevious();posicao--;}}
           if (posicaoPais == 10) {               viewFlipper10.setVisibility(View.VISIBLE);viewFlipper9.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper9.showPrevious();posicao--;}}
           if (posicaoPais == 11) {               viewFlipper11.setVisibility(View.VISIBLE);viewFlipper10.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper10.showPrevious();posicao--;}}
           if (posicaoPais == 12) {               viewFlipper12.setVisibility(View.VISIBLE);viewFlipper11.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper11.showPrevious();posicao--;}}
           if (posicaoPais == 13) {               viewFlipper13.setVisibility(View.VISIBLE);viewFlipper12.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper12.showPrevious();posicao--;}}
           if (posicaoPais == 14) {               viewFlipper14.setVisibility(View.VISIBLE);viewFlipper13.setVisibility(View.INVISIBLE);
                                                                        while(posicao>1){viewFlipper13.showPrevious();posicao--;}}
           TextView nomePais = findViewById(R.id.nomePais);
           nomePais.setText(pais.get(posicaoPais));
           nomeTime.setText(times.get(posicao+(max*(posicaoPais-1))));
       }
       else if (v==botaoAntes2){
           viewFlipper0.showPrevious();
           posicaoPais--;
           if(posicaoPais<1){posicaoPais=max2;}
           if (posicaoPais == 1) {               viewFlipper1.setVisibility(View.VISIBLE);viewFlipper2.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper2.showPrevious();posicao--;}}
           if (posicaoPais == 2) {               viewFlipper2.setVisibility(View.VISIBLE);viewFlipper3.setVisibility(View.INVISIBLE);
                                                                          while(posicao>1){viewFlipper3.showPrevious();posicao--;}}
           if (posicaoPais == 3) {               viewFlipper3.setVisibility(View.VISIBLE);viewFlipper4.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper4.showPrevious();posicao--;}}
           if (posicaoPais == 4) {               viewFlipper4.setVisibility(View.VISIBLE);viewFlipper5.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper5.showPrevious();posicao--;}}
           if (posicaoPais == 5) {               viewFlipper5.setVisibility(View.VISIBLE);viewFlipper6.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper6.showPrevious();posicao--;}}
           if (posicaoPais == 6) {               viewFlipper6.setVisibility(View.VISIBLE);viewFlipper7.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper7.showPrevious();posicao--;}}
           if (posicaoPais == 7) {               viewFlipper7.setVisibility(View.VISIBLE);viewFlipper8.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper8.showPrevious();posicao--;}}
           if (posicaoPais == 8) {               viewFlipper8.setVisibility(View.VISIBLE);viewFlipper9.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper9.showPrevious();posicao--;}}
           if (posicaoPais == 9) {               viewFlipper9.setVisibility(View.VISIBLE);viewFlipper10.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper10.showPrevious();posicao--;}}
           if (posicaoPais == 10) {               viewFlipper10.setVisibility(View.VISIBLE);viewFlipper11.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper11.showPrevious();posicao--;}}
           if (posicaoPais == 11) {               viewFlipper11.setVisibility(View.VISIBLE);viewFlipper12.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper12.showPrevious();posicao--;}}
           if (posicaoPais == 12) {               viewFlipper12.setVisibility(View.VISIBLE);viewFlipper13.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper13.showPrevious();posicao--;}}
           if (posicaoPais == 13) {               viewFlipper13.setVisibility(View.VISIBLE);viewFlipper1.setVisibility(View.INVISIBLE);
                                                                         while(posicao>1){viewFlipper1.showPrevious();posicao--;}}
           if (posicaoPais == 14) {               viewFlipper14.setVisibility(View.VISIBLE);viewFlipper1.setVisibility(View.INVISIBLE);
                                                                        while(posicao>1){viewFlipper1.showPrevious();posicao--;}}
           TextView nomePais = findViewById(R.id.nomePais);
           nomePais.setText(pais.get(posicaoPais));
           nomeTime.setText(times.get(posicao+(max*(posicaoPais-1))));
       }
       else if (v==botaoTime){
           String meutime = times.get(posicao+(max*(posicaoPais-1)));
           PtsEquipeInicial = PtsEquipeInicial(meutime);
           float dinheiro = (PtsEquipeInicial-68)*(PtsEquipeInicial-68)/4;
           // Calling Application class (see application tag in AndroidManifest.xml)
           final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
           globalVariable.DefinirTimes(times);
           globalVariable.Definirmeutime(meutime);
           globalVariable.DefinirPosicao(posicao);
           globalVariable.DefinirParametros(posicaoPais,dinheiro);
           globalVariable.DefinirQualCampeonato(0);
           //globalVariable.DefinirRodada(1);
           globalVariable.DefinirPosicaoChampions(-1);
           globalVariable.ZerarGols();
           globalVariable.ZerarPontos();
           globalVariable.ZerarPtsEquipe();
           globalVariable.DefinirAno(2020);
           for(int i=0 ; i<=max*max2;i++) {
               PtsEquipeInicial=PtsEquipeInicial(times.get(i));
               globalVariable.DefinirPtsEquipe(PtsEquipeInicial, i);
           }
            Intent intent = new Intent(this, Activity4.class);
            startActivity(intent);
        }
   }

public void iniciaChampions(){
    ArrayList<String> timesChampions = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampions = new ArrayList<>();
    timesChampions.add("");
    timesChampions.add("Real Madrid");timesChampions.add("Brugge");timesChampions.add("PSG");timesChampions.add("Galatasaray");
    timesChampions.add("Bayern Munique");timesChampions.add("Olympiakos");timesChampions.add("Tottenham");timesChampions.add("Estrela Vermelha");
    timesChampions.add("Manchester City");timesChampions.add("Atalanta");timesChampions.add("Shaktar Donetsk");timesChampions.add("Dinamo Zagreb");
    timesChampions.add("Juventus");timesChampions.add("Krasnodar");timesChampions.add("Bayer Leverkusen");timesChampions.add("Atlético Madrid");
    timesChampions.add("RB Salzburg");timesChampions.add("Napoli");timesChampions.add("Liverpool");timesChampions.add("Anderlecht");
    timesChampions.add("Barcelona");timesChampions.add("Inter");timesChampions.add("Sparta Praga");timesChampions.add("Borussia Dortmund");
    timesChampions.add("Zenit");timesChampions.add("RB Leipzig");timesChampions.add("Benfica");timesChampions.add("Lyon");
    timesChampions.add("Valencia");timesChampions.add("Ajax");timesChampions.add("Chelsea");timesChampions.add("Lille");
    final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
    globalVariable.DefinirTimesChampions(timesChampions);
    PtsEquipeChampions.add(0);
    for(int i=1; i<=32;i++){PtsEquipeInicial(timesChampions.get(i));PtsEquipeChampions.add(PtsEquipeInicial);}
    globalVariable.DefinirPtsEquipeChampions(PtsEquipeChampions);
}
public void Nomestimes(){
        times.add("");
        times.add("Palmeiras");        times.add("Atlético-MG");        times.add("Atlético-PR");        times.add("Bahia");
        times.add("Botafogo");        times.add("Corinthians");        times.add("Cruzeiro");        times.add("Flamengo");
        times.add("Fluminense");        times.add("Goias");        times.add("Grêmio");        times.add("Internacional");
        times.add("Santos");        times.add("São Paulo");        times.add("Sport");        times.add("Vasco");

        times.add("Arsenal");times.add("Aston Villa");times.add("Chelsea");times.add("Crystal Palace");
        times.add("Everton");times.add("Leeds United");times.add("Leicester");times.add("Liverpool");
        times.add("Manchester City");        times.add("Manchester United");        times.add("Newcastle");        times.add("Tottenham");
        times.add("Southampton");        times.add("West Bromwich");        times.add("West Ham");        times.add("Wolves");

        times.add("Atalanta");        times.add("Bologna");        times.add("Cagliari");        times.add("Fiorentina");
        times.add("Genoa");        times.add("Inter");        times.add("Juventus");       times.add("Milan");
        times.add("Lazio");        times.add("Napoli");        times.add("Parma");        times.add("Roma");
        times.add("Sampdoria");        times.add("Sassuolo");        times.add("Torino");        times.add("Udinese");

        times.add("Athletic Bilbao");        times.add("Atlético Madrid");        times.add("Barcelona");        times.add("Celta de Vigo");
        times.add("Espanyol");        times.add("Getafe");        times.add("La Coruna");       times.add("Levante");
        times.add("Osasuna");        times.add("Real Betis");        times.add("Real Madrid");  times.add("Real Sociedad");
        times.add("Sevilla");        times.add("Valencia");   times.add("Valladolid");     times.add("Villareal");

        times.add("Moenchengladbach");        times.add("Borussia Dortmund");        times.add("Bayern Munique");       times.add("Bayer Leverkusen");
        times.add("Colonia");        times.add("Eintracht Frankfurt");         times.add("Freiburg");times.add("Hamburgo");
        times.add("Hannover96");        times.add("Hertha Berlim");        times.add("Hoffenheim");  times.add("RB Leipzig");
        times.add("Schalke-04");        times.add("Stuttgart");   times.add("Werder Bremen");     times.add("Wolfsburg");

        times.add("Bordeaux");        times.add("Lille");        times.add("Lyon");     times.add("Monaco");
        times.add("Montpellier");     times.add("Nantes");       times.add("Nice");     times.add("Olympique Marselha");
        times.add("PSG");             times.add("Reims");        times.add("Rennes");  times.add("Saint-Etienne");
        times.add("Toulouse");        times.add("Anderlecht");   times.add("Brugge");     times.add("Standard Liege");

        times.add("Benfica");               times.add("Porto");          times.add("Sporting");     times.add("Braga");
        times.add("Vitória Guimarães");     times.add("Ajax");           times.add("Feyenoord");    times.add("PSV");
        times.add("Celtic");                times.add("Glasgow Rangers");times.add("Rosemborg");    times.add("Malmo");
        times.add("Copenhague");            times.add("RB Salzburg");    times.add("Rapid Viena");  times.add("Basel");

        times.add("Zenit");               times.add("CSKA"); times.add("Krasnodar"); times.add("Spartak Moscou");
        times.add("Galatasaray");         times.add("Fenerbahce");times.add("Besiktas"); times.add("Olympiakos");
        times.add("Estrela Vermelha");        times.add("Partizan"); times.add("Ludogorets");  times.add("Dinamo Zagreb");
        times.add("Shaktar Donetsk");     times.add("Dinamo Kiev");   times.add("Sparta Praga");     times.add("APOEL");

        times.add("Birmigham");           times.add("Blackburn"); times.add("Burnley"); times.add("Brighton");
        times.add("Derby Count");         times.add("Fulham");times.add("Hull City");   times.add("Middlesbrough");
        times.add("Norwich");             times.add("Nottingham Forest");  times.add("QPR");times.add("Reading");
        times.add("Sheffield United");    times.add("Stoke City");times.add("Swansea");     times.add("Watford");

        times.add("Avaí");         times.add("Botafogo-SP");   times.add("Bragantino"); times.add("Ceará");
        times.add("Coritiba");     times.add("Criciúma");      times.add("Figueirense");         times.add("Fortaleza");
        times.add("Guarani");      times.add("Juventude");     times.add("Naútico");   times.add("Paraná");
        times.add("Paysandu");     times.add("Ponte Preta");   times.add("Santa Cruz");     times.add("Vitória");

        times.add("Argentino Juniors");         times.add("Arsenal Sarandí");   times.add("Banfield"); times.add("Boca Juniors");
        times.add("Colón");     times.add("Estudiantes");      times.add("Independiente");         times.add("Huracán");
        times.add("Lanús");      times.add("Newell's Old Boys");     times.add("Racing");   times.add("River Plate");
        times.add("Rosario Central");     times.add("San Lorenzo");   times.add("Talleres");     times.add("Vélez Sarsfield");

        times.add("Peñarol");         times.add("Nacional");   times.add("Olimpia"); times.add("Cerro Porteño");
        times.add("Libertad");     times.add("Colo-Colo");      times.add("LaU");         times.add("Univ. Católica");
        times.add("Bolívar");      times.add("Alianza Lima");     times.add("Sporting Cristal");   times.add("Cienciano");
        times.add("Barcelona-EQU");     times.add("Emelec");   times.add("LDU");     times.add("Caracas");

        times.add("América de Cali");         times.add("Atlético Nacional");   times.add("Deportivo Cali"); times.add("Junior");
        times.add("I. Medellín");     times.add("Once Caldas");      times.add("Millonarios");         times.add("Santa Fé");
        times.add("América-MEX");      times.add("Chivas Guadalajara");     times.add("Cruz Azul");   times.add("Monterrey");
        times.add("Pachuca");     times.add("Pumas");   times.add("Tigres");     times.add("Toluca");

    times.add("Atlanta United");                 times.add("Chicago Fire");      times.add("Columbus Crew");times.add("DC United");
    times.add("FC Dallas");times.add("Houston Dynamo");times.add("LA Galaxy");times.add("New England Revolution");
    times.add("NY City");                   times.add("NY Red Bulls");times.add("Orlando City");times.add("Portland Timbers");
    times.add("Seattle Sounders");                        times.add("Sporting Kansas City");times.add("Toronto FC");times.add("Vancouver Whitecaps");

    times.add("Ghuagzhou Evergrande");times.add("Beijing Guoan");times.add("Shandong Luneng");times.add("Shanghai SIPG");
   times.add("Kashima Antlers");times.add("Urawa Red Diamonds");times.add("Vissel Kobe");times.add("FC Tokyo");
   times.add("FC Seoul");times.add("Jeonbuk Hyundai");times.add("Al Ain-EAU");times.add("Al Sadd-QAT");
   times.add("Al Duhail-QAT");times.add("Al Ahli");times.add("Al Hilal");times.add("Persepolis");

   times.add("Sydney FC");times.add("Melbourne Victory");times.add("Suwon Samsung");times.add("Ulsan Hyundai");
   times.add("Jiangsu Suning");       times.add("Shanghai Shenhua");times.add("Cerezo Osaka");times.add("Kawasaki Frontale");
   times.add("Kashiwa Reysol");       times.add("Gamba Osaka");times.add("Yokohama F-Marinos");times.add("Al Nassr");
   times.add("Al Ittihad");times.add("Pakhtakor-UZB");times.add("Sepahan");times.add("Esteghlal");
}
    public Integer PtsEquipeInicial(String timeFoto){
        if(timeFoto.equals("Atlético-MG")){       PtsEquipeInicial=77;        }
        if(timeFoto.equals("Atlético-PR")){       PtsEquipeInicial=76;       }
        if(timeFoto.equals("Bahia")){             PtsEquipeInicial=75;       }
        if(timeFoto.equals("Botafogo")){          PtsEquipeInicial=75;        }
        if(timeFoto.equals("Corinthians")){       PtsEquipeInicial=76;        }
        if(timeFoto.equals("Cruzeiro")){          PtsEquipeInicial=74;        }
        if(timeFoto.equals("Flamengo")){          PtsEquipeInicial=81;       }
        if(timeFoto.equals("Fluminense")){        PtsEquipeInicial=77;        }
        if(timeFoto.equals("Grêmio")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Goias")){            PtsEquipeInicial=73;        }
        if(timeFoto.equals("Internacional")){     PtsEquipeInicial=78;        }
        if(timeFoto.equals("Palmeiras")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Santos")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("São Paulo")){         PtsEquipeInicial=78;       }
        if(timeFoto.equals("Sport")){            PtsEquipeInicial=73;        }
        if(timeFoto.equals("Vasco")){            PtsEquipeInicial=75;        }

        if(timeFoto.equals("Arsenal")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Aston Villa")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Crystal Palace")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Chelsea")){            PtsEquipeInicial=83;        }
        if(timeFoto.equals("Everton")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Leicester")){            PtsEquipeInicial=82;        }
        if(timeFoto.equals("Leeds United")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Liverpool")){            PtsEquipeInicial=86;        }
        if(timeFoto.equals("Manchester City")){            PtsEquipeInicial=85;        }
        if(timeFoto.equals("Manchester United")){            PtsEquipeInicial=83;        }
        if(timeFoto.equals("Newcastle")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Southampton")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Tottenham")){            PtsEquipeInicial=83;        }
        if(timeFoto.equals("West Bromwich")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("West Ham")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Wolves")){            PtsEquipeInicial=81;        }

        if(timeFoto.equals("Atalanta")){            PtsEquipeInicial=83;        }
        if(timeFoto.equals("Bologna")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Cagliari")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Fiorentina")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Genoa")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Inter")){            PtsEquipeInicial=83;        }
        if(timeFoto.equals("Juventus")){            PtsEquipeInicial=84;        }
        if(timeFoto.equals("Milan")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Lazio")){            PtsEquipeInicial=82;        }
        if(timeFoto.equals("Napoli")){            PtsEquipeInicial=82;        }
        if(timeFoto.equals("Parma")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Roma")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Sampdoria")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Sassuolo")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Torino")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Udinese")){            PtsEquipeInicial=77;        }

        if(timeFoto.equals("Athletic Bilbao")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Atlético Madrid")){            PtsEquipeInicial=83;      }
        if(timeFoto.equals("Barcelona")){            PtsEquipeInicial=85;        }
        if(timeFoto.equals("Celta de Vigo")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Espanyol")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Getafe")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Osasuna")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("La Coruna")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Levante")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Real Betis")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Real Madrid")){            PtsEquipeInicial=85;        }
        if(timeFoto.equals("Real Sociedad")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Sevilla")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Valladolid")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Valencia")){            PtsEquipeInicial=82;        }
        if(timeFoto.equals("Villareal")){            PtsEquipeInicial=80;        }

        if(timeFoto.equals("Moenchengladbach")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Borussia Dortmund")){            PtsEquipeInicial=84;        }
        if(timeFoto.equals("Bayern Munique")){            PtsEquipeInicial=85;        }
        if(timeFoto.equals("Bayer Leverkusen")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Eintracht Frankfurt")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Freiburg")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Hamburgo")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Colonia")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Hannover96")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Hertha Berlim")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Hoffenheim")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("RB Leipzig")){            PtsEquipeInicial=82;        }
        if(timeFoto.equals("Schalke-04")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Stuttgart")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Werder Bremen")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Wolfsburg")){            PtsEquipeInicial=77;        }

        if(timeFoto.equals("Bordeaux")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Lille")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Lyon")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Monaco")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Montpellier")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Nantes")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Nice")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Olympique Marselha")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("PSG")){            PtsEquipeInicial=85;        }
        if(timeFoto.equals("Reims")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Rennes")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Saint-Etienne")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Toulouse")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Anderlecht")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Brugge")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Standard Liege")){            PtsEquipeInicial=74;        }

        if(timeFoto.equals("Benfica")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Porto")){            PtsEquipeInicial=80;        }
        if(timeFoto.equals("Sporting")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Braga")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Vitória Guimarães")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Ajax")){            PtsEquipeInicial=81;        }
        if(timeFoto.equals("Feyenoord")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("PSV")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Celtic")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Glasgow Rangers")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Rosemborg")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Malmo")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Copenhague")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("RB Salzburg")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Rapid Viena")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Basel")){            PtsEquipeInicial=77;        }

        if(timeFoto.equals("Zenit")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("CSKA")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Krasnodar")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Spartak Moscou")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Galatasaray")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Fenerbahce")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Besiktas")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Olympiakos")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Estrela Vermelha")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Partizan")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Ludogorets")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Dinamo Zagreb")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Shaktar Donetsk")){            PtsEquipeInicial=79;        }
        if(timeFoto.equals("Dinamo Kiev")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Sparta Praga")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("APOEL")){            PtsEquipeInicial=75;        }

        if(timeFoto.equals("Birmigham")){            PtsEquipeInicial=72;        }
        if(timeFoto.equals("Blackburn")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Burnley")){            PtsEquipeInicial=73;        }
        if(timeFoto.equals("Brighton")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Derby Count")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Fulham")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("Hull City")){            PtsEquipeInicial=73;        }
        if(timeFoto.equals("Middlesbrough")){      PtsEquipeInicial=75;        }
        if(timeFoto.equals("Norwich")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Nottingham Forest")){    PtsEquipeInicial=76;        }
        if(timeFoto.equals("QPR")){                PtsEquipeInicial=73;        }
        if(timeFoto.equals("Reading")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Sheffield United")){    PtsEquipeInicial=78;        }
        if(timeFoto.equals("Stoke City")){            PtsEquipeInicial=77;        }
        if(timeFoto.equals("Swansea")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Watford")){            PtsEquipeInicial=77;        }

        if(timeFoto.equals("Avaí")){                PtsEquipeInicial=72;        }
        if(timeFoto.equals("Botafogo-SP")){            PtsEquipeInicial=69;     }
        if(timeFoto.equals("Bragantino")){            PtsEquipeInicial=74;      }
        if(timeFoto.equals("Ceará")){               PtsEquipeInicial=74;        }
        if(timeFoto.equals("Coritiba")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Criciúma")){            PtsEquipeInicial=71;        }
        if(timeFoto.equals("Figueirense")){         PtsEquipeInicial=73;        }
        if(timeFoto.equals("Fortaleza")){          PtsEquipeInicial=75;         }
        if(timeFoto.equals("Guarani")){            PtsEquipeInicial=72;         }
        if(timeFoto.equals("Juventude")){         PtsEquipeInicial=71;          }
        if(timeFoto.equals("Naútico")){            PtsEquipeInicial=73;         }
        if(timeFoto.equals("Paraná")){            PtsEquipeInicial=72;          }
        if(timeFoto.equals("Paysandu")){          PtsEquipeInicial=70;          }
        if(timeFoto.equals("Ponte Preta")){       PtsEquipeInicial=73;          }
        if(timeFoto.equals("Santa Cruz")){        PtsEquipeInicial=71;          }
        if(timeFoto.equals("Vitória")){            PtsEquipeInicial=73;         }

        if(timeFoto.equals("Argentino Juniors")){       PtsEquipeInicial=73;        }
        if(timeFoto.equals("Arsenal Sarandí")){            PtsEquipeInicial=72;     }
        if(timeFoto.equals("Banfield")){            PtsEquipeInicial=74;      }
        if(timeFoto.equals("Boca Juniors")){               PtsEquipeInicial=80;        }
        if(timeFoto.equals("Colón")){                PtsEquipeInicial=72;        }
        if(timeFoto.equals("Estudiantes")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("Independiente")){         PtsEquipeInicial=77;        }
        if(timeFoto.equals("Huracán")){             PtsEquipeInicial=75;         }
        if(timeFoto.equals("Lanús")){               PtsEquipeInicial=76;         }
        if(timeFoto.equals("Newell's Old Boys")){         PtsEquipeInicial=76;          }
        if(timeFoto.equals("Racing")){               PtsEquipeInicial=79;         }
        if(timeFoto.equals("River Plate")){            PtsEquipeInicial=80;          }
        if(timeFoto.equals("Rosario Central")){          PtsEquipeInicial=76;          }
        if(timeFoto.equals("San Lorenzo")){          PtsEquipeInicial=78;          }
        if(timeFoto.equals("Talleres")){              PtsEquipeInicial=74;          }
        if(timeFoto.equals("Vélez Sarsfield")){            PtsEquipeInicial=76;         }

        if(timeFoto.equals("Peñarol")){       PtsEquipeInicial=76;        }
        if(timeFoto.equals("Nacional")){            PtsEquipeInicial=75;     }
        if(timeFoto.equals("Olimpia")){            PtsEquipeInicial=78;      }
        if(timeFoto.equals("Cerro Porteño")){               PtsEquipeInicial=75;        }
        if(timeFoto.equals("Libertad")){                PtsEquipeInicial=76;        }
        if(timeFoto.equals("Colo-Colo")){            PtsEquipeInicial=76;        }
        if(timeFoto.equals("LaU")){         PtsEquipeInicial=75;        }
        if(timeFoto.equals("Univ. Católica")){             PtsEquipeInicial=75;         }
        if(timeFoto.equals("Bolívar")){               PtsEquipeInicial=74;         }
        if(timeFoto.equals("Alianza Lima")){         PtsEquipeInicial=74;          }
        if(timeFoto.equals("Sporting Cristal")){               PtsEquipeInicial=73;         }
        if(timeFoto.equals("Cienciano")){            PtsEquipeInicial=72;          }
        if(timeFoto.equals("Barcelona-EQU")){          PtsEquipeInicial=76;          }
        if(timeFoto.equals("Emelec")){          PtsEquipeInicial=76;          }
        if(timeFoto.equals("LDU")){              PtsEquipeInicial=77;          }
        if(timeFoto.equals("Caracas")){            PtsEquipeInicial=73;         }

        if(timeFoto.equals("América de Cali")){       PtsEquipeInicial=76;        }
        if(timeFoto.equals("Atlético Nacional")){            PtsEquipeInicial=77;     }
        if(timeFoto.equals("Deportivo Cali")){            PtsEquipeInicial=75;      }
        if(timeFoto.equals("Junior")){               PtsEquipeInicial=76;        }
        if(timeFoto.equals("I. Medellín")){                PtsEquipeInicial=75;        }
        if(timeFoto.equals("Once Caldas")){            PtsEquipeInicial=74;        }
        if(timeFoto.equals("Millonarios")){         PtsEquipeInicial=76;        }
        if(timeFoto.equals("Santa Fé")){             PtsEquipeInicial=75;         }
        if(timeFoto.equals("América-MEX")){               PtsEquipeInicial=76;         }
        if(timeFoto.equals("Chivas Guadalajara")){         PtsEquipeInicial=75;          }
        if(timeFoto.equals("Cruz Azul")){               PtsEquipeInicial=74;         }
        if(timeFoto.equals("Monterrey")){            PtsEquipeInicial=77;          }
        if(timeFoto.equals("Pachuca")){          PtsEquipeInicial=74;          }
        if(timeFoto.equals("Pumas")){          PtsEquipeInicial=75;          }
        if(timeFoto.equals("Tigres")){              PtsEquipeInicial=77;          }
        if(timeFoto.equals("Toluca")){            PtsEquipeInicial=73;         }

        if(timeFoto.equals("Ghuagzhou Evergrande")){       PtsEquipeInicial=79;        }
        if(timeFoto.equals("Beijing Guoan")){            PtsEquipeInicial=76;     }
        if(timeFoto.equals("Shandong Luneng")){            PtsEquipeInicial=77;      }
        if(timeFoto.equals("Shanghai SIPG")){               PtsEquipeInicial=79;        }
        if(timeFoto.equals("Kashima Antlers")){                PtsEquipeInicial=77;        }
        if(timeFoto.equals("Urawa Red Diamonds")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Vissel Kobe")){             PtsEquipeInicial=78;         }
        if(timeFoto.equals("FC Tokyo")){               PtsEquipeInicial=75;         }
        if(timeFoto.equals("FC Seoul")){         PtsEquipeInicial=75;        }
        if(timeFoto.equals("Jeonbuk Hyundai")){            PtsEquipeInicial=78;         }
        if(timeFoto.equals("Al Ain-EAU")){         PtsEquipeInicial=76;          }
        if(timeFoto.equals("Al Sadd-QAT")){               PtsEquipeInicial=76;         }
        if(timeFoto.equals("Al Duhail-QAT")){            PtsEquipeInicial=75;          }
        if(timeFoto.equals("Al Ahli")){          PtsEquipeInicial=75;          }
        if(timeFoto.equals("Al Hilal")){          PtsEquipeInicial=78;          }
        if(timeFoto.equals("Persepolis")){              PtsEquipeInicial=75;          }

        if(timeFoto.equals("Sydney FC")){       PtsEquipeInicial=75;        }
        if(timeFoto.equals("Melbourne Victory")){            PtsEquipeInicial=76;     }
        if(timeFoto.equals("Suwon Samsung")){               PtsEquipeInicial=79;        }
        if(timeFoto.equals("Ulsan Hyundai")){            PtsEquipeInicial=78;        }
        if(timeFoto.equals("Jiangsu Suning")){         PtsEquipeInicial=75;        }
        if(timeFoto.equals("Shanghai Shenhua")){                PtsEquipeInicial=77;        }
        if(timeFoto.equals("Cerezo Osaka")){         PtsEquipeInicial=76;          }
        if(timeFoto.equals("Kawasaki Frontale")){               PtsEquipeInicial=76;         }
        if(timeFoto.equals("Kashiwa Reysol")){            PtsEquipeInicial=75;          }
        if(timeFoto.equals("Gamba Osaka")){          PtsEquipeInicial=75;          }
        if(timeFoto.equals("Yokohama F-Marinos")){            PtsEquipeInicial=77;      }
        if(timeFoto.equals("Al Nassr")){             PtsEquipeInicial=78;         }
        if(timeFoto.equals("Al Ittihad")){               PtsEquipeInicial=75;         }
        if(timeFoto.equals("Pakhtakor-UZB")){            PtsEquipeInicial=78;         }
        if(timeFoto.equals("Sepahan")){          PtsEquipeInicial=78;          }
        if(timeFoto.equals("Esteghlal")){              PtsEquipeInicial=74;          }

        if(timeFoto.equals("Atlanta United")){       PtsEquipeInicial=77;        }
        if(timeFoto.equals("Chicago Fire")){            PtsEquipeInicial=74;     }
        if(timeFoto.equals("Columbus Crew")){               PtsEquipeInicial=73;        }
        if(timeFoto.equals("DC United")){            PtsEquipeInicial=75;        }
        if(timeFoto.equals("FC Dallas")){         PtsEquipeInicial=74;        }
        if(timeFoto.equals("Houston Dynamo")){                PtsEquipeInicial=75;        }
        if(timeFoto.equals("LA Galaxy")){            PtsEquipeInicial=76;          }
        if(timeFoto.equals("New England Revolution")){               PtsEquipeInicial=74;         }
        if(timeFoto.equals("NY City")){          PtsEquipeInicial=75;          }
        if(timeFoto.equals("NY Red Bulls")){            PtsEquipeInicial=75;      }
        if(timeFoto.equals("Orlando City")){             PtsEquipeInicial=76;         }
        if(timeFoto.equals("Portland Timbers")){               PtsEquipeInicial=74;         }
        if(timeFoto.equals("Seattle Sounders")){            PtsEquipeInicial=76;         }
        if(timeFoto.equals("Sporting Kansas City")){          PtsEquipeInicial=75;          }
        if(timeFoto.equals("Toronto FC")){              PtsEquipeInicial=76;          }
        if(timeFoto.equals("Vancouver Whitecaps")){         PtsEquipeInicial=73;          }
        return PtsEquipeInicial;
    }
}
