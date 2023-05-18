package DTO;

public class ChiTietHoaDon {
    private int idHoaDon;
    private int idSanPham;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int idHoaDon, int idSanPham, int soLuong, int donGia, int thanhTien) {
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "idHoaDon=" + idHoaDon +
                ", idSanPham=" + idSanPham +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
    public Object[] toArray()
    {
     return new Object[]{idHoaDon,idSanPham,soLuong,donGia,thanhTien};
    }
    public Object[] toArrayVer1()
    {
        return new Object[]{idSanPham,soLuong,donGia,thanhTien};
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
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

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
