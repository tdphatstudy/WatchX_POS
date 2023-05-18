package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieu;

import java.util.ArrayList;

public class ThuongHieuBUS {
    private ArrayList<ThuongHieu> danhSachThuongHieu=new ArrayList<>();
    private ThuongHieuDAO thuongHieuDAO=new ThuongHieuDAO();

    public ThuongHieuBUS()
    {
     readData();
    }
    private void readData()
    {
        danhSachThuongHieu=thuongHieuDAO.readData();
    }
    public ArrayList<ThuongHieu> getList()
    {
        return danhSachThuongHieu;
    }
    public void refresh()
    {
        readData();
    }
    public boolean add(ThuongHieu thuongHieu)
    {
        if (thuongHieuDAO.add(thuongHieu))
        {
            ThuongHieu thuongHieu1=new ThuongHieu(thuongHieuDAO.getLastID(), thuongHieu.getTenThuongHieu());
            danhSachThuongHieu.add(thuongHieu1);
            return true;
        }
        return false;
    }
    public int getLastID()
    {
        return thuongHieuDAO.getLastID();
    }

    public boolean update(ThuongHieu thuongHieu)
    {
        if (thuongHieuDAO.update(thuongHieu))
        {
            for (int index=0;index<danhSachThuongHieu.size();index++)
            {
                if (danhSachThuongHieu.get(index).getIdThuongHieu()==thuongHieu.getIdThuongHieu())
                {
                    danhSachThuongHieu.set(index, thuongHieu);
                    return true;
                }
            }

        }
        return false;
    }
    public boolean delete(int idThuongHieu)
    {
        if (thuongHieuDAO.remove(idThuongHieu))
        {
            for (int index=0;index<danhSachThuongHieu.size();index++)
            {
                if (danhSachThuongHieu.get(index).getIdThuongHieu()==idThuongHieu)
                {
                    danhSachThuongHieu.remove(index);
                    return  true;
                }
            }

        }
        return false;
    }

}
