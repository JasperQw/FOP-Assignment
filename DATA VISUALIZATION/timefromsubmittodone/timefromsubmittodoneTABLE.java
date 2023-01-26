package timefromsubmittodone;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class timefromsubmittodoneTABLE {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    timefromsubmittodoneTABLE() {
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle("Jobs Flow Time [From Jobs Submitted to Jobs Completed] ");
        
        // Frame Font
        Font font = new Font("Arial", Font.BOLD, 20);
        f.setFont(font);

        // Data to be displayed in the JTable
        String[][] data = {
            { "June", "39585115.9740", " 6 hours 20 minutes 28.786 seconds","0.2642","6.3413","380.4798","22828.7866"},
            { "July", "47155614.0100", " 12 hours 14 minutes 30.667 seconds","0.5101","12.2419","734.5111","44070.6673"},
            { "August", "40844591.0030", " 12 hours 47 minutes 28.016 seconds","0.5330","12.7911","767.4669","46048.0169"},
            { "September", "55010105.1080", " 15 hours 0 minutes 37.431 seconds","0.6254","15.0104","900.6239","54037.4313"},
            { "October", "49638341.1280", " 9 hours 16 minutes 43.998 seconds","0.3866","9.2789","556.7333","33403.9981"},
            { "November", "63392379.7910", "1 days 2 hours 28 minutes 46.886 seconds","1.1033","26.4797","1588.7814","95326.8869"},
            { "December", "22415876.2700", " 17 hours 20 minutes 39.766 seconds","0.7227","17.3444","1040.6628","62439.7668"},
            { "Overall", "378798010.5670", " 14 hours 18 minutes 1.110 seconds","0.5958","14.3003","858.0185","51481.1104"},


        };

        // Column Names
        String[] columnNames = { "Month", "Total Time Flows (seconds)", "Average Time Flows (YY DD HH mm ss.SSS)","(Days)","(Hours)","(Minutes)","(Seconds)" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setSelectionBackground(Color.CYAN);
        j.setSelectionForeground(Color.RED);

        j.setRowHeight(50);
        TableColumnModel columnModel = j.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(190);
        columnModel.getColumn(2).setPreferredWidth(320);

        j.setBackground(Color.orange);
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
			new timefromsubmittodoneTABLE();
		}
	}
	


