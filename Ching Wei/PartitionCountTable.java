import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class PartitionCountTable {

    public static void main(String[] args) {
        
        String [] col_names = {"Partition Type", "June", "July", "August", "September", "October", "November", "December", "Sum", "Max", "Min", "Max/Min among Type"};
 
        Object [] row1 = {"CPU-EPYC", 612, 481, 573, 233, 441, 258, 158, 2756, "June", "December"};
        Object [] row2 = {"CPU-OPTERON", 961, 561, 489, 808, 990, 452, 248, 4509, "October", "December", "Max"};
        Object [] row3 = {"GPU-K10", 115, 63, 62, 62, 78, 35, 13, 428, "June", "December"};
        Object [] row4 = {"GPU-K40C", 67, 35, 18, 51, 19, 68, 37, 295, "November", "August", "Min"};
        Object [] row5 = {"GPU-TITAN", 212, 89, 82, 69, 75, 55, 58, 640, "June", "November"};
        Object [] row6 = {"GPU-V100S", 224, 75, 8, 30, 175, 39, 37, 588, "June", "August"};
        
        Object [][] data = {row1, row2, row3, row4, row5, row6};
                
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
        jframe.setTitle("Number of Each Type of Partiton Being Used per Month");

        //Table Title
        JLabel title = new JLabel("Number of Each Type of Partiton Being Used per Month");
        title.setFont(new Font("Times New Roman", Font.BOLD, 18));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);
        jframe.add(title, BorderLayout.NORTH);

    }
}