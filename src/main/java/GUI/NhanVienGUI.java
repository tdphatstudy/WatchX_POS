package GUI;

import BUS.SanPhamBUS;
import BUS.NhanVienBUS;
import DTO.NhanVien;
import DTO.NhanVien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class NhanVienGUI extends JPanel {
    /*---Thành phần GUI---*/
    private JPanel jpSearchBar,jpEnterTools,jpButton,jpTableView;
    private JPanel jpContainerSearchTools;
    private JLabel jlSearch;
    private JTextField jtxSearchEnter;
    private JLabel jbtnSearch;
    private JPanel jpContainerIdNhanVien,jpContainerHoNhanVien,jpContainerTenNhanVien, jpContainerDiaChiNhanVien
            ,jpContainerEmailNhanVien, jpContainerPhoneNhanVien,jpContainerPasswordNhanVien,
            jpContainerLuongNhanVien, jpContainerChucVuNhanVien;
    private JLabel jlIdNhanVien,jlHoNhanVien,jlTenNhanVien, jlDiaChiNhanVien
            ,jlEmailNhanVien, jlPhoneNhanVien,jlPasswordNhanVien,
            jlLuongNhanVien, jlChucVuNhanVien;
    private JTextField jtxIdNhanVien,jtxHoNhanVien,jtxTenNhanVien, jtxDiaChiNhanVien
            ,jtxEmailNhanVien, jtxPhoneNhanVien,jtxPasswordNhanVien,
            jtxLuongNhanVien, jtxChucVuNhanVien;
    private JLabel jbtnThem,jbtnXoa, jbtnSua, jbtnRefresh;
    private JTable tableNhanVien;
    private JScrollPane scrollPaneNhanVien;
    /*---Biến xử lý---*/
    private NhanVienBUS nhanVienBUS=new NhanVienBUS();
    private DefaultTableModel renderStaffTable=new DefaultTableModel();
    private ArrayList<NhanVien> danhSachNhanVien=new ArrayList<>();
    public NhanVienGUI()
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
        loadDanhSachNhanVien();

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

        jpContainerIdNhanVien=new JPanel();
        jpContainerTenNhanVien=new JPanel();
        jpContainerHoNhanVien=new JPanel();
        jpContainerDiaChiNhanVien=new JPanel();
        jpContainerEmailNhanVien=new JPanel();
        jpContainerPhoneNhanVien=new JPanel();
        jpContainerPasswordNhanVien=new JPanel();
        jpContainerLuongNhanVien=new JPanel();
        jpContainerChucVuNhanVien=new JPanel();

        jlIdNhanVien=new JLabel();
        jlTenNhanVien=new JLabel();
        jlHoNhanVien=new JLabel();
        jlDiaChiNhanVien=new JLabel();
        jlEmailNhanVien=new JLabel();
        jlPhoneNhanVien=new JLabel();
        jlPasswordNhanVien=new JLabel();
        jlLuongNhanVien=new JLabel();
        jlChucVuNhanVien=new JLabel();

        jtxIdNhanVien=new JTextField();
        jtxTenNhanVien=new JTextField();
        jtxHoNhanVien=new JTextField();
        jtxDiaChiNhanVien=new JTextField();
        jtxEmailNhanVien=new JTextField();
        jtxPhoneNhanVien=new JTextField();
        jtxPasswordNhanVien=new JTextField();
        jtxLuongNhanVien=new JTextField();
        jtxChucVuNhanVien=new JTextField();

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
                searchNhanVien();
            }
        });
        jpContainerSearchTools.add(jlSearch);
        jpContainerSearchTools.add(jtxSearchEnter);
        jpContainerSearchTools.add(jbtnSearch);

        /*---Setup các field nhập---*/
        jpEnterTools.setLayout(null);
        jpContainerIdNhanVien.setBounds(72,18,200,40);
        jpContainerHoNhanVien.setBounds(344,18,200,40);
        jpContainerTenNhanVien.setBounds(617,18,300,40);
        jpContainerDiaChiNhanVien.setBounds(72,76,400,40);
        jpContainerEmailNhanVien.setBounds(535,76,400,40);
        jpContainerPhoneNhanVien.setBounds(72,134,400,40);
        jpContainerPasswordNhanVien.setBounds(535,134,400,40);
        jpContainerLuongNhanVien.setBounds(72,192,400,40);
        jpContainerChucVuNhanVien.setBounds(535,192,400,40);

        jpContainerIdNhanVien.setBackground(new Color(53,54,58));
        jpContainerHoNhanVien.setBackground(new Color(53,54,58));
        jpContainerTenNhanVien.setBackground(new Color(53,54,58));
        jpContainerDiaChiNhanVien.setBackground(new Color(53,54,58));
        jpContainerEmailNhanVien.setBackground(new Color(53,54,58));
        jpContainerPhoneNhanVien.setBackground(new Color(53,54,58));
        jpContainerPasswordNhanVien.setBackground(new Color(53,54,58));
        jpContainerLuongNhanVien.setBackground(new Color(53,54,58));
        jpContainerChucVuNhanVien.setBackground(new Color(53,54,58));

        jpContainerIdNhanVien.setLayout(new BorderLayout());
        jlIdNhanVien.setPreferredSize(new Dimension(100,40));
        jtxIdNhanVien.setEditable(false);
        jlIdNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdNhanVien.setForeground(Color.WHITE);
        jlIdNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdNhanVien.setText("ID");
        jtxIdNhanVien.setPreferredSize(new Dimension(100,40));
        jtxIdNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdNhanVien.add(jlIdNhanVien, BorderLayout.WEST);
        jpContainerIdNhanVien.add(jtxIdNhanVien, BorderLayout.EAST);

        jpContainerHoNhanVien.setLayout(new BorderLayout());
        jlHoNhanVien.setPreferredSize(new Dimension(100,40));
        jlHoNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlHoNhanVien.setForeground(Color.WHITE);
        jlHoNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlHoNhanVien.setText("Last Name");
        jtxHoNhanVien.setPreferredSize(new Dimension(100,40));
        jtxHoNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlHoNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerHoNhanVien.add(jlHoNhanVien, BorderLayout.WEST);
        jpContainerHoNhanVien.add(jtxHoNhanVien, BorderLayout.EAST);


        jpContainerTenNhanVien.setLayout(new BorderLayout());
        jlTenNhanVien.setPreferredSize(new Dimension(100,40));
        jlTenNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenNhanVien.setForeground(Color.white);
        jlTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlTenNhanVien.setText("First Name");
        jtxTenNhanVien.setPreferredSize(new Dimension(200,40));
        jtxTenNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerTenNhanVien.add(jlTenNhanVien, BorderLayout.WEST);
        jpContainerTenNhanVien.add(jtxTenNhanVien, BorderLayout.EAST);

        jpContainerDiaChiNhanVien.setLayout(new BorderLayout());
        jlDiaChiNhanVien.setPreferredSize(new Dimension(100,40));
        jlDiaChiNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDiaChiNhanVien.setForeground(Color.WHITE);
        jlDiaChiNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlDiaChiNhanVien.setText("Address");
        jtxDiaChiNhanVien.setPreferredSize(new Dimension(300,40));
        jtxDiaChiNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDiaChiNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDiaChiNhanVien.add(jlDiaChiNhanVien, BorderLayout.WEST);
        jpContainerDiaChiNhanVien.add(jtxDiaChiNhanVien, BorderLayout.EAST);

        jpContainerEmailNhanVien.setLayout(new BorderLayout());
        jlEmailNhanVien.setPreferredSize(new Dimension(100,40));
        jlEmailNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlEmailNhanVien.setForeground(Color.WHITE);
        jlEmailNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlEmailNhanVien.setText("Email");
        jtxEmailNhanVien.setPreferredSize(new Dimension(300,40));
        jtxEmailNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlEmailNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerEmailNhanVien.add(jlEmailNhanVien, BorderLayout.WEST);
        jpContainerEmailNhanVien.add(jtxEmailNhanVien, BorderLayout.EAST);

        jpContainerPhoneNhanVien.setLayout(new BorderLayout());
        jlPhoneNhanVien.setPreferredSize(new Dimension(100,40));
        jlPhoneNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPhoneNhanVien.setForeground(Color.WHITE);
        jlPhoneNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlPhoneNhanVien.setText("Phone");
        jtxPhoneNhanVien.setPreferredSize(new Dimension(300,40));
        jtxPhoneNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPhoneNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerPhoneNhanVien.add(jlPhoneNhanVien, BorderLayout.WEST);
        jpContainerPhoneNhanVien.add(jtxPhoneNhanVien, BorderLayout.EAST);

        jpContainerPasswordNhanVien.setLayout(new BorderLayout());
        jlPasswordNhanVien.setPreferredSize(new Dimension(100,40));
        jlPasswordNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPasswordNhanVien.setForeground(Color.WHITE);
        jlPasswordNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlPasswordNhanVien.setText("Password");
        jtxPasswordNhanVien.setPreferredSize(new Dimension(300,40));
        jtxPasswordNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPasswordNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerPasswordNhanVien.add(jlPasswordNhanVien, BorderLayout.WEST);
        jpContainerPasswordNhanVien.add(jtxPasswordNhanVien, BorderLayout.EAST);

        jpContainerLuongNhanVien.setLayout(new BorderLayout());
        jlLuongNhanVien.setPreferredSize(new Dimension(100,40));
        jlLuongNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlLuongNhanVien.setForeground(Color.WHITE);
        jlLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlLuongNhanVien.setText("Salary");
        jtxLuongNhanVien.setPreferredSize(new Dimension(300,40));
        jtxLuongNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerLuongNhanVien.add(jlLuongNhanVien, BorderLayout.WEST);
        jpContainerLuongNhanVien.add(jtxLuongNhanVien, BorderLayout.EAST);

        jpContainerChucVuNhanVien.setLayout(new BorderLayout());
        jlChucVuNhanVien.setPreferredSize(new Dimension(100,40));
        jlChucVuNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlChucVuNhanVien.setForeground(Color.WHITE);
        jlChucVuNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlChucVuNhanVien.setText("Role");
        jtxChucVuNhanVien.setPreferredSize(new Dimension(300,40));
        jtxChucVuNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlChucVuNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerChucVuNhanVien.add(jlChucVuNhanVien, BorderLayout.WEST);
        jpContainerChucVuNhanVien.add(jtxChucVuNhanVien, BorderLayout.EAST);

        jpEnterTools.add(jpContainerIdNhanVien);
        jpEnterTools.add(jpContainerHoNhanVien);
        jpEnterTools.add(jpContainerTenNhanVien);
        jpEnterTools.add(jpContainerDiaChiNhanVien);
        jpEnterTools.add(jpContainerEmailNhanVien);
        jpEnterTools.add(jpContainerPhoneNhanVien);
        jpEnterTools.add(jpContainerPasswordNhanVien);
        jpEnterTools.add(jpContainerLuongNhanVien);
        jpEnterTools.add(jpContainerChucVuNhanVien);

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
                addNhanVien();
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
                deleteNhanVien();
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
        String[] headerNhanVien={"ID", "Last Name","First Name","Address", "Email","Phone","Password","Salary","Role"};
        String[][] rawTH={{"","","","","","","","",""},{"","","","","","","","",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, headerNhanVien);
        tableNhanVien=new JTable(renderInit);
        tableNhanVien.setSize(900,500);
        scrollPaneNhanVien=new JScrollPane(tableNhanVien);
        scrollPaneNhanVien.setVisible(true);
        jpTableView.add(scrollPaneNhanVien);
        tableNhanVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseRowNhanVien(tableNhanVien.getSelectedRow());
            }
        });
        tableNhanVien.setOpaque(true);
        tableNhanVien.getTableHeader().setBackground(new Color(32, 33, 36));
        tableNhanVien.getTableHeader().setForeground(Color.WHITE);
        scrollPaneNhanVien.getViewport().setBackground(new Color(32, 33, 36));

    }

    private void chooseRowNhanVien(int row)
    {
        Vector temp=new Vector();
        for(int index=0;index<tableNhanVien.getColumnCount();index++)
        {
            temp.add(tableNhanVien.getValueAt(row,index));
        }
        jtxIdNhanVien.setText(""+temp.get(0));
        jtxHoNhanVien.setText((String) temp.get(1));
        jtxTenNhanVien.setText((String) temp.get(2));
        jtxDiaChiNhanVien.setText((String) temp.get(3));
        jtxEmailNhanVien.setText((String) temp.get(4));
        jtxPhoneNhanVien.setText((String) temp.get(5));
        jtxPasswordNhanVien.setText((String) temp.get(6));
        jtxLuongNhanVien.setText(""+ temp.get(7));
        jtxChucVuNhanVien.setText((String) temp.get(8));
    }
    private void loadDanhSachNhanVien()
    {
        danhSachNhanVien=nhanVienBUS.getList();
        renderStaffTable= (DefaultTableModel) tableNhanVien.getModel();
        renderStaffTable.setNumRows(0);
        for (NhanVien index: danhSachNhanVien)
        {
            renderStaffTable.addRow(index.toArray());
        }
        tableNhanVien.setModel(renderStaffTable);
    }
    private boolean isFullFiled()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String ho=jtxHoNhanVien.getText();
        String ten=jtxTenNhanVien.getText();
        String diaChi=jtxDiaChiNhanVien.getText();
        String email=jtxEmailNhanVien.getText();
        String phone=jtxPhoneNhanVien.getText();
        String password=jtxPasswordNhanVien.getText();
        String luong= jtxLuongNhanVien.getText();
        String chucVu= jtxChucVuNhanVien.getText();
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
        } else if (email.trim().equals("") || toolsGUI.isEmail(email)==false)
        {
            JOptionPane.showMessageDialog(null,"Email field is blank or illegel");
            return false;
        } else if (phone.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Phone' field blank");
            return false;
        } else if (password.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Password' field blank");
            return false;
        } else if (luong.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Salary' field blank");
            return false;
        } else if (chucVu.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Role' field blank");
            return false;
        }
        return true;
    }

    private void addNhanVien()
    {
        if (isFullFiled())
        {
            String ho=jtxHoNhanVien.getText();
            String ten=jtxTenNhanVien.getText();
            String diaChi=jtxDiaChiNhanVien.getText();
            String email=jtxEmailNhanVien.getText();
            String phone=jtxPhoneNhanVien.getText();
            String password=jtxPasswordNhanVien.getText();
            int luong= Integer.parseInt(jtxLuongNhanVien.getText());
            String chucVu= jtxChucVuNhanVien.getText();
            if (nhanVienBUS.add(new NhanVien(-1, ho,ten,diaChi,email,phone,password,luong,chucVu)))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderStaffTable= (DefaultTableModel) tableNhanVien.getModel();
                NhanVien insert= new NhanVien(nhanVienBUS.getLastID(), ho, ten, diaChi, email, phone, password,
                        luong, chucVu);
                renderStaffTable.addRow(insert.toArray());
                tableNhanVien.setModel(renderStaffTable);
                refreshNhanVien();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshNhanVien();
            }

        }
    }
    private void deleteNhanVien()
    {
        int row=tableNhanVien.getSelectedRow();
        int id=-1;
        try{
            id=(int)tableNhanVien.getValueAt(row,0);

        } catch (Exception e)
        {
            id= Integer.parseInt((String) tableNhanVien.getValueAt(row,0));
        }

        if (JOptionPane.showConfirmDialog(null, "You want to delete this staff? Staff= " + id ,
                "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
        {
            if(nhanVienBUS.delete(id))
            {
                JOptionPane.showMessageDialog(null,"Succsessly");
                renderStaffTable= (DefaultTableModel) tableNhanVien.getModel();
                renderStaffTable.removeRow(row);
                tableNhanVien.setModel(renderStaffTable);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fail");
            }

        }
    }


    private void refreshNhanVien()
    {
        jtxIdNhanVien.setText("");
        jtxHoNhanVien.setText("");
        jtxTenNhanVien.setText("");
        jtxDiaChiNhanVien.setText("");
        jtxEmailNhanVien.setText("");
        jtxPhoneNhanVien.setText("");
        jtxPasswordNhanVien.setText("");
        jtxChucVuNhanVien.setText("");
        jtxLuongNhanVien.setText("");
    }
    private void searchNhanVien()
    {
        DefaultTableModel table = (DefaultTableModel)tableNhanVien.getModel();
        String search = jtxSearchEnter.getText().trim();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableNhanVien.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void update()
    {
        if (isFullFiled())
        {
            int id= Integer.parseInt(jtxIdNhanVien.getText());
            String ho=jtxHoNhanVien.getText();
            String ten=jtxTenNhanVien.getText();
            String diaChi=jtxDiaChiNhanVien.getText();
            String email=jtxEmailNhanVien.getText();
            String phone=jtxPhoneNhanVien.getText();
            String password=jtxPasswordNhanVien.getText();
            int luong= Integer.parseInt(jtxLuongNhanVien.getText());
            String chucVu= jtxChucVuNhanVien.getText();
            NhanVien nhanVien=new NhanVien(id, ho, ten, diaChi,email,phone, password, luong, chucVu);
            Vector<String> temp=new Vector<>();
            for (int index=0;index<9;index++)
            {
                temp.add(""+nhanVien.toArray()[index]);
            }
            if (nhanVienBUS.update(nhanVien))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderStaffTable= (DefaultTableModel) tableNhanVien.getModel();
                for(int index=0;index<temp.size();index++)
                {
                    renderStaffTable.setValueAt(temp.get(index),tableNhanVien.getSelectedRow(),index);
                }

                tableNhanVien.setModel(renderStaffTable);
                refreshNhanVien();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshNhanVien();
            }
        }
    }


}
