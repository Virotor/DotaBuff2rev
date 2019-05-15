import Help.ItemId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ControllerMatch {

    @FXML
    private LineChart GraphicAdvantage;
    @FXML
    private LineChart GraphicExp;
    @FXML
    private LineChart<Number, Number> GraphicGold;

    public void show(Stage primaryStage, PlayerMatchStatistics[] playerMatchStatistics, DataForGraphs dataForGraphs) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(ControllerMatch.class.getResource("match.fxml"));
        root = loader.load();
        Map<String, Object> namespace = loader.getNamespace();
        GraphicGold = (LineChart<Number, Number>) namespace.get("GraphicGold");
        GraphicExp = (LineChart<Number, Number>) namespace.get("GraphicExp");
        GraphicAdvantage = (LineChart<Number, Number>) namespace.get("GraphicAdvantage");
        this.graphicChangeGoldView(playerMatchStatistics);
        this.graphicChangeExpView(playerMatchStatistics);
        this.graphicAdvantage(dataForGraphs);
        this.assistText(namespace, playerMatchStatistics);
        this.damagetText(namespace, playerMatchStatistics);
        this.gpmText(namespace, playerMatchStatistics);
        this.xpmText(namespace, playerMatchStatistics);
        this.last_heatText(namespace, playerMatchStatistics);
        this.levelText(namespace, playerMatchStatistics);
        this.killText(namespace, playerMatchStatistics);
        this.healText(namespace, playerMatchStatistics);
        this.deathText(namespace, playerMatchStatistics);
        this.deniesText(namespace, playerMatchStatistics);
        /*GraphicGold = (LineChart<Number, Number>) namespace.get("GraphicGold");
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
        for (int i = 0; i < 40; i++) {
            datas.add(new XYChart.Data(i, Math.cos(i)));
            datas2.add(new XYChart.Data(i, Math.sin(i)));
        }
        series1.setData(datas);
        series2.setData(datas2);
        GraphicGold.getData().add(series1);
        GraphicGold.getData().add(series2);*/
        showItem(namespace, playerMatchStatistics);
        primaryStage.setTitle("DotaBuff");
        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.show();
    }

    private void showItem(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        String path = "ItemIcon/";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                File file = new File(path + ItemId.valueOf("i" + playerMatchStatistics[i].getHero_inventory().get(j).toString()).toString() + ".jpg");
                Image im = new Image(file.toURI().toString());
                ImageView image = (ImageView) namespace.get("item" + i + j);
                image.setImage(im);
            }
        }
    }

    private void assistText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("a" + i);
            textField.setText(playerMatchStatistics[i].getAssists().toString());
        }
    }

    private void killText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("k" + i);
            textField.setText(playerMatchStatistics[i].getKills().toString());
        }
    }

    private void deathText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("d" + i);
            textField.setText(playerMatchStatistics[i].getDeaths().toString());
        }
    }

    private void damagetText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("dam" + i);
            textField.setText(playerMatchStatistics[i].getHero_damage().toString());
        }
    }

    private void healText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("heal" + i);
            textField.setText(playerMatchStatistics[i].getHero_healing().toString());
        }
    }

    private void deniesText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("den" + i);
            textField.setText(playerMatchStatistics[i].getDenies().toString());
        }
    }

    private void levelText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("l" + i);
            textField.setText(playerMatchStatistics[i].getLevel().toString());
        }
    }

    private void last_heatText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("a" + i);
            textField.setText(playerMatchStatistics[i].getAssists().toString());
        }
    }

    private void xpmText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("a" + i);
            textField.setText(playerMatchStatistics[i].getXPM().toString());
        }
    }

    private void gpmText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            TextField textField = (TextField) namespace.get("a" + i);
            textField.setText(playerMatchStatistics[i].getGPM().toString());
        }
    }

    private void graphicChangeGoldView(PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            XYChart.Series series = new XYChart.Series();
            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            for (int j = 0; j < playerMatchStatistics[i].getGoldChange().size(); j++) {
                datas.add(new XYChart.Data(j, playerMatchStatistics[i].getGoldChange().get(j)));
            }
            series.setData(datas);
            GraphicGold.getData().add(series);
        }
    }

    private void graphicChangeExpView(PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            XYChart.Series series = new XYChart.Series();
            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            for (int j = 0; j < playerMatchStatistics[i].getExpChange().size(); j++) {
                datas.add(new XYChart.Data(j, playerMatchStatistics[i].getExpChange().get(j)));
            }
            series.setData(datas);
            GraphicExp.getData().add(series);
        }
    }

    private void graphicAdvantage(DataForGraphs dataForGraphs) {
        XYChart.Series seriesExp = new XYChart.Series();
        XYChart.Series seriesGold = new XYChart.Series();
        ObservableList<XYChart.Data> dataExp = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> dataGold = FXCollections.observableArrayList();
        for(int i=0;i<dataForGraphs.getNetWorse().size();i++){
            dataExp.add(new XYChart.Data(i, dataForGraphs.getExp().get(i)));
            dataGold.add(new XYChart.Data(i, dataForGraphs.getNetWorse().get(i)));
        }
        seriesExp.setData(dataExp);
        seriesGold.setData(dataGold);
        GraphicAdvantage.getData().add(seriesExp);
        GraphicAdvantage.getData().add(seriesGold);
        GraphicAdvantage.setCreateSymbols(false);
    }

}

