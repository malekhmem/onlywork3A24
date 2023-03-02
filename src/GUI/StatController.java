package GUI;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
//import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;


public class StatController {
    Connection cnx;

    @FXML
    private TextField materialNameTextField;
    @FXML
    private PieChart statisticsChart;
    @FXML
    private Pane pnLesMateriels;
    @FXML
    private Label lbidmateriel;
    @FXML
    private Label lbstat;
    @FXML
    private Label lbRetour;

    @FXML
    void showStatistics(ActionEvent event) throws SQLException {
        String materialName = materialNameTextField.getText();
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        String qry = "SELECT marque, prix FROM materiel WHERE nomm = ?";
        cnx = Utils.MyDB.getInstance().getCnx();
        PreparedStatement stm = cnx.prepareStatement(qry);
        stm.setString(1, materialName);
        ResultSet rs = stm.executeQuery();
        
        double total = 0;
        while (rs.next()) {
            total += rs.getDouble("prix");
        }
        rs.beforeFirst();
        while (rs.next()) {
            double price = rs.getDouble("prix");
            double percentage = price / total * 100;
            String brand = rs.getString("marque");
            dataset.setValue(brand + " (" + String.format("%.2f", percentage) + "%)", price);
        }
        JFreeChart chart = ChartFactory.createPieChart3D("Statistiques du matériel", dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        ChartPanel chartPanel = new ChartPanel(chart);
        statisticsChart.getData().add(new PieChart.Data("", 0));
        statisticsChart.getData().clear();
        for (PieChart.Data data : statisticsChart.getData()) {
    data.getNode().setVisible(false);
}

for (Object obj : dataset.getKeys()) {
    String key = (String) obj;
    Number value = dataset.getValue(key);
    PieChart.Data data = new PieChart.Data(key, value.doubleValue());
    statisticsChart.getData().add(data);
}
    }

    @FXML
    private void fnfront(MouseEvent event) {
                                       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
}
