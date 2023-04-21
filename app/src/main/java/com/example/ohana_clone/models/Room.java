package com.example.ohana_clone.models;

public class Room {

    private String tieude;
    private String diachi;
    private int soluong;
    private double gia;
    private int resourceId;

    public Room(String tieude, String diachi, int soluong, double gia, int resourceId) {
        this.tieude = tieude;
        this.diachi = diachi;
        this.soluong = soluong;
        this.gia = gia;
        this.resourceId = resourceId;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
