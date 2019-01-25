package monika.dziedzic.agh.edu.pl;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;

class Chart extends ApplicationFrame
{
    public Chart(String title, String chartTitle, float[] matrixU, int n)
    {
        super(title);

        //adding points to the series
        final XYSeries series = new XYSeries("");

        int i=1;
        for (float x=(float) 1/n; x<=1.0; i++, x+=(float) 1/n)
            series.add(x,matrixU[i]);

        //points linked with BVP
        series.add(0.0,5.0);
        series.add(1.0,matrixU[i-1]);

        //create chart
        final XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
            chartTitle,
            "x", "y",
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        //adjust chart
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        final XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }
}