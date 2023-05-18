package BUS;

import DAO.SanPhamDAO;
import DTO.SanPham;

import javax.swing.*;
import java.util.ArrayList;

public class SanPhamBUS {
    private ArrayList<SanPham> danhSachSanPham=new ArrayList<>();
    private SanPhamDAO sanPhamDAO=new SanPhamDAO();

    public SanPhamBUS() {
        readData();
    }
    private void readData()
    {
        danhSachSanPham=sanPhamDAO.readData();
    }
    public ArrayList<SanPham> getList()
    {
        return danhSachSanPham;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(SanPham sanPham)
    {
        if (sanPhamDAO.add(sanPham))
        {
            SanPham sanPham1=new SanPham(getLastID(),sanPham.getIdThuongHieu(), sanPham.getTenSanPham(), sanPham.getSoLuong(), sanPham.getDonGia(),
                    "None","None");
            danhSachSanPham.add(sanPham);
            return true;
        }
        return false;
    }

    public int getLastID()
    {
        return sanPhamDAO.getLastID();
    }
    public boolean update(SanPham sanPham)
    {
        if (sanPhamDAO.update(sanPham))
        {
            for (int index=0;index<danhSachSanPham.size();index++)
            {
                if (danhSachSanPham.get(index).getIdSanPham()==sanPham.getIdSanPham())
                {
                    danhSachSanPham.set(index, sanPham);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean updateSoLuongXuat(int idSanPham, int soLuong)
    {
        if (sanPhamDAO.updateSoLuongXuat(idSanPham,soLuong))
        {
            for (int index=0;index<danhSachSanPham.size();index++)
            {
                if (danhSachSanPham.get(index).getIdSanPham()==idSanPham)
                {
                    SanPham sanPham=danhSachSanPham.get(index);
                    sanPham.setSoLuong(sanPham.getSoLuong()-soLuong);
                    danhSachSanPham.set(index, sanPham);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean updateSoLuongNhap(int idSanPham, int soLuong)
    {
        if (sanPhamDAO.updateSoLuongNhap(idSanPham,soLuong))
        {
            for (int index=0;index<danhSachSanPham.size();index++)
            {
                if (danhSachSanPham.get(index).getIdSanPham()==idSanPham)
                {
                    SanPham sanPham=danhSachSanPham.get(index);
                    sanPham.setSoLuong(sanPham.getSoLuong()+soLuong);
                    danhSachSanPham.set(index, sanPham);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idSanPham)
    {
        if (sanPhamDAO.remove(idSanPham))
        {
            for (int index=0;index<danhSachSanPham.size();index++)
            {
                if (danhSachSanPham.get(index).getIdSanPham()==idSanPham)
                {
                    danhSachSanPham.remove(index);
                    return true;
                }
            }

        }
        return false;
    }
    public int getAmountByID(int idsp)
    {
        for (SanPham index: this.danhSachSanPham)
        {
            if (index.getIdSanPham()==idsp)
            {
                return index.getSoLuong();
            }
        }
        JOptionPane.showMessageDialog(null,"\n" +
                "Out of Stock");
        return -1;
    }
    public String getName(int id)
    {
        for (SanPham index: danhSachSanPham)
        {
            if (index.getIdSanPham() == id)
            {
                return index.getTenSanPham();
            }
        }
        return null;
    }
}
