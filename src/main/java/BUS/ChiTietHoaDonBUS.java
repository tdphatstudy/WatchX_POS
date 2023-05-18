package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDon;

import java.util.ArrayList;

public class ChiTietHoaDonBUS {
    private ArrayList<ChiTietHoaDon> danhSachChiTietHoaDon=new ArrayList<>();
    private ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAO();

    public ChiTietHoaDonBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachChiTietHoaDon=chiTietHoaDonDAO.readData();
    }
    public ArrayList<ChiTietHoaDon> getList()
    {
        return danhSachChiTietHoaDon;
    }
    public ArrayList<ChiTietHoaDon> getListById(int idHoaDon)
    {
        ArrayList<ChiTietHoaDon> chiTietHoaDons =new ArrayList<>();
        for (ChiTietHoaDon index: danhSachChiTietHoaDon)
        {
            if (index.getIdHoaDon()==idHoaDon)
            {
                chiTietHoaDons.add(index);
            }
        }
        return chiTietHoaDons;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(ChiTietHoaDon chiTietHoaDon)
    {
        if (chiTietHoaDonDAO.add(chiTietHoaDon))
        {
            danhSachChiTietHoaDon.add(chiTietHoaDon);
            return true;
        }
        return false;
    }
    public boolean update(ChiTietHoaDon chiTietHoaDon)
    {
        if (chiTietHoaDonDAO.update(chiTietHoaDon))
        {
            for (int index=0;index<danhSachChiTietHoaDon.size();index++)
            {
                if (danhSachChiTietHoaDon.get(index).getIdHoaDon()==chiTietHoaDon.getIdHoaDon())
                {
                    danhSachChiTietHoaDon.set(index, chiTietHoaDon);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idHoaDon)
    {
        if (chiTietHoaDonDAO.remove(idHoaDon))
        {
            for (int index=0;index<danhSachChiTietHoaDon.size();index++)
            {
                if (danhSachChiTietHoaDon.get(index).getIdHoaDon()==idHoaDon)
                {
                    danhSachChiTietHoaDon.remove(index);
                }
            }
            return true;

        }
        return false;
    }

    public boolean deleteDetail(int idHoaDon,int idSanPham)
    {
        if (chiTietHoaDonDAO.removeDetail(idHoaDon,idSanPham))
        {
            for (int index=0;index<danhSachChiTietHoaDon.size();index++)
            {
                if (danhSachChiTietHoaDon.get(index).getIdHoaDon()==idHoaDon
                        && danhSachChiTietHoaDon.get(index).getIdSanPham()==idSanPham)
                {
                    danhSachChiTietHoaDon.remove(index);
                }
            }
            return true;

        }
        return false;
    }
    public ArrayList<ChiTietHoaDon> getDanhSachChiTietHoaDonByID(int id)
    {
        ArrayList<ChiTietHoaDon> rs=new ArrayList<>();
        for (ChiTietHoaDon index: danhSachChiTietHoaDon)
        {
            if(index.getIdHoaDon()==id)
            {
                rs.add(index);
            }
        }
        return rs;
    }


}
