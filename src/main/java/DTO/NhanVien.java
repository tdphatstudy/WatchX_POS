package DTO;

public class NhanVien {
    private int idNhanVien;
    private String hoNhanVien;
    private String  tenNhanVien;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String password;
    private int luong;
    private String chucVu;

    public NhanVien() {
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVien(int idNhanVien, String hoNhanVien, String tenNhanVien, String diaChi, String email, String soDienThoai, String password, int luong, String chucVu) {
        this.idNhanVien = idNhanVien;
        this.hoNhanVien = hoNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.password = password;
        this.luong = luong;
        this.chucVu = chucVu;
    }
    public Object[] toArray()
    {
        return new Object[] {idNhanVien, hoNhanVien, tenNhanVien, diaChi, email, soDienThoai, password, luong, chucVu};
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "idNhanVien=" + idNhanVien +
                ", hoNhanVien='" + hoNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", password='" + password + '\'' +
                ", luong=" + luong +
                ", chucVu='" + chucVu + '\'' +
                '}';
    }
}
