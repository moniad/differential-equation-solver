package monika.dziedzic.agh.edu.pl;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

class Chart extends ApplicationFrame
{
    Chart(String title, String chartTitle, float[] matrixU, int n)
    {
        super(title);
        n--;
        final XYSeries series = new XYSeries("");

        series.add(0.0,5.0);

        double x = (double) 1/n;
        int i = 1;
        while (x <= 1.0)
        {
            series.add(x,matrixU[i]);
            x += (double) 1/n;
            i++;
        }

        series.add(1.0,matrixU[i-1]);

        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Convection-diffusion chart",
                "x", "y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1300, 800));
        setContentPane(chartPanel);
    }
}