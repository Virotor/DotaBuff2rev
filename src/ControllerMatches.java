import Help.HeroId;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ControllerMatches {

    public Button dfg;
    static private PlayerStatistics player;
    static private ArrayList<MatchesPlayed> listMatches;
    static private Stage scene;
    static private Map<String, Object> namespace;
    static private TextField id;
    static  private TextField idMatch;

    static  private int listNumber;

    public static void setListMatches(ArrayList<MatchesPlayed> listMatches) {
        ControllerMatches.listMatches = listMatches;
    }
    /*public ControllerMatches(PlayerStatistics newPlayer){
       player=newPlayer;
    }*/

    public void show(Stage primaryStage) throws IOException {
        String statistic = player.getNickName() + "    " + player.getGPM() + player.getLose() + player.getWin();
        Parent root;// = FXMLLoader.load(ControllerMatches.class.getResource("matches.fxml"));
        FXMLLoader loader = new FXMLLoader(ControllerMatches.class.getResource("matches.fxml"));
        root = loader.load();
        namespace = loader.getNamespace();
        Text lblData = (Text) namespace.get("playerInfo");
        id = (TextField) namespace.get("newPlayer");
        idMatch=(TextField) namespace.get("idMatch");
        this.imageShow(namespace);
        this.killShow(namespace);
        this.deathsShow(namespace);
        this.assistsShow(namespace);
        this.durationShow(namespace);
        this.lobbyShow(namespace);
        this.winShow(namespace);
        lblData.setText(statistic);
        scene = primaryStage;
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 960, 540));
        scene.show();
    }


    static public void setPlayer(PlayerStatistics player) {
        ControllerMatches.player = player;
    }

    private void imageShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            ImageView image = (ImageView) namespace.get("image" + i);
            String name = "src/HeroesIcon/" + HeroId.valueOf("h" + player.getMatchesPlayeds()[i].getHeroId().toString()) + ".jpg";
            File file = new File(name);
            Image im = new Image(file.toURI().toString());
            image.setImage(im);
        }
    }

    private void killShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("k" + i);
            text.setText(player.getMatchesPlayeds()[i].getKills().toString());
        }
    }

    private void deathsShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("d" + i);
            text.setText(player.getMatchesPlayeds()[i].getDeaths().toString());
        }
    }

    private void assistsShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("a" + i);
            text.setText(player.getMatchesPlayeds()[i].getAssists().toString());
        }
    }

    private void durationShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("lobby" + i);
            text.setText(player.getMatchesPlayeds()[i].getDuration().toString());
        }
    }

    private void lobbyShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("duration" + i);
            text.setText(player.getMatchesPlayeds()[i].getLobbyType().toString());
        }
    }

    private void winShow(Map<String, Object> namespace) {
        for (int i = 0; i < 25; i++) {
            Text text = (Text) namespace.get("win" + i);
            if (player.getMatchesPlayeds()[i].getRadiantWin()) {
                text.setText("Radiant win");
            } else text.setText("Dire win");
        }
    }


    public void heroStatistics() throws IOException {
        Controller.heroMenu(scene);
    }

   /* public void chooseFirst() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void chooseSecond() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[1].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void chooseThird() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[2].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void chooseFourth() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[3].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void chooseFifth() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[4].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose6() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose7() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose8() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose9() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose10() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose11() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose12() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose13() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose14() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose15() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose16() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose17() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose18() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose19() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose20() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose21() throws IOException {

        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose22() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose23() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose24() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }

    public void choose25() throws IOException {
        ControllerMatch cm = new ControllerMatch();
        PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(player.getMatchesPlayeds()[0].getMatchID().toString());
        cm.show(scene, playerMatchStatistics);
    }*/

    public void newPlayer() throws IOException {
        String str = id.getText();
        PlayerStatistics playerStatistics=Client.playerStatisticsAndMatches(str);
        ControllerMatches.setPlayer(playerStatistics);
        ControllerMatches cm = new ControllerMatches();
        cm.show(scene);
    }

    public void searchId() throws IOException {
        String str = idMatch.getText();
        ControllerMatch cm = new ControllerMatch();
        //PlayerMatchStatistics[] playerMatchStatistics = Client.playerMatchStatistics(str);
       // cm.show(scene, playerMatchStatistics);
    }
}
