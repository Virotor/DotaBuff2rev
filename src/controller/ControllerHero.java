package controller;

import Help.HeroId;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class ControllerHero {

    private ArrayList<StringBuilder> listText;

    static private Stage scene;

    private String nameHero;

    public static String userName = "root";
    public static String password = "1111";
    public static String connectionURL = "jdbc:mysql://localhost:3306/hero_db?autoReconnect=true&useSSL=false";


    public void ReadFile(String name) {
       listText = new ArrayList<>();
       nameHero=name;
        try (
        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from hero where idhero  = '" + Integer.parseInt(name) + "'");
            while (resultSet.next()) {
                listText.add(new StringBuilder(resultSet.getString("firstskillname")));
                listText.add(new StringBuilder(resultSet.getString("secondskillname")));
                listText.add(new StringBuilder(resultSet.getString("thirdskillname")));
                listText.add(new StringBuilder(resultSet.getString("ultimateskillname")));
                listText.add(new StringBuilder(resultSet.getString("abouthero")));
                listText.add(new StringBuilder(resultSet.getString("skill1")));
                listText.add(new StringBuilder(resultSet.getString("skill2")));
                listText.add(new StringBuilder(resultSet.getString("skill3")));
                listText.add(new StringBuilder(resultSet.getString("skill4")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void show(Stage primaryStage) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hero.fxml"));
        root = loader.load();
        Scene scene = primaryStage.getScene();
        ScrollPane node = (ScrollPane) scene.getRoot().getChildrenUnmodifiable().get(0);
        AnchorPane pane = (AnchorPane) node.getContent();
        TabPane tabPane = (TabPane) pane.getChildren().get(0);
        Map<String, Object> namespace = loader.getNamespace();
        Text lblData = (Text) namespace.get("textTable");
        lblData.setText(listText.get(4).toString());
        Text skillData1 = (Text) namespace.get("firstSkill");
        skillData1.setText(listText.get(5).toString());
        Text skillData2 = (Text) namespace.get("secondSkill");
        skillData2.setText(listText.get(6).toString());
        Text skillData3 = (Text) namespace.get("thirdSkill");
        skillData3.setText(listText.get(7).toString());
        Text skillData4 = (Text) namespace.get("ultimateSkill");
        skillData4.setText(listText.get(8).toString());
        TitledPane skillName1 = (TitledPane) namespace.get("firstSkillText");
        skillName1.setText(listText.get(0).toString());
        TitledPane skillName2 = (TitledPane) namespace.get("secondSkillText");
        skillName2.setText(listText.get(1).toString());
        TitledPane skillName3 = (TitledPane) namespace.get("thirdSkillText");
        skillName3.setText(listText.get(2).toString());
        TitledPane skillName4 = (TitledPane) namespace.get("ultimateName");
        skillName4.setText(listText.get(3).toString());
        ArrayList<ImageView> listImageView = new ArrayList<>();
        ArrayList<String> listNameView = new ArrayList<>();
        listImageView.add((ImageView) namespace.get("imageM"));
        listImageView.add((ImageView) namespace.get("imageT"));
        listImageView.add((ImageView) namespace.get("imageFirstSkill"));
        listImageView.add((ImageView) namespace.get("imageSecondSkill"));
        listImageView.add((ImageView) namespace.get("imageThirdSkill"));
        listImageView.add((ImageView) namespace.get("ultimateImage"));
        listNameView.add("Hero/" + HeroId.valueOf("h"+ this.nameHero).toString() + "/image.png");
        listNameView.add("Hero/" + HeroId.valueOf("h"+ this.nameHero).toString() + "/talents.png");
        listNameView.add("Hero/" + HeroId.valueOf("h"+ this.nameHero).toString() + "/skill1.png");
        listNameView.add("Hero/" + HeroId.valueOf("h"+ this.nameHero).toString() + "/skill2.png");
        listNameView.add("Hero/" + HeroId.valueOf("h"+ this.nameHero).toString() + "/skill3.png");
        listNameView.add("Hero/" + HeroId.valueOf("h"+ this.nameHero).toString() + "/ultimate.png");
        for (int i = 0; i < 6; i++) {
            File file = new File(listNameView.get(i));
            Image im = new Image(file.toURI().toString());
            listImageView.get(i).setImage(im);
        }
        AnchorPane anchorPane = (AnchorPane) namespace.get("ImagePane");
        anchorPane.autosize();
        listImageView.get(0).fitWidthProperty().bind(anchorPane.widthProperty());
        listImageView.get(0).fitHeightProperty().bind(anchorPane.heightProperty());
        Tab tab = new Tab(nameHero, root);
        tabPane.getTabs().add(tab);
    }

    public void goBack() throws IOException {
        Menu menu = new Menu();
        menu.goMenu(scene);
    }


}

