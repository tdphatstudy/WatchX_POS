package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien;

import javax.swing.*;
import java.util.ArrayList;

public class NhanVienBUS {
    private ArrayList<NhanVien> danhSachNhanVien=new ArrayList<>();
    private NhanVienDAO nhanVienDAO=new NhanVienDAO();

    public NhanVienBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachNhanVien=nhanVienDAO.readData();
    }
    public ArrayList<NhanVien> getList()
    {
        return danhSachNhanVien;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(NhanVien nhanVien)
    {
        if (nhanVienDAO.add(nhanVien))
        {
            NhanVien nhanVien1=new NhanVien(nhanVienDAO.getLastID(), nhanVien.getHoNhanVien(), nhanVien.getTenNhanVien(),
                    nhanVien.getDiaChi(), nhanVien.getEmail(), nhanVien.getSoDienThoai(), nhanVien.getPassword(),
                    nhanVien.getLuong(), nhanVien.getChucVu());
            danhSachNhanVien.add(nhanVien1);
            return true;
        }
        return false;
    }

    public  int getLastID()
    {
        return nhanVienDAO.getLastID();
    }
    public boolean update(NhanVien nhanVien)
    {
        if (nhanVienDAO.update(nhanVien))
        {
            for (int index=0;index<danhSachNhanVien.size();index++)
            {
                if (danhSachNhanVien.get(index).getIdNhanVien()==nhanVien.getIdNhanVien())
                {
                    danhSachNhanVien.set(index, nhanVien);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idNhanVien)
    {
        if (nhanVienDAO.remove(idNhanVien))
        {
            for (int index=0;index<danhSachNhanVien.size();index++)
            {
                if (danhSachNhanVien.get(index).getIdNhanVien()==idNhanVien)
                {
                    danhSachNhanVien.remove(index);
                    return  true;
                }
            }

        }
        return false;
    }
    public  NhanVien login(String username, String password) {
        if (!username.trim().equals("") && !password.trim().equals("")) {
            return nhanVienDAO.login(username, password);

        } else  {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống các trường!");
        }
        return null;
    }

}
