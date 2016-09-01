package com.carlospanarello.quadromedalhasrio2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.carlospanarello.quadromedalhasrio2016.model.ItemMedalhasPais;
import com.carlospanarello.quadromedalhasrio2016.model.ItemQuadroMedalha;


public class ModelHelper extends SQLiteOpenHelper implements Serializable {
    private static final String LOG = "ModelHelper";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "model";

    // Table names
    private static final String TABLE_QUADRO = "QuadroMedalha";
    private static final String TABLE_MEDALHA_PAIS = "MedalhaPais";
    private static final String TABLE_ATUALIZACAO = "Atualizado";

    // Common column names
    private static final String KEY_ID = "_id";
    private static final String ID_COUNTRY = "id_country";
    private static final String GOLD = "gold_count";
    private static final String SILVER = "silver_count";
    private static final String BRONZE = "bronze_count";

    // Table QuadroMedalha columns
    private static final String NOME_PAIS = "name_country";
    private static final String TOTAL = "total_medals";
    private static final String POSICAO = "position";

    // Table MedalhaPais columns
    private static final String ID_SPORT = "id_sport";
    private static final String SPORT_NAME = "sport_name";

    //Tabel Atualizacao
    private static final String DATA = "dataAtualizacao";


    // ItemQuestion table create statement
    private static final String CREATE_TABLE_QUADRO =
            "CREATE TABLE " + TABLE_QUADRO + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + ID_COUNTRY + " TEXT ,"
                    + GOLD + " INTEGER ,"
                    + SILVER + " INTEGER ,"
                    + BRONZE + " INTEGER ,"
                    + NOME_PAIS + " TEXT ,"
                    + TOTAL + " INTEGER ,"
                    + POSICAO + " INTEGER "
                    + ");";

    // Answer table create statement
    private static final String CREATE_TABLE_MEDALHA_PAIS =
            "CREATE TABLE " + TABLE_MEDALHA_PAIS + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + ID_COUNTRY + " TEXT ,"
                    + GOLD + " INTEGER ,"
                    + SILVER + " INTEGER ,"
                    + BRONZE + " INTEGER ,"
                    + ID_SPORT + " TEXT ,"
                    + SPORT_NAME + " TEXT "
                    + ");";

    // Answer table create statement
    private static final String CREATE_TABLE_ATUALIZACAO =
            "CREATE TABLE " + TABLE_ATUALIZACAO + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + DATA + " TEXT "
                    + ");";

    public ModelHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void popularQuadro(ItemQuadroMedalha[] mVO) {
        SQLiteDatabase db = this.getWritableDatabase();

        for(ItemQuadroMedalha item :  mVO ){

            if(item != null) {
                ContentValues values = new ContentValues();
                //values.put(KEY_ID, arg.getId());
                values.put(ID_COUNTRY, item.getId_country());
                values.put(GOLD, item.getGold_count());
                values.put(SILVER, item.getSilver_count());
                values.put(BRONZE, item.getBronze_count());
                values.put(NOME_PAIS, item.getName_country());
                values.put(TOTAL, item.getTotal_medals());
                values.put(POSICAO, item.getPosition());

                db.insert(TABLE_QUADRO, null, values);
            }
        }
    }

