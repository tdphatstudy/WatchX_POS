package BUS;

import BUS.ChiTietHoaDonBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class PrintPDF {
    private final File fontFile = new File("./Font/vuArialBold.ttf");
    private final BaseFont font=BaseFont.createFont(fontFile.getAbsolutePath(),BaseFont.IDENTITY_H,BaseFont.EMBEDDED);

    public PrintPDF() throws IOException, DocumentException {
    }

    public void printBill(HoaDon hoaDon) throws DocumentException, IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String nameFile= "./pdf/"+hoaDon.getIdHoaDon()+"-"+timestamp.getTime()+".pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(nameFile));
        document.open();
        //Tạo Header
        PdfPTable headerTable=new PdfPTable(2);
        headerTable.setWidthPercentage(70);
        headerTable.setHorizontalAlignment(Element.ALIGN_LEFT);
        headerTable.setWidths(new int[] {50,50});
        headerTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        Image image=Image.getInstance("./Image/storelogo.png");
        headerTable.addCell(image);
        String address="Address: 273, An Dương Vương, Quận 5, Thành Phố Hồ Chí Minh.";
        Paragraph header =new Paragraph(address,new Font(font,12));
        headerTable.addCell(header);
        document.add(headerTable);
        String info="Bill No. "+hoaDon.getIdHoaDon()+" \nEmployee No. "+hoaDon.getIdNhanVien()+"\nCustomer No. "+hoaDon.getIdKhachHang()+"\n Date."+ hoaDon.getNgayLapHoaDon();
        Paragraph infoHeader=new Paragraph(info);
        document.add(infoHeader);
        String line="=====================================================================";
        Paragraph drawLine=new Paragraph(line);
        document.add(drawLine);
        //Tạo Nội Dung
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setWidths(new int[]{30, 10,10});
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.addCell(new Phrase("Số Lượng x Tên SP",new Font(font,12)) );
        table.addCell(new Phrase("Đơn Giá",new Font(font,12)));
        table.addCell(new Phrase("Thành Tiền",new Font(font,12)));
        // Nôi dung chi tiết Hóa Đơn.
        ChiTietHoaDonBUS chiTietHoaDonBUS=new ChiTietHoaDonBUS();
        SanPhamBUS sanPhamBUS=new SanPhamBUS();
        ArrayList<ChiTietHoaDon> chiTietHoaDon=chiTietHoaDonBUS.getDanhSachChiTietHoaDonByID(hoaDon.getIdHoaDon());

        for (ChiTietHoaDon index: chiTietHoaDon)
        {
            table.addCell(new Phrase(index.getSoLuong()+" x "
                    +sanPhamBUS.getName(index.getIdSanPham()),new Font(font,12)) );
            table.addCell(new Phrase(index.getDonGia()+"",new Font(font,12)));
            table.addCell(new Phrase(index.getThanhTien()+"",new Font(font,12)));
        }
        document.add(table);
        //Tạo Phần Tổng Tiền
        document.add(drawLine);
        PdfPTable tableTotal = new PdfPTable(4);
        tableTotal.setWidthPercentage(100);
        tableTotal.setHorizontalAlignment(Element.ALIGN_LEFT);
        tableTotal.setWidths(new int[]{30,10,10,10});
        tableTotal.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        tableTotal.addCell(new Phrase("Tổng Cộng: ",new Font(font,12)));
        tableTotal.addCell(new Phrase());
        tableTotal.addCell(new Phrase());
        tableTotal.addCell(""+hoaDon.getTongCong());
        tableTotal.addCell(new Phrase("Tiền Khách Đưa: ",new Font(font,12)));
        tableTotal.addCell(new Phrase());
        tableTotal.addCell(new Phrase());
        tableTotal.addCell(""+hoaDon.getTienKhachDua());
        tableTotal.addCell(new Phrase("Tiền Thừa: ",new Font(font,12)));
        tableTotal.addCell(new Phrase());
        tableTotal.addCell(new Phrase());
        tableTotal.addCell(""+hoaDon.getTienThua());
        document.add(tableTotal);

        document.close();
        File file=new File(nameFile);
        if(!Desktop.isDesktopSupported())
        {
            JOptionPane.showMessageDialog(null,"Chức năng mở file không khả dụng trên thiết bị này");
            return;
        }
        Desktop desktop=Desktop.getDesktop();
        if(file.exists())
        {
            desktop.open(file);
        }
    }


}