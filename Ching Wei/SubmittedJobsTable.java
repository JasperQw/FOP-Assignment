import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SubmittedJobsTable {

    public static void main(String[] args) {
        
        String [] col_names = {"Month", "Amount"};
        Object[][] data = new Object [8][col_names.length];
        
        data[0][0] = "June";        data[0][1] = 2423;
        data[1][0] = "July";        data[1][1] = 1448;
        data[2][0] = "August";      data[2][1] = 1520;
        data[3][0] = "September";   data[3][1] = 1377;
        data[4][0] = "October";     data[4][1] = 1866;
        data[5][0] = "November";    data[5][1] = 1212;
        data[6][0] = "December";    data[6][1] = 706;
        data[7][0] = "Sum";         data[7][1] = 2423 + 1448 + 1520 + 1377 + 1866 + 1212 + 706;
                
        // Table formatting
        DefaultTableModel model = new DefaultTableModel(data, col_names);
        JTable jtable = new JTable(model);
        jtable.setRowHeight(25);
        jtable.setGridColor(Color.BLACK);
        jtable.setShowGrid(true);
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtable.setFont(new Font("Arial", Font.BOLD, 12));
        jtable.setForeground(Color.BLACK);
        jtable.setBackground(Color.WHITE);
        
        // Table header formatting
        JTableHeader tablehead = jtable.getTableHeader();
        tablehead.setBackground(Color.BLACK);
        tablehead.setForeground(Color.WHITE);
        tablehead.setFont(new Font("Times New Roman", Font.BOLD, 14));

        // Alternate row coloring
        jtable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBackground(row % 2 == 0 ? Color.WHITE : new Color(255, 153, 153));
        if (isSelected) {
            setForeground(Color.RED);
        }

        else {
            setForeground(Color.BLACK);
        }
        return this;
    }
    });;
        
        // Frame setup
        JFrame jframe = new JFrame();
        jframe.setSize(800,600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.add(new JScrollPane(jtable));
        jframe.setTitle("Number of Jobs Submitted per Month");

        //Table Title
        JLabel title = new JLabel("Number of Jobs Submitted per Month");
        title.setFont(new Font("Times New Roman", Font.BOLD, 18));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);
        jframe.add(title, BorderLayout.NORTH);

    }
}