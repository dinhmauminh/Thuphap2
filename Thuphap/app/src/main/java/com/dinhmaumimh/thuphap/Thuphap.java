package com.dinhmaumimh.thuphap;

/**
 * Created by Admin on 3/15/2018.
 */

public class Thuphap {
    private int id;
    private  String tieude;

    public Thuphap(int id, String tieude, String noidung, String danhmuc, String tacgia) {
        this.id = id;
        this.tieude = tieude;
        this.noidung = noidung;
        this.danhmuc = danhmuc;
        this.tacgia = tacgia;
    }

    private  String noidung;
    private  String danhmuc;
    private  String tacgia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }


}
