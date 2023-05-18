package GUI;

import DTO.NhanVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    /*-----Thành phần GUI------*/
    /*------Thành phần chính---*/
    private JPanel titleBar,menuBar, viewFrame;
    private  NhanVien login;
    private BrandManager brandManager;
    private NhaCungCapGUI nhaCungCapGUI;
    private NhanVienGUI nhanVienGUI;
    private KhachHangGUI khachHangGUI;
    private SanPhamGUI sanPhamGUI;
    private PhieuNhapGUI phieuNhapGUI;
    private POS pos;
    /*---Thành phần titleBar---*/
    private JPanel jpIcon, jpTools;
    private JLabel jlIcon, jlNameStore, jlClose;
    /*----Thành phần menuBar---*/
    private JPanel jpInforStaff,jpListRoles;
    private JLabel jlNameStaff,jlPositionStaff,jlDashbroad,jlProductManager,jlOrderManager,
            jlProviderManager,jlBrandManager,jlStaffManager,jlCustomerManager,jlPOS;
    //Các thành phần xử lý.
    /*---Variable xử lý---*/
    private ArrayList<JLabel> roleLabelList;
    public MainFrame(NhanVien nhanVien)
    {
        this.login = nhanVien;
        if (login.getChucVu().equals("Admin")) {
            setAdminRole();
        } else  {
            setStaffRole();
        }
        init();
    }
    private void init()
    {

        this.setSize(1250,750);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.delarceVariable();
        this.setLayout(new BorderLayout());
        this.add(titleBar, BorderLayout.NORTH);
        this.setupTitleBar();
        this.add(menuBar,BorderLayout.WEST);
        this.setupMenuBar();
        this.add(viewFrame,BorderLayout.EAST);


        viewFrame.add(brandManager);

        viewFrame.add(nhaCungCapGUI);

        viewFrame.add(sanPhamGUI);

        viewFrame.add(khachHangGUI);

        viewFrame.add(nhanVienGUI);

        viewFrame.add(phieuNhapGUI);

        viewFrame.add(pos);



    }
    private void delarceVariable()
    {
        titleBar=new JPanel();
        menuBar=new JPanel();
        viewFrame=new JPanel();
        jpIcon=new JPanel();
        jpTools=new JPanel();
        jpInforStaff=new JPanel();
        jpListRoles=new JPanel();
        jlPositionStaff=new JLabel();
        jlNameStaff=new JLabel("",SwingConstants.CENTER);
        brandManager=new BrandManager();
        nhaCungCapGUI=new NhaCungCapGUI();
        nhanVienGUI=new NhanVienGUI();
        khachHangGUI=new KhachHangGUI();
        sanPhamGUI=new SanPhamGUI();
        phieuNhapGUI=new PhieuNhapGUI();
        pos=new POS(login.getIdNhanVien());
        brandManager.setVisible(false);
        nhaCungCapGUI.setVisible(false);
        nhanVienGUI.setVisible(false);
        khachHangGUI.setVisible(false);
        sanPhamGUI.setVisible(false);
        phieuNhapGUI.setVisible(false);
        pos.setVisible(false);

        /*---Setup toàn frame---*/
        titleBar.setPreferredSize(new Dimension(1250,50));
        menuBar.setPreferredSize(new Dimension(250,700));
        titleBar.setBackground(new Color(32, 33, 36));
        menuBar.setBackground(new Color(32, 33, 36));
        titleBar.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
        menuBar.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));

        viewFrame.setBackground(new Color(61,62,66));
        viewFrame.setPreferredSize(new Dimension(1000,700));




        /*---Setup bộ phận---*/
        jpIcon.setPreferredSize(new Dimension(250,50));
        jpTools.setPreferredSize(new Dimension(100,50));
        jpTools.setBackground(new Color(32, 33, 36));
        jpIcon.setBackground(new Color(32, 33, 36));




    }

    private void setupTitleBar()
    {
        /*---Khai báo---*/
        jlIcon=new JLabel();
        jlClose=new JLabel();
        /*---Setup toàn phần ---*/
        titleBar.setLayout(new BorderLayout());
        titleBar.add(jpIcon,BorderLayout.WEST);
        titleBar.add(jpTools,BorderLayout.EAST);
        /*---Setup chi tiết---*/
        jpIcon.setLayout(new FlowLayout(FlowLayout.LEFT,25,-75));
        jlIcon.setIcon(new ImageIcon("./Image/storelogo.png"));
        jpIcon.add(jlIcon);
        jpTools.setLayout(new FlowLayout(FlowLayout.LEFT,35,10));
        jlClose.setIcon(new javax.swing.ImageIcon("./Image/close.png"));
        jlClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        jpTools.add(jlClose);

    }

    private void setupMenuBar()
    {

        /*---Setup toàn phần ---*/
        jpInforStaff.setBackground(new Color(32, 33, 36));
        jpInforStaff.setPreferredSize(new Dimension(250,250));
        jpListRoles.setBackground(new Color(32, 33, 36));
        jpListRoles.setPreferredSize(new Dimension(250,450));
        menuBar.setLayout(new BorderLayout());
        menuBar.add(jpInforStaff,BorderLayout.NORTH);
        menuBar.add(jpListRoles, BorderLayout.SOUTH);
        jpInforStaff.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),4));
        jpListRoles.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),4));
        jpInforStaff.setLayout(null);
        jpListRoles.setLayout(new FlowLayout(FlowLayout.CENTER,25,10));
        /*---Setup chi tiết---*/
        jlPositionStaff.setBounds(61,24,128,128);
        jlPositionStaff.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
        jlPositionStaff.setIcon(new ImageIcon("./Image/staff.png"));
        jlNameStaff.setBounds(25,176,200,50);
        jlNameStaff.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
        jlNameStaff.setFont(new Font("iCiel Gotham Medium", 0, 20));
        jlNameStaff.setForeground(Color.white);
        jlNameStaff.setText("ADMIN");
        jpInforStaff.add(jlPositionStaff);
        jpInforStaff.add(jlNameStaff);
        for (JLabel index: roleLabelList)
        {
            index.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    index.setOpaque(true);
                    index.setForeground(Color.WHITE);
                    index.setBackground(new Color(238,57,57));
                    index.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    index.setOpaque(false);
                    index.setForeground(Color.white);
                    index.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
                    index.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));

                }
            });
            index.setPreferredSize(new Dimension(200,50));
            index.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
            index.setForeground(Color.white);
            index.setFont(new Font("iCiel Gotham Medium", 0, 20));
            jpListRoles.add(index);
        }


    }
    private void setupRoleList()
    {
        jlDashbroad=new JLabel("Dashbroad", SwingConstants.CENTER);
        jlBrandManager=new JLabel("Brand",SwingConstants.CENTER);
        jlProviderManager=new JLabel("Provider",SwingConstants.CENTER);
        jlCustomerManager=new JLabel("Customer",SwingConstants.CENTER);
        jlStaffManager=new JLabel("Staff",SwingConstants.CENTER);
        jlProductManager=new JLabel("Product",SwingConstants.CENTER);
        jlOrderManager=new JLabel("Order",SwingConstants.CENTER);
        jlPOS=new JLabel("POS",SwingConstants.CENTER);

        jlDashbroad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabDash();
            }
        });
        jlBrandManager.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               tabThuongHieu();
            }

        });
        jlProviderManager.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabNhaCungCap();
            }
        });
        jlCustomerManager.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabKhach();
            }
        });
        jlStaffManager.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabNhanVien();
            }
        });
        jlProductManager.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabSanPham();
            }
        });
        jlOrderManager.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               tabPhieuNhap();
            }
        });
        jlPOS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("123");
            }
        });

    }
    private void setAdminRole()
    {
        setupRoleList();
        roleLabelList=new ArrayList<>();
        roleLabelList.add(jlDashbroad);
        roleLabelList.add(jlOrderManager);
        roleLabelList.add(jlCustomerManager);
        roleLabelList.add(jlStaffManager);
        roleLabelList.add(jlProductManager);
        roleLabelList.add(jlBrandManager);
        roleLabelList.add(jlProviderManager);
    }
    private void setStaffRole()
    {
        setupRoleList();
        roleLabelList=new ArrayList<>();
        roleLabelList.add(jlDashbroad);
        roleLabelList.add(jlOrderManager);
        roleLabelList.add(jlCustomerManager);
        roleLabelList.add(jlProductManager);

    }
    private void closeAllTab()
    {
        brandManager.setVisible(false);
        nhaCungCapGUI.setVisible(false);
        nhanVienGUI.setVisible(false);
        khachHangGUI.setVisible(false);
        sanPhamGUI.setVisible(false);
        phieuNhapGUI.setVisible(false);
        pos.setVisible(false);
    }
    private  void tabDash()
    {
        closeAllTab();
        pos.setVisible(true);
    }
    private void tabKhach()
    {
        closeAllTab();
        khachHangGUI.setVisible(true);


    }
    private void tabSanPham()
    {
        closeAllTab();
        sanPhamGUI.setVisible(true);


    }
    private void tabThuongHieu()
    {
        closeAllTab();
        brandManager.setVisible(true);
    }
    private void tabNhanVien()
    {
        closeAllTab();

        nhanVienGUI.setVisible(true);
    }
    private void tabNhaCungCap()
    {
        closeAllTab();
        nhaCungCapGUI.setVisible(true);
    }

    private void tabPhieuNhap()
    {
        closeAllTab();
        phieuNhapGUI.setVisible(true);
    }


}
