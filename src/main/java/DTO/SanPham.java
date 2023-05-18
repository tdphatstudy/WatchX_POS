package DTO;

public class SanPham {
    private int idSanPham;
    private int idThuongHieu;
    private String tenSanPham;
    private int soLuong;
    private int donGia;
    private String moTa;
    private String hinhAnh;

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public SanPham() {
    }

    public SanPham(int idSanPham, int idThuongHieu, String tenSanPham, int soLuong, int donGia, String moTa, String hinhAnh) {
        this.idSanPham = idSanPham;
        this.idThuongHieu = idThuongHieu;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public Object[] toArray()
    {
        return new Object[] {idSanPham,idThuongHieu,tenSanPham,soLuong, donGia};
    }
    @Override
    public String toString() {
        return "SanPham{" +
                "idSanPham=" + idSanPham +
                ", idThuongHieu=" + idThuongHieu +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", moTa='" + moTa + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }


}
