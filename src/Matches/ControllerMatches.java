package Matches;

import Help.HeroId;
import Statistics.PlayerStatistics;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import match.ControllerMatch;
import sample.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ControllerMatches {

    public Button dfg;
    static private PlayerStatistics player;
    static private ArrayList<Matches.LastMatches> listMatches;
    static private Stage scene;

    public static void setListMatches(ArrayList<Matches.LastMatches> listMatches) {
        ControllerMatches.listMatches = listMatches;
    }
/*
    public ControllerMatches(PlayerStatistics newPlayer){
       player=newPlayer;
   }*/

    public void show(Stage primaryStage) throws IOException {
        String statistic = player.toString();
        Parent root;// = FXMLLoader.load(ControllerMatches.class.getResource("matches.fxml"));
        FXMLLoader loader = new FXMLLoader(ControllerMatches.class.getResource("matches.fxml"));
        root = loader.load();
        Map<String, Object> namespace = loader.getNamespace();
        Text lblData = (Text) namespace.get("playerInfo");
        this.imageShow(namespace);
        this.killShow(namespace);
        this.deathsShow(namespace);
        this.assistsShow(namespace);
        this.durationShow(namespace);
        this.lobbyShow(namespace);
        this.winShow(namespace);
        lblData.setText(statistic);
        scene=primaryStage;
        scene.setTitle("DotaBuff");
        scene.setScene(new Scene(root, 960, 540));
        scene.show();
    }




    static public void setPlayer(PlayerStatistics player) {
        ControllerMatches.player = player;
    }

    private void imageShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            ImageView image = (ImageView) namespace.get("image"+ i);
            String name = "C://Users/virot/IdeaProjects/DotaBuff2/src/HeroesIcon/" + HeroId.valueOf("h"+listMatches.get(i).getHeroId()).toString() +".jpg";
            File file = new File(name);
            Image im = new Image(file.toURI().toString());
            image.setImage(im);
        }
    }

    private void killShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            Text text = (Text) namespace.get("k"+ i);
            text.setText(listMatches.get(i).getKills().toString());
        }
    }

    private void deathsShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            Text text = (Text) namespace.get("d"+ i);
            text.setText(listMatches.get(i).getDeaths().toString());
        }
    }

    private void assistsShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            Text text = (Text) namespace.get("a"+ i);
            text.setText(listMatches.get(i).getAssists().toString());
        }
    }
    private void durationShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            Text text = (Text) namespace.get("lobby"+ i);
            text.setText(listMatches.get(i).getDuration().toString());
        }
    }

    private void lobbyShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            Text text = (Text) namespace.get("duration"+ i);
            text.setText(listMatches.get(i).getLobbyType().toString());
        }
    }

    private void winShow(Map<String,Object> namespace){
        for(int i = 0; i<listMatches.size(); i++){
            Text text = (Text) namespace.get("win"+ i);
            if(listMatches.get(i).getRadiantWin()){
                text.setText("Radiant win");
            }else text.setText("Dire win");
        }
    }


    public void heroStatistics(ActionEvent actionEvent) throws IOException {
        Controller.heroMenu(new Stage());
        scene.close();
    }

    public void chooseFirst(ActionEvent actionEvent) throws IOException {
        ControllerMatch.show(scene);
    }

    public void chooseSecond(ActionEvent actionEvent) {
    }

    public void chooseThird(ActionEvent actionEvent) {
    }

    public void chooseFourth(ActionEvent actionEvent) {
    }

    public void chooseFifth(ActionEvent actionEvent) {
    }

    public void choose6(ActionEvent actionEvent) {
    }

    public void choose7(ActionEvent actionEvent) {
    }

    public void choose8(ActionEvent actionEvent) {
    }

    public void choose9(ActionEvent actionEvent) {
    }

    public void choose10(ActionEvent actionEvent) {
    }

    public void choose11(ActionEvent actionEvent) {
    }

    public void choose12(ActionEvent actionEvent) {
    }

    public void choose13(ActionEvent actionEvent) {
    }

    public void choose14(ActionEvent actionEvent) {
    }

    public void choose15(ActionEvent actionEvent) {
    }

    public void choose16(ActionEvent actionEvent) {
    }

    public void choose17(ActionEvent actionEvent) {
    }

    public void choose18(ActionEvent actionEvent) {
    }

    public void choose19(ActionEvent actionEvent) {
    }

    public void choose20(ActionEvent actionEvent) {
    }

    public void choose21(ActionEvent actionEvent) {
    }

    public void choose22(ActionEvent actionEvent) {
    }

    public void choose23(ActionEvent actionEvent) {
    }

    public void choose24(ActionEvent actionEvent) {
    }

    public void choose25(ActionEvent actionEvent) {
    }
}
