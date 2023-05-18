package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhap;

import java.util.ArrayList;

public class ChiTietPhieuNhapBUS {
    private ArrayList<ChiTietPhieuNhap> danhSachChiTietPhieuNhap=new ArrayList<>();
    private ChiTietPhieuNhapDAO chiTietPhieuNhapDAO=new ChiTietPhieuNhapDAO();

    public ChiTietPhieuNhapBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachChiTietPhieuNhap=chiTietPhieuNhapDAO.readData();
    }
    public ArrayList<ChiTietPhieuNhap> getList()
    {
        return danhSachChiTietPhieuNhap;
    }
    public ArrayList<ChiTietPhieuNhap> getListById(int idPhieuNhap)
    {
        ArrayList<ChiTietPhieuNhap> chiTietPhieuNhaps =new ArrayList<>();
        for (ChiTietPhieuNhap index: danhSachChiTietPhieuNhap)
        {
            if (index.getIdPhieuNhap()==idPhieuNhap)
            {
                chiTietPhieuNhaps.add(index);
            }
        }
        return chiTietPhieuNhaps;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(ChiTietPhieuNhap chiTietPhieuNhap)
    {
        if (chiTietPhieuNhapDAO.add(chiTietPhieuNhap))
        {
            danhSachChiTietPhieuNhap.add(chiTietPhieuNhap);
            return true;
        }
        return false;
    }
    public boolean update(ChiTietPhieuNhap chiTietPhieuNhap)
    {
        if (chiTietPhieuNhapDAO.update(chiTietPhieuNhap))
        {
            for (int index=0;index<danhSachChiTietPhieuNhap.size();index++)
            {
                if (danhSachChiTietPhieuNhap.get(index).getIdPhieuNhap()== chiTietPhieuNhap.getIdPhieuNhap())
                {
                    danhSachChiTietPhieuNhap.set(index, chiTietPhieuNhap);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idPhieuNhap)
    {
        if (chiTietPhieuNhapDAO.remove(idPhieuNhap))
        {
            for (int index=0;index<danhSachChiTietPhieuNhap.size();index++)
            {
                if (danhSachChiTietPhieuNhap.get(index).getIdPhieuNhap()==idPhieuNhap)
                {
                    danhSachChiTietPhieuNhap.remove(index);
                }
            }
            return true;

        }
        return false;
    }

    public boolean deleteDetail(int idPhieuNhap,int idSanPham)
    {
        if (chiTietPhieuNhapDAO.removeDetail(idPhieuNhap,idSanPham))
        {
            for (int index=0;index<danhSachChiTietPhieuNhap.size();index++)
            {
                if (danhSachChiTietPhieuNhap.get(index).getIdPhieuNhap()==idPhieuNhap
                        && danhSachChiTietPhieuNhap.get(index).getIdSanPham()==idSanPham)
                {
                    danhSachChiTietPhieuNhap.remove(index);
                }
            }
            return true;

        }
        return false;
    }

}
