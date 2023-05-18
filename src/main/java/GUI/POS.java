package GUI;

import BUS.HoaDonBUS;
import BUS.PrintPDF;
import DTO.ChiTietHoaDon;
import DTO.ChiTietPhieuNhap;
import DTO.HoaDon;
import DTO.SanPham;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Timestamp;

public class POS extends JPanel {
    private JPanel jlDetail,jlTableView,jlInvoice;
    private JPanel jpIdProduct,jpSoLuong, jpDonGia;
    private JLabel jlIdProduct, jlSoLuong, jlDonGia, jlBtnAdd,jlBtnDel;
    private JTextField jtxIdProduct,jtxSoLuong, jtxDonGia;
    private JButton jbtnChooseIDProduct, jbtnIdCustomer;
    private JTable tableDetail;
    private DefaultTableModel render;
    private JScrollPane scrollPaneDetail;
    private HoaDonBUS hoaDonBUS=new HoaDonBUS();
    private JPanel jpIdCustomer,jpTotal,jpTienKhachDua,jpExcessCash;
    private JLabel jlIdCustomer, jlTotal,jlTienKhachDua, jlExcessCash;
    private JLabel jbtnPrint, jbtnCancel;
    private JTextField jtxIdCustomer, jtxTotal, jtxTKD ,jtxEC;
    private int idNV;
    private PrintPDF printPDF;

