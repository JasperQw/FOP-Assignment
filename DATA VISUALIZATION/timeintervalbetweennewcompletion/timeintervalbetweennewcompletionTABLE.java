package timeintervalbetweennewcompletion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class timeintervalbetweennewcompletionTABLE {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    timeintervalbetweennewcompletionTABLE() {
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle("The Average time intervals between each Jobs Completion (Inclusive of Incompelete work flow) ");
        
        // Frame Font
        Font font = new Font("Arial", Font.BOLD, 20);
        f.setFont(font);

        // Data to be displayed in the JTable
        String[][] data = {
            { "June", " 22 minutes 45.723 seconds","0.0158","0.3794","22.7621","1365.7234"},
            { "July", " 38 minutes 51.790 seconds","0.0270","0.6477","38.8632","2331.7901"},
            { "August"," 36 minutes 56.836 seconds","0.0257","0.6158","36.9473","2216.8367"},
            { "September", " 37 minutes 23.948 seconds","0.0260","0.6233","37.3991","2243.9487"},
            { "October", " 28 minutes 26.320 seconds","0.0197","0.4740","28.4387","1706.3208"},
            { "November","39 minutes 13.786 seconds","0.0272","0.6538","39.2298","2353.7867"},
            { "December"," 49 minutes 44.237 seconds","0.0345","0.8290","49.7373","2984.2379"},
            { "Overall"," 33 minutes 43.575 seconds","0.0234","0.5621","33.7263","2023.5759"},


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
			new timeintervalbetweennewcompletionTABLE();
		}
	}
	


