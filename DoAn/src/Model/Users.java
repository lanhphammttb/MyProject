package Model;

public class Users {
    String ID, MaNhanVien, UserName, PassWord, Quyen, GhiChu;

    public Users() {
    }

    public Users(String ID, String MaNhanVien, String UserName, String PassWord, String Quyen, String GhiChu) {
        this.ID = ID;
        this.MaNhanVien = MaNhanVien;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.Quyen = Quyen;
        this.GhiChu = GhiChu;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
