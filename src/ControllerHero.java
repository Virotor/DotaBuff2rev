//import ControllerMatches;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ControllerHero {

    private ArrayList<StringBuilder> listText;

    static private Stage scene;

    private String nameHero;

    private boolean isPrePlayerStatistics;

    static private  PlayerMatchStatistics[] playerMatchStatistics;
    static private  DataForGraphs dataForGraphs;


    public void ReadFile(String name) {
        try {
            nameHero = name;
            int j = 0;
            String tempString = "";
            FileReader hf;
            Scanner scan;
            ArrayList<String> listName = new ArrayList<>();
            listText = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                listText.add(new StringBuilder());
            }
            listName.add("Hero/" + name + "/text.txt");
            hf = new FileReader(listName.get(0));
            scan = new Scanner(hf);
            while (j != 4) {
                listText.get(j).append(scan.nextLine()).append("\n");
                j++;
            }
            while (scan.hasNextLine()) {
                tempString = scan.nextLine();
                if (!tempString.equals("Способность")) {
                    listText.get(j).append(tempString).append("\n");
                } else {
                    tempString = "";
                    j++;
                }
            }
            hf.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show(Stage primaryStage) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hero.fxml"));
        root = loader.load();
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
        listNameView.add("Hero/" + this.nameHero + "/image.png");
        listNameView.add("Hero/" + this.nameHero + "/talents.png");
        listNameView.add("Hero/" + this.nameHero + "/skill1.png");
        listNameView.add("Hero/" + this.nameHero + "/skill2.png");
        listNameView.add("Hero/" + this.nameHero + "/skill3.png");
        listNameView.add("Hero/" + this.nameHero + "/ultimate.png");
        for (int i = 0; i < 6; i++) {
            File file = new File(listNameView.get(i));
            Image im = new Image(file.toURI().toString());
            listImageView.get(i).setImage(im);
            //listImageView.get(i).fitHeightProperty().bind(primaryStage.heightProperty());
            //listImageView.get(i).fitWidthProperty().set(primaryStage.widthProperty().asObject().getValue());
        }
        AnchorPane anchorPane = (AnchorPane) namespace.get("ImagePane");
        listImageView.get(0).fitWidthProperty().bind(anchorPane.widthProperty());
        listImageView.get(0).fitHeightProperty().bind(anchorPane.heightProperty());
        scene = primaryStage;
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 960, 540));
        scene.show();
    }

    public void goBack() throws IOException {
        switch (ModelCancel.getCodeOfOperation().pop()) {
            case 1: {
                Menu menu = new Menu();
                menu.goMenu(scene);
                break;
            }
            case 2: {
                ControllerMatches controllerMatches = new ControllerMatches();
                controllerMatches.show(scene);
                break;
            }
            case 3:{
                ControllerMatch controllerMatch = new ControllerMatch();
                controllerMatch.show(scene,ModelCancel.getPlayerMatchStatisticsStack().pop(),ModelCancel.getDataForGraphsStack().pop());
                break;
            }
        }
    }

    public void setPrePlayerStatistics(boolean prePlayerStatistics) {
        isPrePlayerStatistics = prePlayerStatistics;
    }

    public void setPlayerMatchStatistics(PlayerMatchStatistics[] playerMatchStatistics) {
        this.playerMatchStatistics = playerMatchStatistics;
    }

    public void setDataForGraphs(DataForGraphs dataForGraphs) {
        this.dataForGraphs = dataForGraphs;
    }
}

