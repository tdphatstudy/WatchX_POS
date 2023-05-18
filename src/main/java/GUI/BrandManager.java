package GUI;

import BUS.SanPhamBUS;
import BUS.ThuongHieuBUS;
import DTO.ThuongHieu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class BrandManager extends JPanel {
    /*---Thành phần GUI---*/
    private JPanel jpSearchBar,jpEnterTools,jpButton,jpTableView;
    private JPanel jpContainerSearchTools;
    private JLabel jlSearch;
    private JTextField jtxSearchEnter;
    private JLabel jbtnSearch;
    private JPanel jpContainerIdThuongHieu,jpContainerTenThuongHieu;
    private JLabel jlIdThuongHieu,jlTenThuongHieu;
    private JTextField jtxIdThuongHieu,jtxTenThuongHieu;
    private JLabel jbtnThem,jbtnXoa;
    private JTable tableThuongHieu;
    private JScrollPane scrollPaneThuongHieu;
    /*---Biến xử lý---*/
    private ThuongHieuBUS thuongHieuBUS=new ThuongHieuBUS();
    private DefaultTableModel renderBrandTable=new DefaultTableModel();
    private ArrayList<ThuongHieu> danhSachThuongHieu=new ArrayList<>();
    public BrandManager()
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
        loadDanhSachThuongHieu();

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
        jpContainerIdThuongHieu=new JPanel();
        jpContainerTenThuongHieu=new JPanel();
        jlIdThuongHieu=new JLabel();
        jlTenThuongHieu=new JLabel();
        jtxIdThuongHieu=new JTextField();
        jtxTenThuongHieu=new JTextField();
        jbtnThem=new JLabel();
        jbtnXoa=new JLabel();

        /*---Setup toàn Panel---*/
        jpSearchBar.setPreferredSize(new Dimension(990,50));
        jpSearchBar.setBackground(new Color(32, 33, 36));
        jpSearchBar.setBorder(line);
        jpEnterTools.setPreferredSize(new Dimension(990,200));
        jpEnterTools.setBackground(new Color(32, 33, 36));
        jpEnterTools.setBorder(line);
        jpButton.setPreferredSize(new Dimension(990,50));
        jpButton.setBackground(new Color(32, 33, 36));
        jpButton.setBorder(line);
        jpTableView.setPreferredSize(new Dimension(990,400));
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
                searchThuongHieu();
            }
        });
        jpContainerSearchTools.add(jlSearch);
        jpContainerSearchTools.add(jtxSearchEnter);
        jpContainerSearchTools.add(jbtnSearch);

        /*---Setup các field nhập---*/
        jpEnterTools.setLayout(null);
        jpContainerIdThuongHieu.setBounds(295,40,400,40);
        jpContainerTenThuongHieu.setBounds(295,120,400,40);
        jpContainerTenThuongHieu.setBackground(new Color(53,54,58));
        jpContainerIdThuongHieu.setBackground(new Color(53,54,58));
        jpContainerIdThuongHieu.setLayout(new BorderLayout());
        jlIdThuongHieu.setPreferredSize(new Dimension(100,40));
        jtxIdThuongHieu.setEditable(false);
        jlIdThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdThuongHieu.setForeground(Color.WHITE);
        jlIdThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jlIdThuongHieu.setText("ID");
        jtxIdThuongHieu.setPreferredSize(new Dimension(300,40));
        jtxIdThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlIdThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerIdThuongHieu.add(jlIdThuongHieu, BorderLayout.WEST);
        jpContainerIdThuongHieu.add(jtxIdThuongHieu, BorderLayout.EAST);
        jpContainerTenThuongHieu.setLayout(new BorderLayout());
        jlTenThuongHieu.setPreferredSize(new Dimension(100,40));
        jlTenThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenThuongHieu.setForeground(Color.white);
        jlTenThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jlTenThuongHieu.setText("NAME");
        jtxTenThuongHieu.setPreferredSize(new Dimension(300,40));
        jtxTenThuongHieu.setFont(new Font("iCiel Gotham Medium", 0, 16));
        jlTenThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerTenThuongHieu.add(jlTenThuongHieu, BorderLayout.WEST);
        jpContainerTenThuongHieu.add(jtxTenThuongHieu, BorderLayout.EAST);
        jpEnterTools.add(jpContainerIdThuongHieu);
        jpEnterTools.add(jpContainerTenThuongHieu);

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
                addThuongHieu();
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
        jpButton.add(jbtnThem);
        jbtnXoa.setForeground(new Color(238,57,57));
        jbtnXoa.setPreferredSize(new Dimension(150, 40));
        jbtnXoa.setBorder(BorderFactory.createLineBorder(new Color(238,57,57)));
        jbtnXoa.setIcon(new ImageIcon("./Image/remove_red.png"));
        jbtnXoa.setHorizontalAlignment(SwingConstants.CENTER);
        jbtnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteThuongHieu();
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
        String[] headerThuongHieu={"ID", "Name"};
        String[][] rawTH={{"",""},{"",""}};
        DefaultTableModel renderInit=new DefaultTableModel(rawTH, headerThuongHieu);
        tableThuongHieu=new JTable(renderInit);
        tableThuongHieu.setSize(900,500);
        scrollPaneThuongHieu=new JScrollPane(tableThuongHieu);
        scrollPaneThuongHieu.setVisible(true);
        jpTableView.add(scrollPaneThuongHieu);
        tableThuongHieu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseRowThuongHieu(tableThuongHieu.getSelectedRow());
            }
        });
        tableThuongHieu.setOpaque(true);
        tableThuongHieu.getTableHeader().setBackground(new Color(32, 33, 36));
        tableThuongHieu.getTableHeader().setForeground(Color.WHITE);
        scrollPaneThuongHieu.getViewport().setBackground(new Color(32, 33, 36));

    }

    private void chooseRowThuongHieu(int row)
    {
        Vector temp=new Vector();
        for(int index=0;index<tableThuongHieu.getColumnCount();index++)
        {
            temp.add(tableThuongHieu.getValueAt(row,index));
        }
        jtxIdThuongHieu.setText(""+temp.get(0));
        jtxTenThuongHieu.setText((String) temp.get(1));
    }
    private void loadDanhSachThuongHieu()
    {
        danhSachThuongHieu=thuongHieuBUS.getList();
        renderBrandTable= (DefaultTableModel) tableThuongHieu.getModel();
        renderBrandTable.setNumRows(0);
        for (ThuongHieu index: danhSachThuongHieu)
        {
            renderBrandTable.addRow(index.toArray());
        }
        tableThuongHieu.setModel(renderBrandTable);
    }
    private boolean isFullFiled()
    {
        String tenTH=jtxTenThuongHieu.getText();
        if (tenTH.trim().equals(""))
        {
            return false;
        }
        return true;
    }

    private void addThuongHieu()
    {
        if (isFullFiled())
        {
            String ten=jtxTenThuongHieu.getText();
            if (thuongHieuBUS.add(new ThuongHieu(-1, ten)))
            {
                JOptionPane.showMessageDialog(null,"Successful");
                renderBrandTable= (DefaultTableModel) tableThuongHieu.getModel();
                ThuongHieu insert= new ThuongHieu(thuongHieuBUS.getLastID(), ten);
                renderBrandTable.addRow(insert.toArray());
                tableThuongHieu.setModel(renderBrandTable);
                refreshThuongHieu();
            }else
            {
                JOptionPane.showMessageDialog(null, "Fail! Please try again!");
                refreshThuongHieu();
            }

        }else
        {
            JOptionPane.showMessageDialog(null,"Enter Name Field, Please");
        }
    }
    private void deleteThuongHieu()
    {
        int row=tableThuongHieu.getSelectedRow();
        int id=-1;
        try{
            id=(int)tableThuongHieu.getValueAt(row,0);

        } catch (Exception e)
        {
            id= Integer.parseInt((String) tableThuongHieu.getValueAt(row,0));
        }

            if (JOptionPane.showConfirmDialog(null, "You want to delete this brand? Brand= " + id ,
                    "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            {
                if(thuongHieuBUS.delete(id))
                {
                    JOptionPane.showMessageDialog(null,"Succsessly");
                    renderBrandTable= (DefaultTableModel) tableThuongHieu.getModel();
                    renderBrandTable.removeRow(row);
                    tableThuongHieu.setModel(renderBrandTable);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Fail");
                }

        }
    }


    private void refreshThuongHieu()
    {
        jtxIdThuongHieu.setText("");
        jtxTenThuongHieu.setText("");
    }
    private void searchThuongHieu()
    {
        DefaultTableModel table = (DefaultTableModel)tableThuongHieu.getModel();
        String search = jtxSearchEnter.getText().trim();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableThuongHieu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }


}
