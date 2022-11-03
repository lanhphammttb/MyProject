package Model;

public class HoaDon {

    String MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, KhuyenMai, TongTien, GhiChu;

    public HoaDon() {
    }

    public HoaDon(String MaHoaDon, String MaKhachHang, String MaNhanVien, String NgayLapHoaDon, String KhuyenMai, String TongTien, String GhiChu) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.NgayLapHoaDon = NgayLapHoaDon;
        this.KhuyenMai = KhuyenMai;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNgayLapHoaDon() {
        return NgayLapHoaDon;
    }

    public void setNgayLapHoaDon(String NgayLapHoaDon) {
        this.NgayLapHoaDon = NgayLapHoaDon;
    }

    public String getKhuyenMai() {
        return KhuyenMai;
    }

    public void setKhuyenMai(String KhuyenMai) {
        this.KhuyenMai = KhuyenMai;
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
