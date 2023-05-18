package DAO;

import DTO.ChiTietHoaDon;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChiTietHoaDonDAO {
    private  ConnectionSQL connectionSQL;
    public ChiTietHoaDonDAO()
    {

    }
    public ArrayList<ChiTietHoaDon> readData()
    {
        ArrayList<ChiTietHoaDon> danhSachChiTietHoaDon=new ArrayList<>();
        connectionSQL=new ConnectionSQL();

        try
        {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `chitiethoadon`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    int idHoaDon=resultSet.getInt("id_invoice");
                    int idSanPham=resultSet.getInt("id_product");
                    int soLuong=resultSet.getInt("SoLuong");
                    int donGia=resultSet.getInt("DonGia");
                    int thanhTien=resultSet.getInt("ThanhTien");
                    danhSachChiTietHoaDon.add(new ChiTietHoaDon(idHoaDon,idSanPham,soLuong,donGia,thanhTien));
                }
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachChiTietHoaDon;
    }
    public boolean add(ChiTietHoaDon chiTietHoaDon)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("INSERT INTO `chitiethoadon` " +
                "VALUES ('"+chiTietHoaDon.getIdHoaDon()+"','"+chiTietHoaDon.getIdSanPham()+"'," +
                "'"+chiTietHoaDon.getSoLuong()+"','"+chiTietHoaDon.getDonGia()+"','"+chiTietHoaDon.getThanhTien()+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean update(ChiTietHoaDon chiTietHoaDon)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("UPDATE `chitiethoadon` SET " +
                " `SoLuong`= '"+ chiTietHoaDon.getSoLuong()+"'"+
                ", `DonGia`= '"+chiTietHoaDon.getDonGia()+"' " +
                ", `ThanhTien`= '"+chiTietHoaDon.getThanhTien()+"' " +
                " WHERE id_invoice='"+chiTietHoaDon.getIdHoaDon()+"' AND id_product='"+chiTietHoaDon.getIdSanPham()+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean remove(int idHoaDon)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `chitiethoadon` WHERE id_invoice= '"+idHoaDon+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean removeDetail(int idHoaDon, int idSanPham)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `chitiethoadon` " +
                "WHERE id_invoice= '"+idHoaDon+"' AND id_product= '"+idSanPham+"'");
        connectionSQL.closeConnect();
        return result;
    }
}
