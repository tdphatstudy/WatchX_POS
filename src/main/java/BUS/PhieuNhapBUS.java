package BUS;

import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhap;
import DTO.PhieuNhap;

import java.util.ArrayList;

public class PhieuNhapBUS {
    private ArrayList<PhieuNhap> danhSachPhieuNhap=new ArrayList<>();
    private ArrayList<ChiTietPhieuNhap> danhSachChiTietPhieuNhap_temp=new ArrayList<>();
    private ChiTietPhieuNhapBUS chiTietPhieuNhapBUS=new ChiTietPhieuNhapBUS();
    private SanPhamBUS sanPhamBUS=new SanPhamBUS();
    private PhieuNhapDAO PhieuNhapDAO=new PhieuNhapDAO();

    public PhieuNhapBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachPhieuNhap=PhieuNhapDAO.readData();
    }
    public ArrayList<PhieuNhap> getList()
    {
        return danhSachPhieuNhap;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add_invoice(PhieuNhap PhieuNhap)
    {
        if (PhieuNhapDAO.add(PhieuNhap))
        {
            PhieuNhap phieuNhap=new PhieuNhap(PhieuNhapDAO.getLastID(), PhieuNhap.getIdNhaCungCap(), PhieuNhap.getIdNhanVien(),
            PhieuNhap.getNgayNhap(),PhieuNhap.getTongTien());
            danhSachPhieuNhap.add(phieuNhap);
            return true;
        }
        return false;
    }
    public boolean update_invoice(PhieuNhap PhieuNhap)
    {
        if (PhieuNhapDAO.update(PhieuNhap))
        {
            for (int index=0;index<danhSachPhieuNhap.size();index++)
            {
                if (danhSachPhieuNhap.get(index).getIdPhieuNhap()==PhieuNhap.getIdPhieuNhap())
                {
                    danhSachPhieuNhap.set(index, PhieuNhap);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete_invoice(int idPhieuNhap)
    {
        if (PhieuNhapDAO.remove(idPhieuNhap))
        {
            for (int index=0;index<danhSachPhieuNhap.size();index++)
            {
                if (danhSachPhieuNhap.get(index).getIdPhieuNhap()==idPhieuNhap)
                {
                    danhSachPhieuNhap.remove(index);
                    return  true;
                }
            }

        }
        return false;
    }
    public boolean add_temp(ChiTietPhieuNhap chiTietPhieuNhap)
    {
        return danhSachChiTietPhieuNhap_temp.add(chiTietPhieuNhap);
    }
    public boolean update_temp(ChiTietPhieuNhap chiTietPhieuNhap)
    {
        for (int index=0;index<danhSachChiTietPhieuNhap_temp.size();index++)
        {
            if (danhSachChiTietPhieuNhap_temp.get(index).getIdPhieuNhap()==chiTietPhieuNhap.getIdPhieuNhap() &&
                    danhSachChiTietPhieuNhap_temp.get(index).getIdSanPham()==chiTietPhieuNhap.getIdSanPham())
            {
                danhSachChiTietPhieuNhap_temp.set(index,chiTietPhieuNhap);
                return true;
            }
        }
        return false;
    }
    public boolean delete_temp(int idPhieuNhap)
    {
        boolean result=false;
        for (int index=0;index<danhSachChiTietPhieuNhap_temp.size();index++)
        {
            if (danhSachChiTietPhieuNhap_temp.get(index).getIdPhieuNhap()==idPhieuNhap)
            {
                danhSachChiTietPhieuNhap_temp.remove(index);
                result=true;
            }
            else {
                result=false;
            }
        }
        return result;
    }
    public boolean deleteDetail_temp(int idPhieuNhap,int idSanPham)
    {
        for (int index=0;index<danhSachChiTietPhieuNhap_temp.size();index++) {
            if (danhSachChiTietPhieuNhap_temp.get(index).getIdPhieuNhap() == idPhieuNhap &&
                    danhSachChiTietPhieuNhap_temp.get(index).getIdSanPham() == idSanPham) {

                danhSachChiTietPhieuNhap_temp.remove(index);
                return true;
            }
        }
        return false;
    }
    public boolean deleteDetail_temp(int idSanPham)
    {
        for (int index=0;index<danhSachChiTietPhieuNhap_temp.size();index++) {
            if (danhSachChiTietPhieuNhap_temp.get(index).getIdSanPham() == idSanPham) {

                danhSachChiTietPhieuNhap_temp.remove(index);
                return true;
            }
        }
        return false;
    }
    public ArrayList<ChiTietPhieuNhap> getDetailList_temp()
    {
        return danhSachChiTietPhieuNhap_temp;
    }
    public void refreshDetailList_temp()
    {
        danhSachChiTietPhieuNhap_temp.clear();
    }
    public void setDetaiListByIdPhieuNhap(int idPhieuNhap)
    {
        danhSachChiTietPhieuNhap_temp=chiTietPhieuNhapBUS.getListById(idPhieuNhap);
    }

    public boolean add(PhieuNhap PhieuNhap)
    {
        boolean result=false;
        if (add_invoice(PhieuNhap))
        {
            for (int index=0;index<danhSachChiTietPhieuNhap_temp.size();index++)
            {
                ChiTietPhieuNhap chiTietPhieuNhap=danhSachChiTietPhieuNhap_temp.get(index);
                chiTietPhieuNhap.setIdPhieuNhap(getLastId());
                if (chiTietPhieuNhapBUS.add(chiTietPhieuNhap))
                {
                    result=true;
                    sanPhamBUS.updateSoLuongNhap(chiTietPhieuNhap.getIdSanPham(),chiTietPhieuNhap.getSoLuong());
                }
                else
                {
                    delete_invoice(PhieuNhap.getIdPhieuNhap());
                    result=false;
                }
            }
            refreshDetailList_temp();
        }
        return result;
    }
    public  boolean remove(int idPhieuNhap)
    {
        if (delete_invoice(idPhieuNhap) && chiTietPhieuNhapBUS.delete(idPhieuNhap))
        {
            return true;
        }
        return false;
    }
    public int getLastId()
    {
        return PhieuNhapDAO.getLastID();
    }

}
