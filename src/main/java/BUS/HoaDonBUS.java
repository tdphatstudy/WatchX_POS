package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDon;
import DTO.ChiTietPhieuNhap;
import DTO.HoaDon;

import javax.swing.*;
import java.util.ArrayList;

public class HoaDonBUS {
    private ArrayList<HoaDon> danhSachHoaDon=new ArrayList<>();
    private ArrayList<ChiTietHoaDon> danhSachChiTietHoaDon_temp=new ArrayList<>();
    private ChiTietHoaDonBUS chiTietHoaDonBUS=new ChiTietHoaDonBUS();
    private SanPhamBUS sanPhamBUS=new SanPhamBUS();
    private HoaDonDAO hoaDonDAO=new HoaDonDAO();

    public HoaDonBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachHoaDon=hoaDonDAO.readData();
    }
    public ArrayList<HoaDon> getList()
    {
        return danhSachHoaDon;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add_invoice(HoaDon hoaDon)
    {
        if (hoaDon.getIdKhachHang()!=-1)
        {
            if (hoaDonDAO.add(hoaDon))
            {
                HoaDon hoaDon1=new HoaDon(hoaDonDAO.getLastID(),hoaDon.getIdNhanVien(),hoaDon.getIdKhachHang(),
                        hoaDon.getTienKhachDua(), hoaDon.getTongCong(), hoaDon.getTienThua(), hoaDon.getNgayLapHoaDon());
                danhSachHoaDon.add(hoaDon1);
                return true;
            }
        }else
        {
            if (hoaDonDAO.add_notcustomer(hoaDon))
            {
                danhSachHoaDon.add(hoaDon);
                return true;
            }
        }
        return false;
    }
    public boolean update_invoice(HoaDon hoaDon)
    {
        if (hoaDonDAO.update(hoaDon))
        {
            for (int index=0;index<danhSachHoaDon.size();index++)
            {
                if (danhSachHoaDon.get(index).getIdHoaDon()==hoaDon.getIdHoaDon())
                {
                    danhSachHoaDon.set(index, hoaDon);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete_invoice(int idHoaDon)
    {
        if (hoaDonDAO.remove(idHoaDon))
        {
            for (int index=0;index<danhSachHoaDon.size();index++)
            {
                if (danhSachHoaDon.get(index).getIdHoaDon()==idHoaDon)
                {
                    danhSachHoaDon.remove(index);
                    return  true;
                }
            }

        }
        return false;
    }
    public  int getLastID()
    {
        return hoaDonDAO.getLastID();
    }
    public boolean add_temp(ChiTietHoaDon chiTietHoaDon)
    {
        return danhSachChiTietHoaDon_temp.add(chiTietHoaDon);
    }
    public boolean update_temp(ChiTietHoaDon chiTietHoaDon)
    {
        for (int index=0;index<danhSachChiTietHoaDon_temp.size();index++)
        {
            if (danhSachChiTietHoaDon_temp.get(index).getIdHoaDon()==chiTietHoaDon.getIdHoaDon() &&
                    danhSachChiTietHoaDon_temp.get(index).getIdSanPham()==chiTietHoaDon.getIdSanPham())
            {
                danhSachChiTietHoaDon_temp.set(index,chiTietHoaDon);
                return true;
            }
        }
        return false;
    }
    public boolean delete_temp(int idHoaDon)
    {
        boolean result=false;
        for (int index=0;index<danhSachChiTietHoaDon_temp.size();index++)
        {
            if (danhSachChiTietHoaDon_temp.get(index).getIdHoaDon()==idHoaDon)
            {
                danhSachChiTietHoaDon_temp.remove(index);
                result=true;
            }
            else {
                result=false;
            }
        }
        return result;
    }
    public boolean deleteDetail_temp(int idHoaDon,int idSanPham)
    {
        for (int index=0;index<danhSachChiTietHoaDon_temp.size();index++) {
            if (danhSachChiTietHoaDon_temp.get(index).getIdHoaDon() == idHoaDon &&
                    danhSachChiTietHoaDon_temp.get(index).getIdSanPham() == idSanPham) {

                danhSachChiTietHoaDon_temp.remove(index);
                return true;
            }
        }
        return false;
    }
    public boolean deleteDetail_temp(int idSanPham)
    {
        for (int index=0;index<danhSachChiTietHoaDon_temp.size();index++) {
            if (danhSachChiTietHoaDon_temp.get(index).getIdSanPham() == idSanPham) {

                danhSachChiTietHoaDon_temp.remove(index);
                return true;
            }
        }
        return false;
    }
    public ArrayList<ChiTietHoaDon> getDetailList_temp()
    {
        return danhSachChiTietHoaDon_temp;
    }
    public void refreshDetailList_temp()
    {
        danhSachChiTietHoaDon_temp.clear();
    }
    public void setDetaiListByIdHoaDon(int idHoaDon)
    {
        danhSachChiTietHoaDon_temp=chiTietHoaDonBUS.getListById(idHoaDon);
    }

    public boolean add(HoaDon hoaDon)
    {
        boolean result=false;
        if (add_invoice(hoaDon))
        {
            for (int index=0;index<danhSachChiTietHoaDon_temp.size();index++)
            {
                ChiTietHoaDon chiTietHoaDon= danhSachChiTietHoaDon_temp.get(index);
                chiTietHoaDon.setIdHoaDon(hoaDonDAO.getLastID());
                if (chiTietHoaDonBUS.add(danhSachChiTietHoaDon_temp.get(index)))
                {

                    result=true;
                    sanPhamBUS.updateSoLuongXuat(chiTietHoaDon.getIdSanPham(),chiTietHoaDon.getSoLuong());
                }
                else
                {
                    delete_invoice(hoaDon.getIdHoaDon());
                    result=false;
                }
            }
            refreshDetailList_temp();
        }
        return result;
    }
    public  boolean remove(int idHoaDon)
    {
        if (delete_invoice(idHoaDon) && chiTietHoaDonBUS.delete(idHoaDon))
        {
            return true;
        }
        return false;
    }
    public boolean checkExistDetail(int idsp)
    {
        boolean rs=true;
        if(danhSachChiTietHoaDon_temp != null)
        {
            for(ChiTietHoaDon index: danhSachChiTietHoaDon_temp)
            {
                if ( index.getIdSanPham()==idsp)
                {
                    rs=false;
                    break;
                }
            }
        }
        return rs;
    }


    public boolean checkOutOfStock(int id,int sl)
    {
        if (sl> sanPhamBUS.getAmountByID(id)) {
            JOptionPane.showMessageDialog(null, "Not Enough Product");
            return false;
        }
        return true;
    }
    public int getTotal_temp()
    {
        int total=0;
        for (ChiTietHoaDon index : danhSachChiTietHoaDon_temp)
        {
            total+=index.getThanhTien();
        }
        return total;
    }

}
