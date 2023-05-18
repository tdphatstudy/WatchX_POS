package DTO;

import java.sql.Timestamp;

public class PhieuNhap {
    private int idPhieuNhap;
    private int idNhaCungCap;
    private int idNhanVien;
    private Timestamp ngayNhap;
    private int tongTien;

    public PhieuNhap() {
    }

    public PhieuNhap(int idPhieuNhap, int idNhaCungCap, int idNhanVien, Timestamp ngayNhap, int tongTien) {
        this.idPhieuNhap = idPhieuNhap;
        this.idNhaCungCap = idNhaCungCap;
        this.idNhanVien = idNhanVien;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public int getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(int idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public int getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(int idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Timestamp getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Timestamp ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    public Object[] toArray()
    {
        return new Object[] {idPhieuNhap,idNhaCungCap,idNhanVien,ngayNhap,tongTien};
    }
    @Override
    public String toString() {
        return "PhieuNhap{" +
                "idPhieuNhap=" + idPhieuNhap +
                ", idNhaCungCap=" + idNhaCungCap +
                ", idNhanVien=" + idNhanVien +
                ", ngayNhap=" + ngayNhap +
                ", tongTien=" + tongTien +
                '}';
    }
}
