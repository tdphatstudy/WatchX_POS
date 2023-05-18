package GUI;

import BUS.SanPhamBUS;
import BUS.KhachHangBUS;
import DTO.KhachHang;
import DTO.KhachHang;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Vector;

public class KhachHangGUI extends JPanel {
    /*---Thành phần GUI---*/
    private JPanel jpSearchBar,jpEnterTools,jpButton,jpTableView;
    private JPanel jpContainerSearchTools;
    private JLabel jlSearch;
    private JTextField jtxSearchEnter;
    private JLabel jbtnSearch;
    private JPanel jpContainerIdKhachHang,jpContainerHoKhachHang,jpContainerTenKhachHang, jpContainerDiaChiKhachHang
            ,jpContainerEmailKhachHang, jpContainerPhoneKhachHang;
    private JLabel jlIdKhachHang,jlHoKhachHang,jlTenKhachHang, jlDiaChiKhachHang
            ,jlEmailKhachHang, jlPhoneKhachHang;
    private JTextField jtxIdKhachHang,jtxHoKhachHang,jtxTenKhachHang, jtxDiaChiKhachHang
            ,jtxEmailKhachHang, jtxPhoneKhachHang;
    private JLabel jbtnThem,jbtnXoa, jbtnSua, jbtnRefresh;
    private JTable tableKhachHang;
    private JScrollPane scrollPaneKhachHang;
    /*---Biến xử lý---*/
    private KhachHangBUS khachHangBUS=new KhachHangBUS();
    private DefaultTableModel renderCustomerTable=new DefaultTableModel();
    private ArrayList<KhachHang> danhSachKhachHang=new ArrayList<>();
    public KhachHangGUI()
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
        this.add(jpSearchBar);
        this.add(jpEnterTools);
        this.add(jpButton);
        this.add(jpTableView);
        loadDanhSachKhachHang();

    }
    private void delarceVariable()
    {
        LineBorder line = new LineBorder(new Color(61,62,66), 1, true);
        jpSearchBar=new JPanel();
        jpEnterTools=new JPanel();
        jpButton=new JPanel();
        jpTableView=new JPanel();
        jpContainerSearchTools =new JPanel();
        jlSearch=new JLabel("",SwingConstants.LEADING);
        jtxSearchEnter=new JTextField();
        jbtnSearch=new JLabel("",SwingConstants.CENTER);

        jpContainerIdKhachHang=new JPanel();
        jpContainerTenKhachHang=new JPanel();
        jpContainerHoKhachHang=new JPanel();
        jpContainerDiaChiKhachHang=new JPanel();
        jpContainerEmailKhachHang=new JPanel();
        jpContainerPhoneKhachHang=new JPanel();


        jlIdKhachHang=new JLabel();
        jlTenKhachHang=new JLabel();
        jlHoKhachHang=new JLabel();
        jlDiaChiKhachHang=new JLabel();
        jlEmailKhachHang=new JLabel();
        jlPhoneKhachHang=new JLabel();

        jtxIdKhachHang=new JTextField();
        jtxTenKhachHang=new JTextField();
        jtxHoKhachHang=new JTextField();
        jtxDiaChiKhachHang=new JTextField();
        jtxEmailKhachHang=new JTextField();
        jtxPhoneKhachHang=new JTextField();


        jbtnThem=new JLabel();
        jbtnXoa=new JLabel();
        jbtnSua=new JLabel();

        /*---Setup toàn Panel---*/
        jpSearchBar.setPreferredSize(new Dimension(990,50));
        jpSearchBar.setBackground(new Color(32, 33, 36));
        jpSearchBar.setBorder(line);
        jpEnterTools.setPreferredSize(new Dimension(990,250));
        jpEnterTools.setBackground(new Color(32, 33, 36));
        jpEnterTools.setBorder(line);
        jpButton.setPreferredSize(new Dimension(990,50));
        jpButton.setBackground(new Color(32, 33, 36));
        jpButton.setBorder(line);
        jpTableView.setPreferredSize(new Dimension(990,350));
        jpTableView.setBackground(new Color(32, 33, 36));
        jpTableView.setBorder(line);

        /*---Setup search bar---*/
        jpSearchBar.setLayout(null);
        jpContainerSearchTools.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),2));
        jpContainerSearchTools.setBounds(20,10,400,30);
        jpContainerSearchTools.setBackground(new Color(32,33,36));
        jpSearchBar.add(jpContainerSearchTools);
        jpContainerSearchTools.setLayout(new FlowLayout(FlowLayout.CENTER,0,-2));
        jlSearch.setText("Search: ");
        jlSearch.setForeground(Color.WHITE);
        jlSearch.setBackground(new Color(32, 33, 36));
        jlSearch.setPreferredSize(new Dimension(50,30));
        jtxSearchEnter.setPreferredSize(new Dimension(300,30));
        jbtnSearch.setBackground(new Color(32, 33, 36));
        jbtnSearch.setPreferredSize(new Dimension(46,30));
        jbtnSearch.setIcon(new ImageIcon("./Image/search-icon.png"));
        jbtnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchKhachHang();
            }
        });
        jpContainerSearchTools.add(jlSearch);
        jpContainerSearchTools.add(jtxSearchEnter);
        jpContainerSearchTools.add(jbtnSearch);

        /*---Setup các field nhập---*/
        jpEnterTools.setLayout(null);
        jpContainerIdKhachHang.setBounds(63,20,400,40);
        jpContainerHoKhachHang.setBounds(526,20,400,40);
        jpContainerTenKhachHang.setBounds(63,80,400,40);
        jpContainerPhoneKhachHang.setBounds(526,80,400,40);
        jpContainerEmailKhachHang.setBounds(63,140,400,40);
        jpContainerDiaChiKhachHang.setBounds(526,140,400,40);

        jpContainerIdKhachHang.setBackground(new Color(53,54,58));
        jpContainerHoKhachHang.setBackground(new Color(53,54,58));
        jpContainerTenKhachHang.setBackground(new Color(53,54,58));
        jpContainerDiaChiKhachHang.setBackground(new Color(53,54,58));
        jpContainerEmailKhachHang.setBackground(new Color(53,54,58));
        jpContainerPhoneKhachHang.setBackground(new Color(53,54,58));


        jpContainerIdKhachHang.setLayout(new BorderLayout());
        jlIdKhachHang.setPreferredSize(new Dimension(100,40));
        jtxIdKhachHang.setEditable(false);
        jlIdKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdKhachHang.setForeground(Color.WHITE);
        jlIdKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdKhachHang.setText("ID");
        jtxIdKhachHang.setPreferredSize(new Dimension(300,40));
        jtxIdKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdKhachHang.add(jlIdKhachHang, BorderLayout.WEST);
        jpContainerIdKhachHang.add(jtxIdKhachHang, BorderLayout.EAST);

        jpContainerHoKhachHang.setLayout(new BorderLayout());
        jlHoKhachHang.setPreferredSize(new Dimension(100,40));
        jlHoKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlHoKhachHang.setForeground(Color.WHITE);
        jlHoKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jlHoKhachHang.setText("Last Name");
        jtxHoKhachHang.setPreferredSize(new Dimension(300,40));
        jtxHoKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlHoKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerHoKhachHang.add(jlHoKhachHang, BorderLayout.WEST);
        jpContainerHoKhachHang.add(jtxHoKhachHang, BorderLayout.EAST);


        jpContainerTenKhachHang.setLayout(new BorderLayout());
        jlTenKhachHang.setPreferredSize(new Dimension(100,40));
        jlTenKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenKhachHang.setForeground(Color.white);
        jlTenKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jlTenKhachHang.setText("First Name");
        jtxTenKhachHang.setPreferredSize(new Dimension(300,40));
        jtxTenKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerTenKhachHang.add(jlTenKhachHang, BorderLayout.WEST);
        jpContainerTenKhachHang.add(jtxTenKhachHang, BorderLayout.EAST);

        jpContainerPhoneKhachHang.setLayout(new BorderLayout());
        jlPhoneKhachHang.setPreferredSize(new Dimension(100,40));
        jlPhoneKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPhoneKhachHang.setForeground(Color.WHITE);
        jlPhoneKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jlPhoneKhachHang.setText("Phone");
        jtxPhoneKhachHang.setPreferredSize(new Dimension(300,40));
        jtxPhoneKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPhoneKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerPhoneKhachHang.add(jlPhoneKhachHang, BorderLayout.WEST);
        jpContainerPhoneKhachHang.add(jtxPhoneKhachHang, BorderLayout.EAST);



        jpContainerEmailKhachHang.setLayout(new BorderLayout());
        jlEmailKhachHang.setPreferredSize(new Dimension(100,40));
        jlEmailKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlEmailKhachHang.setForeground(Color.WHITE);
        jlEmailKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jlEmailKhachHang.setText("Email");
        jtxEmailKhachHang.setPreferredSize(new Dimension(300,40));
        jtxEmailKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlEmailKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerEmailKhachHang.add(jlEmailKhachHang, BorderLayout.WEST);
        jpContainerEmailKhachHang.add(jtxEmailKhachHang, BorderLayout.EAST);

        jpContainerDiaChiKhachHang.setLayout(new BorderLayout());
        jlDiaChiKhachHang.setPreferredSize(new Dimension(100,40));
        jlDiaChiKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDiaChiKhachHang.setForeground(Color.WHITE);
        jlDiaChiKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jlDiaChiKhachHang.setText("Address");
        jtxDiaChiKhachHang.setPreferredSize(new Dimension(300,40));
        jtxDiaChiKhachHang.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDiaChiKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDiaChiKhachHang.add(jlDiaChiKhachHang, BorderLayout.WEST);
        jpContainerDiaChiKhachHang.add(jtxDiaChiKhachHang, BorderLayout.EAST);


        jpEnterTools.add(jpContainerIdKhachHang);
        jpEnterTools.add(jpContainerHoKhachHang);
        jpEnterTools.add(jpContainerTenKhachHang);
        jpEnterTools.add(jpContainerDiaChiKhachHang);
        jpEnterTools.add(jpContainerEmailKhachHang);
        jpEnterTools.add(jpContainerPhoneKhachHang);


        /*---Setup phần nút bấm---*/
        jpButton.setLayout(new FlowLayout(FlowLayout.CENTER, 100,5));
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
                addKhachHang();
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


        jpButton.add(jbtnThem);
        jpButton.add(jbtnSua);
        jbtnXoa.setForeground(new Color(238,57,57));
        jbtnXoa.setPreferredSize(new Dimension(150, 40));
        jbtnXoa.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
        jbtnXoa.setIcon(new ImageIcon("./Image/remove_red.png"));
        jbtnXoa.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteKhachHang();
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
        jpButton.add(jbtnXoa);

        /*---Setup table---*/
        jpTableView.setLayout(new BorderLayout());
        String[] headerKhachHang={"ID", "Last Name","First Name","Phone", "Email","Address"};
        String[][] rawTH={{"","","","","","",},{"","","","","",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, headerKhachHang);
        tableKhachHang=new JTable(renderInit);
        tableKhachHang.setSize(900,500);
        scrollPaneKhachHang=new JScrollPane(tableKhachHang);
        scrollPaneKhachHang.setVisible(true);
        jpTableView.add(scrollPaneKhachHang);
        tableKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseRowKhachHang(tableKhachHang.getSelectedRow());
            }
        });
        tableKhachHang.setOpaque(true);
        tableKhachHang.getTableHeader().setBackground(new Color(32, 33, 36));
        tableKhachHang.getTableHeader().setForeground(Color.WHITE);
        scrollPaneKhachHang.getViewport().setBackground(new Color(32, 33, 36));

    }

    private void chooseRowKhachHang(int row)
    {
        Vector temp=new Vector();
        for(int index=0;index<tableKhachHang.getColumnCount();index++)
        {
            temp.add(tableKhachHang.getValueAt(row,index));
        }
        jtxIdKhachHang.setText(""+temp.get(0));
        jtxHoKhachHang.setText((String) temp.get(1));
        jtxTenKhachHang.setText((String) temp.get(2));
        jtxDiaChiKhachHang.setText((String) temp.get(5));
        jtxEmailKhachHang.setText((String) temp.get(4));
        jtxPhoneKhachHang.setText((String) temp.get(3));

    }
    private void loadDanhSachKhachHang()
    {
        danhSachKhachHang=khachHangBUS.getList();
        renderCustomerTable= (DefaultTableModel) tableKhachHang.getModel();
        renderCustomerTable.setNumRows(0);
        for (KhachHang index: danhSachKhachHang)
        {
            renderCustomerTable.addRow(index.toArray());
        }
        tableKhachHang.setModel(renderCustomerTable);
    }
    private boolean isFullFiled()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String ho=jtxHoKhachHang.getText();
        String ten=jtxTenKhachHang.getText();
        String diaChi=jtxDiaChiKhachHang.getText();
        String email=jtxEmailKhachHang.getText();
        String phone=jtxPhoneKhachHang.getText();
        if (ten.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'First Name' field blank");
            return false;
        } else if (ho.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Last Name' field blank");
            return false;
        } else if (diaChi.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Address' field blank");
            return false;
        } else if (email.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Email field is blank or illegel");
            return false;
        } else if (phone.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Phone' field blank");
            return false;
        }
        return true;
    }

    private void addKhachHang()
    {
        if (isFullFiled())
        {
            String id=jtxIdKhachHang.getText();
            String ho=jtxHoKhachHang.getText();
            String ten=jtxTenKhachHang.getText();
            String diaChi=jtxDiaChiKhachHang.getText();
            String email=jtxEmailKhachHang.getText();
            String phone=jtxPhoneKhachHang.getText();

            if (id.trim().equals(""))
            {
                if (khachHangBUS.add(new KhachHang(-1, ho,ten,phone,email,diaChi)))
                {

                    JOptionPane.showMessageDialog(null,"Successful");
                    renderCustomerTable= (DefaultTableModel) tableKhachHang.getModel();
                    KhachHang insert= new KhachHang(khachHangBUS.getLastID(), ho, ten, phone, email, diaChi);
                    renderCustomerTable.addRow(insert.toArray());
                    tableKhachHang.setModel(renderCustomerTable);
                    refreshKhachHang();
                }else
                {
                    JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                    refreshKhachHang();
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "This Customer already exist");
                refreshKhachHang();
            }

        }
    }
    private void deleteKhachHang()
    {
        int row=tableKhachHang.getSelectedRow();
        int id=-1;
        try{
            id=(int)tableKhachHang.getValueAt(row,0);

        } catch (Exception e)
        {
            id= Integer.parseInt((String) tableKhachHang.getValueAt(row,0));
        }

        if (JOptionPane.showConfirmDialog(null, "You want to delete this customer? Customer= " + id ,
                "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
        {
            if(khachHangBUS.delete(id))
            {
                JOptionPane.showMessageDialog(null,"Succsessly");
                renderCustomerTable= (DefaultTableModel) tableKhachHang.getModel();
                renderCustomerTable.removeRow(row);
                tableKhachHang.setModel(renderCustomerTable);
                refreshKhachHang();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fail");
                refreshKhachHang();
            }

        }
    }


    private void refreshKhachHang()
    {
        jtxIdKhachHang.setText("");
        jtxHoKhachHang.setText("");
        jtxTenKhachHang.setText("");
        jtxDiaChiKhachHang.setText("");
        jtxEmailKhachHang.setText("");
        jtxPhoneKhachHang.setText("");

    }
    private void searchKhachHang()
    {
        DefaultTableModel table = (DefaultTableModel)tableKhachHang.getModel();
        String search = jtxSearchEnter.getText().trim();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableKhachHang.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void update()
    {
        if (isFullFiled())
        {
            int id= Integer.parseInt(jtxIdKhachHang.getText());
            String ho=jtxHoKhachHang.getText();
            String ten=jtxTenKhachHang.getText();
            String diaChi=jtxDiaChiKhachHang.getText();
            String email=jtxEmailKhachHang.getText();
            String phone=jtxPhoneKhachHang.getText();

            KhachHang nhanVien=new KhachHang(id,ho,ten,phone,email,diaChi);
            Vector<String> temp=new Vector<>();
            for (int index=0;index<6;index++)
            {
                temp.add(""+nhanVien.toArray()[index]);
            }
            if (khachHangBUS.update(nhanVien))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderCustomerTable= (DefaultTableModel) tableKhachHang.getModel();
                for(int index=0;index<temp.size();index++)
                {
                    renderCustomerTable.setValueAt(temp.get(index),tableKhachHang.getSelectedRow(),index);
                }

                tableKhachHang.setModel(renderCustomerTable);
                refreshKhachHang();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshKhachHang();
            }
        }
    }


}
