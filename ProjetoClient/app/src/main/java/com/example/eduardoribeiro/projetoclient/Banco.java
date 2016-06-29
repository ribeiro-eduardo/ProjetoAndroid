package com.example.eduardoribeiro.projetoclient;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Eduardo Ribeiro on 29/06/2016.
 */
public class Banco extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String BANCO = "projeto";
    private static final String TABELA = "entrega";

    public Banco(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABELA + " ( " +
                "id INTEGER PRIMARY KEY, " +
                "endereco varchar(255), " +
        "descricao text, "+
        "entregador_id INTEGER, "+
        "status varchar(20);");
        Log.i("BANCO", "criado");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putEntrega(Entrega entrega){
        ContentValues cv = new ContentValues();
        cv.put("entrega", entrega.getId());
        this.getWritableDatabase().insert(TABELA, null, cv);
        this.close();
    }
}
