package DAO;

import DTO.SanPham;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamDAO {
    private ConnectionSQL connectionSQL;

    public SanPhamDAO() {

    }

    public ArrayList<SanPham> readData() {
        connectionSQL = new ConnectionSQL();
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try {
            ResultSet r = connectionSQL.sqlQuery("SELECT * FROM `sanpham`");
            if (r != null) {
                while (r.next()) {
                    SanPham sanPham=new SanPham();
                    sanPham.setIdSanPham(r.getInt("id_product"));
                    sanPham.setIdThuongHieu(r.getInt("id_brand"));
                    sanPham.setTenSanPham(r.getString("TenSanPham"));
                    sanPham.setSoLuong(r.getInt("SoLuong"));
                    sanPham.setMoTa(r.getString("MoTa"));
                    sanPham.setDonGia(r.getInt("DonGia"));
                    sanPham.setHinhAnh(r.getString("HinhAnh"));
                    danhSachSanPham.add(sanPham);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not found data");
        } finally {
            connectionSQL.closeConnect();
        }
        return danhSachSanPham;
    }


    public boolean add(SanPham sp)  {
        connectionSQL = new ConnectionSQL();
        boolean  result = connectionSQL.sqlUpdate("INSERT INTO SANPHAM (`id_product`, `id_brand`, `TenSanPham`, `SoLuong`, `MoTa`, `DonGia`, `HinhAnh`) VALUES ("
                + "NULL" + ", '"
                + sp.getIdThuongHieu() + "', '"
                + sp.getTenSanPham() + "', '"
                + sp.getSoLuong() + "', '"
                + sp.getMoTa() + "', '"
                + sp.getDonGia() + "', '"
                + sp.getHinhAnh() + "');");
        connectionSQL.closeConnect();
        return  result;
    }

    public boolean remove(int idSanPham)  {
        connectionSQL = new ConnectionSQL();
        boolean  result = connectionSQL.sqlUpdate("DELETE FROM SANPHAM WHERE id_product = '" + idSanPham + "'");
        connectionSQL.closeConnect();
        return  result;
    }

    public boolean update(SanPham sp)  {
        connectionSQL = new ConnectionSQL();
        boolean  result = connectionSQL.sqlUpdate("UPDATE `sanpham` SET "
                + "id_brand='" + sp.getIdThuongHieu()
                + "',TenSanPham='" + sp.getTenSanPham()
                + "',SoLuong='" + sp.getSoLuong()
                + "',MoTa='" + sp.getMoTa()
                + "',DonGia='" + sp.getDonGia()
                + "',HinhAnh='" + sp.getHinhAnh()
                + "' WHERE id_product='" + sp.getIdSanPham() + "'");
        connectionSQL.closeConnect();
        return  result;
    }

    public boolean updateSoLuongXuat(int idSanPham, int soLuong)  {
        connectionSQL = new ConnectionSQL();
        boolean  result = connectionSQL.sqlUpdate("UPDATE SANPHAM SET "
                + "SoLuong= SoLuong -'" + soLuong
                + "' where id_product='" + idSanPham + "'");
        connectionSQL.closeConnect();
        return  result;
    }
    public boolean updateSoLuongNhap(int idSanPham, int soLuong)  {
        connectionSQL = new ConnectionSQL();
        boolean  result = connectionSQL.sqlUpdate("UPDATE SANPHAM SET "
                + "SoLuong= SoLuong +'" + soLuong
                + "' where id_product='" + idSanPham + "'");
        connectionSQL.closeConnect();
        return  result;
    }

    public int getLastID()
    {
        connectionSQL=new ConnectionSQL();
        int lastID=-1;
        try {
            ResultSet resultSet=connectionSQL.sqlQuery("SELECT MAX(id_product) FROM `sanpham`");
            if (resultSet!=null)
            {
                while (resultSet.next())
                {
                    lastID=resultSet.getInt("MAX(id_product)");
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
