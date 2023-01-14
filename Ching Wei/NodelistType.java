import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class NodelistType  {
    
    public static void main(String [] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader("jobsallocatedfull.txt"));
        ArrayList<String> TypeofNode = new ArrayList<>();
        ArrayList<Integer> TypeofNodeCount = new ArrayList<>();

        while(reader.hasNextLine()) {
            String temp = reader.nextLine();
            String [] tempoArray = temp.split(" ");
            
            if (TypeofNode.indexOf(tempoArray[4].replaceAll("NodeList=", "")) == -1) {
                TypeofNode.add(tempoArray[4].replaceAll("NodeList=", ""));
            }
        }
        Collections.sort(TypeofNode);

        System.out.println("Count All");
        for (int i = 0; i < TypeofNode.size(); i ++) {
            int counting = NodeCount(TypeofNode.get(i), '6', true);
            TypeofNodeCount.add(counting);
        }


            Object[] NodelistType = TypeofNode.toArray();
            Object[] NodelistTypeCount = TypeofNodeCount.toArray();
        
            String [] col_names = {"Nodelist Type", "Amount"};
            Object[][] data = new Object [NodelistType.length][col_names.length];
    
            for (int i = 0; i < NodelistType.length; i ++) {
                data[i][0] = NodelistType[i];
            }
    
            for (int i = 0; i < NodelistTypeCount.length; i ++) {
                data[i][1] = NodelistTypeCount[i];
            }
            
                    
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
            jframe.setTitle("Number of Jobs Completed per Month");
    
            //Table Title
            JLabel title = new JLabel("Number of Jobs Completed per Month");
            title.setFont(new Font("Times New Roman", Font.BOLD, 18));
            title.setForeground(Color.BLACK);
            title.setHorizontalAlignment(JLabel.CENTER);
            jframe.add(title, BorderLayout.NORTH);
    
        }


    public static int NodeCount(String TypeofNode, char month, boolean countAll) throws FileNotFoundException {
        
        Scanner read = new Scanner(new FileReader("jobsallocatedfull.txt"));
        int counting = 0;

        if (countAll == false) {
        while(read.hasNextLine()) {
            String temp = read.nextLine();

                if (temp.contains(TypeofNode) && temp.charAt(7) == month) {
                    counting ++;
                }   
        }

        if (counting != 0)
            System.out.println(TypeofNode + ": " + counting);
    }

    if (countAll == true) {
        while(read.hasNextLine()) {
            String temp = read.nextLine();

                if (temp.contains(TypeofNode)) {
                    counting ++;
                }   
        }

        if (counting != 0)
            System.out.println(TypeofNode + ": " + counting);
    }
    return counting;
}
}
