package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;

import java.util.ArrayList;

public class KhachHangBUS {
    private ArrayList<KhachHang> danhSachKhachHang=new ArrayList<>();
    private KhachHangDAO khachHangDAO=new KhachHangDAO();

    public KhachHangBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachKhachHang=khachHangDAO.readData();
    }
    public ArrayList<KhachHang> getList()
    {
        return danhSachKhachHang;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(KhachHang khachHang)
    {
        if (khachHangDAO.add(khachHang))
        {
            KhachHang khachHang1=new KhachHang(khachHangDAO.getLastID(), khachHang.getHoKhachHang(), khachHang.getTenKhachHang(),
                    khachHang.getSoDienThoai(), khachHang.getEmail(), khachHang.getDiaChi());
            danhSachKhachHang.add(khachHang1);
            return true;
        }
        return false;
    }
    public int getLastID()
    {
        return khachHangDAO.getLastID();
    }
    public boolean update(KhachHang khachHang)
    {
        if (khachHangDAO.update(khachHang))
        {
            for (int index=0;index<danhSachKhachHang.size();index++)
            {
                if (danhSachKhachHang.get(index).getIdKhachHang()==khachHang.getIdKhachHang())
                {
                    danhSachKhachHang.set(index, khachHang);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idKhachHang)
    {
        if (khachHangDAO.remove(idKhachHang))
        {
            for (int index=0;index<danhSachKhachHang.size();index++)
            {
                if (danhSachKhachHang.get(index).getIdKhachHang()==idKhachHang)
                {
                    danhSachKhachHang.remove(index);
                    return  true;
                }
            }

        }
        return false;
    }

}
