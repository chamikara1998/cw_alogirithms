package components;

import algorithm.MaximumFlowProcessor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;

public class MaxFlowAnalyserGUI extends Application implements Component {

    private XYChart.Series series;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Max Flow Algorithm Performance");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Nodes of Flow Network");
        yAxis.setLabel("Time in Millis");
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);
        series = new XYChart.Series();
        analyseAlgorithm();
        series.setName("Algorithm Performance");
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }

    private void analyseAlgorithm() {
        int[] algorithmNodeAmounts = {6, 12, 24, 48};

        for (int algorithmNodeAmount : algorithmNodeAmounts) {
            int[][] dataSet = new int[algorithmNodeAmount][algorithmNodeAmount];
            for (int i = 0; i < algorithmNodeAmount; i++){
                for(int j = 0; j< algorithmNodeAmount; j++){
                    Random rand = new Random();
                    dataSet[i][j] = rand.nextInt(25);
                }
            }
            calculateProcessingTimeAndPublishGraph(dataSet);
        }
    }

    private void calculateProcessingTimeAndPublishGraph(int[][] dataSet) {
        MaximumFlowProcessor maximumFlowProcessor = new MaximumFlowProcessor();
        long startTime = System.currentTimeMillis();
        maximumFlowProcessor.getMaxFlow(dataSet, 0, 5);
        long endTime = System.currentTimeMillis();
        series.getData().add(new XYChart.Data(dataSet[0].length, (endTime - startTime)));
    }

    @Override
    public void render() {
        Application.launch(MaxFlowAnalyserGUI.class);
    }
}
