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
public class ChiTietPhieuNhap {
    String MaCTPN, MaPhieuNhap, MaSanPham,TongTien, GhiChu, SoLuong;
    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(String MaCTPN, String MaPhieuNhap, String MaSanPham, String SoLuong, String TongTien, String GhiChu) {
        this.MaCTPN = MaCTPN;
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public String getMaCTPN() {
        return MaCTPN;
    }

    public void setMaCTPN(String MaCTPN) {
        this.MaCTPN = MaCTPN;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
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

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    

}

