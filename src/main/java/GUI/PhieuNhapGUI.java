package GUI;

import BUS.ChiTietPhieuNhapBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietPhieuNhap;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class PhieuNhapGUI extends JPanel {
    /*---Thành phần GUI---*/
    private JPanel jpSearchBarPhieuNhap,jpEnterToolsPhieuNhap,jpButtonPhieuNhap,jpTableViewPhieuNhap;
    private JPanel jpContainerSearchToolsPhieuNhap;
    private JLabel jlSearchPhieuNhap;
    private JTextField jtxSearchEnterPhieuNhap;
    private JLabel jbtnSearchPhieuNhap;
    private JPanel jpContainerIdPhieuNhap,jpContainerIdNhanVien, jpContainerIdNhaCungCap,jpContainerNgayNhap, jpContainerTongTien,
    jpContainerIdProduct,jpContainerSoLuong,jpContainerthanhTien, jpContainerIdDonGia;
    private JLabel jlIdPhieuNhap,jlIdNhanVien, jlIdNhaCungCap, jlNgayNhap, jlTongTien,jlIdProduct,jlSoLuong, jlDonGia, jlThanhTien;
    private JTextField jtxIdPhieuNhap,jtxIdNhanVien, jtxIdNhaCungCap, jtxNgayNhap, jtxTongTien,jtxIdProduct,jtxSoLuong, jtxDonGia, jtxThanhTien;
    private JButton jbtnIdNhaCungCap, jbtnIdProduct, jbtnCal;
    private JLabel jbtnThem,jbtnXoa, jbtnExportXLS, jbtnSuaCT, jbtnThemCT, jbtnXoaCT, jbtnReset, jbtnResetCT, jbtnExport;
    private JPanel jpBtnPhieuNhap, jpBtnCT;
    private JTable tablePhieuNhap, tableChiTietPhieuNhap;
    private JDateChooser ngayNhap;
    private JScrollPane scrollPanePhieuNhap, scrollPaneChiTietPhieuNhap;

    /*---Biến xử lý---*/
   private PhieuNhapBUS phieuNhapBUS=new PhieuNhapBUS();
   private ChiTietPhieuNhapBUS chiTietPhieuNhapBUS=new ChiTietPhieuNhapBUS();
    private DefaultTableModel renderOrderTable=new DefaultTableModel();
    private DefaultTableModel renderDetailOrderTable=new DefaultTableModel();
    private ArrayList<PhieuNhap> danhSachPhieuNhap=new ArrayList<>();
    private ArrayList<ChiTietPhieuNhap> danhSachChiTietPhieuNhap=new ArrayList<>();
    private NhanVien nhanVien;
    public PhieuNhapGUI()
    {

        init();
        setSessionOfStaff();
    }
    private  void init()
    {
        this.setPreferredSize(new Dimension(1000,700));
        this.setBackground(new Color(53,54,58));
        this.setBorder(BorderFactory.createLineBorder(new Color(61,62,66)));
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.delarceVariable();
        this.add(jpSearchBarPhieuNhap);
        this.add(jpEnterToolsPhieuNhap);
        this.add(jpButtonPhieuNhap);
        this.add(jpTableViewPhieuNhap);
        loadDanhSachPhieuNhap();

    }
    private void delarceVariable()
    {
        LineBorder line = new LineBorder(new Color(61,62,66), 1, true);
        jpSearchBarPhieuNhap=new JPanel();
        jpEnterToolsPhieuNhap=new JPanel();
        jpButtonPhieuNhap=new JPanel();
        jpTableViewPhieuNhap=new JPanel();
        jpContainerSearchToolsPhieuNhap =new JPanel();
        jlSearchPhieuNhap=new JLabel("",SwingConstants.LEADING);
        jtxSearchEnterPhieuNhap=new JTextField();
        jbtnSearchPhieuNhap=new JLabel("",SwingConstants.CENTER);
        jpContainerIdPhieuNhap=new JPanel();
        jpContainerIdNhanVien=new JPanel();
        jpContainerIdNhaCungCap=new JPanel();
        jpContainerNgayNhap=new JPanel();
        jpContainerTongTien=new JPanel();
        jpContainerIdProduct=new JPanel();
        jpContainerSoLuong=new JPanel();
        jpContainerIdDonGia=new JPanel();
        jpContainerthanhTien=new JPanel();
        jlIdPhieuNhap=new JLabel();
        jlIdNhanVien=new JLabel();
        jlIdNhaCungCap=new JLabel();
        jlNgayNhap=new JLabel();
        jlTongTien=new JLabel();
        jlIdProduct=new JLabel();
        jlThanhTien=new JLabel();
        jlDonGia=new JLabel();
        jlSoLuong=new JLabel();
        jtxIdPhieuNhap=new JTextField();
        jtxIdNhanVien=new JTextField();
        jtxIdNhaCungCap=new JTextField();
        jtxNgayNhap=new JTextField();
        jtxTongTien=new JTextField();
        jtxIdProduct=new JTextField();
        jtxThanhTien=new JTextField();
        jtxSoLuong=new JTextField();
        jtxDonGia=new JTextField();
        jpBtnPhieuNhap= new JPanel();
        jpBtnCT= new JPanel();
        jbtnThem=new JLabel();
        jbtnXoa=new JLabel();
        jbtnThemCT=new JLabel();
        jbtnReset=new JLabel();
        jbtnResetCT=new JLabel();
        jbtnXoaCT=new JLabel();
        jbtnSuaCT=new JLabel();
        jbtnExportXLS=new JLabel();
        jbtnIdNhaCungCap=new JButton("...");
        jbtnIdProduct=new JButton("...");
        jbtnCal=new JButton("...");
        ngayNhap=new JDateChooser();

        /*---Setup toàn Panel---*/
        jpSearchBarPhieuNhap.setPreferredSize(new Dimension(990,50));
        jpSearchBarPhieuNhap.setBackground(new Color(32, 33, 36));
        jpSearchBarPhieuNhap.setBorder(line);
        jpEnterToolsPhieuNhap.setPreferredSize(new Dimension(990,230));
        jpEnterToolsPhieuNhap.setBackground(new Color(32, 33, 36));
        jpEnterToolsPhieuNhap.setBorder(line);
        jpButtonPhieuNhap.setPreferredSize(new Dimension(990,50));
        jpButtonPhieuNhap.setBackground(new Color(32, 33, 36));
        jpButtonPhieuNhap.setBorder(line);
        jpTableViewPhieuNhap.setPreferredSize(new Dimension(990,370));
        jpTableViewPhieuNhap.setBackground(new Color(32, 33, 36));
        jpTableViewPhieuNhap.setBorder(line);

    /*---Setup search bar---*/
        jpSearchBarPhieuNhap.setLayout(null);
        jpContainerSearchToolsPhieuNhap.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),2));
        jpContainerSearchToolsPhieuNhap.setBounds(20,10,400,30);
        jpContainerSearchToolsPhieuNhap.setBackground(new Color(32,33,36));
        jpSearchBarPhieuNhap.add(jpContainerSearchToolsPhieuNhap);
        jpContainerSearchToolsPhieuNhap.setLayout(new FlowLayout(FlowLayout.CENTER,0,-2));
        jlSearchPhieuNhap.setText("Search: ");
        jlSearchPhieuNhap.setForeground(Color.WHITE);
        jlSearchPhieuNhap.setBackground(new Color(32, 33, 36));
        jlSearchPhieuNhap.setPreferredSize(new Dimension(50,30));
        jtxSearchEnterPhieuNhap.setPreferredSize(new Dimension(300,30));
        jbtnSearchPhieuNhap.setBackground(new Color(32, 33, 36));
        jbtnSearchPhieuNhap.setPreferredSize(new Dimension(46,30));
        jbtnSearchPhieuNhap.setIcon(new ImageIcon("./Image/search-icon.png"));
        jbtnSearchPhieuNhap.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            searchPhieuNhap();
        }
    });
        jpContainerSearchToolsPhieuNhap.add(jlSearchPhieuNhap);
        jpContainerSearchToolsPhieuNhap.add(jtxSearchEnterPhieuNhap);
        jpContainerSearchToolsPhieuNhap.add(jbtnSearchPhieuNhap);

    /*---Setup các field nhập---*/
        jpEnterToolsPhieuNhap.setLayout(null);
        jpContainerIdPhieuNhap.setBounds(65,5,400,40);
        jpContainerIdNhanVien.setBounds(65,50,400,40);
        jpContainerIdNhaCungCap.setBounds(65,95,400,40);
        jpContainerNgayNhap.setBounds(65,140,400,40);
        jpContainerTongTien.setBounds(65,185,400,40);
        jpContainerIdProduct.setBounds(530,50,400,40);
        jpContainerIdDonGia.setBounds(530,95,400,40);
        jpContainerSoLuong.setBounds(530,140,400,40);
        jpContainerthanhTien.setBounds(530,185,400,40);

        jpContainerIdNhanVien.setBackground(new Color(53,54,58));
        jpContainerIdPhieuNhap.setBackground(new Color(53,54,58));
        jpContainerIdNhaCungCap.setBackground(new Color(53,54,58));
        jpContainerNgayNhap.setBackground(new Color(53,54,58));
        jpContainerTongTien.setBackground(new Color(53,54,58));
        jpContainerIdProduct.setBackground(new Color(53,54,58));
        jpContainerIdDonGia.setBackground(new Color(53,54,58));
        jpContainerSoLuong.setBackground(new Color(53,54,58));
        jpContainerthanhTien.setBackground(new Color(53,54,58));

        jpContainerIdPhieuNhap.setLayout(new BorderLayout());
        jlIdPhieuNhap.setPreferredSize(new Dimension(100,40));
        jtxIdPhieuNhap.setEditable(false);
        jlIdPhieuNhap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdPhieuNhap.setForeground(Color.WHITE);
        jlIdPhieuNhap.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdPhieuNhap.setText("Id Order");
        jtxIdPhieuNhap.setPreferredSize(new Dimension(300,40));
        jtxIdPhieuNhap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdPhieuNhap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdPhieuNhap.add(jlIdPhieuNhap, BorderLayout.WEST);
        jpContainerIdPhieuNhap.add(jtxIdPhieuNhap, BorderLayout.EAST);

        jpContainerIdNhanVien.setLayout(new BorderLayout());
        jlIdNhanVien.setPreferredSize(new Dimension(100,40));
        jlIdNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdNhanVien.setForeground(Color.white);
        jlIdNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdNhanVien.setText("Id Staff");
        jtxIdNhanVien.setPreferredSize(new Dimension(300,40));
        jtxIdNhanVien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jtxIdNhanVien.setEditable(false);
        jlIdNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdNhanVien.add(jlIdNhanVien, BorderLayout.WEST);
        jpContainerIdNhanVien.add(jtxIdNhanVien, BorderLayout.EAST);
        jpEnterToolsPhieuNhap.add(jpContainerIdPhieuNhap);
        jpEnterToolsPhieuNhap.add(jpContainerIdNhanVien);

        jpContainerIdNhaCungCap.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlIdNhaCungCap.setPreferredSize(new Dimension(100,40));
        jlIdNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdNhaCungCap.setForeground(Color.white);
        jlIdNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdNhaCungCap.setText("Id Order");
        jtxIdNhaCungCap.setPreferredSize(new Dimension(250,40));
        jtxIdNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jtxIdNhaCungCap.setEditable(false);
        jbtnIdNhaCungCap.setPreferredSize(new Dimension(50,40));
        jbtnIdNhaCungCap.setBackground(new Color(53,54,58));
        jbtnIdNhaCungCap.setText("...");
        jbtnIdNhaCungCap.setForeground(Color.WHITE);
        jbtnIdNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getIdProvider();
            }
        });
        jbtnIdNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdNhaCungCap.add(jlIdNhaCungCap);
        jpContainerIdNhaCungCap.add(jtxIdNhaCungCap);
        jpContainerIdNhaCungCap.add(jbtnIdNhaCungCap);
        jpEnterToolsPhieuNhap.add(jpContainerIdPhieuNhap);
        jpEnterToolsPhieuNhap.add(jpContainerIdNhaCungCap);

        jpContainerNgayNhap.setLayout(new BorderLayout());
        jlNgayNhap.setPreferredSize(new Dimension(100,40));
        jlNgayNhap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlNgayNhap.setForeground(Color.white);
        jlNgayNhap.setHorizontalAlignment(SwingConstants.CENTER);
        jlNgayNhap.setText("Date");
        ngayNhap.setPreferredSize(new Dimension(300,40));
        jpContainerNgayNhap.add(jlNgayNhap, BorderLayout.WEST);
        jpContainerNgayNhap.add(ngayNhap, BorderLayout.EAST);
        jpEnterToolsPhieuNhap.add(jpContainerIdPhieuNhap);
        jpEnterToolsPhieuNhap.add(jpContainerNgayNhap);

        jpContainerTongTien.setLayout(new BorderLayout());
        jlTongTien.setPreferredSize(new Dimension(100,40));
        jlTongTien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTongTien.setForeground(Color.white);
        jlTongTien.setHorizontalAlignment(SwingConstants.CENTER);
        jtxTongTien.setEditable(false);
        jlTongTien.setText("Total Order");
        jtxTongTien.setPreferredSize(new Dimension(300,40));
        jtxTongTien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTongTien.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerTongTien.add(jlTongTien, BorderLayout.WEST);
        jpContainerTongTien.add(jtxTongTien, BorderLayout.EAST);
        jpEnterToolsPhieuNhap.add(jpContainerIdPhieuNhap);
        jpEnterToolsPhieuNhap.add(jpContainerTongTien);

        jpContainerIdProduct.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlIdProduct.setPreferredSize(new Dimension(100,40));
        jlIdProduct.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdProduct.setForeground(Color.white);
        jlIdProduct.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdProduct.setText("Id Order");
        jtxIdProduct.setPreferredSize(new Dimension(250,40));
        jtxIdProduct.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jtxIdProduct.setEditable(false);
        jbtnIdProduct.setPreferredSize(new Dimension(50,40));
        jbtnIdProduct.setBackground(new Color(53,54,58));
        jbtnIdProduct.setText("...");
        jbtnIdProduct.setForeground(Color.WHITE);
        jbtnIdProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               getIdProduct();
            }
        });
        jbtnIdProduct.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdProduct.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdProduct.add(jlIdProduct);
        jpContainerIdProduct.add(jtxIdProduct);
        jpContainerIdProduct.add(jbtnIdProduct);
        jpEnterToolsPhieuNhap.add(jpContainerIdProduct);

        jpContainerIdDonGia.setLayout(new BorderLayout());
        jlDonGia.setPreferredSize(new Dimension(100,40));
        jlDonGia.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDonGia.setForeground(Color.white);
        jlDonGia.setHorizontalAlignment(SwingConstants.CENTER);
        jlDonGia.setText("Price");
        jtxDonGia.setPreferredSize(new Dimension(300,40));
        jtxDonGia.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDonGia.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdDonGia.add(jlDonGia, BorderLayout.WEST);
        jpContainerIdDonGia.add(jtxDonGia, BorderLayout.EAST);
        jpEnterToolsPhieuNhap.add(jpContainerIdDonGia);

        jpContainerSoLuong.setLayout(new BorderLayout());
        jlSoLuong.setPreferredSize(new Dimension(100,40));
        jlSoLuong.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlSoLuong.setForeground(Color.white);
        jlSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
        jlSoLuong.setText("Amount");
        jtxSoLuong.setPreferredSize(new Dimension(300,40));
        jtxSoLuong.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerSoLuong.add(jlSoLuong, BorderLayout.WEST);
        jpContainerSoLuong.add(jtxSoLuong, BorderLayout.EAST);
        jpEnterToolsPhieuNhap.add(jpContainerSoLuong);

        jpContainerthanhTien.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        jlThanhTien.setPreferredSize(new Dimension(100,40));
        jlThanhTien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlThanhTien.setForeground(Color.white);
        jlThanhTien.setHorizontalAlignment(SwingConstants.CENTER);
        jtxThanhTien.setEditable(false);
        jlThanhTien.setText("Total");
        jtxThanhTien.setPreferredSize(new Dimension(250,40));
        jtxThanhTien.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlThanhTien.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnCal.setPreferredSize(new Dimension(50,40));
        jbtnCal.setBackground(new Color(53,54,58));
        jbtnCal.setForeground(Color.WHITE);
        jbtnCal.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnCal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculator();
            }
        });
        jpContainerthanhTien.add(jlThanhTien);
        jpContainerthanhTien.add(jtxThanhTien);
        jpContainerthanhTien.add(jbtnCal);
        jpEnterToolsPhieuNhap.add(jpContainerthanhTien);


    /*---Setup phần nút bấm---*/
        jpButtonPhieuNhap.setLayout(new BorderLayout());
        jpBtnPhieuNhap.setPreferredSize(new Dimension(495,50));
        jpBtnPhieuNhap.setBackground(new Color(32, 33, 36));
        jpBtnCT.setPreferredSize(new Dimension(495,50));
        jpBtnCT.setBackground(new Color(32, 33, 36));
        jpButtonPhieuNhap.add(jpBtnPhieuNhap, BorderLayout.WEST);
        jpButtonPhieuNhap.add(jpBtnCT, BorderLayout.EAST);
        jpBtnPhieuNhap.setLayout(new FlowLayout(FlowLayout.CENTER,10 ,5));
        jpBtnCT.setLayout(new FlowLayout(FlowLayout.CENTER,10 ,5));
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
        jpBtnPhieuNhap.add(jbtnThem);

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
        jpBtnPhieuNhap.add(jbtnXoa);
        jbtnReset.setPreferredSize(new Dimension(40,40));
        jbtnReset.setIcon(new ImageIcon("./Image/reset-data.png"));
        jpBtnPhieuNhap.add(jbtnReset);

        jbtnThemCT.setForeground(new Color(42,184,14));
        jbtnThemCT.setPreferredSize(new Dimension(120, 40));
        jbtnThemCT.setBorder(BorderFactory.createLineBorder(new Color(42,184,14)));
        jbtnThemCT.setIcon(new ImageIcon("./Image/add-green.png"));
        jbtnThemCT.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnThemCT.setText("  Add");
        jbtnThemCT.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jbtnThemCT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addDetail();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnThemCT.setOpaque(true);
                jbtnThemCT.setForeground(Color.WHITE);
                jbtnThemCT.setBackground(new Color(42,184,14));
                jbtnThemCT.setIcon(new ImageIcon("./Image/add-white.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnThemCT.setOpaque(false);
                jbtnThemCT.setForeground(new Color(42,184,14));
                jbtnThemCT.setIcon(new ImageIcon("./Image/add-green.png"));
            }
        });
        jpBtnCT.add(jbtnThemCT);

        jbtnSuaCT.setForeground(new Color(41,70,237));
        jbtnSuaCT.setPreferredSize(new Dimension(120, 40));
        jbtnSuaCT.setBorder(BorderFactory.createLineBorder(new Color(41,70,237)));
        jbtnSuaCT.setIcon(new ImageIcon("./Image/update_blue.png"));
        jbtnSuaCT.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnSuaCT.setText("Edit");
        jbtnSuaCT.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jbtnSuaCT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               //
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnSuaCT.setOpaque(true);
                jbtnSuaCT.setForeground(Color.WHITE);
                jbtnSuaCT.setBackground(new Color(41,70,237));
                jbtnSuaCT.setIcon(new ImageIcon("./Image/update_white.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnSuaCT.setOpaque(false);
                jbtnSuaCT.setForeground(new Color(41,70,237));
                jbtnSuaCT.setIcon(new ImageIcon("./Image/update_blue.png"));
            }
        });
        jpBtnCT.add(jbtnSuaCT);

        jbtnXoaCT.setForeground(new Color(238,57,57));
        jbtnXoaCT.setPreferredSize(new Dimension(120, 40));
        jbtnXoaCT.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
        jbtnXoaCT.setIcon(new ImageIcon("./Image/remove_red.png"));
        jbtnXoaCT.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnXoaCT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              deleteDetail();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnXoaCT.setOpaque(true);
                jbtnXoaCT.setForeground(Color.WHITE);
                jbtnXoaCT.setBackground(new Color(238,57,57));
                jbtnXoaCT.setIcon(new ImageIcon("./Image/remove-white.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnXoaCT.setOpaque(false);
                jbtnXoaCT.setForeground(new Color(238,57,57));
                jbtnXoaCT.setIcon(new ImageIcon("./Image/remove_red.png"));
            }
        });
        jbtnXoaCT.setText("Del");
        jbtnXoaCT.setFont(new Font("iCiel Gotham Medium", 0, 24));
        jpBtnCT.add(jbtnXoaCT);
        jbtnResetCT.setPreferredSize(new Dimension(40,40));
        jbtnResetCT.setIcon(new ImageIcon("./Image/reset-data.png"));
        jpBtnCT.add(jbtnResetCT);


    /*---Setup table---*/
        jpTableViewPhieuNhap.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        String[] headerTablePhieuNhap={"Id Order","Id Provider","Date","Id Customer","Total"};
        String[] headerTableCTPhieuNhap={"Id Order","Id Product","Qty","Price","Total"};
        String[][] rawPN={{"","","","",""},{"","","","",""}};
        DefaultTableModel renderPN=new DefaultTableModel(rawPN,headerTablePhieuNhap);
        DefaultTableModel renderCTPN=new DefaultTableModel(rawPN,headerTableCTPhieuNhap);
        tablePhieuNhap=new JTable(renderPN);
        tableChiTietPhieuNhap=new JTable(renderCTPN);
        tablePhieuNhap.setSize(450,370);
        tableChiTietPhieuNhap.setSize(450,370);
        scrollPanePhieuNhap=new JScrollPane(tablePhieuNhap);
        scrollPanePhieuNhap.setVisible(true);
        scrollPaneChiTietPhieuNhap=new JScrollPane(tableChiTietPhieuNhap);
        scrollPaneChiTietPhieuNhap.setVisible(true);
        jpTableViewPhieuNhap.add(scrollPanePhieuNhap);
        jpTableViewPhieuNhap.add(scrollPaneChiTietPhieuNhap);
        tablePhieuNhap.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            chooseRowPhieuNhap(tablePhieuNhap.getSelectedRow());
        }
    });
        tableChiTietPhieuNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseRowChiTiet(tableChiTietPhieuNhap.getSelectedRow());
            }
        });
        tablePhieuNhap.setOpaque(true);
        tablePhieuNhap.getTableHeader().setBackground(new Color(32, 33, 36));
        tablePhieuNhap.getTableHeader().setForeground(Color.WHITE);
        scrollPanePhieuNhap.getViewport().setBackground(new Color(32, 33, 36));

        tableChiTietPhieuNhap.setOpaque(true);
        tableChiTietPhieuNhap.getTableHeader().setBackground(new Color(32, 33, 36));
        tableChiTietPhieuNhap.getTableHeader().setForeground(Color.WHITE);
        scrollPaneChiTietPhieuNhap.getViewport().setBackground(new Color(32, 33, 36));

}

    private void chooseRowPhieuNhap(int row)
    {
        danhSachChiTietPhieuNhap.clear();
        Vector temp=new Vector();
        for(int index=0;index<tablePhieuNhap.getColumnCount();index++)
        {
            temp.add(tablePhieuNhap.getValueAt(row,index));
        }
        jtxIdPhieuNhap.setText(String.valueOf(temp.get(0)));
        jtxIdNhaCungCap.setText(String.valueOf(temp.get(1)));
        jtxIdNhanVien.setText(String.valueOf(temp.get(2)));
        ngayNhap.setDate((Date) temp.get(3));
        jtxTongTien.setText(String.valueOf(temp.get(4)));
        phieuNhapBUS.setDetaiListByIdPhieuNhap((Integer) temp.get(0));
        danhSachChiTietPhieuNhap=phieuNhapBUS.getDetailList_temp();
        loadChiTietPhieuNhap();
    }
    private void chooseRowChiTiet(int row)
    {
        Vector temp=new Vector();
        for(int index=0;index<tableChiTietPhieuNhap.getColumnCount();index++)
        {
            temp.add(tableChiTietPhieuNhap.getValueAt(row,index));
        }
        jtxIdProduct.setText(""+ temp.get(1));
        jtxSoLuong.setText(""+temp.get(2));
        jtxDonGia.setText(""+ temp.get(3));
        jtxThanhTien.setText(""+temp.get(4));
    }
    public void loadDanhSachPhieuNhap()
    {
        danhSachPhieuNhap=phieuNhapBUS.getList();
        renderOrderTable= (DefaultTableModel) tablePhieuNhap.getModel();
        renderOrderTable.setNumRows(0);
        for (PhieuNhap index: danhSachPhieuNhap)
        {
            renderOrderTable.addRow(index.toArray());
        }
        tablePhieuNhap.setModel(renderOrderTable);
    }
    public void loadChiTietPhieuNhap()
    {
        if(danhSachChiTietPhieuNhap!=null)
        {
            renderDetailOrderTable=(DefaultTableModel) tableChiTietPhieuNhap.getModel();
            renderDetailOrderTable.setNumRows(0);
            for (ChiTietPhieuNhap index : danhSachChiTietPhieuNhap)
            {
                renderDetailOrderTable.addRow(index.toArray());
            }
            tableChiTietPhieuNhap.setModel(renderDetailOrderTable);
        }
    }


    private void add() {
        if (isFullPhieuNhapField()) {
            int idNCC = Integer.parseInt(jtxIdNhaCungCap.getText());
            Timestamp ngay = new Timestamp(ngayNhap.getDate().getTime());
            int idNV = Integer.parseInt(jtxIdNhanVien.getText());
            int total = Integer.parseInt(jtxTongTien.getText());
            PhieuNhap phieuNhap = new PhieuNhap(-1, idNCC, idNV,ngay, total);
            if (phieuNhapBUS.add(phieuNhap)) {
                JOptionPane.showMessageDialog(null, "Successful");
                renderOrderTable = (DefaultTableModel) tablePhieuNhap.getModel();
                phieuNhap.setIdPhieuNhap(phieuNhapBUS.getLastId());
                renderOrderTable.addRow(phieuNhap.toArray());
                tablePhieuNhap.setModel(renderOrderTable);
                refreshPhieuNhap();
                danhSachChiTietPhieuNhap.clear();
                loadChiTietPhieuNhap();
                refreshCTPN();
            } else {
                JOptionPane.showMessageDialog(null, "Fail");
                refreshPhieuNhap();
                refreshCTPN();
            }
        }
    }

    private void delete()
    {
        int row=tablePhieuNhap.getSelectedRow();
        if (row>=0)
        {
            int id= Integer.parseInt(String.valueOf(tablePhieuNhap.getValueAt(row,0)));

            if (JOptionPane.showConfirmDialog(null, "You want to delete this promo? promo " + id + "/",
                    "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            {
                if(phieuNhapBUS.remove(id))
                {

                    JOptionPane.showMessageDialog(null,"Succsessly");
                    renderOrderTable= (DefaultTableModel) tablePhieuNhap.getModel();
                    renderOrderTable.removeRow(row);
                    tablePhieuNhap.setModel(renderOrderTable);
                    phieuNhapBUS.setDetaiListByIdPhieuNhap(id);
                    danhSachChiTietPhieuNhap=phieuNhapBUS.getDetailList_temp();
                    loadTotalBill();
                    refreshCTPN();
                    refreshPhieuNhap();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Fail");
                }
            }

        } else
        {
            JOptionPane.showMessageDialog(null,"Choose order.");
        }

    }
    private void deleteDetail()
    {
        int row=tableChiTietPhieuNhap.getSelectedRow();
        if(row>=0)
        {
            int id= Integer.parseInt(String.valueOf(tableChiTietPhieuNhap.getValueAt(row,0)));
            int idsp= Integer.parseInt(String.valueOf(tableChiTietPhieuNhap.getValueAt(row,1)));
                if (JOptionPane.showConfirmDialog(null, "You want to delete this detail order?  id product " + idsp,
                        "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
                {
                    for (ChiTietPhieuNhap index: danhSachChiTietPhieuNhap)
                    {
                        if (index.getIdSanPham()==idsp)
                        {
                            phieuNhapBUS.deleteDetail_temp(id,idsp);
                            danhSachChiTietPhieuNhap.remove(index);
                            loadChiTietPhieuNhap();
                            refreshCTPN();
                            loadTotalBill();
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

    private void update()
    {

    }
    private void updateDetail()
    {

    }

    private void refreshPhieuNhap()
    {

    }
    private void searchPhieuNhap()
    {

    }

    private void getIdProduct()
    {
        ChooseProduct chooseProduct=new ChooseProduct();
        chooseProduct.setVisible(true);
        chooseProduct.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (chooseProduct.getValue()!=null) {
                    jtxIdProduct.setText(String.valueOf(chooseProduct.getValue().getIdSanPham()));
                }

            }
        });
    }
    
    private void getIdProvider()
    {
        ChooseProvider chooseProvider=new ChooseProvider();
        chooseProvider.setVisible(true);
        chooseProvider.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (chooseProvider.getValue()!=null) {
                    jtxIdNhaCungCap.setText(String.valueOf(chooseProvider.getValue().getIdNhaCungCap()));
                }

            }
        });
    }
    private boolean isFullCTField()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String idsp=jtxIdProduct.getText();
        String soLuong=jtxSoLuong.getText();
        String donGia=jtxDonGia.getText();
        String thanhTien=jtxThanhTien.getText();
        if (idsp.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please do not leave the 'Id Product' field blank");
            return false;
        } else if (soLuong.trim().equals("") || toolsGUI.isInterger(soLuong)==false)
        {
            JOptionPane.showMessageDialog(null, "Amount Field is blank field or illegel value ");
            return false;
        } else if (donGia.trim().equals("") || toolsGUI.isInterger(donGia)==false)
        {
            JOptionPane.showMessageDialog(null, "Price Field is blank field or illegel value ");
            return false;
        } else if (thanhTien.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Total Field is blank field or illegel value ");
            return false;
        }

        return true;
    }

    private void addDetail()
    {

        if (isFullCTField())
        {
            int idsp= Integer.parseInt(jtxIdProduct.getText());
            int soLuong= Integer.parseInt(jtxSoLuong.getText());
            int donGia= Integer.parseInt(jtxDonGia.getText());
            int thanhTien= Integer.parseInt(jtxThanhTien.getText());
            if (checkExistDetail(idsp))
            {
                ChiTietPhieuNhap chiTietPhieuNhap=new ChiTietPhieuNhap(-1, idsp,soLuong,donGia,thanhTien);
                phieuNhapBUS.add_temp(chiTietPhieuNhap);
                danhSachChiTietPhieuNhap.add(chiTietPhieuNhap);
                loadChiTietPhieuNhap();
                refreshCTPN();
                loadTotalBill();
            } else
            {
                JOptionPane.showMessageDialog(null,"Exist detail! Choose Edit to change.");
                refreshCTPN();
            }
        }
    }
    private boolean checkExistDetail(int idsp)
    {
        boolean rs=true;
        if(danhSachChiTietPhieuNhap != null)
        {
            for(ChiTietPhieuNhap index: danhSachChiTietPhieuNhap)
            {
                if ( index.getIdSanPham()==idsp)
                {
                    rs=false;
                    break;
                }
            }
        }
        return rs;
    }
    private void refreshCTPN()
    {
        jtxIdProduct.setText("");
        jtxDonGia.setText("");
        jtxThanhTien.setText("");
        jtxSoLuong.setText("");
    }
    private void loadTotalBill()
    {
        int rs=0;
        if (danhSachChiTietPhieuNhap!=null)
        {
            for (ChiTietPhieuNhap index: danhSachChiTietPhieuNhap)
            {
                rs+=index.getThanhTien();
            }
        }
        jtxTongTien.setText(String.valueOf(rs));
    }
    private boolean isFullPhieuNhapField()
    {
        String id=jtxIdNhaCungCap.getText();
        Date date=ngayNhap.getDate();
        if (id.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Provider Id Field is blank field");
            return false;
        } else if (date==null)
        {
            JOptionPane.showMessageDialog(null,"Date Filed is blank");
            return false;
        } else if (danhSachChiTietPhieuNhap==null || phieuNhapBUS.getDetailList_temp()==null)
        {
            JOptionPane.showMessageDialog(null, "No order details");
            return false;
        }


        return true;
    }

    private void setSessionOfStaff()
    {

        jtxIdNhanVien.setText("1");
    }

    private void calculator()
    {
        int sl= Integer.parseInt(jtxDonGia.getText());
        int dg= Integer.parseInt(jtxSoLuong.getText());
        jtxThanhTien.setText(String.valueOf(sl*dg));
    }

    


}
