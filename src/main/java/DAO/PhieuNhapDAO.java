package DAO;

import DTO.PhieuNhap;
import Tools.TimeTools;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class PhieuNhapDAO {
    private ConnectionSQL connectionSQL;
    public PhieuNhapDAO(){}
    public ArrayList<PhieuNhap> readData()
    {
        ArrayList<PhieuNhap> danhSachPhieuNhap=new ArrayList<>();
        connectionSQL=new ConnectionSQL();
        ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `phieunhap`");
        try
        {
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    PhieuNhap phieuNhap=new PhieuNhap();
                    phieuNhap.setIdPhieuNhap(resultSet.getInt("id_order"));
                    phieuNhap.setIdNhanVien(resultSet.getInt("id_staff"));
                    phieuNhap.setIdNhaCungCap(resultSet.getInt("id_provider"));
                    phieuNhap.setNgayNhap(resultSet.getTimestamp("NgayNhap"));
                    phieuNhap.setTongTien(resultSet.getInt("TongTien"));
                    danhSachPhieuNhap.add(phieuNhap);
                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data.");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachPhieuNhap;
    }
    public boolean add(PhieuNhap phieuNhap)
    {
        TimeTools timeTools=new TimeTools();
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("INSERT INTO `phieunhap` " +
                "VALUES (NULL,'"+phieuNhap.getIdNhanVien()+"','"+phieuNhap.getIdNhaCungCap()+
                "','"+timeTools.convertDateToString(new Date(phieuNhap.getNgayNhap().getTime()))+
                "','"+phieuNhap.getTongTien()+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public  boolean update(PhieuNhap phieuNhap)
    {
        TimeTools timeTools=new TimeTools();
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("UPDATE `phieunhap` SET " +
                " id_staff= '"+phieuNhap.getIdNhanVien()+"'" +
                ", id_provider= '"+phieuNhap.getIdNhaCungCap()+"'"+
                ", NgayNhap= '"+timeTools.convertDateToString(new Date(phieuNhap.getNgayNhap().getTime()))+"' "+
                ", TongTien= '"+phieuNhap.getTongTien()+"' "+
                " WHERE id_order='"+phieuNhap.getIdPhieuNhap()+"'");
        connectionSQL.closeConnect();
        return  result;
    }
    public boolean remove(int idPhieuNhap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `phieunhap` WHERE id_order= '"+idPhieuNhap+"'");
        connectionSQL.closeConnect();
        return result;
    }

    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_order) FROM `phieunhap`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_order)");
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
