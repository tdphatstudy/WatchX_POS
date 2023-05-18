package DAO;

import DTO.ChiTietHoaDon;
import DTO.ChiTietPhieuNhap;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChiTietPhieuNhapDAO {
    private  ConnectionSQL connectionSQL;
    public  ChiTietPhieuNhapDAO()
    {}
    public ArrayList<ChiTietPhieuNhap> readData()
    {
        ArrayList<ChiTietPhieuNhap> danhSachChiTietPhieuNhap=new ArrayList<>();
        connectionSQL=new ConnectionSQL();

        try
        {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `chitietphieunhap`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    int idPhieuNhap=resultSet.getInt("id_order");
                    int idSanPham=resultSet.getInt("id_product");
                    int donGia=resultSet.getInt("DonGia");
                    int soLuong=resultSet.getInt("SoLuong");
                    int thanhTien=resultSet.getInt("ThanhTien");
                    danhSachChiTietPhieuNhap.add(new ChiTietPhieuNhap(idPhieuNhap,idSanPham,donGia,soLuong,thanhTien));
                }
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachChiTietPhieuNhap;
    }
    public boolean add(ChiTietPhieuNhap chiTietPhieuNhap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("INSERT INTO `chitietphieunhap` " +
                "VALUES ('"+chiTietPhieuNhap.getIdPhieuNhap()+"','"+chiTietPhieuNhap.getIdSanPham()+"'," +
                "'"+chiTietPhieuNhap.getDonGia()+"','"+chiTietPhieuNhap.getSoLuong()+"','"+chiTietPhieuNhap.getThanhTien()+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean update(ChiTietPhieuNhap chiTietPhieuNhap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("UPDATE `chitietphieunhap` SET " +
                " `SoLuong`= '"+ chiTietPhieuNhap.getSoLuong()+"'"+
                ", `DonGia`= '"+chiTietPhieuNhap.getDonGia()+"' " +
                ", `ThanhTien`= '"+chiTietPhieuNhap.getThanhTien()+"' " +
                " WHERE id_order='"+chiTietPhieuNhap.getIdPhieuNhap()+"' AND id_product='"+chiTietPhieuNhap.getIdSanPham()+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean remove(int idPhieuNhap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `chitietphieunhap` WHERE id_order= '"+idPhieuNhap+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean removeDetail(int idPhieuNhap, int idSanPham)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `chitietphieunhap` " +
                "WHERE id_order= '"+idPhieuNhap+"' AND id_product= '"+idSanPham+"'");
        connectionSQL.closeConnect();
        return result;
    }
}
