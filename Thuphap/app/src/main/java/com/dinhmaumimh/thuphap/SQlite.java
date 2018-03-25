package com.dinhmaumimh.thuphap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 3/15/2018.
 */

public class SQlite extends SQLiteOpenHelper {
    public  static  final String DATABASE_NAME = "thuphap_list";
    public  static  final String TABLE_NAME = "thuphap";
    public  static  final  String ID = "id";
    public  static  final  String TIEUDE = "tieude";
    public  static  final  String NOIDUNG = "noidung";
    public  static  final  String DANHMUC = "danhmuc";
    public  static  final  String TACGIA = "tacgia";
    private  Context context;
    public SQlite(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("database", "SQlite:databsemanager ");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQUERY = "CREATE TABLE "+TABLE_NAME+"("+
                ID +" integer primary key autoincrement , "+
                TIEUDE + " TEXT, "+
                NOIDUNG +" TEXT, "+
                DANHMUC +" TEXT, "+
                TACGIA + " TEXT )";
        db.execSQL(sqlQUERY);
        Toast.makeText(context,"Create thanh cong",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

         db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
         onCreate(db);
         Toast.makeText(context, "Update thanh cong", Toast.LENGTH_SHORT).show();
    }
    public void addThuphap(String tieude,String noidung,String danhmuc,String tacgia){
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues ct = new ContentValues();
        ct.put(TIEUDE,tieude);
        ct.put(NOIDUNG,noidung);
        ct.put(DANHMUC,danhmuc);
        ct.put(TACGIA,tacgia);
        sq.insert(TABLE_NAME,null,ct);
        sq.close();
    }
    public  void Delete(int id){
        SQLiteDatabase SQ = this.getWritableDatabase();
        SQ.delete(TABLE_NAME,"id"+id,null);
        SQ.close();

    }
    public  Thuphap tim(int id){
        SQLiteDatabase Sq = getReadableDatabase();
        Cursor cu = Sq.rawQuery("select * from thuphap where id = "+id,null);
        if(cu.getCount() > 0){
            cu.moveToFirst();
            Thuphap tp = new Thuphap(cu.getInt(0),cu.getString(1), cu.getString(2), cu.getString(3),cu.getString(4));
            return tp;

        }else
        {
            return  null;
        }
    }
    public ArrayList<Thuphap>  danhsach(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cu = db.rawQuery("select id,tieude,noidung,danhmuc,tacgia from thuphap ",null);
        if(cu.getCount() >0){
            ArrayList<Thuphap> tp = new ArrayList<Thuphap>();
            Thuphap tp1;
            while (cu.moveToNext()){
                tp1 = new Thuphap(cu.getInt(0),cu.getString(1),cu.getString(2),cu.getColumnName(3),cu.getString(4));
                tp.add(tp1);
            }

            return  tp;
        }else{
            return null;
        }
    }

}
