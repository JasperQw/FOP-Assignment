import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Font;

public class ChartUser extends Application {
   public void start(Stage stage) {                 
      CategoryAxis xAxis = new CategoryAxis(); 
      xAxis.setTickLabelFont(new Font(12)); // set font size
      xAxis.setTickLabelRotation(90); // rotate names by 90 degrees
      xAxis.setCategories(FXCollections.<String>
      observableArrayList(Arrays.asList("yatyuen", "farhatabjani", "aah", "lin0618","janvik","xinpeng","kurk","mk_98", "hva170037", "htt_felicia", "fairus", "han", "f4ww4z", "manoj", "ongkuanhung", "liew","shahreeza", "hass", "chiuling" ,"hongvin","lobbeytan", "fahmi8" ,"tingweijing", "aznul" ,"roland","noraini")));
      xAxis.setLabel("Users");
       
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("Number of errors");
     
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("Users and Number of This Association Errors Made");
        
      //Prepare XYChart.Series objects by setting data       
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("This association error");
      series1.getData().add(new XYChart.Data<>("yatyuen", 1));
      series1.getData().add(new XYChart.Data<>("farhatabjani", 3));
      series1.getData().add(new XYChart.Data<>("aah", 12));
      series1.getData().add(new XYChart.Data<>("lin0618", 4));
      series1.getData().add(new XYChart.Data<>("janvik", 4));
      series1.getData().add(new XYChart.Data<>("xinpeng", 1));
      series1.getData().add(new XYChart.Data<>("kurk", 1));
      series1.getData().add(new XYChart.Data<>("mk_98", 24));
      series1.getData().add(new XYChart.Data<>("hva170037", 5));
      series1.getData().add(new XYChart.Data<>("htt_felicia", 21));
      series1.getData().add(new XYChart.Data<>("fairus", 10));
      series1.getData().add(new XYChart.Data<>("han", 11));
      series1.getData().add(new XYChart.Data<>("f4ww4z", 4));
      series1.getData().add(new XYChart.Data<>("manoj", 4));
      series1.getData().add(new XYChart.Data<>("ongkuanhung", 1));
      series1.getData().add(new XYChart.Data<>("liew", 3));
      series1.getData().add(new XYChart.Data<>("shahreeza", 6));
      series1.getData().add(new XYChart.Data<>("hass", 1));
      series1.getData().add(new XYChart.Data<>("chiuling", 2));
      series1.getData().add(new XYChart.Data<>("hongvin", 9));
      series1.getData().add(new XYChart.Data<>("lobbeytan", 3));
      series1.getData().add(new XYChart.Data<>("fahmi8", 1));
      series1.getData().add(new XYChart.Data<>("tingweijing", 2));
      series1.getData().add(new XYChart.Data<>("aznul", 2));
      series1.getData().add(new XYChart.Data<>("roland", 4));
      series1.getData().add(new XYChart.Data<>("noraini", 4));

      barChart.getData().addAll(series1);
      Group root = new Group(barChart);
      Scene scene = new Scene(root, 600, 600);
      barChart.setPrefSize(600, 600);
      barChart.setMinWidth(600);
      barChart.setMinHeight(600);
      barChart.setMaxWidth(600);
      barChart.setMaxHeight(600);
      stage.setTitle("Bar Chart");
      stage.setScene(scene);
      stage.show();   
   }
   public static void main(String args[]){
      launch(args);
   }
}
