import Help.HeroId;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ControllerMatches {

    static private PlayerStatistics player;
    static private int page;
    @FXML
    static private Button back;
    @FXML
    static private Button next;
    static private Stage scene;
    @FXML
    private TextField newPlayer;
    @FXML
    private TextField idMatch;
    private Map<String, Object> namespace;

    static private String playerID;

    static void setPlayerID(String playerID) {
        ControllerMatches.playerID = playerID;
    }

    void show(Stage primaryStage) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(ControllerMatches.class.getResource("etert.fxml"));
        root = loader.load();

        namespace = loader.getNamespace();
        newPlayer = (TextField) namespace.get("newPlayer");
        idMatch = (TextField) namespace.get("idMatch");
        back = (Button) namespace.get("back");
        next = (Button) namespace.get("next");
        this.setPlayerInfo();
        this.imageShow();
        this.killShow();
        this.deathsShow();
        this.assistsShow();
        this.durationShow();
        this.lobbyShow();
        this.winShow();
        this.setButton();
        this.buttonAction();
        scene = primaryStage;
        scene.setResizable(true);
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 1280, 720));
        scene.show();
    }


    static void setPlayer(PlayerStatistics player) {
        ControllerMatches.player = player;
    }


    private void setPlayerInfo() {
        Text name = (Text) namespace.get("name");
        name.setText(player.getNickName());
        Text win = (Text) namespace.get("win");
        win.setText(player.getWin().toString());
        Text lose = (Text) namespace.get("lose");
        lose.setText(player.getLose().toString());
        Text winrate = (Text) namespace.get("winrate");
        winrate.setText(player.getWinrate().toString());
    }

    private void buttonAction() {
        for (int i = 0; i < 25; i++) {
            final int j = i;
            Text button = (Text) namespace.get("button" + i);
            button.setText(player.getMatchesPlayeds()[j + 25 * page].getMatchID().toString());
            button.removeEventHandler(MouseEvent.MOUSE_CLICKED,e->{
                WaitMenu waitMenu = new WaitMenu();
                try {
                    ModelCancel.setCodeOfOperation(2);
                    ModelCancel.setPlayerStatisticsStack(player);
                    waitMenu.waitMatches(scene, player.getMatchesPlayeds()[j + 25 * page].getMatchID().toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            button.removeEventHandler(MouseEvent.MOUSE_ENTERED,e->{
                button.setUnderline(true);
                Color color = new Color(0.2, 0.2, 0.5, 1);
                button.setFill(color);
            });
            button.removeEventHandler(MouseEvent.MOUSE_EXITED,e->{
                button.setUnderline(false);
                Color color = new Color(0, 0, 0.0, 1);
                button.setFill(color);
            });
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                WaitMenu waitMenu = new WaitMenu();
                try {
                    ModelCancel.setCodeOfOperation(2);
                    ModelCancel.setPlayerStatisticsStack(player);
                    waitMenu.waitMatches(scene, player.getMatchesPlayeds()[j + 25 * page].getMatchID().toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                button.setUnderline(true);
                Color color = new Color(0.2, 0.2, 0.5, 1);
                button.setFill(color);
            });
            button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                button.setUnderline(false);
                Color color = new Color(0, 0, 0.0, 1);
                button.setFill(color);
            });
        }
    }

    private void imageShow() {
        for (int i = 0; i < 25; i++) {
            ImageView image = (ImageView) namespace.get("image" + i);
            String name = "src/HeroesIcon/" + HeroId.valueOf("h" + player.getMatchesPlayeds()[i+page*25].getHeroId().toString()) + ".jpg";
            File file = new File(name);
            Image im = new Image(file.toURI().toString());
            image.setImage(im);
            int finalI = i;
            image.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                try {
                    this.ClickOnHero(HeroId.valueOf("h" + player.getMatchesPlayeds()[finalI + page * 25].getHeroId()).toString());
                    ModelCancel.setCodeOfOperation(2);
                    ModelCancel.setPlayerStatisticsStack(player);
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

    private void response(){
        idMatch.setOnMouseClicked(e-> {
            Popup popper = new Popup();
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            popper.setAutoHide(true);
            popper.setX(350);
            popper.setY(200);
            tf1.setLayoutX(4);
            tf2.setLayoutY(90);
            AnchorPane group = new AnchorPane(tf1, tf2);
            group.setStyle("-fx-background-color: rgba(0, 255, 0, .3)");
            popper.getContent().addAll(group);
            popper.show(idMatch, 100, 100);
        });

    }


    private void ClickOnHero(String heroName) throws IOException {
        ControllerHero ch = new ControllerHero();
        ch.ReadFile(heroName);
        ch.setPrePlayerStatistics(true);
        ch.show(scene);
    }

    private void killShow() {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("k" + i);
            text.setText(player.getMatchesPlayeds()[i+page*25].getKills().toString());
        }
    }

    private void deathsShow() {

        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("d" + i);
            text.setText(player.getMatchesPlayeds()[i+page*25].getDeaths().toString());
        }
    }

    private void assistsShow() {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("a" + i);
            text.setText(player.getMatchesPlayeds()[i+page*25].getAssists().toString());
        }
    }

    private void durationShow() {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("duration" + i);
            text.setText(Double.toString(player.getMatchesPlayeds()[i+page*25].getDuration() / 60));
        }
    }

    private void lobbyShow() {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("lobby" + i);
            text.setText(player.getMatchesPlayeds()[i+page*25].getLobbyType().toString());
        }
    }

    private void winShow() {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("win" + i);
            if ((player.getMatchesPlayeds()[i+page*25].getRadiantWin()&&player.getMatchesPlayeds()[i+page*25].getPlayerSlot()<100)||
                    (!player.getMatchesPlayeds()[i+page*25].getRadiantWin()&&player.getMatchesPlayeds()[i+page*25].getPlayerSlot()>100)) {
                text.setText("Победа");
                Color color = new Color(0.1, 0.94, 0.2, 1);
                text.setFill(color);
            } else {
                text.setText("Поражение");
                Color color = new Color(1, 0.2, 0.2, 1);
                text.setFill(color);
            }
        }
    }


    public void newPlayer() throws IOException {
        WaitMenu waitMenu = new WaitMenu();
        waitMenu.waitProfile(scene, newPlayer.getText());
    }

    public void searchId() throws IOException {
        WaitMenu waitMenu = new WaitMenu();
        waitMenu.waitMatches(scene, idMatch.getText());
    }

    static void setPage(int page) {
        ControllerMatches.page = page;
    }

    private void setButton() {
        if (page == 0) {
            back.setVisible(false);
        } else {
            back.setVisible(true);
            back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> refreshStage(-1));
        }
        if (page > (player.getMatchesPlayeds().length / 25)-1) {
            next.setVisible(false);
        } else {
            back.setVisible(true);
            next.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> refreshStage(1));
        }
    }

    private void refreshStage(int i) {
        Platform.runLater(()->{
            page += i;
            this.buttonAction();
            this.imageShow();
            this.killShow();
            this.deathsShow();
            this.assistsShow();
            this.durationShow();
            this.lobbyShow();
            this.winShow();
            this.setButton();
        });
    }

    public void Refresh() throws IOException {
        WaitMenu waitMenu = new WaitMenu();
        waitMenu.waitProfile(scene, playerID);
        ModelCancel.setCodeOfOperation(2);
    }

    public void goBack() throws IOException {
        switch (ModelCancel.getCodeOfOperation().pop()){
            case 1: {
                Menu menu = new Menu();
                menu.goMenu(scene);
                break;
            }
            case 2: {
                ControllerMatches controllerMatches = new ControllerMatches();
                ControllerMatches.setPlayer(ModelCancel.getPlayerStatisticsStack().pop());
                page=0;
                controllerMatches.show(scene);
                break;
            }
            case 3: {
                ControllerMatch controllerMatch = new ControllerMatch();
                controllerMatch.show(scene,ModelCancel.getPlayerMatchStatisticsStack().pop(),ModelCancel.getDataForGraphsStack().pop());
                break;
            }
        }
    }
}
