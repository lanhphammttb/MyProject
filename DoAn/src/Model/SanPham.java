package Model;


public class SanPham{
    String MaSanPham, TenSanPham, LoaiSanPham, Size, GiaBan;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String TenSanPham, String LoaiSanPham, String Size, String GiaBan) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.LoaiSanPham = LoaiSanPham;
        this.Size = Size;
        this.GiaBan = GiaBan;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(String LoaiSanPham) {
        this.LoaiSanPham = LoaiSanPham;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }
}