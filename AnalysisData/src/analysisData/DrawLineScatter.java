package analysisData;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class DrawLineScatter {
	
	public void drawMixedFigure() {
				
		// 创建第一个数据集
        CategoryDataset categorydataset = createDataset();
        NumberAxis numberaxis = new NumberAxis("销量");
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        CategoryPlot categoryplot = new CategoryPlot(categorydataset, null,
                numberaxis, lineandshaperenderer);
        categoryplot.setDomainGridlinesVisible(true);
        // 创建第二个数据集
        CategoryDataset categorydataset1 = createDataset();
        NumberAxis numberaxis1 = new NumberAxis("销量");
        BarRenderer barrenderer = new BarRenderer();
        barrenderer
                .setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot categoryplot1 = new CategoryPlot(categorydataset1, null,
                numberaxis1, barrenderer);
        categoryplot1.setDomainGridlinesVisible(true);
        // 创建组合数据集
        CategoryAxis categoryaxis = new CategoryAxis();
        CombinedDomainCategoryPlot combineddomaincategoryplot = new CombinedDomainCategoryPlot(categoryaxis);
        combineddomaincategoryplot.add(categoryplot, 2);
        combineddomaincategoryplot.add(categoryplot1, 1);
        // 创建图表对象
        JFreeChart jfreechart = new JFreeChart("组合图", null, combineddomaincategoryplot, true);
        //Show the image in the chartFrame
 		ChartFrame frame=new ChartFrame("线性拟合",jfreechart);
 		frame.setVisible(true);
 		frame.pack();

	}
	
	/**
     * 返回数据集
     * 
     * @return
     */
    private static CategoryDataset createDataset() {
        // 时间维度
        String[] category1 = { "第一季度", "第二季度", "第三季度", "第四季度" };
        // 分类维度
        String[] category2 = { "JAVA", "C/C++", "PHP" };
        DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
        for (int i = 0; i < category1.length; i++) {
            String category = category1[i];
            for (int j = 0; j < category2.length; j++) {
                String cat = category2[j];
                // 模拟添加数据
                defaultdataset.addValue( j, cat, category);
            }
        }
        return defaultdataset;
    }
    
    public static void main(String[] args) {
    	DrawLineScatter dls = new DrawLineScatter();
    	dls.drawMixedFigure();
	}

}
