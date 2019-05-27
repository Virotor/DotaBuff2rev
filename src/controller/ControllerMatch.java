package controller;

import Help.HeroId;
import Help.ItemId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ModelCancel;
import statistics.DataForGraphs;
import statistics.PlayerMatchStatistics;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ControllerMatch {

    @FXML
    private LineChart GraphicAdvantage;
    @FXML
    private LineChart GraphicExp;
    @FXML
    private LineChart GraphicGold;
    static private Stage stage;


    public void show(Stage primaryStage, PlayerMatchStatistics[] playerMatchStatistics, DataForGraphs dataForGraphs, Tab tab) throws IOException {
        Parent root;
        stage = primaryStage;
        FXMLLoader loader = new FXMLLoader(ControllerMatches.class.getResource("match.fxml"));
        root = loader.load();
        Map<String, Object> namespace = loader.getNamespace();
        GraphicGold = (LineChart<Number, Number>) namespace.get("GraphicGold");
        GraphicExp = (LineChart<Number, Number>) namespace.get("GraphicExp");
        GraphicAdvantage = (LineChart<Number, Number>) namespace.get("GraphicAdvantage");
        this.showName(namespace, playerMatchStatistics, dataForGraphs);
        this.graphicChangeGoldView(playerMatchStatistics);
        this.graphicChangeExpView(playerMatchStatistics);
        this.graphicAdvantage(dataForGraphs);
        this.assistText(namespace, playerMatchStatistics);
        this.damagetText(namespace, playerMatchStatistics);
        this.wText(namespace, playerMatchStatistics);
        this.imageSet(namespace, playerMatchStatistics, dataForGraphs);
        this.gpmText(namespace, playerMatchStatistics);
        this.xpmText(namespace, playerMatchStatistics);
        this.last_heatText(namespace, playerMatchStatistics);
        this.levelText(namespace, playerMatchStatistics);
        this.killText(namespace, playerMatchStatistics);
        this.healText(namespace, playerMatchStatistics);
        this.deathText(namespace, playerMatchStatistics);
        this.deniesText(namespace, playerMatchStatistics);
        showItem(namespace, playerMatchStatistics);
        if(tab!=null){
            tab.setContent(root);
            tab.setText("Match");
        }

    }

    private void showName(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics, DataForGraphs dataForGraphs) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("name" + i);
            textField.setText(playerMatchStatistics[i].getNickName());
            if (playerMatchStatistics[i].getAccount_id() != 0) {
                Object finalObject = playerMatchStatistics[i].getAccount_id();
                textField.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    WaitMenu waitMenu = new WaitMenu();
                    try {
                        ModelCancel.setCodeOfOperation(3);
                        ModelCancel.setPlayerMatchStatisticsStack(playerMatchStatistics);
                        ModelCancel.setDataForGraphsStack(dataForGraphs);
                        waitMenu.waitProfile(stage, finalObject.toString());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                textField.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                    textField.setUnderline(true);
                    Color color = new Color(0.2, 0.2, 0.5, 1);
                    textField.setFill(color);
                });
                textField.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                    textField.setUnderline(false);
                    Color color = new Color(0, 0, 0.0, 1);
                    textField.setFill(color);
                });
            }
        }
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
       /* for (int i = 0; i < 10; i++) {
            for (int j = 6; j < 9; j++) {
            File file = new File(path + ItemId.valueOf("i" + playerMatchStatistics[i].getBackPack().get(j - 6).toString()).toString() + ".jpg");
            Image im = new Image(file.toURI().toString());
            ImageView image = (ImageView) namespace.get("item" + i + j);
            image.setImage(im);
        }
    }*/
    }

    private void assistText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("a" + i);
            textField.setText(playerMatchStatistics[i].getAssists().toString());
        }
    }

    private void killText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("k" + i);
            textField.setText(playerMatchStatistics[i].getKills().toString());
        }
    }

    private void deathText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("d" + i);
            textField.setText(playerMatchStatistics[i].getDeaths().toString());
        }
    }

    private void damagetText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("dam" + i);
            String text = playerMatchStatistics[i].getHero_damage().toString();
            textField.setText(text);
        }
    }

    private void healText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("heal" + i);
            textField.setText(playerMatchStatistics[i].getHero_healing().toString());
        }
    }

    private void deniesText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("den" + i);
            textField.setText(playerMatchStatistics[i].getDenies().toString());
        }
    }

    private void levelText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("l" + i);
            textField.setText(playerMatchStatistics[i].getLevel().toString());
        }
    }

    private void last_heatText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("h" + i);
            textField.setText(playerMatchStatistics[i].getLast_hits().toString());
        }
    }

    private void xpmText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("x" + i);
            textField.setText(playerMatchStatistics[i].getXPM().toString());
        }
    }

    private void wText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("w" + i);
            textField.setText(playerMatchStatistics[i].getNetWorse().toString());
        }
    }

    private void gpmText(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics) {
        for (int i = 0; i < 10; i++) {
            Text textField = (Text) namespace.get("g" + i);
            textField.setText(playerMatchStatistics[i].getGPM().toString());
        }
    }

    private void graphicChangeGoldView(PlayerMatchStatistics[] playerMatchStatistics) {
        if (!playerMatchStatistics[0].getExpChange().isEmpty()) {
            for (int i = 0; i < 10; i++) {
                XYChart.Series series = new XYChart.Series();
                ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
                for (int j = 0; j < playerMatchStatistics[i].getGoldChange().size(); j++) {
                    datas.add(new XYChart.Data(j, playerMatchStatistics[i].getGoldChange().get(j)));
                    Node node = datas.get(j).getNode();
                    Tooltip tooltip = new Tooltip('(' + datas.get(j).getXValue().toString() + ';' + datas.get(j).getYValue().toString() + ')');
                    Tooltip.install(node, tooltip);
                }
                series.setData(datas);
                series.setName(HeroId.valueOf("h" + playerMatchStatistics[i].getHero_id().toString()).toString());
                GraphicGold.getData().add(series);
                GraphicGold.setTitle("График золота");
            }
        }
    }

    private void graphicChangeExpView(PlayerMatchStatistics[] playerMatchStatistics) {
        if (!playerMatchStatistics[0].getExpChange().isEmpty()) {
            for (int i = 0; i < 10; i++) {
                XYChart.Series series = new XYChart.Series();
                ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
                for (int j = 0; j < playerMatchStatistics[i].getExpChange().size(); j++) {
                    datas.add(new XYChart.Data(j, playerMatchStatistics[i].getExpChange().get(j)));
                    Tooltip.install(series.getNode(), new Tooltip(playerMatchStatistics[i].getExpChange().get(j).toString()));
                }
                series.setData(datas);
                series.setName(HeroId.valueOf("h" + playerMatchStatistics[i].getHero_id().toString()).toString());
                GraphicExp.getData().add(series);
            }
        } else System.out.println("Empty");
    }

    private void graphicAdvantage(DataForGraphs dataForGraphs) {
        if (dataForGraphs != null) {
            XYChart.Series seriesExp = new XYChart.Series();
            XYChart.Series seriesGold = new XYChart.Series();
            ObservableList<XYChart.Data> dataExp = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> dataGold = FXCollections.observableArrayList();
            for (int i = 0; i < dataForGraphs.getNetWorse().size(); i++) {
                dataExp.add(new XYChart.Data(i, dataForGraphs.getExp().get(i)));
                dataGold.add(new XYChart.Data(i, dataForGraphs.getNetWorse().get(i)));
            }
            seriesExp.setData(dataExp);
            seriesGold.setData(dataGold);
            seriesExp.setName("Опыт");
            seriesGold.setName("Золото");
            GraphicAdvantage.setCreateSymbols(false);
            GraphicAdvantage.getData().add(seriesExp);
            GraphicAdvantage.getData().add(seriesGold);
            for (int i = 0; i < dataForGraphs.getNetWorse().size(); i++) {
                Tooltip.install(dataExp.get(i).getNode(),
                        new Tooltip('(' + dataExp.get(i).getXValue().toString() + ';' + dataExp.get(i).getYValue().toString() + ')'));
                Tooltip.install(dataGold.get(i).getNode(),
                        new Tooltip('(' + dataGold.get(i).getXValue().toString() + ';' + dataGold.get(i).getYValue().toString() + ')'));
            }
        }
    }

    private void imageSet(Map<String, Object> namespace, PlayerMatchStatistics[] playerMatchStatistics, DataForGraphs dataForGraphs) {
        for (int i = 0; i < 10; i++) {
            File file = new File("src/HeroesIcon/" + HeroId.valueOf("h" + playerMatchStatistics[i].getHero_id()).toString() + ".jpg");
            Image im = new Image(file.toURI().toString());
            ImageView image = (ImageView) namespace.get("image" + i);
            image.setImage(im);
            int finali = i;
            image.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                try {
                    this.ClickOnHero(HeroId.valueOf("h" + playerMatchStatistics[finali].getHero_id()).toString());
                    ModelCancel.setCodeOfOperation(3);
                    ModelCancel.setPlayerMatchStatisticsStack(playerMatchStatistics);
                    ModelCancel.setDataForGraphsStack(dataForGraphs);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            image.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                InnerShadow innerShadow = new InnerShadow();
                Color color = new Color(1, 0.12, 0.20, 0.90);
                innerShadow.setColor(color);
                innerShadow.setRadius(20);
                image.setEffect(innerShadow);
            });
            image.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                InnerShadow innerShadow = new InnerShadow();
                innerShadow.setRadius(0.0);
                image.setEffect(innerShadow);
            });
        }
    }

    private void ClickOnHero(String heroName) throws IOException {
        ControllerHero ch = new ControllerHero();
        ch.ReadFile(heroName);
        ch.show(stage);
    }

    public void goBack() throws IOException {
        Menu menu = new Menu();
        menu.goMenu(stage);

    }

}

