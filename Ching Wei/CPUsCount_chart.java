import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class CPUsCount_chart extends JPanel
{
    private int histogramHeight = 200;
    private int barWidth = 50;
    private int barGap = 10;
  

    private JPanel barPanel;
    private JPanel labelPanel;
    

    private List<Bar> bars = new ArrayList<Bar>();

    
    public CPUsCount_chart()
    {   
        
        setBorder( new EmptyBorder(10, 10, 10, 10) );
        setLayout( new BorderLayout() );

        JLabel titleLabel = new JLabel("Number of CPUs Being Used");
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
        
        panel.addHistogramColumn("1", 860, Color.blue);
        panel.addHistogramColumn("10", 55, Color.blue);
        panel.addHistogramColumn("11", 13, Color.blue);
        panel.addHistogramColumn("12", 116, Color.blue);
        panel.addHistogramColumn("128", 1, Color.blue);
        panel.addHistogramColumn("14", 6, Color.blue);
        panel.addHistogramColumn("15", 5, Color.blue);
        panel.addHistogramColumn("16", 2325, Color.blue);
        panel.addHistogramColumn("18", 4, Color.blue);
        panel.addHistogramColumn("2", 197, Color.blue);
        panel.addHistogramColumn("20", 20, Color.blue);
        panel.addHistogramColumn("22", 7, Color.blue);
        panel.addHistogramColumn("24", 332, Color.blue);
        panel.addHistogramColumn("3", 4, Color.blue);
        panel.addHistogramColumn("30", 18, Color.blue);
        panel.addHistogramColumn("31", 2, Color.blue);
        panel.addHistogramColumn("32", 1473, Color.blue);
        panel.addHistogramColumn("34", 1, Color.blue);
        panel.addHistogramColumn("35", 24, Color.blue);
        panel.addHistogramColumn("36", 3, Color.blue);
        panel.addHistogramColumn("39", 3, Color.blue);
        panel.addHistogramColumn("4", 517, Color.blue);
        panel.addHistogramColumn("40", 3, Color.blue);
        panel.addHistogramColumn("45", 1, Color.blue);
        panel.addHistogramColumn("48", 394, Color.blue);
        panel.addHistogramColumn("5", 82, Color.blue);
        panel.addHistogramColumn("50", 17, Color.blue);
        panel.addHistogramColumn("56", 3, Color.blue);
        panel.addHistogramColumn("6", 56, Color.blue);
        panel.addHistogramColumn("60", 2, Color.blue);
        panel.addHistogramColumn("64", 659, Color.blue);
        panel.addHistogramColumn("7", 4, Color.blue);
        panel.addHistogramColumn("8", 2007, Color.blue);
        panel.addHistogramColumn("96", 2, Color.blue);

        panel.layoutHistogram();

        JFrame frame = new JFrame("CPUs Count");
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