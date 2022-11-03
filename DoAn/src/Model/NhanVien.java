package Model;

public class NhanVien {
    String MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SDT, CMND;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String TenNhanVien, String NgaySinh, String GioiTinh, String NgayVaoLam, String ChucVu, String DiaChi, String SDT, String CMND) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.NgayVaoLam = NgayVaoLam;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CMND = CMND;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
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

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
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

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }


}
