package DTO;

public class ChiTietPhieuNhap {
    private int idPhieuNhap;
    private int idSanPham;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(int idPhieuNhap, int idSanPham, int soLuong, int donGia, int thanhTien) {
        this.idPhieuNhap = idPhieuNhap;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public int getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(int idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;

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
    public Object[] toArray()
    {
        return new Object[] {idPhieuNhap,idSanPham,soLuong,donGia,thanhTien};
    }
    @Override
    public String toString() {
        return "ChiTietPhieuNhap{" +
                "idPhieuNhap=" + idPhieuNhap +
                ", idSanPham=" + idSanPham +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
