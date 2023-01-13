// Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;


public class JTableExamples {
	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	JTableExamples()
	{
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("JTable Example");

		// Data to be displayed in the JTable
		String[][] data = {
			{ "Kundan Kumar Jha", "4031", "CSE"},
			{ "Anand Jha", "6014", "IT"}
		};

		// Column Names
		String[] columnNames = { "Name", "Roll Number", "Department","try" };

		// Initializing the JTable
		j = new JTable(data, columnNames);
		j.setSelectionBackground(Color.CYAN);
		j.setSelectionForeground(Color.RED);
		
		j.setRowHeight(50);

		j.setBackground(Color.PINK);
		j.setForeground(Color.black);


		j.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		f.setVisible(true);
		
	}

	// Driver method
	public static void main(String[] args)
	{
		new JTableExamples();
	}
}
