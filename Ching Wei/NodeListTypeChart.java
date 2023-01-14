import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class NodeListTypeChart extends JPanel
{
    private int histogramHeight = 200;
    private int barWidth = 50;
    private int barGap = 10;
  

    private JPanel barPanel;
    private JPanel labelPanel;
    

    private List<Bar> bars = new ArrayList<Bar>();

    
    public NodeListTypeChart()
    {   
        
        setBorder( new EmptyBorder(10, 10, 10, 10) );
        setLayout( new BorderLayout() );

        JLabel titleLabel = new JLabel("Number of Each Type of Partiton Being Used");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.PAGE_START);

        barPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
        Border inner = new EmptyBorder(10, 10, 0, 10);
        Border compound = new CompoundBorder(outer, inner);
        barPanel.setBorder( compound );

        labelPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        labelPanel.setBorder( new EmptyBorder(5, 10, 0, 10) );
        
        add(barPanel, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.PAGE_END);

        

    }

    public void addHistogramColumn(String label, int value, Color color)
    {
        Bar bar = new Bar(label, value, color);
        bars.add( bar );
    }

    public void layoutHistogram()
    {
        barPanel.removeAll();
        labelPanel.removeAll();

        int maxValue = 0;

        for (Bar bar: bars)
            maxValue = Math.max(maxValue, bar.getValue());

        for (Bar bar: bars)
        {
            JLabel label = new JLabel(bar.getValue() + "");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.TOP);
            label.setVerticalAlignment(JLabel.BOTTOM);
            int barHeight = (bar.getValue() * histogramHeight) / maxValue;
            Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
            label.setIcon( icon );
            barPanel.add( label );

            JLabel barLabel = new JLabel( bar.getLabel() );
            barLabel.setHorizontalAlignment(JLabel.CENTER);
            labelPanel.add( barLabel );
        }
    }

    private class Bar
    {
        private String label;
        private int value;
        private Color color;

        public Bar(String label, int value, Color color)
        {
            this.label = label;
            this.value = value;
            this.color = color;
        }

        public String getLabel()
        {
            return label;
        }

        public int getValue()
        {
            return value;
        }

        public Color getColor()
        {
            return color;
        }
    }

    private class ColorIcon implements Icon
    {
        private int shadow = 3;

        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width - shadow, height);
            g.setColor(Color.GRAY);
            g.fillRect(x + width - shadow, y + shadow, shadow, height - shadow);
        }
    }

    private static void createAndShowGUI()
    {
        PartitionCountChart panel = new PartitionCountChart();
        
        panel.addHistogramColumn("cpu01", 971, Color.blue);
        panel.addHistogramColumn("cpu03", 675, Color.blue);
        panel.addHistogramColumn("cpu04", 528, Color.blue);
        panel.addHistogramColumn("cpu05", 360, Color.blue);
        panel.addHistogramColumn("cpu07", 311, Color.blue);
        panel.addHistogramColumn("cpu08", 229, Color.blue);
        panel.addHistogramColumn("cpu09", 344, Color.blue);
        panel.addHistogramColumn("cpu10", 381, Color.blue);
        panel.addHistogramColumn("cpu11", 610, Color.blue);
        panel.addHistogramColumn("cpu12", 788, Color.blue);
        panel.addHistogramColumn("cpu13", 668, Color.blue);
        panel.addHistogramColumn("cpu14", 436, Color.blue);
        panel.addHistogramColumn("cpu15", 584, Color.blue);
        //panel.addHistogramColumn("cpu[01,03-04,09]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[01,03]", 3, Color.blue);
        //panel.addHistogramColumn("cpu[01,04,09,11]", 3, Color.blue);
        //panel.addHistogramColumn("cpu[01,04]", 5, Color.blue);
        //panel.addHistogramColumn("cpu[01,09-11]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[03,07]", 10, Color.blue);
        //panel.addHistogramColumn("cpu[03,09]", 23, Color.blue);
        //panel.addHistogramColumn("cpu[03,11]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[03-04]", 4, Color.blue);
        //panel.addHistogramColumn("cpu[04-05,07-08,11]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[04-05]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[07,11]", 4, Color.blue);
        //panel.addHistogramColumn("cpu[07-08]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[08-09]", 3, Color.blue);
        //panel.addHistogramColumn("cpu[08-11]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[09,11]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[09-10]", 27, Color.blue);
        //panel.addHistogramColumn("cpu[10-11]", 10, Color.blue);
        //panel.addHistogramColumn("cpu[12,14-15]", 2, Color.blue);
        //panel.addHistogramColumn("cpu[12,15]", 1, Color.blue);
        //panel.addHistogramColumn("cpu[12-13,15]", 4, Color.blue);
        //panel.addHistogramColumn("cpu[12-13]", 163, Color.blue);
        //panel.addHistogramColumn("cpu[12-15]", 101, Color.blue);
        //panel.addHistogramColumn("cpu[13,15]", 2, Color.blue);
        //panel.addHistogramColumn("cpu[13-14]", 4, Color.blue);
        //panel.addHistogramColumn("cpu[14-15]", 3, Color.blue);
        panel.addHistogramColumn("gpu01", 222, Color.blue);
        panel.addHistogramColumn("gpu02", 640, Color.blue);
        panel.addHistogramColumn("gpu03", 206, Color.blue);
        panel.addHistogramColumn("gpu04", 295, Color.blue);
        panel.addHistogramColumn("gpu05", 588, Color.blue);

        panel.layoutHistogram();

        JFrame frame = new JFrame("Nodelist Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}