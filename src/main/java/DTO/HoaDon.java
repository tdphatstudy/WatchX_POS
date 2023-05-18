package DTO;

import java.sql.Timestamp;

public class HoaDon {
    private int idHoaDon;
    private int idNhanVien;
    private int idKhachHang;
    private int tienKhachDua;
    private int tongCong;
    private int tienThua;
    private Timestamp ngayLapHoaDon;

    public HoaDon() {
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(int tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public int getTongCong() {
        return tongCong;
    }

    public void setTongCong(int tongCong) {
        this.tongCong = tongCong;
    }

    public int getTienThua() {
        return tienThua;
    }

    public void setTienThua(int tienThua) {
        this.tienThua = tienThua;
    }

    public Timestamp getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Timestamp ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public HoaDon(int idHoaDon, int idNhanVien, int idKhachHang, int tienKhachDua, int tongCong, int tienThua, Timestamp ngayLapHoaDon) {
        this.idHoaDon = idHoaDon;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.tienKhachDua = tienKhachDua;
        this.tongCong = tongCong;
        this.tienThua = tienThua;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "idHoaDon=" + idHoaDon +
                ", idNhanVien=" + idNhanVien +
                ", idKhachHang=" + idKhachHang +
                ", tienKhachDua=" + tienKhachDua +
                ", tongCong=" + tongCong +
                ", tienThua=" + tienThua +
                ", ngayLapHoaDon=" + ngayLapHoaDon +
                '}';
    }
}
