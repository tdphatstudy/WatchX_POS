package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;

import java.util.ArrayList;

public class NhaCungCapBUS {
    private ArrayList<NhaCungCap> danhSachNhaCungCap=new ArrayList<>();
    private NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAO();

    public NhaCungCapBUS()
    {
        readData();
    }
    private void readData()
    {
        danhSachNhaCungCap=nhaCungCapDAO.readData();
    }
    public ArrayList<NhaCungCap> getList()
    {
        return danhSachNhaCungCap;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(NhaCungCap nhaCungCap)
    {

        if (nhaCungCapDAO.add(nhaCungCap))
        {
            NhaCungCap nhaCungCap1=new NhaCungCap(nhaCungCapDAO.getLastID(),nhaCungCap.getTenNhaCungCap(),
                    nhaCungCap.getDiaChi(),nhaCungCap.getEmail(),nhaCungCap.getSoDienThoai());
            danhSachNhaCungCap.add(nhaCungCap1);
            return true;
        }
        return false;
    }
    public int getLastID()
    {
        return nhaCungCapDAO.getLastID();
    }
    public boolean update(NhaCungCap nhaCungCap)
    {
        if (nhaCungCapDAO.update(nhaCungCap))
        {
            for (int index=0;index<danhSachNhaCungCap.size();index++)
            {
                if (danhSachNhaCungCap.get(index).getIdNhaCungCap()==nhaCungCap.getIdNhaCungCap())
                {
                    danhSachNhaCungCap.set(index, nhaCungCap);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idNhaCungCap)
    {
        if (nhaCungCapDAO.remove(idNhaCungCap))
        {
            for (int index=0;index<danhSachNhaCungCap.size();index++)
            {
                if (danhSachNhaCungCap.get(index).getIdNhaCungCap()==idNhaCungCap)
                {
                    danhSachNhaCungCap.remove(index);
                    return  true;
                }
            }

        }
        return false;
    }

}