    {
        try {
            printPDF = new PrintPDF();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public POS(int idNV)
    {
        setSession(idNV);
        init();
    }
    private void init()
    {
        this.setPreferredSize(new Dimension(1000,700));
        this.setBackground(new Color(53,54,58));
        this.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
        this.setLayout(null);
        this.delarce();

    }
    private  void delarce()
    {
        jlDetail=new JPanel();
        jlTableView=new JPanel();
        jlInvoice=new JPanel();
        jpIdProduct=new JPanel();
        jpDonGia=new JPanel();
        jpSoLuong=new JPanel();
        jlIdProduct=new JLabel("ID");
        jlSoLuong=new JLabel("SL");
        jlDonGia=new JLabel("Price");
        jbtnChooseIDProduct=new JButton("...");
        jtxIdProduct=new JTextField();
        jtxDonGia=new JTextField();
        jtxSoLuong=new JTextField();
        jlBtnAdd=new JLabel();
        jlBtnDel=new JLabel();
        jpIdCustomer=new JPanel();
        jpTotal=new JPanel();
        jpTienKhachDua=new JPanel();
        jpExcessCash=new JPanel();
        jbtnPrint=new JLabel();
        jbtnCancel=new JLabel();
        jtxIdCustomer=new JTextField();
        jtxTotal=new JTextField();
        jtxTKD=new JTextField();
        jtxEC=new JTextField();
        jbtnIdCustomer=new JButton("...");
        jlTotal=new JLabel("Total");
        jlTienKhachDua=new JLabel("Given");
        jlIdCustomer=new JLabel("Customer");
        jlExcessCash=new JLabel("Excess");

        /*----Setup toàn bộ-----*/
        jlInvoice.setBounds(690,0,300,700);
        jlInvoice.setBackground(new Color(32, 33, 36));
        jlInvoice.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),3));
        this.add(jlInvoice);
        jlDetail.setBounds(0,0,700,100);
        jlDetail.setBackground(new Color(32, 33, 36));
        jlDetail.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),3));
        this.add(jlDetail);
        jlTableView.setBounds(0,100,700,600);
        jlTableView.setBackground(Color.WHITE);
        jlTableView.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),3));
        this.add(jlTableView);
        /*---Seup Detail----*/
        jlDetail.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));
        jpIdProduct.setPreferredSize(new Dimension(200,40));
        jpIdProduct.setBackground(new Color(61,62,66));
        jpIdProduct.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlIdProduct.setPreferredSize(new Dimension(60,40));
        jlIdProduct.setForeground(Color.WHITE);
        jlIdProduct.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdProduct.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jtxIdProduct.setEditable(false);
        jtxIdProduct.setPreferredSize(new Dimension(100,40));
        jbtnChooseIDProduct.setBackground(new Color(32, 33, 36));
        jbtnChooseIDProduct.setForeground(Color.WHITE);
        jbtnChooseIDProduct.setPreferredSize(new Dimension(40,40));
        jbtnChooseIDProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getDetail();
            }
        });
        jpIdProduct.add(jlIdProduct);
        jpIdProduct.add(jtxIdProduct);
        jpIdProduct.add(jbtnChooseIDProduct);
        jlDetail.add(jpIdProduct);

        jpSoLuong.setPreferredSize(new Dimension(150,40));
        jpSoLuong.setBackground(new Color(61,62,66));
        jpSoLuong.setBackground(new Color(61,62,66));
        jpSoLuong.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlSoLuong.setPreferredSize(new Dimension(50,40));
        jlSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
        jlSoLuong.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlSoLuong.setForeground(Color.WHITE);
        jtxSoLuong.setPreferredSize(new Dimension(100,40));
        jpSoLuong.add(jlSoLuong);
        jpSoLuong.add(jtxSoLuong);
        jlDetail.add(jpSoLuong);

        jpDonGia.setPreferredSize(new Dimension(200,40));
        jpDonGia.setBackground(new Color(61,62,66));
        jpDonGia.setPreferredSize(new Dimension(200,40));
        jpDonGia.setBackground(new Color(61,62,66));
        jpDonGia.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlDonGia.setPreferredSize(new Dimension(100,40));
        jlDonGia.setHorizontalAlignment(SwingConstants.CENTER);
        jlDonGia.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDonGia.setForeground(Color.WHITE);
        jtxDonGia.setPreferredSize(new Dimension(100,40));
        jtxDonGia.setEditable(false);
        jtxDonGia.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jpDonGia.add(jlDonGia);
        jpDonGia.add(jtxDonGia);
        jlDetail.add(jpDonGia);

        jlBtnAdd.setPreferredSize(new Dimension(40,40));
        jlBtnAdd.setIcon(new ImageIcon("./Image/add.png"));
        jlBtnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }
        });
        jlDetail.add(jlBtnAdd);

        jlBtnDel.setPreferredSize(new Dimension(40,40));
        jlBtnDel.setIcon(new ImageIcon("./Image/delete.png"));
        jlBtnDel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteDetail();
            }
        });
        jlDetail.add(jlBtnDel);

        /*----Setup tableview------*/
        jlTableView.setLayout(new BorderLayout());
        String[] header={"Id Product","Amount","Price","Total"};
        String[][] rawTH={{"","","",""},{"","","",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, header);
        tableDetail=new JTable(renderInit);
        tableDetail.setSize(550,450);
        scrollPaneDetail=new JScrollPane(tableDetail);
        scrollPaneDetail.setVisible(true);
        jlTableView.add(scrollPaneDetail);
        tableDetail.setOpaque(true);
        tableDetail.getTableHeader().setBackground(new Color(32, 33, 36));
        tableDetail.getTableHeader().setForeground(Color.WHITE);
        scrollPaneDetail.getViewport().setBackground(new Color(32, 33, 36));

        /*-----Setup Detail------*/
        jlInvoice.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        jpIdCustomer.setPreferredSize(new Dimension(200,40));
        jpIdCustomer.setBackground(new Color(61,62,66));
        jpIdCustomer.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlIdCustomer.setPreferredSize(new Dimension(60,40));
        jlIdCustomer.setForeground(Color.WHITE);
        jlIdCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdCustomer.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jtxIdCustomer.setEditable(false);
        jtxIdCustomer.setPreferredSize(new Dimension(100,40));
        jbtnIdCustomer.setBackground(new Color(32, 33, 36));
        jbtnIdCustomer.setForeground(Color.WHITE);
        jbtnIdCustomer.setPreferredSize(new Dimension(40,40));
        jbtnIdCustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getCustomer();
            }
        });
        jpIdCustomer.add(jlIdCustomer);
        jpIdCustomer.add(jtxIdCustomer);
        jpIdCustomer.add(jbtnIdCustomer);
        jlInvoice.add(jpIdCustomer);

        jpTotal.setPreferredSize(new Dimension(200,40));
        jpTotal.setBackground(new Color(61,62,66));
        jpTotal.setPreferredSize(new Dimension(200,40));
        jpTotal.setBackground(new Color(61,62,66));
        jpTotal.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlTotal.setPreferredSize(new Dimension(60,40));
        jlTotal.setHorizontalAlignment(SwingConstants.CENTER);
        jlTotal.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTotal.setForeground(Color.WHITE);
        jtxTotal.setPreferredSize(new Dimension(140,40));
        jtxTotal.setEditable(false);
        jtxTotal.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jpTotal.add(jlTotal);
        jpTotal.add(jtxTotal);
        jlInvoice.add(jpTotal);

        jpTienKhachDua.setPreferredSize(new Dimension(200,40));
        jpTienKhachDua.setBackground(new Color(61,62,66));
        jpTienKhachDua.setPreferredSize(new Dimension(200,40));
        jpTienKhachDua.setBackground(new Color(61,62,66));
        jpTienKhachDua.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlTienKhachDua.setPreferredSize(new Dimension(60,40));
        jlTienKhachDua.setHorizontalAlignment(SwingConstants.CENTER);
        jlTienKhachDua.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTienKhachDua.setForeground(Color.WHITE);
        jtxTKD.setPreferredSize(new Dimension(140,40));
        jtxTKD.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jtxTKD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()== KeyEvent.VK_ENTER)
                {
                    calEC();

                }
            }
        });
        jpTienKhachDua.add(jlTienKhachDua);
        jpTienKhachDua.add(jtxTKD);
        jlInvoice.add(jpTienKhachDua);

        jpExcessCash.setPreferredSize(new Dimension(200,40));
        jpExcessCash.setBackground(new Color(61,62,66));
        jpExcessCash.setPreferredSize(new Dimension(200,40));
        jpExcessCash.setBackground(new Color(61,62,66));
        jpExcessCash.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlExcessCash.setPreferredSize(new Dimension(60,40));
        jlExcessCash.setHorizontalAlignment(SwingConstants.CENTER);
        jlExcessCash.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlExcessCash.setForeground(Color.WHITE);
        jtxEC.setPreferredSize(new Dimension(140,40));
        jtxEC.setEditable(false);
        jtxEC.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jpExcessCash.add(jlExcessCash);
        jpExcessCash.add(jtxEC);
        jlInvoice.add(jpExcessCash);

        jbtnPrint.setPreferredSize(new Dimension(150,40));
        jbtnPrint.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
        jbtnPrint.setIcon(new ImageIcon("./Image/pdf.png"));
        jbtnPrint.setForeground(Color.ORANGE);
        jbtnPrint.setText("Print");
        jbtnPrint.setFont(new Font("iCiel Gotham Medium", 0, 20));
        jbtnPrint.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addInvoice();
            }
        });
        jlInvoice.add(jbtnPrint);

        jbtnCancel.setPreferredSize(new Dimension(150,40));
        jbtnCancel.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        jbtnCancel.setIcon(new ImageIcon("./Image/delete.png"));
        jbtnCancel.setForeground(Color.WHITE);
        jbtnCancel.setBackground(Color.RED);
        jbtnCancel.setOpaque(true);
        jbtnCancel.setText("Cancel");
        jbtnCancel.setFont(new Font("iCiel Gotham Medium", 0, 20));
        jbtnCancel.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancel();
            }
        });
        jlInvoice.add(jbtnCancel);


    }
    private boolean isFull()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String id=jtxIdProduct.getText();
        String dg=jtxDonGia.getText();
        String sl=jtxSoLuong.getText();
        if (id.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Id Field is blank");
            return false;
        } else if (sl.trim().equals("") && toolsGUI.isInterger(sl)==false && Integer.parseInt(sl)>0 )
        {
            JOptionPane.showMessageDialog(null,"Amount Field is illegel");
            return false;
        }
        return true;

    }
    private void add()
    {
        if (isFull())
        {
            int id= Integer.parseInt(jtxIdProduct.getText());
            int dg= Integer.parseInt(jtxDonGia.getText());
            int sl= Integer.parseInt(jtxSoLuong.getText());
            ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon(-1,id,sl,dg,sl*dg);
            if (hoaDonBUS.checkOutOfStock(id,sl)) {
                if (hoaDonBUS.checkExistDetail(id)) {
                    hoaDonBUS.add_temp(chiTietHoaDon);
                    loadChiTiet();
                    loadTotal();
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(null, "Exist deltai");
                    refresh();
                }
            }
        }
    }
    private  void setInfor(SanPham sanPham)
    {
        jtxIdProduct.setText(String.valueOf(sanPham.getIdSanPham()));
        jtxDonGia.setText(String.valueOf(sanPham.getDonGia()));
        jtxSoLuong.setText("1");
    }
    private void getDetail()
    {
        ChooseProduct chooseProduct= new ChooseProduct();
        chooseProduct.setVisible(true);
        chooseProduct.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (chooseProduct.getValue()!=null)
                {
                    setInfor(chooseProduct.getValue());
                }
            }
        });
    }
    private void getCustomer()
    {
        ChooseCustomer chooseCustomer= new ChooseCustomer();
        chooseCustomer.setVisible(true);
        chooseCustomer.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (chooseCustomer.getValue()!=null)
                {
                    jtxIdCustomer.setText(String.valueOf(chooseCustomer.getValue().getIdKhachHang()));
                }
            }
        });
    }
    private void refresh()
    {
        jtxIdProduct.setText("");
        jtxSoLuong.setText("");
        jtxDonGia.setText("");
    }
    public void loadChiTiet()
    {
            render=(DefaultTableModel) tableDetail.getModel();
            render.setNumRows(0);
            for (ChiTietHoaDon index : hoaDonBUS.getDetailList_temp())
            {
                render.addRow(index.toArrayVer1());
            }
            tableDetail.setModel(render);
    }
    private void deleteDetail()
    {
        int row=tableDetail.getSelectedRow();
        if(row>=0)
        {
            int id= Integer.parseInt(String.valueOf(tableDetail.getValueAt(row,0)));
            int idsp= Integer.parseInt(String.valueOf(tableDetail.getValueAt(row,1)));
            if (JOptionPane.showConfirmDialog(null, "You want to delete this detail order?  id product " + idsp,
                    "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            {
                for (ChiTietHoaDon index: hoaDonBUS.getDetailList_temp())
                {
                    if (index.getIdSanPham()==idsp)
                    {
                        hoaDonBUS.deleteDetail_temp(idsp);
                        loadChiTiet();
                        refresh();
                        loadTotal();
                        break;
                    }
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Choose detail, please");
        }


    }
    private void loadTotal()
    {
        int total= hoaDonBUS.getTotal_temp();
        jtxTotal.setText(String.valueOf(total));

    }
    private void calEC()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String tkd=jtxTKD.getText();
        if (tkd.trim().equals("") || toolsGUI.isInterger(tkd)==false || Integer.parseInt(jtxTKD.getText())<Integer.parseInt(jtxTotal.getText()))
        {
            JOptionPane.showMessageDialog(null, "Given Field is wrong");
        }else
        {
            double total= Integer.parseInt(jtxTotal.getText());
            double tienKhachDua= Integer.parseInt(jtxTKD.getText());
            jtxEC.setText(String.valueOf(tienKhachDua-total));
        }

    }
    private boolean isFullInvoice()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String tKd=jtxTKD.getText();
        String total=jtxTotal.getText();
        String ec=jtxEC.getText();
        if (tKd.trim().equals("")||  toolsGUI.isInterger(tKd)==false || Integer.parseInt(tKd)<Integer.parseInt(total))
        {
            JOptionPane.showMessageDialog(null, "Given Filed is blank or illegel");
            return  false;
        } else if (total.trim().equals("")||  toolsGUI.isInterger(tKd)==false )
        {
            JOptionPane.showMessageDialog(null, "Total Filed is blank or illegel");
            return  false;
        } else if (ec.trim().equals("")||  toolsGUI.isInterger(tKd)==false || Double.parseDouble(ec)>0)
        {
            JOptionPane.showMessageDialog(null, "Excess Filed is blank or illegel");
            return  false;
        } else if(hoaDonBUS.getDetailList_temp()==null)
        {
            JOptionPane.showMessageDialog(null,"No Detail");
            return false;
        }
        return true;
    }
    private void addInvoice()
    {
        if (isFullInvoice())
        {
            int idCus=-1;
            if (!jtxIdCustomer.getText().trim().equals(""))
            {
                idCus=Integer.parseInt(jtxIdCustomer.getText());
            }
            int tKd= Integer.parseInt(jtxTKD.getText());
            int total= Integer.parseInt(jtxTotal.getText());
            int ec= (int) Double.parseDouble(jtxEC.getText());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            HoaDon hoaDon =new HoaDon(-1,this.idNV,idCus,tKd,total,ec, timestamp);
            if (hoaDonBUS.add(hoaDon) )
            {
                JOptionPane.showMessageDialog(null, "Successful");
                hoaDon.setIdHoaDon(hoaDonBUS.getLastID());
                renew();
                loadChiTiet();
                refresh();
                try {
                    printPDF.printBill(hoaDon);
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else
            {
                JOptionPane.showMessageDialog(null, "Fail");
                renew();
                loadChiTiet();
                refresh();
            }
        }
    }
    private void cancel()
    {
        hoaDonBUS.refreshDetailList_temp();
        renew();
        loadChiTiet();
        refresh();
    }
    private void setSession(int idNV)
    {
        this.idNV = idNV;
    }
    private void renew()
    {
        jtxIdCustomer.setText("");
        jtxEC.setText("");
        jtxTotal.setText("");
        jtxTKD.setText("");

    }

}
