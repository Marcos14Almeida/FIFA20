package com.example.teste1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//Como usar database SQLite
//https://www.youtube.com/watch?v=-wor0Po7SEc
public class Conexao extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final String DATABASE_NAME = "jogadores.db";
    private static final int version =1;
    private static final String TABLE_NAME = "jogadores";
    private static final String KEY_ID = "ID";
    private static final String KEY_NOME = "NOME";
    private static final String KEY_IDADE = "IDADE";
    private static final String KEY_OVERALL = "OVERALL";
    private static final String KEY_POTENCIAL = "POTENCIAL";

    public Conexao(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, IDADE TEXT, OVERALL TEXT, POTENCIAL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public boolean inserir(String Nome, String Idade, String Overall, String Potencial){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOME, Nome);
        values.put(KEY_IDADE,Idade);
        values.put(KEY_OVERALL,Overall);
        values.put(KEY_POTENCIAL,Potencial);
        //devolve o id
        long result = db.insert(TABLE_NAME,null,values);
        if(result==-1){return false;}
        else{
            return true;}
    }

    public String obterTodos(){
        db=this.getReadableDatabase();
        //nome da tabela, Colunas a serem consultadas,
        String[] columns = new String[]{KEY_ID,KEY_NOME,KEY_IDADE,KEY_OVERALL,KEY_POTENCIAL};
        Cursor cursor = db.query(TABLE_NAME,columns,null,null,null,null,null);
        String result="";
        int iid= cursor.getColumnIndex(KEY_ID);
        int inome= cursor.getColumnIndex(KEY_NOME);
        int iidade= cursor.getColumnIndex(KEY_IDADE);
        int ioverall= cursor.getColumnIndex(KEY_OVERALL);
        int ipotencial= cursor.getColumnIndex(KEY_POTENCIAL);


        while(cursor.moveToNext()){
            result=result+
                    "Id: "+cursor.getString(iid)+"\n"+
                    "Nome: "+cursor.getString(inome)+"\n"+
                    "Idade: "+cursor.getString(iidade)+"\n"+
                    "Overall: "+cursor.getString(ioverall)+"\n"+
                    "Potencial: "+cursor.getString(ipotencial)+"\n\n";
        }
        db.close();
        return result;
    }

    public void excluir(String id){
        db=this.getWritableDatabase();
        db.delete(TABLE_NAME,"ID = ?", new String[]{id});
    }

    public Cursor getListContent(){
        db=this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;
    }

    public void update(long l,String Nome, Integer Idade, Integer Overall, Integer Potencial){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOME, Nome);
        values.put(KEY_IDADE,Idade);
        values.put(KEY_OVERALL,Overall);
        values.put(KEY_POTENCIAL,Potencial);
        //devolve o id
        db.update(TABLE_NAME,values,KEY_ID+"="+l,null);
        db.close();
    }


    public String getNome(long l1){
        db=this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NOME,KEY_IDADE,KEY_OVERALL,KEY_POTENCIAL},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name = cursor.getString(1);
            return name;
        }
        return null;
    }
    public String getIdade(long l1){
        db=this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NOME,KEY_IDADE,KEY_OVERALL,KEY_POTENCIAL},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name = cursor.getString(2);
            return name;
        }
        return null;
    }
    public String getOverall(long l1){
        db=this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NOME,KEY_IDADE,KEY_OVERALL,KEY_POTENCIAL},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name = cursor.getString(3);
            return name;
        }
        return null;
    }
    public String getPotencial(long l1){
        db=this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NOME,KEY_IDADE,KEY_OVERALL,KEY_POTENCIAL},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name = cursor.getString(4);
            return name;
        }
        return null;
    }

    public boolean isTableExists(String tableName, boolean openDb) {
        if(openDb) {
            if(db == null || !db.isOpen()) {
                db = getReadableDatabase();
            }

            if(!db.isReadOnly()) {
                db.close();
                db = getReadableDatabase();
            }
        }

        String query = "select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'";
        try (Cursor cursor = db.rawQuery(query, null)) {
            if(cursor!=null) {
                if(cursor.getCount()>0) {
                    return true;
                }
            }
            return false;
        }
    }
}
