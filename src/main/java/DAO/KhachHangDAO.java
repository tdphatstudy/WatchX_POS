package DAO;

import DTO.KhachHang;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangDAO {
    private ConnectionSQL connectionSQL;

    public ArrayList<KhachHang> readData()
    {
        ArrayList<KhachHang> danhSachKhachHang=new ArrayList<>();
        connectionSQL=new ConnectionSQL();

        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `khachhang`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    int idKhachHang= resultSet.getInt("id_customer");
                    String hoKhachHang=resultSet.getString("HoKhachHang");
                    String tenKhachHang=resultSet.getString("TenKhachHang");
                    String soDienThoai=resultSet.getString("Phone");
                    String email=resultSet.getString("Email");
                    String diaChi=resultSet.getString("DiaChi");
                    danhSachKhachHang.add(new KhachHang(idKhachHang,hoKhachHang,tenKhachHang,soDienThoai,email,diaChi));
                }
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data. Try again!");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachKhachHang;
    }
    public boolean add(KhachHang khachHang)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("INSERT INTO `khachhang` (`id_customer`, `HoKhachHang`, `TenKhachHang`, `Phone`, `Email`, `DiaChi`) " +
                "VALUES (NULL, '"+khachHang.getHoKhachHang()+"', '"+khachHang.getTenKhachHang()+"', " +
                "'"+khachHang.getSoDienThoai()+"', '"+khachHang.getEmail()+"', '"+khachHang.getDiaChi()+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean update(KhachHang khachHang)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("UPDATE `khachhang` SET `HoKhachHang` = '"+khachHang.getHoKhachHang()+"' "
                +  ",`TenKhachHang` = '"+khachHang.getTenKhachHang()+"'"
                +  ",`Phone`='"+khachHang.getSoDienThoai()+"'"
                +  ", `Email`= '"+khachHang.getEmail()+"'"
                +  ",`DiaChi`= '"+khachHang.getDiaChi()+"'"
                + "WHERE `id_customer` = "+khachHang.getIdKhachHang()+";");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean remove(int idKhachHang)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `khachhang` WHERE id_customer='"+idKhachHang+"'");
        connectionSQL.closeConnect();
        return result;
    }

    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_customer) FROM `khachhang`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_customer)");
                }
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data");
        } finally {
            connectionSQL.closeConnect();
        }
        return lastID;
    }
}
