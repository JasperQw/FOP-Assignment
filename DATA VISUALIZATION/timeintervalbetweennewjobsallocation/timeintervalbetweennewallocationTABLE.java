package timeintervalbetweennewjobsallocation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class timeintervalbetweennewallocationTABLE {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    timeintervalbetweennewallocationTABLE() {
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle("The Average time intervals between each Jobs Allocation (Inclusive of Incompelete work flow) ");
        
        // Frame Font
        Font font = new Font("Arial", Font.BOLD, 20);
        f.setFont(font);

        // Data to be displayed in the JTable
        String[][] data = {
            { "June", " 19 minutes 41.681 seconds","0.0137","0.3282","19.6947","1181.6816"},
            { "July", " 33 minutes 55.552 seconds","0.0236","0.5654","33.9259","2035.5529"},
            { "August"," 35 minutes 43.988 seconds","0.0248","0.5956","35.7331","2143.9880"},
            { "September", " 34 minutes 15.593 seconds","0.0238","0.5710","34.2599","2055.5931"},
            { "October", " 25 minutes 5.726 seconds","0.0174","0.4183","25.0954","1505.7266"},
            { "November"," 47 minutes 34.193 seconds","0.0330","0.7928","47.5699","2854.1938"},
            { "December"," 40 minutes 5.308 seconds","0.0278","0.6681","40.0885","2405.3081"},
            { "Overall"," 31 minutes 1.828 seconds","0.0215","0.5172","31.0305","1861.8285"},


        };

        // Column Names
        String[] columnNames = { "Month", "Average Time Intervals (YY DD HH mm ss.SSS)","(Days)","(Hours)","(Minutes)","(Seconds)" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setSelectionBackground(Color.CYAN);
        j.setSelectionForeground(Color.RED);

        j.setRowHeight(50);
        TableColumnModel columnModel = j.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(100);

        j.setBackground(Color.cyan);
        j.setForeground(Color.black);

        j.setBounds(30, 40, 200, 300);

        //set font for JTable content
        j.setFont(new Font("Arial", Font.PLAIN, 14));
        j.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setFont(new Font("Lucida Blackletter", Font.PLAIN, 17));
                return this;
            }   
        });
        
        //set font for JTable header
        j.getTableHeader().setFont(new Font("Party LET", Font.BOLD, 15));
        j.getTableHeader().setPreferredSize(new Dimension(250, 60));


        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(1200, 600);
        // Frame Visible = true
        f.setVisible(true);
    }
	    // Driver method
		public static void main(String[] args) {
			new timeintervalbetweennewallocationTABLE();
		}
	}
	


