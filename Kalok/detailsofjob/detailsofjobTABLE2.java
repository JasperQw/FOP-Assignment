package detailsofjob;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class detailsofjobTABLE2 {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    detailsofjobTABLE2() {
        // Frame initialization
        f = new JFrame();

        // Frame Title
        f.setTitle(" Total Jobs Completed, Allocated & Submitted by Months ");
        
        // Frame Font
        Font font = new Font("Arial", Font.BOLD, 20);
        f.setFont(font);

        // Data to be displayed in the JTable
        String[][] data = {
            { "    Average","1507", "1316","1211"},
            { "    Minimum","706", "551","452"},
            { "    Maximum","2423", "2191","1893"},

        };

        // Column Names
        String[] columnNames = { "Analysis metrics of jobs ","Jobs Submitted ", "Jobs Allocated", "Jobs Completion"};

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setSelectionBackground(Color.blue);
        j.setSelectionForeground(Color.RED);

        j.setRowHeight(50);
        TableColumnModel columnModel = j.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(1);
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(2).setPreferredWidth(1);

        j.setBackground(Color.green);
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
        f.setSize(900, 600);
        // Frame Visible = true
        f.setVisible(true);
    }
	    // Driver method
		public static void main(String[] args) {
			new detailsofjobTABLE2();
		}
	}
	


