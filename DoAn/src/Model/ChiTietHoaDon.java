/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jangx
 */
public class ChiTietHoaDon {
    String MaCTHD, MaHoaDon, MaSanPham,TongTien, SoLuong;
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaCTHD, String MaHoaDon, String MaSanPham, String SoLuong, String TongTien) {
        this.MaCTHD = MaCTHD;
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public String getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(String MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

}

