package GUI;

import BUS.SanPhamBUS;
import DTO.SanPham;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class SanPhamGUI extends JPanel {
    /*---Thành phần GUI---*/
    private JPanel jpSearchBarSanPham,jpEnterToolsSanPham,jpButtonSanPham,jpTableViewSanPham;
    private JPanel jpContainerSearchToolsSanPham;
    private JLabel jlSearchSanPham;
    private JTextField jtxSearchEnterSanPham;
    private JLabel jbtnSearchSanPham;
    private JPanel jpContainerIdSanPham,jpContainerIdThuongHieu, jpContainerTenSanPham,jpContainerSoLuongSanPham, jpContainerDonGiaSanPham;
    private JLabel jlIdSanPham,jlIdThuongHieu, jlTenSanPham, jlSoLuongSanPham, jlDonGiaSanPham;
    private JTextField jtxIdSanPham,jtxIdThuongHieu, jtxTenSanPham, jtxSoLuongSanPham, jtxDonGiaSanPham;
    private JLabel jbtnThem,jbtnXoa, jbtnSua;
    private JButton jbtnIdThuongHieu;
    private JTable tableSanPham;
    private JScrollPane scrollPaneSanPham;
    /*---Biến xử lý---*/
    private SanPhamBUS sanPhamBUS=new SanPhamBUS();
    private DefaultTableModel renderProductTable=new DefaultTableModel();
    private ArrayList<SanPham> danhSachSanPham=new ArrayList<>();
    public SanPhamGUI()
    {
        init();
    }
    private  void init()
    {
        this.setPreferredSize(new Dimension(1000,700));
        this.setBackground(new Color(53,54,58));
        this.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.delarceVariable();
        this.add(jpSearchBarSanPham);
        this.add(jpEnterToolsSanPham);
        this.add(jpButtonSanPham);
        this.add(jpTableViewSanPham);
        loadDanhSachSanPham();

    }
    private void delarceVariable()
    {
        LineBorder line = new LineBorder(new Color(61,62,66), 1, true);
        jpSearchBarSanPham=new JPanel();
        jpEnterToolsSanPham=new JPanel();
        jpButtonSanPham=new JPanel();
        jpTableViewSanPham=new JPanel();
        jpContainerSearchToolsSanPham =new JPanel();
        jlSearchSanPham=new JLabel("",SwingConstants.LEADING);
        jtxSearchEnterSanPham=new JTextField();
        jbtnSearchSanPham=new JLabel("",SwingConstants.CENTER);
        jpContainerIdSanPham=new JPanel();
        jpContainerIdThuongHieu=new JPanel();
        jpContainerTenSanPham=new JPanel();
        jpContainerSoLuongSanPham=new JPanel();
        jpContainerDonGiaSanPham=new JPanel();
        jlIdSanPham=new JLabel();
        jlIdThuongHieu=new JLabel();
        jlTenSanPham=new JLabel();
        jlSoLuongSanPham=new JLabel();
        jlDonGiaSanPham=new JLabel();
        jtxIdSanPham=new JTextField();
        jtxIdThuongHieu=new JTextField();
        jtxTenSanPham=new JTextField();
        jtxSoLuongSanPham=new JTextField();
        jtxDonGiaSanPham=new JTextField();
        jbtnIdThuongHieu=new JButton("...");
        jbtnThem=new JLabel();
        jbtnXoa=new JLabel();
        jbtnSua=new JLabel();

        /*---Setup toàn Panel---*/
        jpSearchBarSanPham.setPreferredSize(new Dimension(990,50));
        jpSearchBarSanPham.setBackground(new Color(32, 33, 36));
        jpSearchBarSanPham.setBorder(line);
        jpEnterToolsSanPham.setPreferredSize(new Dimension(990,200));
        jpEnterToolsSanPham.setBackground(new Color(32, 33, 36));
        jpEnterToolsSanPham.setBorder(line);
        jpButtonSanPham.setPreferredSize(new Dimension(990,50));
        jpButtonSanPham.setBackground(new Color(32, 33, 36));
        jpButtonSanPham.setBorder(line);
        jpTableViewSanPham.setPreferredSize(new Dimension(990,400));
        jpTableViewSanPham.setBackground(new Color(32, 33, 36));
        jpTableViewSanPham.setBorder(line);

        /*---Setup search bar---*/
        jpSearchBarSanPham.setLayout(null);
        jpContainerSearchToolsSanPham.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),2));
        jpContainerSearchToolsSanPham.setBounds(20,10,400,30);
        jpContainerSearchToolsSanPham.setBackground(new Color(32,33,36));
        jpSearchBarSanPham.add(jpContainerSearchToolsSanPham);
        jpContainerSearchToolsSanPham.setLayout(new FlowLayout(FlowLayout.CENTER,0,-2));
        jlSearchSanPham.setText("Search: ");
        jlSearchSanPham.setForeground(Color.WHITE);
        jlSearchSanPham.setBackground(new Color(32, 33, 36));
        jlSearchSanPham.setPreferredSize(new Dimension(50,30));
        jtxSearchEnterSanPham.setPreferredSize(new Dimension(300,30));
        jbtnSearchSanPham.setBackground(new Color(32, 33, 36));
        jbtnSearchSanPham.setPreferredSize(new Dimension(46,30));
        jbtnSearchSanPham.setIcon(new ImageIcon("./Image/search-icon.png"));
        jbtnSearchSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchSanPham();
            }
        });
        jpContainerSearchToolsSanPham.add(jlSearchSanPham);
        jpContainerSearchToolsSanPham.add(jtxSearchEnterSanPham);
        jpContainerSearchToolsSanPham.add(jbtnSearchSanPham);

        /*---Setup các field nhập---*/
        jpEnterToolsSanPham.setLayout(null);
        jpContainerIdSanPham.setBounds(63,20,400,40);
        jpContainerIdThuongHieu.setBounds(526,20,400,40);
        jpContainerTenSanPham.setBounds(63,80,400,40);
        jpContainerSoLuongSanPham.setBounds(526,80,400,40);
        jpContainerDonGiaSanPham.setBounds(245,140,400,40);
        jpContainerIdThuongHieu.setBackground(new Color(53,54,58));
        jpContainerIdSanPham.setBackground(new Color(53,54,58));
        jpContainerTenSanPham.setBackground(new Color(53,54,58));
        jpContainerSoLuongSanPham.setBackground(new Color(53,54,58));
        jpContainerDonGiaSanPham.setBackground(new Color(53,54,58));
        jpContainerIdSanPham.setLayout(new BorderLayout());
        jlIdSanPham.setPreferredSize(new Dimension(100,40));
        jtxIdSanPham.setEditable(false);
        jlIdSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdSanPham.setForeground(Color.WHITE);
        jlIdSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdSanPham.setText("Id");
        jtxIdSanPham.setPreferredSize(new Dimension(300,40));
        jtxIdSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdSanPham.add(jlIdSanPham, BorderLayout.WEST);
        jpContainerIdSanPham.add(jtxIdSanPham, BorderLayout.EAST);

        jpContainerIdThuongHieu.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlIdThuongHieu.setPreferredSize(new Dimension(100,40));
        jlIdThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdThuongHieu.setForeground(Color.white);
        jlIdThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdThuongHieu.setText("Brand Id");
        jtxIdThuongHieu.setPreferredSize(new Dimension(250,40));
        jtxIdThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jbtnIdThuongHieu.setPreferredSize(new Dimension(50,40));
        jbtnIdThuongHieu.setBackground(new Color(53,54,58));
        jbtnIdThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jbtnIdThuongHieu.setText("...");
        jbtnIdThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdThuongHieu.add(jlIdThuongHieu);
        jpContainerIdThuongHieu.add(jtxIdThuongHieu);
        jpContainerIdThuongHieu.add(jbtnIdThuongHieu);
        jbtnIdThuongHieu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseIdThuongHieu();
            }
        });
        jpEnterToolsSanPham.add(jpContainerIdSanPham);
        jpEnterToolsSanPham.add(jpContainerIdThuongHieu);


        jpContainerTenSanPham.setLayout(new BorderLayout());
        jlTenSanPham.setPreferredSize(new Dimension(100,40));
        jlTenSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenSanPham.setForeground(Color.white);
        jlTenSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jlTenSanPham.setText("Product Name");
        jtxTenSanPham.setPreferredSize(new Dimension(300,40));
        jtxTenSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerTenSanPham.add(jlTenSanPham, BorderLayout.WEST);
        jpContainerTenSanPham.add(jtxTenSanPham, BorderLayout.EAST);
        jpEnterToolsSanPham.add(jpContainerIdSanPham);
        jpEnterToolsSanPham.add(jpContainerTenSanPham);

        jpContainerSoLuongSanPham.setLayout(new BorderLayout());
        jlSoLuongSanPham.setPreferredSize(new Dimension(100,40));
        jlSoLuongSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlSoLuongSanPham.setForeground(Color.white);
        jlSoLuongSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jlSoLuongSanPham.setText("Amount");
        jtxSoLuongSanPham.setPreferredSize(new Dimension(300,40));
        jtxSoLuongSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlSoLuongSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerSoLuongSanPham.add(jlSoLuongSanPham, BorderLayout.WEST);
        jpContainerSoLuongSanPham.add(jtxSoLuongSanPham, BorderLayout.EAST);
        jpEnterToolsSanPham.add(jpContainerIdSanPham);
        jpEnterToolsSanPham.add(jpContainerSoLuongSanPham);

        jpContainerDonGiaSanPham.setLayout(new BorderLayout());
        jlDonGiaSanPham.setPreferredSize(new Dimension(100,40));
        jlDonGiaSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDonGiaSanPham.setForeground(Color.white);
        jlDonGiaSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jlDonGiaSanPham.setText("Price");
        jtxDonGiaSanPham.setPreferredSize(new Dimension(300,40));
        jtxDonGiaSanPham.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDonGiaSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDonGiaSanPham.add(jlDonGiaSanPham, BorderLayout.WEST);
        jpContainerDonGiaSanPham.add(jtxDonGiaSanPham, BorderLayout.EAST);
        jpEnterToolsSanPham.add(jpContainerIdSanPham);
        jpEnterToolsSanPham.add(jpContainerDonGiaSanPham);

        /*---Setup phần nút bấm---*/
        jpButtonSanPham.setLayout(new FlowLayout(FlowLayout.CENTER, 100,5));
        jbtnThem.setForeground(new Color(42,184,14));
        jbtnThem.setPreferredSize(new Dimension(150, 40));
        jbtnThem.setBorder(BorderFactory.createLineBorder(new Color(42,184,14)));
        jbtnThem.setIcon(new ImageIcon("./Image/add-green.png"));
        jbtnThem.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnThem.setText("  Add");
        jbtnThem.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jbtnThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnThem.setOpaque(true);
                jbtnThem.setForeground(Color.WHITE);
                jbtnThem.setBackground(new Color(42,184,14));
                jbtnThem.setIcon(new ImageIcon("./Image/add-white.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnThem.setOpaque(false);
                jbtnThem.setForeground(new Color(42,184,14));
                jbtnThem.setIcon(new ImageIcon("./Image/add-green.png"));
            }
        });
        jpButtonSanPham.add(jbtnThem);

        jbtnSua.setForeground(new Color(41,70,237));
        jbtnSua.setPreferredSize(new Dimension(150, 40));
        jbtnSua.setBorder(BorderFactory.createLineBorder(new Color(41,70,237)));
        jbtnSua.setIcon(new ImageIcon("./Image/update_blue.png"));
        jbtnSua.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnSua.setText("  Update");
        jbtnSua.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jbtnSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                update();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnSua.setOpaque(true);
                jbtnSua.setForeground(Color.WHITE);
                jbtnSua.setBackground(new Color(41,70,237));
                jbtnSua.setIcon(new ImageIcon("./Image/update_white.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnSua.setOpaque(false);
                jbtnSua.setForeground(new Color(41,70,237));
                jbtnSua.setIcon(new ImageIcon("./Image/update_blue.png"));
            }
        });
        jpButtonSanPham.add(jbtnSua);

        jbtnXoa.setForeground(new Color(238,57,57));
        jbtnXoa.setPreferredSize(new Dimension(150, 40));
        jbtnXoa.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
        jbtnXoa.setIcon(new ImageIcon("./Image/remove_red.png"));
        jbtnXoa.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnXoa.setOpaque(true);
                jbtnXoa.setForeground(Color.WHITE);
                jbtnXoa.setBackground(new Color(238,57,57));
                jbtnXoa.setIcon(new ImageIcon("./Image/remove-white.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnXoa.setOpaque(false);
                jbtnXoa.setForeground(new Color(238,57,57));
                jbtnXoa.setIcon(new ImageIcon("./Image/remove_red.png"));
            }
        });
        jbtnXoa.setText("  Delete");
        jbtnXoa.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jpButtonSanPham.add(jbtnXoa);


        /*---Setup table---*/
        jpTableViewSanPham.setLayout(new BorderLayout());
        String[] headerSanPham={"ID", "Brand ID","Product Name", "Amount","Price"};
        String[][] rawTH={{"","","","",""},{"","","","",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, headerSanPham);
        tableSanPham=new JTable(renderInit);
        tableSanPham.setSize(900,500);
        scrollPaneSanPham=new JScrollPane(tableSanPham);
        scrollPaneSanPham.setVisible(true);
        jpTableViewSanPham.add(scrollPaneSanPham);
        tableSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseRowSanPham(tableSanPham.getSelectedRow());
            }
        });
        tableSanPham.setOpaque(true);
        tableSanPham.getTableHeader().setBackground(new Color(32, 33, 36));
        tableSanPham.getTableHeader().setForeground(Color.WHITE);
        scrollPaneSanPham.getViewport().setBackground(new Color(32, 33, 36));

    }

    private void chooseRowSanPham(int row)
    {
        Vector temp=new Vector();
        for(int index=0;index<tableSanPham.getColumnCount();index++)
        {
            temp.add(tableSanPham.getValueAt(row,index));
        }
        jtxIdSanPham.setText(""+temp.get(0));
        jtxIdThuongHieu.setText(""+temp.get(1));
        jtxTenSanPham.setText((String) temp.get(2));
        jtxSoLuongSanPham.setText(""+temp.get(3));
        jtxDonGiaSanPham.setText(""+temp.get(4));
    }
    public void loadDanhSachSanPham()
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
    private boolean isFullFiled()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String idbrand=jtxIdThuongHieu.getText();
        String ten=jtxTenSanPham.getText();
        String soLuong=jtxSoLuongSanPham.getText();
        String gia=jtxDonGiaSanPham.getText();
        if (idbrand.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please do not leave the 'Brand ID' field blank");
            return false;
        } else if(ten.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please do not leave the 'Product Name' field blank");
            return false;
        } else if (soLuong.trim().equals("") || toolsGUI.isInterger(soLuong)==false)
        {
            JOptionPane.showMessageDialog(null, "Amount field is blank or illegel value");
            return false;
        } else if (gia.trim().equals("") || toolsGUI.isInterger(gia)==false )
        {
            JOptionPane.showMessageDialog(null, "Price field is blank or illegel value");
            return false;
        }
        return true;
    }

    private void add()
    {
        if (isFullFiled())
        {
            int idbrand= Integer.parseInt(jtxIdThuongHieu.getText());
            String ten=jtxTenSanPham.getText();
            int soLuong= Integer.parseInt(jtxSoLuongSanPham.getText());
            int gia= Integer.parseInt(jtxDonGiaSanPham.getText());
            if (sanPhamBUS.add(new SanPham(-1, idbrand,ten,soLuong,gia,"None","None")))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderProductTable= (DefaultTableModel) tableSanPham.getModel();
                SanPham insert= new SanPham(sanPhamBUS.getLastID(), idbrand,ten,soLuong,gia,"None","None");
                renderProductTable.addRow(insert.toArray());
                tableSanPham.setModel(renderProductTable);
                refreshSanPham();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshSanPham();
            }

        }
    }
    private void delete()
    {
        int row=tableSanPham.getSelectedRow();
        int id=-1;
        try{
            id=(int)tableSanPham.getValueAt(row,0);

        } catch (Exception e)
        {
            id= Integer.parseInt((String) tableSanPham.getValueAt(row,0));
        }
        if (JOptionPane.showConfirmDialog(null, "You want to delete this product? Product= " + id ,
                "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
        {
            if(sanPhamBUS.delete(id))
            {
                JOptionPane.showMessageDialog(null,"Succsessly");
                renderProductTable= (DefaultTableModel) tableSanPham.getModel();
                renderProductTable.removeRow(row);
                tableSanPham.setModel(renderProductTable);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fail");
            }

        }
    }
    private void update()
    {
        if (isFullFiled())
        {
            int id= Integer.parseInt(jtxIdSanPham.getText());
            int idbrand= Integer.parseInt(jtxIdThuongHieu.getText());
            String ten=jtxTenSanPham.getText();
            int soLuong= Integer.parseInt(jtxSoLuongSanPham.getText());
            int gia= Integer.parseInt(jtxDonGiaSanPham.getText());
            SanPham sanPham=new SanPham(id, idbrand,ten,soLuong,gia,"None","None");
            Vector<String> temp=new Vector<>();
            for (int index=0;index<5;index++)
            {
                temp.add(""+sanPham.toArray()[index]);
            }
            if (sanPhamBUS.update(sanPham))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderProductTable= (DefaultTableModel) tableSanPham.getModel();
                for(int index=0;index<temp.size();index++)
                {
                    renderProductTable.setValueAt(temp.get(index),tableSanPham.getSelectedRow(),index);
                }

                tableSanPham.setModel(renderProductTable);
                refreshSanPham();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshSanPham();
            }

        }
    }

    private void refreshSanPham()
    {
        jtxIdSanPham.setText("");
        jtxIdThuongHieu.setText("");
        jtxTenSanPham.setText("");
        jtxSoLuongSanPham.setText("");
        jtxDonGiaSanPham.setText("");
    }
    private void searchSanPham()
    {
        DefaultTableModel table = (DefaultTableModel)tableSanPham.getModel();
        String search = jtxSearchEnterSanPham.getText().trim();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableSanPham.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void chooseIdThuongHieu()
    {
        ChooseBrand chooseBrand=new ChooseBrand();
        chooseBrand.setVisible(true);
        chooseBrand.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (chooseBrand.getValue()!=null) {
                    jtxIdThuongHieu.setText(String.valueOf(chooseBrand.getValue().getIdThuongHieu()));
                }

                }
        });
    }


}
