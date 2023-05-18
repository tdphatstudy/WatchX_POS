package DTO;

public class NhaCungCap {
    private int idNhaCungCap;
    private String tenNhaCungCap;
    private String diaChi;
    private String email;
    private String soDienThoai;

    public NhaCungCap() {
    }

    public NhaCungCap(int idNhaCungCap, String tenNhaCungCap, String diaChi, String email, String soDienThoai) {
        this.idNhaCungCap = idNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }



    public int getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(int idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
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

    public Object[] toArray()
    {
        return new Object[] {idNhaCungCap,tenNhaCungCap,diaChi,email,soDienThoai};
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "idNhaCungCap=" + idNhaCungCap +
                ", tenNhaCungCap='" + tenNhaCungCap + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
