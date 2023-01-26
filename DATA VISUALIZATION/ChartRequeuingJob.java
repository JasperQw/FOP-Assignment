
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
public class ChartRequeuingJob extends Application{
   public void start(Stage stage) {                 
      CategoryAxis xAxis = new CategoryAxis();  
      xAxis.setCategories(FXCollections.<String>
      observableArrayList(Arrays.asList("June", "July", "August", "September","October","November","December")));
      xAxis.setLabel("Month");
       
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("Number of requeuing job");
     
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("Number of Requeuing Job According Month");
        
      //Prepare XYChart.Series objects by setting data       
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("Error");
      series1.getData().add(new XYChart.Data<>("June", 21));
      series1.getData().add(new XYChart.Data<>("July", 1));
      series1.getData().add(new XYChart.Data<>("August", 14));
      series1.getData().add(new XYChart.Data<>("September", 5));
      series1.getData().add(new XYChart.Data<>("October", 4));
      series1.getData().add(new XYChart.Data<>("November", 16));
      series1.getData().add(new XYChart.Data<>("December", 15));
      
      barChart.getData().addAll(series1);
      Group root = new Group(barChart);
      Scene scene = new Scene(root, 600, 400);
      stage.setTitle("Bar Chart");
      stage.setScene(scene);
      stage.show();        
   }
   public static void main(String args[]){
      launch(args);
   }
}
