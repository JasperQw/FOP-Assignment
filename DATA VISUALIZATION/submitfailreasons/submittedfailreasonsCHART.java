package submitfailreasons;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;


public class submittedfailreasonsCHART extends JPanel
{
    private int histogramHeight = 200;
    private int barWidth = 50;
    private int barGap = 10;
  
    private JPanel barPanel;
    private JPanel labelPanel;
    private JPanel legendPanel;
    private List<Bar> bars = new ArrayList<Bar>();

    public submittedfailreasonsCHART()
    {   
        setLayout( new BorderLayout() );

        JLabel titleLabel = new JLabel("Types of Job Submission Failure reasons ");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.PAGE_START);

        barPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
        Border inner = new EmptyBorder(10, 10, 0, 10);
        Border compound = new CompoundBorder(outer, inner);
        barPanel.setBorder( compound );
        barPanel.setPreferredSize(new Dimension(bars.size() * (barWidth + barGap), histogramHeight));

        labelPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        labelPanel.setBorder( new EmptyBorder(5, 10, 0, 10) );
        labelPanel.setPreferredSize(new Dimension(bars.size() * (barWidth + barGap), 25));

        JScrollPane scrollPane = new JScrollPane(barPanel);
        add(scrollPane, BorderLayout.CENTER);
        scrollPane = new JScrollPane(labelPanel);
        add(scrollPane, BorderLayout.PAGE_END);

        legendPanel = new JPanel(new GridLayout(0, 1));
        legendPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(legendPanel, BorderLayout.LINE_END);
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
    legendPanel.removeAll();

    int maxValue = 0;

    for (Bar bar: bars)
        maxValue = Math.max(maxValue, bar.getValue());

    for (Bar bar: bars)
    {
        JLabel barLabel = new JLabel(bar.getValue() + "");
        barLabel.setHorizontalTextPosition(JLabel.CENTER);
        barLabel.setHorizontalAlignment(JLabel.CENTER);
        barLabel.setVerticalTextPosition(JLabel.TOP);
        barLabel.setVerticalAlignment(JLabel.BOTTOM);
        int barHeight = (bar.getValue() * histogramHeight) / maxValue;
        Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
        barLabel.setIcon( icon );
        barPanel.add( barLabel );

        JLabel label = new JLabel( bar.getLabel() );
        label.setHorizontalAlignment(JLabel.CENTER);
        labelPanel.add( label );

        JLabel legendLabel = new JLabel(bar.getLabel());
        legendLabel.setIcon(new ColorIcon(bar.getColor(), 20, 20));
        legendPanel.add(legendLabel);
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
        g.fillRect(x, y, width, height);
    }
}


    private static void createAndShowGUI()
    {
        submittedfailreasonsCHART panel = new submittedfailreasonsCHART();
        panel.addHistogramColumn("Invalid partition name specified", 40, Color.black);
        panel.addHistogramColumn("Invalid qos specification", 152, Color.magenta);
        panel.addHistogramColumn("Job violates accounting/QOS policy", 132, Color.red);
        panel.addHistogramColumn("Requested node configuration is not available", 119, Color.green);
        panel.addHistogramColumn("Invalid node name specified", 1, Color.cyan);
        panel.addHistogramColumn("Requested reservation is invalid", 1, Color.yellow);
        panel.addHistogramColumn("Invalid account or account/partition combination specified", 23, Color.orange);
        panel.layoutHistogram();

        JFrame frame = new JFrame("Histogram Panel");
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