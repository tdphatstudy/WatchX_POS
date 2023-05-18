package GUI;

import BUS.NhanVienBUS;
import BUS.ThuongHieuBUS;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.ThuongHieu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class Login extends javax.swing.JFrame{
    private JPanel titleBar,tableView, tablePlace, toolsBar;
    private JPanel jpIcon,jpClose, jpUser, jpPass;
    private JLabel jlIcon,jlClose, jlUser, jlPass , jlLoginButton;
    private JTextField jtxUser, jtxPass;


    public Login()
    {

        init();
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
        tablePlace=new JPanel();
        jpUser=new JPanel();
        jpPass=new JPanel();
        jlLoginButton = new JLabel();
        jlUser = new JLabel("Username");
        jlPass = new JLabel("Password");
        jtxUser = new JTextField();
        jtxPass = new JTextField();

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
        jpUser.setBackground(new Color(53,54,58));
        jpPass.setBackground(new Color(53,54,58));
        jpUser.setBounds(70,110,450,40);
        jpUser.setLayout(new BorderLayout());
        jlUser.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlUser.setForeground(Color.WHITE);
        jlUser.setHorizontalAlignment(SwingConstants.CENTER);
        jtxUser.setPreferredSize(new Dimension(350, 40));
        jpUser.add(jlUser, BorderLayout.WEST);
        jpUser.add(jtxUser, BorderLayout.EAST);
        jpPass.setBounds(70,220,450,40);
        jpPass.setLayout(new BorderLayout());
        jlPass.setPreferredSize(new Dimension(100, 40));
        jlPass.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPass.setForeground(Color.WHITE);
        jlPass.setHorizontalAlignment(SwingConstants.CENTER);
        jtxPass.setPreferredSize(new Dimension(350, 40));
        jpPass.add(jlPass, BorderLayout.WEST);
        jpPass.add(jtxPass, BorderLayout.EAST);
        tableView.add(jpPass);
        tableView.add(jpUser);

        toolsBar.setLayout(new FlowLayout());
        jlLoginButton.setForeground(new Color(238,57,57));
        jlLoginButton.setPreferredSize(new Dimension(150, 40));
        jlLoginButton.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
        jlLoginButton.setHorizontalAlignment(SwingConstants.CENTER);
        jlLoginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVienBUS nhanVienBUS = new NhanVienBUS();
                NhanVien nhanVien = nhanVienBUS.login(jtxUser.getText(), jtxPass.getText());
                System.out.println("SS"+nhanVien);
                if (nhanVien !=null && nhanVien.getIdNhanVien()!=0) {
                    MainFrame mainFrame = new MainFrame( nhanVien);
                    mainFrame.setVisible(true);
                } else  {
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc email");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jlLoginButton.setOpaque(true);
                jlLoginButton.setForeground(Color.WHITE);
                jlLoginButton.setBackground(new Color(238,57,57));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlLoginButton.setOpaque(false);
                jlLoginButton.setForeground(new Color(238,57,57));
            }
        });
        jlLoginButton.setText("LOGIN");
        jlLoginButton.setFont(new Font("iCiel Gotham Medium", 0, 24));
        toolsBar.add(jlLoginButton);


    }

}
