package timeintervalbetweenewsubmission;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class timeintervalbetweennewsubmissionTABLE {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    timeintervalbetweennewsubmissionTABLE() {
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle("The Average time intervals between each new Jobs Submission (Inclusive of Incompelete work flow) ");
        
        // Frame Font
        Font font = new Font("Arial", Font.BOLD, 20);
        f.setFont(font);

        // Data to be displayed in the JTable
        String[][] data = {
            { "June", " 17 minutes 48.490 seconds","0.0124","0.2968","17.8082","1068.4902"},
            { "July", " 30 minutes 36.837 seconds","0.0213","0.5102","30.6140","1836.8371"},
            { "August"," 28 minutes 49.331 seconds","0.0200","0.4804","28.8222","1729.3319"},
            { "September", " 31 minutes 11.304 seconds","0.0217","0.5198","31.1884","1871.3043"},
            { "October", " 23 minutes 51.278 seconds","0.0166","0.3976","23.8546","1431.2786"},
            { "November","35 minutes 22.236 seconds","0.0246","0.5895","35.3706","2122.2367"},
            { "December"," 31 minutes 17.107 seconds","0.0217","0.5214","31.2851","1877.1070"},
            { "Overall"," 27 minutes 6.119 seconds","0.0188","0.4517","27.1020","1626.1199"},


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
			new timeintervalbetweennewsubmissionTABLE();
		}
	}
	


