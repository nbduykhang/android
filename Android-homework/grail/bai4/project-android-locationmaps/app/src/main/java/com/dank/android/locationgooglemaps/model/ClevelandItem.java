package com.dank.android.locationgooglemaps.model;

import java.io.Serializable;

public class ClevelandItem implements Serializable {
    private String ten;
    private String link;
    private int hinh;
    private double viDo;
    private double kinhDo;

    public ClevelandItem() {

    }

    public ClevelandItem(String ten, String link, int hinh, double viDo, double kinhDo) {
        this.ten = ten;
        this.link = link;
        this.hinh = hinh;
        this.viDo = viDo;
        this.kinhDo = kinhDo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public double getViDo() {
        return viDo;
    }

    public void setViDo(double viDo) {
        this.viDo = viDo;
    }

    public double getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(double kinhDo) {
        this.kinhDo = kinhDo;
    }

    @Override
    public String toString() {
        return this.ten;
    }
}
