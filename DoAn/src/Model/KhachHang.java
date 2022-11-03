/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author LeThanhLoi
 */
public class KhachHang {
    String MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, GhiChu;

    public KhachHang() {
    }

    public KhachHang(String MaKhachHang, String TenKhachHang, String NgaySinh, String GioiTinh, String DiaChi, String SDT, String LoaiKhachHang, String GhiChu) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.LoaiKhachHang = LoaiKhachHang;
        this.GhiChu = GhiChu;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLoaiKhachHang() {
        return LoaiKhachHang;
    }

    public void setLoaiKhachHang(String LoaiKhachHang) {
        this.LoaiKhachHang = LoaiKhachHang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}
