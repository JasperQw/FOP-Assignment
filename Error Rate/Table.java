package error.rate;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
        JFrame fr;
        JTable jt;
        public Table(String title,String[]columns,Object[][]data){
            fr = new JFrame(title);
            jt = new JTable(data,columns);
            jt.setBounds(30, 40, 200, 300);
            JScrollPane jsp = new JScrollPane(jt);
            fr.add(jsp);
            fr.setSize(500, 200);
            fr.setVisible(true);
        }
}
