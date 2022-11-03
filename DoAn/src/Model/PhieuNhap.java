package Model;

/**
 *
 * @author PLanh
 */
public class PhieuNhap {
    String MaPhieuNhap, MaNhanVien, MaNCC, NgayNhap, TongTien, GhiChu;

    public PhieuNhap() {
    }

    public PhieuNhap(String MaPhieuNhap, String MaNhanVien, String MaNCC, String NgayNhap, String TongTien, String GhiChu) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNhanVien = MaNhanVien;
        this.MaNCC = MaNCC;
        this.NgayNhap = NgayNhap;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
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
