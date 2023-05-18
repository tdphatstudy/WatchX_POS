package GUI;

import BUS.SanPhamBUS;
import DTO.SanPham;
import DTO.SanPham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class ChooseProduct extends javax.swing.JFrame{
    private JPanel titleBar,tableView, tablePlace, toolsBar;
    private JPanel jpIcon,jpClose;
    private JLabel jlIcon,jlClose, jlOk, jlCancel;
    private JTable tableSanPham;
    private JScrollPane scrollPaneSanPham;
    private DefaultTableModel renderProductTable=new DefaultTableModel();
    private SanPhamBUS sanPhamBUS=new SanPhamBUS();
    private ArrayList<SanPham> danhSachSanPham=new ArrayList<>();
    private SanPham value=null;
    public ChooseProduct()
    {

        init();
        loadDanhSachSanPham();
    }
    private void init()
    {
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.delarceVariable();
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.add(titleBar);
        this.add(tableView);
        this.add(toolsBar);
    }

    private void delarceVariable()
    {
        titleBar=new JPanel();
        tableView=new JPanel();
        toolsBar=new JPanel();
        jlClose=new JLabel();
        jlIcon=new JLabel();
        jpClose=new JPanel();
        jpIcon=new JPanel();
        jlOk=new JLabel();
        jlCancel=new JLabel();
        tablePlace=new JPanel();

        /*---setup toàn phần---*/
        titleBar.setPreferredSize(new Dimension(600,50));
        titleBar.setBackground(new Color(32, 33, 36));
        tableView.setPreferredSize(new Dimension(600,400));
        tableView.setBackground(new Color(61,62,66));
        titleBar.setPreferredSize(new Dimension(600,50));
        titleBar.setBackground(new Color(32, 33, 36));
        toolsBar.setPreferredSize(new Dimension(600,50));
        toolsBar.setBackground(new Color(32, 33, 36));
        jpIcon.setPreferredSize(new Dimension(250,50));
        jpClose.setPreferredSize(new Dimension(100,50));
        jpClose.setBackground(new Color(32, 33, 36));
        jpIcon.setBackground(new Color(32, 33, 36));


        titleBar.setLayout(new BorderLayout());
        titleBar.add(jpIcon,BorderLayout.WEST);
        titleBar.add(jpClose,BorderLayout.EAST);
        jpIcon.setLayout(new FlowLayout(FlowLayout.LEFT,25,-75));
        jlIcon.setIcon(new ImageIcon("./Image/storelogo.png"));
        jpIcon.add(jlIcon);
        jpClose.setLayout(new FlowLayout(FlowLayout.LEFT,35,10));
        jlClose.setIcon(new javax.swing.ImageIcon("./Image/close.png"));
        jlClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        jpClose.add(jlClose);
        tableView.setLayout(null);
        tablePlace.setBounds(25,15,550,375);
        tablePlace.setBackground(Color.BLUE);
        tableView.add(tablePlace);
        tablePlace.setLayout(new BorderLayout());
        String[] headerSanPham={"ID Product","Id Brand", "Name", "Amount", "Price"};
        String[][] rawTH={{"","","","",""},{"","","","",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, headerSanPham);
        tableSanPham=new JTable(renderInit);
        tableSanPham.setBounds(100,40,550,375);
        scrollPaneSanPham=new JScrollPane(tableSanPham);
        scrollPaneSanPham.setVisible(true);
        tablePlace.add(scrollPaneSanPham);
        tableSanPham.setOpaque(true);
        tableSanPham.getTableHeader().setBackground(new Color(32, 33, 36));
        tableSanPham.getTableHeader().setForeground(Color.WHITE);
        scrollPaneSanPham.getViewport().setBackground(new Color(61,62,66));

        toolsBar.setLayout(new FlowLayout());

        jlOk.setForeground(new Color(42,184,14));
        jlOk.setPreferredSize(new Dimension(150, 40));
        jlOk.setBorder(BorderFactory.createLineBorder(new Color(42,184,14)));
        jlOk.setHorizontalAlignment(SwingConstants.CENTER);
        jlOk.setText("OK");
        jlOk.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jlOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setValue();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jlOk.setOpaque(true);
                jlOk.setForeground(Color.WHITE);
                jlOk.setBackground(new Color(42,184,14));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlOk.setOpaque(false);
                jlOk.setForeground(new Color(42,184,14));
            }
        });
        toolsBar.add(jlOk);
        jlCancel.setForeground(new Color(238,57,57));
        jlCancel.setPreferredSize(new Dimension(150, 40));
        jlCancel.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
        jlCancel.setHorizontalAlignment(SwingConstants.CENTER);
        jlCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jlCancel.setOpaque(true);
                jlCancel.setForeground(Color.WHITE);
                jlCancel.setBackground(new Color(238,57,57));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlCancel.setOpaque(false);
                jlCancel.setForeground(new Color(238,57,57));
            }
        });
        jlCancel.setText("Delete");
        jlCancel.setFont(new Font("iCiel Gotham Medium", 0, 24));
        toolsBar.add(jlCancel);


    }

    private void loadDanhSachSanPham()
    {
        danhSachSanPham=sanPhamBUS.getList();
        renderProductTable= (DefaultTableModel) tableSanPham.getModel();
        renderProductTable.setNumRows(0);
        for (SanPham index: danhSachSanPham)
        {
            renderProductTable.addRow(index.toArray());
        }
        tableSanPham.setModel(renderProductTable);
    }
    private void close()
    {
        this.dispose();
    }
    private void setValue()
    {
        int row= tableSanPham.getSelectedRow();
        if(row==-1)
        {
            JOptionPane.showMessageDialog(null, "Please! Pick the row");
        }
        else
        {
            Vector temp=new Vector();
            for(int i=0;i<renderProductTable.getColumnCount();i++)
            {
                temp.add(tableSanPham.getValueAt(row,i));
            }
            this.value=new SanPham();
            value.setIdSanPham((Integer) temp.get(0));
            value.setIdThuongHieu((Integer) temp.get(1));
            value.setTenSanPham((String) temp.get(2));
            value.setSoLuong((Integer) temp.get(3));
            value.setDonGia((Integer) temp.get(4));
            this.dispose();

        }
    }
    public SanPham getValue()
    {
        return value;
    }

}
