package DAO;

import DTO.ThuongHieu;
import org.apache.poi.ss.formula.functions.T;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThuongHieuDAO {
    private ConnectionSQL connectionSQL;
    public ThuongHieuDAO(){}
    public ArrayList<ThuongHieu> readData()
    {
        connectionSQL=new ConnectionSQL();
        ArrayList<ThuongHieu> danhSachThuongHieu=new ArrayList<>();
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `thuonghieu`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    ThuongHieu thuongHieu=new ThuongHieu();
                    thuongHieu.setIdThuongHieu(resultSet.getInt("id_brand"));
                    thuongHieu.setTenThuongHieu(resultSet.getString("TenThuongHieu"));
                    danhSachThuongHieu.add(thuongHieu);
                }
            }

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachThuongHieu;
    }
    public boolean add(ThuongHieu thuongHieu)
    {
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("INSERT INTO `thuonghieu` VALUES (NULL,'"+thuongHieu.getTenThuongHieu()+"')");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean remove (int idThuongHieu)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `thuonghieu` WHERE id_brand= '"+idThuongHieu+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean update(ThuongHieu thuongHieu)
    {
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("UPDATE `thuonghieu` SET TenThuongHieu= '"+thuongHieu.getTenThuongHieu()+"' " +
                "WHERE id_brand= '"+thuongHieu.getIdThuongHieu()+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_brand) FROM `thuonghieu`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_brand)");
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
