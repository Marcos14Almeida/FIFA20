package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class ActivityHistorico extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    RadioButton botaoCampeao;
    ListAdapter listAdapter;
    Spinner spinner;
    boolean flagBotao=false;
    int ano,max,max2,campeonato, ntitulosNacionais=0,ntitulosNacionais2=0,ntitulosInternacionais=0;
    String meutime;
    ListView listView;
    Integer itemEscolhido=1;
    ArrayList<Integer> historicoMinhaPosicao = new ArrayList<>();
    ArrayList<Integer> historicoMeuCampeonato = new ArrayList<>();
    ArrayList<String> timesOrdem= new ArrayList<>();
    ArrayList<String> textoHistorico= new ArrayList<>();
    ArrayList<String> textoMeuHistoricoChampions= new ArrayList<>();
    ArrayList<String> textoFinal= new ArrayList<>(); //lista 1
    ArrayList<String> textoHistoricoCampeonatosTotal= new ArrayList<>();//lista 3
    ArrayList<String> textoHistoricoCampeonatos= new ArrayList<>();
    ArrayList<String> historicoCampeonatos = new ArrayList<>(); //lista2
    ArrayList<String> historicoChampionsLeague = new ArrayList<>();
    ArrayList<Integer> historicoMeuChampions = new ArrayList<>();
    ArrayList<String> historicoLibertadores = new ArrayList<>();
    ArrayList<Integer> historicoMeuLibertadores = new ArrayList<>();
    ImageView trofeu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        //GLOBAL
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        historicoMinhaPosicao = globalVariable.SaberHistoricoMinhaPosicao();
        ano = globalVariable.SaberAno();
        meutime  = globalVariable.Sabermeutime();
        max= globalVariable.SaberMax();
        max2=globalVariable.SaberMax2();
        timesOrdem=globalVariable.SabertimesOrdem();
        historicoMeuCampeonato = globalVariable.SaberHistoricoMeuCampeonato();
        historicoCampeonatos = globalVariable.SaberHistoricoCampeonatos();
        campeonato = globalVariable.SaberCampeonato();

        ArrayList<Integer> arrayAno = new ArrayList<>();
        //Campeonato Nacional
        int minhaposicao = timesOrdem.indexOf(meutime)%max;
        if(minhaposicao==0){minhaposicao=max;}

         ///////////////////////////////////////////////////////////////////////////
        //Meus Titulos
        ///////////////////////////////////////////////////////////////////////////
        //historico Champions
        historicoMeuChampions.clear();
        historicoMeuChampions=globalVariable.SaberHistoricoMeuChampions();
        //historico Libertadores
        historicoMeuLibertadores.clear();
        historicoMeuLibertadores=globalVariable.SaberHistoricoMeuLibertadores();
        int i=0;
        if(ano>2020){
            for(i=0;i<historicoMeuChampions.size();i++ ){
                if(historicoMeuCampeonato.get(i)>=2 && historicoMeuCampeonato.get(i)<10){
                if(historicoMeuChampions.get(i)==0)textoMeuHistoricoChampions.add("Não Participou");
                if(historicoMeuChampions.get(i)==32)textoMeuHistoricoChampions.add("Fase de Grupos");
                if(historicoMeuChampions.get(i)==16)textoMeuHistoricoChampions.add("Oitavas");
                if(historicoMeuChampions.get(i)==8)textoMeuHistoricoChampions.add("Quartas");
                if(historicoMeuChampions.get(i)==4)textoMeuHistoricoChampions.add("Semifinal");
                if(historicoMeuChampions.get(i)==2)textoMeuHistoricoChampions.add("Vice");
                if(historicoMeuChampions.get(i)==1){textoMeuHistoricoChampions.add("Campeão");ntitulosInternacionais++;}
                }
                if(historicoMeuCampeonato.get(i)==1 || historicoMeuCampeonato.get(i)>=10){
                if(historicoMeuLibertadores.get(i)==0)textoMeuHistoricoChampions.add("Não Participou");
                if(historicoMeuLibertadores.get(i)==32)textoMeuHistoricoChampions.add("Fase de Grupos");
                if(historicoMeuLibertadores.get(i)==16)textoMeuHistoricoChampions.add("Oitavas");
                if(historicoMeuLibertadores.get(i)==8)textoMeuHistoricoChampions.add("Quartas");
                if(historicoMeuLibertadores.get(i)==4)textoMeuHistoricoChampions.add("Semifinal");
                if(historicoMeuLibertadores.get(i)==2)textoMeuHistoricoChampions.add("Vice");
                if(historicoMeuLibertadores.get(i)==1){textoMeuHistoricoChampions.add("Campeão");ntitulosInternacionais++;}
            }
        }
        }

        i=0;
        ano=globalVariable.SaberAno();
        while(ano>2020) {
           arrayAno.add(i+2020);
           //2ªDivisão
           if(historicoMeuCampeonato.get(i)==9 || historicoMeuCampeonato.get(i)==10){textoHistorico.add(arrayAno.get(i)+": "+historicoMinhaPosicao.get(i)+"º - 2ªdivisão");}
           else{textoHistorico.add(arrayAno.get(i)+": "+historicoMinhaPosicao.get(i)+"º");}
           //texto final mostrado
            if(historicoMeuCampeonato.get(i)>=2 && historicoMeuCampeonato.get(i)<10){textoFinal.add(textoHistorico.get(i)+" - Champions: "+textoMeuHistoricoChampions.get(i));}
            if(historicoMeuCampeonato.get(i)==1 || historicoMeuCampeonato.get(i)>=10){textoFinal.add(textoHistorico.get(i)+" - Libertadores: "+textoMeuHistoricoChampions.get(i));}
            //ADICIONA TITULOS
           if(historicoMinhaPosicao.get(i)==1 && (historicoMeuCampeonato.get(i)!=9 && historicoMeuCampeonato.get(i)!=10)){ntitulosNacionais=ntitulosNacionais+1;}
            if(historicoMinhaPosicao.get(i)==1 && (historicoMeuCampeonato.get(i)==9 || historicoMeuCampeonato.get(i)==10)){ntitulosNacionais2=ntitulosNacionais2+1;}
            i++;
            ano--;
        }
        ano = globalVariable.SaberAno();
        if(campeonato==9 || campeonato==10){textoFinal.add(ano+": "+minhaposicao+"º - 2ªdivisão");}
        else{textoFinal.add(ano+": "+minhaposicao+"º");}
        listView = findViewById(R.id.lista);
        listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,textoFinal);
        listView.setAdapter(listAdapter);

         /////////////////////////////////////////////////////////////////////////////////////
        //                               SPINNER                                            //
        //////////////////////////////////////////////////////////////////////////////////////

        spinner=findViewById(R.id.spinner);
        final ArrayList<String> items = new ArrayList<>();
        items.add("Meu Histórico");
        items.add("Champions League");
        items.add("Libertadores");
        lista(0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                items.get(position);
                if(position==0){lista(0);}
                if(position==1){lista(1);}
                if(position==2){lista(2);}

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       //BOTAO DE CAMPEAO
        botaoCampeao =findViewById(R.id.botaoCampeao);
        botaoCampeao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagBotao=!flagBotao;
                                            lista3();
                if(!flagBotao)botaoCampeao.setChecked(false);
                if(flagBotao)botaoCampeao.setChecked(true);
            }
        });


        ///////////////////////////////////////////////////////////////////////////
        //IMAGEM TROFÉU
        ///////////////////////////////////////////////////////////////////////////
        trofeu = findViewById(R.id.trofeuNacional);
        if(campeonato==1){trofeu.setImageResource(R.drawable.trophybrasileirao);}
        if(campeonato==2){trofeu.setImageResource(R.drawable.trophypremier);}
        if(campeonato==3){trofeu.setImageResource(R.drawable.trophyitalia);}
        if(campeonato==4){trofeu.setImageResource(R.drawable.trophylaliga);}
        if(campeonato==5){trofeu.setImageResource(R.drawable.trophybundesliga);}
        if(campeonato==6){trofeu.setImageResource(R.drawable.trophyligue1);}
        if(campeonato>=7){trofeu.setImageResource(R.drawable.trophyliga);}

        trofeu = findViewById(R.id.trofeuInternacional);
        if(campeonato>=2 && campeonato<=9){trofeu.setImageResource(R.drawable.trophychampions);}


        TextView titulos = findViewById(R.id.textoTitulosNacionais);
        titulos.setText(String.valueOf(ntitulosNacionais));
        titulos = findViewById(R.id.textoTitulos2divisao);
        titulos.setText(String.valueOf(ntitulosNacionais2));
        titulos = findViewById(R.id.textoTitulosInternacionais);
        titulos.setText(String.valueOf(ntitulosInternacionais));

        //scoreJogo;
        TextView textoScore = findViewById(R.id.textoScore);
        textoScore.setText("Score: "+globalVariable.SaberScoreJogo());
    }//onCreate



    ///////////////////////////////////////////////////////////////////////////
    //                       FUNÇÕES                                        //
    ///////////////////////////////////////////////////////////////////////////
    public void lista(Integer position){
        textoHistoricoCampeonatos.clear();
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        //CAMPEOES CHAMPIONS
        historicoChampionsLeague=globalVariable.SaberHistoricoChampionsLeague();
        historicoLibertadores=globalVariable.SaberHistoricoLibertadores();
        if(position==0) {
            listView = findViewById(R.id.lista);
            listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,textoFinal);
            listView.setAdapter(listAdapter);
        }
        if(position==1) {
            for (int kano = 1; kano <= ano - 2020; kano++) {
                textoHistoricoCampeonatos.add((2020 + kano - 1) + ":\n " + historicoChampionsLeague.get((2 * (kano - 1))) + " x " + historicoChampionsLeague.get((2 * (kano - 1)) + 1));
                }
            listView = findViewById(R.id.lista);
            listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,textoHistoricoCampeonatos);
            listView.setAdapter(listAdapter);
        }
        if(position==2) {
            for (int kano = 1; kano <= ano - 2020; kano++) {
              textoHistoricoCampeonatos.add((2020 + kano - 1) + ":\n " + historicoLibertadores.get((2 * (kano - 1))) + " x " + historicoLibertadores.get((2 * (kano - 1)) + 1));
            }
            listView = findViewById(R.id.lista);
            listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,textoHistoricoCampeonatos);
            listView.setAdapter(listAdapter);
        }

    }




    public void popupCampeonatos(View view){
        PopupMenu pop = new PopupMenu(this,view);
        pop.setOnMenuItemClickListener(this);
        pop.inflate(R.menu.popup_lista_campeonatos);
        pop.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                itemEscolhido=1;lista3();
                return true;
            case R.id.item2:
                itemEscolhido=2;lista3();
                return true;
            case R.id.item3:
                itemEscolhido=3;lista3();
                return true;
            case R.id.item4:
                itemEscolhido=4;lista3();
                return true;
            case R.id.item5:
                itemEscolhido=5;lista3();
                return true;
            case R.id.item6:
                itemEscolhido=6;lista3();
                return true;
            case R.id.item7:
                itemEscolhido=7;lista3();
                return true;
            case R.id.item8:
                itemEscolhido=8;lista3();
                return true;
            case R.id.item9:
                itemEscolhido=9;lista3();
                return true;
            case R.id.item10:
                itemEscolhido=10;lista3();
                return true;
            case R.id.item11:
                itemEscolhido=11;lista3();
                return true;
            case R.id.item12:
                itemEscolhido=12;lista3();
                return true;
            case R.id.item13:
                itemEscolhido=13;lista3();
                return true;
            default:
                return false;
        }
    }

    public void lista3(){
        //TODOS OS CAMPEÕES do item escolhido
        textoHistoricoCampeonatosTotal = new ArrayList<String>();
        if(flagBotao==false){
        for(int kano=1; kano<=ano-2020;kano++){
            for(int icampeonato=1; icampeonato<=max2;icampeonato++){
                for(int itime=1; itime<=max;itime++){
                    if(icampeonato==itemEscolhido && itime==1){
                        textoHistoricoCampeonatosTotal.add((2020+kano-1)
                                +":\n 1º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+1)
                                + "\n 2º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+2)
                                + "\n 3º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+3)
                                + "\n 4º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+4)
                                + "\n 5º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+5)
                                + "\n 6º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+6)
                                + "\n 7º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+7)
                                + "\n 8º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+8)
                                + "\n 9º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+9)
                                + "\n 10º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+10)
                                + "\n 11º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+11)
                                + "\n 12º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+12)
                                + "\n 13º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+13)
                                + "\n 14º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+14)
                                + "\n 15º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+15)
                                + "\n 16º"+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+16)
                        );
                    }}}}
}
        else{
            for(int kano=1; kano<=ano-2020;kano++){
                for(int icampeonato=1; icampeonato<=max2;icampeonato++){
                    for(int itime=1; itime<=max;itime++){
                        if(icampeonato==itemEscolhido && itime==1){
                            textoHistoricoCampeonatosTotal.add((2020+kano-1)
                                    +":\n 1º "+historicoCampeonatos.get( ((kano-1)*max2*max) + ((icampeonato-1)*max)+1)
                            );
                        }}}}
        }

        listView = findViewById(R.id.lista3);
        listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,textoHistoricoCampeonatosTotal);
        listView.setAdapter(listAdapter);
    }
}
