package DAO;

import DTO.HoaDon;
import Tools.TimeTools;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class HoaDonDAO {
    private ConnectionSQL connectionSQL;
    public HoaDonDAO(){}
    public ArrayList<HoaDon> readData()
    {
        ArrayList<HoaDon> danhSachHoaDon=new ArrayList<>();
        connectionSQL=new ConnectionSQL();

        try
        {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `hoadon`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    HoaDon hoaDon=new HoaDon();
                    hoaDon.setIdHoaDon(resultSet.getInt("id_invoice"));
                    hoaDon.setIdNhanVien(resultSet.getInt("id_staff"));
                    hoaDon.setIdKhachHang(resultSet.getInt("id_customer"));
                    hoaDon.setTienKhachDua(resultSet.getInt("TienKhachDua"));
                    hoaDon.setTongCong(resultSet.getInt("TongTien"));
                    hoaDon.setTienThua(resultSet.getInt("TienThua"));
                    hoaDon.setNgayLapHoaDon(resultSet.getTimestamp("NgayLapHoaDon"));
                    danhSachHoaDon.add(hoaDon);
                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data.");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachHoaDon;
    }
    public boolean add(HoaDon hoaDon)
    {
        TimeTools timeTools=new TimeTools();
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("INSERT INTO `hoadon` " +
                "VALUES (NULL,'"+hoaDon.getIdNhanVien()+"','"+hoaDon.getIdKhachHang()+"'" +
                ",'"+hoaDon.getTienKhachDua()+"','"+hoaDon.getTongCong()+"','"+hoaDon.getTienThua()+"','"+timeTools.convertDateToString(new Date(hoaDon.getNgayLapHoaDon().getTime()))+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean add_notcustomer(HoaDon hoaDon)
    {
        TimeTools timeTools=new TimeTools();
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("INSERT INTO `hoadon` " +
                "VALUES (NULL,'"+hoaDon.getIdNhanVien()+"',NULL" +
                ",'"+hoaDon.getTienKhachDua()+"','"+hoaDon.getTongCong()+"','"+hoaDon.getTienThua()+"','"+timeTools.convertDateToString(new Date(hoaDon.getNgayLapHoaDon().getTime()))+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public  boolean update(HoaDon hoaDon)
    {
        TimeTools timeTools=new TimeTools();
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("UPDATE `hoadon` SET " +
                " id_staff= '"+hoaDon.getIdNhanVien()+"'" +
                ", id_customer= '"+hoaDon.getIdKhachHang()+"'"+
                ", TienKhachDua= '"+hoaDon.getTienKhachDua()+"' "+
                ", TongTien= '"+hoaDon.getTongCong()+"' "+
                ", TienThua= '"+hoaDon.getTienThua()+"' "+
                ", NgayLapHoaDon= '"+timeTools.convertDateToString(new Date(hoaDon.getNgayLapHoaDon().getTime()))+"' "+
                " WHERE id_invoice='"+hoaDon.getIdHoaDon()+"'");
        connectionSQL.closeConnect();
        return  result;
    }
    public boolean remove(int idHoaDon)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `hoadon` WHERE id_invoice= '"+idHoaDon+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_invoice) FROM `hoadon`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_invoice)");
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
