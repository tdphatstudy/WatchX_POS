package DAO;


import DTO.NhanVien;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienDAO {
    private ConnectionSQL connectionSQL;
    public NhanVienDAO()
    {

    }
    public ArrayList<NhanVien> readData()
    {
        ArrayList<NhanVien> danhSachNhanVien=new ArrayList<>();
        connectionSQL=new ConnectionSQL();
        try
        {
            String query="SELECT * FROM NhanVien";
            ResultSet resultSet=connectionSQL.sqlQuery(query);
            if(resultSet!=null)
            {
                while (resultSet.next())
                {
                    int idNhanVien= resultSet.getInt("id_staff");
                    String hoNhanVien=resultSet.getString("HoNhanVien");
                    String tenNhanVien=resultSet.getString("TenNhanVien");
                    String diaChi=resultSet.getString("DiaChi");
                    String email=resultSet.getString("Email");
                    String soDienThoai=resultSet.getString("Phone");
                    String password=resultSet.getString("Password");
                    int luong=resultSet.getInt("Luong");
                    String chucVu=resultSet.getString("ChucVu");
                    danhSachNhanVien.add(new NhanVien(idNhanVien,hoNhanVien,tenNhanVien,diaChi,email,soDienThoai,password,luong,chucVu));
                }
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data");
        }finally {
            connectionSQL.closeConnect();
        }
        return danhSachNhanVien;
    }

    public boolean add(NhanVien nhanVien)
    {
        connectionSQL= new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("INSERT INTO `nhanvien`" +
                " (`id_staff`, `HoNhanVien`, `TenNhanVien`, `DiaChi`, `Email`, `Phone`, `Password`, `Luong`, `ChucVu`) VALUES (NULL, '"+nhanVien.getHoNhanVien()+"', " +
                "'"+nhanVien.getTenNhanVien()+"', '"+nhanVien.getDiaChi()+"', '"+nhanVien.getEmail()+"', " +
                "'"+nhanVien.getSoDienThoai()+"', '"+nhanVien.getPassword()+"', '"+nhanVien.getLuong()+"', '"+nhanVien.getChucVu()+"');");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean update(NhanVien nhanVien)
    {
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("UPDATE `nhanvien` SET `HoNhanVien` = '"+nhanVien.getHoNhanVien()+"' "
                +  ",`TenNhanVien` = '"+nhanVien.getTenNhanVien()+"'"
                +  ",`DiaChi`= '"+nhanVien.getDiaChi()+"'"
                +  ", `Email`= '"+nhanVien.getEmail()+"'"
                +  ",`Phone`='"+nhanVien.getSoDienThoai()+"'"
                +  ",`Password`='"+nhanVien.getPassword()+"'"
                +  ",`Luong`='"+nhanVien.getLuong()+"'"
                +  ",`ChucVu`='"+nhanVien.getChucVu()+"'"
                + "WHERE   id_staff = "+nhanVien.getIdNhanVien()+";");
        connectionSQL.closeConnect();
        return result;
    }
    public boolean remove(int idNhanVien)
    {
        connectionSQL=new ConnectionSQL();
        boolean result= connectionSQL.sqlUpdate("DELETE FROM `nhanvien` WHERE id_staff= '"+idNhanVien+"'");
        connectionSQL.closeConnect();
        return result;
    }

    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_staff) FROM `nhanvien`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_staff)");
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
    public NhanVien login(String username, String password) {
        connectionSQL=new ConnectionSQL();
        NhanVien login = null;
        try
        {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT * FROM `nhanvien` WHERE Email='"+username+"' AND Password='"+password+"'");

            if (resultSet!=null)
            {
                login =  new NhanVien();
                while (resultSet.next())
                {

                    login.setIdNhanVien(resultSet.getInt("id_staff"));
                    login.setHoNhanVien(resultSet.getString("HoNhanVien"));
                    login.setTenNhanVien(resultSet.getString("TenNhanVien"));
                    login.setDiaChi(resultSet.getString("DiaChi"));
                    login.setEmail(resultSet.getString("Email"));
                    login.setChucVu(resultSet.getString("ChucVu"));

                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Can't read data.");
        } finally {
            connectionSQL.closeConnect();
        }

        return login;
    }


}
