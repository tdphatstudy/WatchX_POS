package DAO;

import DTO.NhaCungCap;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhaCungCapDAO {
    private ConnectionSQL connectionSQL;
    public NhaCungCapDAO(){}
    public ArrayList<NhaCungCap> readData()
    {
        ArrayList<NhaCungCap> danhSachNhaCungCap=new ArrayList<>();
        connectionSQL=new ConnectionSQL();

        try
        {
            ResultSet resultSet= connectionSQL.sqlQuery("SELECT * FROM `nhacungcap`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    NhaCungCap nhaCungCap=new NhaCungCap();
                    nhaCungCap.setIdNhaCungCap(resultSet.getInt("id_provider"));
                    nhaCungCap.setTenNhaCungCap(resultSet.getString("TenNhaCungCap"));
                    nhaCungCap.setDiaChi(resultSet.getString("DiaChi"));
                    nhaCungCap.setEmail(resultSet.getString("Email"));
                    nhaCungCap.setSoDienThoai(resultSet.getString("Phone"));
                    danhSachNhaCungCap.add(nhaCungCap);

                }
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Can't read data");
        } finally {
            connectionSQL.closeConnect();
        }

        return danhSachNhaCungCap;
    }

    public boolean add(NhaCungCap nhaCungCap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("INSERT INTO `nhacungcap` (`id_provider`, `TenNhaCungCap`, `DiaChi`, `Email`, `Phone`) " +
                "VALUES (NULL, '"+nhaCungCap.getTenNhaCungCap()+"', '"+nhaCungCap.getDiaChi()+"', '"+nhaCungCap.getEmail()+"', '"+nhaCungCap.getSoDienThoai()+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean update(NhaCungCap nhaCungCap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("UPDATE `nhacungcap` SET " +
                " TenNhaCungCap= '"+nhaCungCap.getTenNhaCungCap()+"'"+
                ", DiaChi= '"+nhaCungCap.getDiaChi()+"'"+
                ", Email= '"+nhaCungCap.getEmail()+"'"+
                ", Phone= '"+nhaCungCap.getSoDienThoai()+"'"+
                " WHERE id_provider='"+nhaCungCap.getIdNhaCungCap()+"'");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean remove(int idNhaCungCap)
    {
        connectionSQL=new ConnectionSQL();
        boolean result=connectionSQL.sqlUpdate("DELETE FROM `nhacungcap` WHERE id_provider= '"+idNhaCungCap+"' ");
        connectionSQL.closeConnect();
        return result;
    }

    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_provider) FROM `nhacungcap`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_provider)");
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

