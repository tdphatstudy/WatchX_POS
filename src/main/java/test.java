
import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.PrintPDF;
import DAO.ConnectionSQL;
import DAO.ChiTietHoaDonDAO;
import DAO.ThuongHieuDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import GUI.*;
import com.itextpdf.text.DocumentException;
import com.mysql.jdbc.log.Log;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) {

       // POS pos = new POS();
       // pos.setVisible(true);
        //MainFrame mainFrame = new MainFrame();
        //mainFrame.setVisible(true);
        //ChooseBrand chooseBrand=new ChooseBrand();
        //chooseBrand.setVisible(true);
        // ChooseProduct chooseProduct=new ChooseProduct();
        // chooseProduct.setVisible(true);
        //ChooseProvider chooseProvider=new ChooseProvider();
        //chooseProvider.setVisible(true);
        Login login =new Login();
        login.setVisible(true);
    }
}
