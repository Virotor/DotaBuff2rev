package Heroes;

import Matches.ControllerMatches;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ControllerHero {

    /* @FXML
     private ScrollPane scrollPane;
     @FXML
     private StackPane paneScore;
     @FXML
     private Text firstSkill;
     @FXML
     private Text secondSkill;
     @FXML
     private Text thirdSkill;
     @FXML
     private Text ultimateSkill;
     @FXML
     private ImageView imageM;
     @FXML
     private ImageView imageT;
     @FXML
     private TitledPane firstSkillText;
     @FXML
     private ImageView imageFirstSkill;
     @FXML
     private TitledPane secondSkillText;
     @FXML
     private ImageView imageSecondSkill;
     @FXML
     private TitledPane thirdSkillText;
     @FXML
     private ImageView imageThirdSkill;
     @FXML
     private TitledPane ultimateName;
     @FXML
     private ImageView ultimateImage;
     @FXML
     private Text textTable;*/
    private ArrayList<StringBuilder> listText;

    static private Stage scene;

    private String nameHero;

    public ControllerHero() {
        nameHero = "";
    }

    public void ReadFile(String name) throws IOException {
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
            listName.add("C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + name + "/text.txt");
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
        ImageView image = (ImageView) namespace.get("imageM");
        ImageView imageTalent = (ImageView) namespace.get("imageT");
        ImageView imageFirst = (ImageView) namespace.get("imageFirstSkill");
        ImageView imageSecond = (ImageView) namespace.get("imageSecondSkill");
        ImageView imageThird = (ImageView) namespace.get("imageThirdSkill");
        ImageView imageUltimate = (ImageView) namespace.get("ultimateImage");
        String name = "C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + this.nameHero + "/image.png";
        String nameTalent = "C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + this.nameHero + "/talents.png";
        String nameFirstIm = "C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + this.nameHero + "/skill1.png";
        String nameSecondIm = "C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + this.nameHero + "/skill2.png";
        String nameThirdIm = "C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + this.nameHero + "/skill3.png";
        String nameUltimateIm = "C://Users/virot/IdeaProjects/DotaBuff2/src/Hero/" + this.nameHero + "/ultimate.png";
        File file = new File(name);
        Image im = new Image(file.toURI().toString());
        image.setImage(im);
        file = new File(nameTalent);
        im = new Image(file.toURI().toString());
        imageTalent.setImage(im);
        file = new File(nameFirstIm);
        im = new Image(file.toURI().toString());
        imageFirst.setImage(im);
        file = new File(nameSecondIm);
        im = new Image(file.toURI().toString());
        imageSecond.setImage(im);
        file = new File(nameThirdIm);
        im = new Image(file.toURI().toString());
        imageThird.setImage(im);
        file = new File(nameUltimateIm);
        im = new Image(file.toURI().toString());
        imageUltimate.setImage(im);
        scene = primaryStage;
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 960, 540));
        scene.show();
    }

    public void chooseMatch(ActionEvent actionEvent) throws IOException {
        ControllerMatches cm = new ControllerMatches();
        cm.show(new Stage());
        scene.close();
    }

    public void chooseHero(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Controller.heroMenu(primaryStage);
        scene.close();
    }

    public void chooseItem(ActionEvent actionEvent) {
    }
}

