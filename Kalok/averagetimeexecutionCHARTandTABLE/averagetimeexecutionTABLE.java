package averagetimeexecutionCHARTandTABLE;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class averagetimeexecutionTABLE {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    averagetimeexecutionTABLE() {
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle("Execution Time [From Jobs Allocated to Jobs Completed]");
        
        // Frame Font
        Font font = new Font("Arial", Font.BOLD, 20);
        f.setFont(font);

        // Data to be displayed in the JTable
        String[][] data = {
            { "June", "31093358.8470", " 4 hours 57 minutes 39.482 seconds","0.2067","4.9610","297.6580","17859.4824"},
            { "July", "30161651.4940", " 7 hours 43 minutes 18.757 seconds","0.3217","7.7219","463.3126","27798.7571"},
            { "August", "21841012.4700", " 6 hours 31 minutes 24.959 seconds","0.2718","6.5236","391.4160","23484.9596"},
            { "September", "32138759.4980", " 8 hours 35 minutes 2.563 seconds","0.3577","8.5841","515.0442","30902.6534"},
            { "October", "27099895.9350", " 4 hours 56 minutes 45.450 seconds","0.2061","4.9460","296.7575","17805.4507"},
            { "November", "29933438.9350", "11 hours 21 minutes 32.676 seconds","0.4733","11.3591","681.5446","40892.6761"},
            { "December", "12494709.0780", " 8 hours 56 minutes 42.858 seconds","0.3727","8.9452","536.7143","32202.8584"},
            { "Overall", "207561557.8840", " 7 hours 39 minutes 50.264 seconds","0.3193","7.6640","459.8377","27590.2642"},


        };

        // Column Names
        String[] columnNames = { "Month", "Total Time Execution (seconds)", "Average Time Execution (YY DD HH mm ss.SSS)","(Days)","(Hours)","(Minutes)","(Seconds)" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setSelectionBackground(Color.CYAN);
        j.setSelectionForeground(Color.RED);

        j.setRowHeight(50);
        TableColumnModel columnModel = j.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(190);

        columnModel.getColumn(2).setPreferredWidth(320);

        j.setBackground(Color.PINK);
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
			new averagetimeexecutionTABLE();
		}
	}
	