    public void popularMedalhaPais(ItemMedalhasPais[] quadro) {
        SQLiteDatabase db = this.getWritableDatabase();

        for(ItemMedalhasPais item:quadro ){

            ContentValues values = new ContentValues();
            //values.put(KEY_ID, arg.getId());
            values.put(ID_COUNTRY, item.getId_country());
            values.put(GOLD, item.getGold_count());
            values.put(SILVER, item.getSilver_count());
            values.put(BRONZE, item.getBronze_count());
            values.put(SPORT_NAME, item.getSport_name());
            values.put(ID_SPORT, item.getId_sport());

            db.insert(TABLE_MEDALHA_PAIS, null, values);
        }
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_QUADRO, KEY_ID + " > " + 0, null);
        db.delete(TABLE_MEDALHA_PAIS, KEY_ID + " > " + 0, null);
        db.delete(TABLE_ATUALIZACAO, KEY_ID + " > " + 0, null);
    }

    public void deleteAllQuadro(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_QUADRO, KEY_ID + " > " + 0, null);
    }

    public void deleteAllMedalhaPais(String country){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MEDALHA_PAIS, ID_COUNTRY + " LIKE '" + country + "'" , null);
    }

    public void deleteAllAtualizacao(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ATUALIZACAO, KEY_ID + " > " + 0, null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_ATUALIZACAO);
        db.execSQL(CREATE_TABLE_MEDALHA_PAIS);
        db.execSQL(CREATE_TABLE_QUADRO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATUALIZACAO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDALHA_PAIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUADRO);
        // create new tables
        onCreate(db);
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public List<ItemQuadroMedalha> getQuadroMedalhas() {
        List<ItemQuadroMedalha> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUADRO;

        Log.i(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                // adding to todo list
                list.add(montaItemQuadro(c));
            } while (c.moveToNext());
        }

        return list;
    }

    private ItemQuadroMedalha montaItemQuadro(Cursor c) {
        ItemQuadroMedalha entry = new ItemQuadroMedalha();
        entry.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        entry.setBronze_count(c.getInt(c.getColumnIndex(BRONZE)));
        entry.setSilver_count(c.getInt(c.getColumnIndex(SILVER)));
        entry.setGold_count(c.getInt(c.getColumnIndex(GOLD)));
        entry.setName_country(c.getString(c.getColumnIndex(NOME_PAIS)));
        entry.setPosition(c.getInt(c.getColumnIndex(POSICAO)));
        entry.setTotal_medals(c.getInt(c.getColumnIndex(TOTAL)));
        entry.setId_country(c.getString(c.getColumnIndex(ID_COUNTRY)));

        return entry;
    }

    public List<ItemMedalhasPais> getMedalhasPais(String country) {
        List<ItemMedalhasPais> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MEDALHA_PAIS
                + " WHERE " + ID_COUNTRY + " LIKE '" + country + "'" ;

        Log.i(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                // adding to todo list
                list.add(montaItemMedalhaPais(c));
            } while (c.moveToNext());
        }

        return list;
    }

    private ItemMedalhasPais montaItemMedalhaPais(Cursor c) {
        ItemMedalhasPais entry = new ItemMedalhasPais();
        entry.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        entry.setBronze_count(c.getInt(c.getColumnIndex(BRONZE)));
        entry.setSilver_count(c.getInt(c.getColumnIndex(SILVER)));
        entry.setGold_count(c.getInt(c.getColumnIndex(GOLD)));
        entry.setId_sport(c.getString(c.getColumnIndex(ID_SPORT)));
        entry.setSport_name(c.getString(c.getColumnIndex(SPORT_NAME)));
        entry.setId_country(c.getString(c.getColumnIndex(ID_COUNTRY)));

        return entry;
    }

    public void incluiDataUltimaAtualizacao(String data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DATA, data);

        db.insert(TABLE_ATUALIZACAO, null, values);
    }

    public long updateDataAtualizacao(String data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, 1);
        values.put(DATA, data);

        // updating row
        return db.update(TABLE_ATUALIZACAO, values, KEY_ID + " = ?",
                new String[]{String.valueOf(1)});
    }

    public String buscaDataAtualizacao(){
        String retorno =null;
        try {
            String selectQuery = "SELECT * FROM " + TABLE_ATUALIZACAO
                    + " WHERE " + KEY_ID + " = 1";

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            retorno = c.getString(c.getColumnIndex(DATA));
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(retorno == null || retorno.isEmpty()){
            retorno = "2016-01-01 00:00:00.000";
        }

        return retorno;

    }
}