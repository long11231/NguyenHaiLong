/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenhailong_ph42034;

import java.io.Serializable;

/**
 *
 * @author H.Long
 */
public class SinhVien implements Serializable{
    private String ten;
    private String mssv;
    private double toan;
    private double van;
    private double anh;

    public SinhVien() {
    }

    public SinhVien(String ten, String mssv, double toan, double van, double anh) {
        this.ten = ten;
        this.mssv = mssv;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getAnh() {
        return anh;
    }

    public void setAnh(double anh) {
        this.anh = anh;
    }

    public double dtb(){
        return (this.toan+this.anh+this.van)/3;
    }
}
