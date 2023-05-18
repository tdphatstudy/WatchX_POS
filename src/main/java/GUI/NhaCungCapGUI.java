package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCap;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class NhaCungCapGUI extends JPanel {
    /*---Thành phần GUI---*/
    private JPanel jpSearchBarNhaCungCap,jpEnterToolsNhaCungCap,jpButtonNhaCungCap,jpTableViewNhaCungCap;
    private JPanel jpContainerSearchToolsNhaCungCap;
    private JLabel jlSearchNhaCungCap;
    private JTextField jtxSearchEnterNhaCungCap;
    private JLabel jbtnSearchNhaCungCap;
    private JPanel jpContainerIdNhaCungCap,jpContainerTenNhaCungCap, jpContainerDiaChiNhaCungCap,jpContainerEmailNhaCungCap, jpContainerPhoneNhaCungCap;
    private JLabel jlIdNhaCungCap,jlTenNhaCungCap, jlDiaChiNhaCungCap, jlEmailNhaCungCap, jlPhoneNhaCungCap;
    private JTextField jtxIdNhaCungCap,jtxTenNhaCungCap, jtxDiaChiNhaCungCap, jtxEmailNhaCungCap, jtxPhoneNhaCungCap;
    private JLabel jbtnThem,jbtnXoa, jbtnSua;
    private JTable tableNhaCungCap;
    private JScrollPane scrollPaneNhaCungCap;
    /*---Biến xử lý---*/
    private NhaCungCapBUS nhaCungCapBUS=new NhaCungCapBUS();
    private DefaultTableModel renderProviderTable=new DefaultTableModel();
    private ArrayList<NhaCungCap> danhSachNhaCungCap=new ArrayList<>();
    public NhaCungCapGUI()
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
        this.add(jpSearchBarNhaCungCap);
        this.add(jpEnterToolsNhaCungCap);
        this.add(jpButtonNhaCungCap);
        this.add(jpTableViewNhaCungCap);
        loadDanhSachNhaCungCap();

    }
    private void delarceVariable()
    {
        LineBorder line = new LineBorder(new Color(61,62,66), 1, true);
        jpSearchBarNhaCungCap=new JPanel();
        jpEnterToolsNhaCungCap=new JPanel();
        jpButtonNhaCungCap=new JPanel();
        jpTableViewNhaCungCap=new JPanel();
        jpContainerSearchToolsNhaCungCap =new JPanel();
        jlSearchNhaCungCap=new JLabel("",SwingConstants.LEADING);
        jtxSearchEnterNhaCungCap=new JTextField();
        jbtnSearchNhaCungCap=new JLabel("",SwingConstants.CENTER);
        jpContainerIdNhaCungCap=new JPanel();
        jpContainerTenNhaCungCap=new JPanel();
        jpContainerDiaChiNhaCungCap=new JPanel();
        jpContainerEmailNhaCungCap=new JPanel();
        jpContainerPhoneNhaCungCap=new JPanel();
        jlIdNhaCungCap=new JLabel();
        jlTenNhaCungCap=new JLabel();
        jlDiaChiNhaCungCap=new JLabel();
        jlEmailNhaCungCap=new JLabel();
        jlPhoneNhaCungCap=new JLabel();
        jtxIdNhaCungCap=new JTextField();
        jtxTenNhaCungCap=new JTextField();
        jtxDiaChiNhaCungCap=new JTextField();
        jtxEmailNhaCungCap=new JTextField();
        jtxPhoneNhaCungCap=new JTextField();
        jbtnThem=new JLabel();
        jbtnXoa=new JLabel();
        jbtnSua=new JLabel();

        /*---Setup toàn Panel---*/
        jpSearchBarNhaCungCap.setPreferredSize(new Dimension(990,50));
        jpSearchBarNhaCungCap.setBackground(new Color(32, 33, 36));
        jpSearchBarNhaCungCap.setBorder(line);
        jpEnterToolsNhaCungCap.setPreferredSize(new Dimension(990,200));
        jpEnterToolsNhaCungCap.setBackground(new Color(32, 33, 36));
        jpEnterToolsNhaCungCap.setBorder(line);
        jpButtonNhaCungCap.setPreferredSize(new Dimension(990,50));
        jpButtonNhaCungCap.setBackground(new Color(32, 33, 36));
        jpButtonNhaCungCap.setBorder(line);
        jpTableViewNhaCungCap.setPreferredSize(new Dimension(990,400));
        jpTableViewNhaCungCap.setBackground(new Color(32, 33, 36));
        jpTableViewNhaCungCap.setBorder(line);

        /*---Setup search bar---*/
        jpSearchBarNhaCungCap.setLayout(null);
        jpContainerSearchToolsNhaCungCap.setBorder(BorderFactory.createLineBorder(new Color(61,62,66),2));
        jpContainerSearchToolsNhaCungCap.setBounds(20,10,400,30);
        jpContainerSearchToolsNhaCungCap.setBackground(new Color(32,33,36));
        jpSearchBarNhaCungCap.add(jpContainerSearchToolsNhaCungCap);
        jpContainerSearchToolsNhaCungCap.setLayout(new FlowLayout(FlowLayout.CENTER,0,-2));
        jlSearchNhaCungCap.setText("Search: ");
        jlSearchNhaCungCap.setForeground(Color.WHITE);
        jlSearchNhaCungCap.setBackground(new Color(32, 33, 36));
        jlSearchNhaCungCap.setPreferredSize(new Dimension(50,30));
        jtxSearchEnterNhaCungCap.setPreferredSize(new Dimension(300,30));
        jbtnSearchNhaCungCap.setBackground(new Color(32, 33, 36));
        jbtnSearchNhaCungCap.setPreferredSize(new Dimension(46,30));
        jbtnSearchNhaCungCap.setIcon(new ImageIcon("./Image/search-icon.png"));
        jbtnSearchNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchNhaCungCap();
            }
        });
        jpContainerSearchToolsNhaCungCap.add(jlSearchNhaCungCap);
        jpContainerSearchToolsNhaCungCap.add(jtxSearchEnterNhaCungCap);
        jpContainerSearchToolsNhaCungCap.add(jbtnSearchNhaCungCap);

        /*---Setup các field nhập---*/
        jpEnterToolsNhaCungCap.setLayout(null);
        jpContainerIdNhaCungCap.setBounds(63,20,400,40);
        jpContainerTenNhaCungCap.setBounds(526,20,400,40);
        jpContainerDiaChiNhaCungCap.setBounds(63,80,400,40);
        jpContainerEmailNhaCungCap.setBounds(526,80,400,40);
        jpContainerPhoneNhaCungCap.setBounds(245,140,400,40);
        jpContainerTenNhaCungCap.setBackground(new Color(53,54,58));
        jpContainerIdNhaCungCap.setBackground(new Color(53,54,58));
        jpContainerDiaChiNhaCungCap.setBackground(new Color(53,54,58));
        jpContainerEmailNhaCungCap.setBackground(new Color(53,54,58));
        jpContainerPhoneNhaCungCap.setBackground(new Color(53,54,58));
        jpContainerIdNhaCungCap.setLayout(new BorderLayout());
        jlIdNhaCungCap.setPreferredSize(new Dimension(100,40));
        jtxIdNhaCungCap.setEditable(false);
        jlIdNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdNhaCungCap.setForeground(Color.WHITE);
        jlIdNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdNhaCungCap.setText("Id");
        jtxIdNhaCungCap.setPreferredSize(new Dimension(300,40));
        jtxIdNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdNhaCungCap.add(jlIdNhaCungCap, BorderLayout.WEST);
        jpContainerIdNhaCungCap.add(jtxIdNhaCungCap, BorderLayout.EAST);
        
        jpContainerTenNhaCungCap.setLayout(new BorderLayout());
        jlTenNhaCungCap.setPreferredSize(new Dimension(100,40));
        jlTenNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenNhaCungCap.setForeground(Color.white);
        jlTenNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlTenNhaCungCap.setText("Name");
        jtxTenNhaCungCap.setPreferredSize(new Dimension(300,40));
        jtxTenNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerTenNhaCungCap.add(jlTenNhaCungCap, BorderLayout.WEST);
        jpContainerTenNhaCungCap.add(jtxTenNhaCungCap, BorderLayout.EAST);
        jpEnterToolsNhaCungCap.add(jpContainerIdNhaCungCap);
        jpEnterToolsNhaCungCap.add(jpContainerTenNhaCungCap);

        jpContainerDiaChiNhaCungCap.setLayout(new BorderLayout());
        jlDiaChiNhaCungCap.setPreferredSize(new Dimension(100,40));
        jlDiaChiNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDiaChiNhaCungCap.setForeground(Color.white);
        jlDiaChiNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlDiaChiNhaCungCap.setText("Address");
        jtxDiaChiNhaCungCap.setPreferredSize(new Dimension(300,40));
        jtxDiaChiNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlDiaChiNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDiaChiNhaCungCap.add(jlDiaChiNhaCungCap, BorderLayout.WEST);
        jpContainerDiaChiNhaCungCap.add(jtxDiaChiNhaCungCap, BorderLayout.EAST);
        jpEnterToolsNhaCungCap.add(jpContainerIdNhaCungCap);
        jpEnterToolsNhaCungCap.add(jpContainerDiaChiNhaCungCap);

        jpContainerEmailNhaCungCap.setLayout(new BorderLayout());
        jlEmailNhaCungCap.setPreferredSize(new Dimension(100,40));
        jlEmailNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlEmailNhaCungCap.setForeground(Color.white);
        jlEmailNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlEmailNhaCungCap.setText("Email");
        jtxEmailNhaCungCap.setPreferredSize(new Dimension(300,40));
        jtxEmailNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlEmailNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerEmailNhaCungCap.add(jlEmailNhaCungCap, BorderLayout.WEST);
        jpContainerEmailNhaCungCap.add(jtxEmailNhaCungCap, BorderLayout.EAST);
        jpEnterToolsNhaCungCap.add(jpContainerIdNhaCungCap);
        jpEnterToolsNhaCungCap.add(jpContainerEmailNhaCungCap);

        jpContainerPhoneNhaCungCap.setLayout(new BorderLayout());
        jlPhoneNhaCungCap.setPreferredSize(new Dimension(100,40));
        jlPhoneNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPhoneNhaCungCap.setForeground(Color.white);
        jlPhoneNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jlPhoneNhaCungCap.setText("NAME");
        jtxPhoneNhaCungCap.setPreferredSize(new Dimension(300,40));
        jtxPhoneNhaCungCap.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlPhoneNhaCungCap.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerPhoneNhaCungCap.add(jlPhoneNhaCungCap, BorderLayout.WEST);
        jpContainerPhoneNhaCungCap.add(jtxPhoneNhaCungCap, BorderLayout.EAST);
        jpEnterToolsNhaCungCap.add(jpContainerIdNhaCungCap);
        jpEnterToolsNhaCungCap.add(jpContainerPhoneNhaCungCap);
        
        /*---Setup phần nút bấm---*/
        jpButtonNhaCungCap.setLayout(new FlowLayout(FlowLayout.CENTER, 100,5));
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
        jpButtonNhaCungCap.add(jbtnThem);

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
        jpButtonNhaCungCap.add(jbtnSua);

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
        jpButtonNhaCungCap.add(jbtnXoa);


        /*---Setup table---*/
        jpTableViewNhaCungCap.setLayout(new BorderLayout());
        String[] headerNhaCungCap={"ID", "Name","Address", "Email","Phone"};
        String[][] rawTH={{"","","","",""},{"","","","",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, headerNhaCungCap);
        tableNhaCungCap=new JTable(renderInit);
        tableNhaCungCap.setSize(900,500);
        scrollPaneNhaCungCap=new JScrollPane(tableNhaCungCap);
        scrollPaneNhaCungCap.setVisible(true);
        jpTableViewNhaCungCap.add(scrollPaneNhaCungCap);
        tableNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseRowNhaCungCap(tableNhaCungCap.getSelectedRow());
            }
        });
        tableNhaCungCap.setOpaque(true);
        tableNhaCungCap.getTableHeader().setBackground(new Color(32, 33, 36));
        tableNhaCungCap.getTableHeader().setForeground(Color.WHITE);
        scrollPaneNhaCungCap.getViewport().setBackground(new Color(32, 33, 36));

    }

    private void chooseRowNhaCungCap(int row)
    {
        Vector temp=new Vector();
        for(int index=0;index<tableNhaCungCap.getColumnCount();index++)
        {
            temp.add(tableNhaCungCap.getValueAt(row,index));
        }
        jtxIdNhaCungCap.setText(""+temp.get(0));
        jtxTenNhaCungCap.setText((String) temp.get(1));
        jtxDiaChiNhaCungCap.setText((String) temp.get(2));
        jtxEmailNhaCungCap.setText((String) temp.get(3));
        jtxPhoneNhaCungCap.setText((String) temp.get(4));
    }
    public void loadDanhSachNhaCungCap()
    {
        danhSachNhaCungCap=nhaCungCapBUS.getList();
        renderProviderTable= (DefaultTableModel) tableNhaCungCap.getModel();
        renderProviderTable.setNumRows(0);
        for (NhaCungCap index: danhSachNhaCungCap)
        {
            renderProviderTable.addRow(index.toArray());
        }
        tableNhaCungCap.setModel(renderProviderTable);
    }
    private boolean isFullFiled()
    {
        ToolsGUI toolsGUI=new ToolsGUI();
        String ten=jtxTenNhaCungCap.getText();
        String diachi=jtxDiaChiNhaCungCap.getText();
        String email=jtxEmailNhaCungCap.getText();
        String phone=jtxPhoneNhaCungCap.getText();
        if (ten.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please do not leave the 'Name' field blank");
            return false;
        } else if(diachi.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please do not leave the 'Address' field blank");
            return false;
        } else if (email.trim().equals("") || toolsGUI.isEmail(email)==false)
        {
            JOptionPane.showMessageDialog(null, "Email field is blank or illegel value");
            return false;
        } else if (phone.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please do not leave the 'Phone' field blank");
            return false;
        }
        return true;
    }

    private void add()
    {
        if (isFullFiled())
        {
            String ten=jtxTenNhaCungCap.getText();
            String diachi=jtxDiaChiNhaCungCap.getText();
            String email=jtxEmailNhaCungCap.getText();
            String phone=jtxPhoneNhaCungCap.getText();
            if (nhaCungCapBUS.add(new NhaCungCap(-1, ten,diachi,email,phone)))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderProviderTable= (DefaultTableModel) tableNhaCungCap.getModel();
                NhaCungCap insert= new NhaCungCap(nhaCungCapBUS.getLastID(), ten,diachi,email,phone);
                renderProviderTable.addRow(insert.toArray());
                tableNhaCungCap.setModel(renderProviderTable);
                refreshNhaCungCap();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshNhaCungCap();
            }

        }
    }
    private void delete()
    {
        int row=tableNhaCungCap.getSelectedRow();
        int id=-1;
        try{
            id=(int)tableNhaCungCap.getValueAt(row,0);

        } catch (Exception e)
        {
            id= Integer.parseInt((String) tableNhaCungCap.getValueAt(row,0));
        }

        if (JOptionPane.showConfirmDialog(null, "You want to delete this provider? Provider= " + id ,
                "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
        {
            if(nhaCungCapBUS.delete(id))
            {
                JOptionPane.showMessageDialog(null,"Succsessly");
                renderProviderTable= (DefaultTableModel) tableNhaCungCap.getModel();
                renderProviderTable.removeRow(row);
                tableNhaCungCap.setModel(renderProviderTable);
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
            int id= Integer.parseInt(jtxIdNhaCungCap.getText());
            String ten=jtxTenNhaCungCap.getText();
            String diachi=jtxDiaChiNhaCungCap.getText();
            String email=jtxEmailNhaCungCap.getText();
            String phone=jtxPhoneNhaCungCap.getText();
            NhaCungCap nhaCungCap=new NhaCungCap(id, ten,diachi,email,phone);
            Vector<String> temp=new Vector<>();
            for (int index=0;index<5;index++)
            {
                temp.add(""+nhaCungCap.toArray()[index]);
            }
            if (nhaCungCapBUS.update(nhaCungCap))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderProviderTable= (DefaultTableModel) tableNhaCungCap.getModel();
                for(int index=0;index<temp.size();index++)
                {
                    renderProviderTable.setValueAt(temp.get(index),tableNhaCungCap.getSelectedRow(),index);
                }

                tableNhaCungCap.setModel(renderProviderTable);
                refreshNhaCungCap();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshNhaCungCap();
            }

        }
    }

    private void refreshNhaCungCap()
    {
        jtxIdNhaCungCap.setText("");
        jtxTenNhaCungCap.setText("");
        jtxDiaChiNhaCungCap.setText("");
        jtxEmailNhaCungCap.setText("");
        jtxPhoneNhaCungCap.setText("");
    }
    private void searchNhaCungCap()
    {
        DefaultTableModel table = (DefaultTableModel)tableNhaCungCap.getModel();
        String search = jtxSearchEnterNhaCungCap.getText().trim();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableNhaCungCap.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }


}
