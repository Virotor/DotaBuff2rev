import Matches.ControllerMatches;
import Matches.LastMatches;
import Statistics.PlayerStatistics;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Help.HeroId hero= Help.HeroId.valueOf("h1");
        //System.out.println(hero);
        ArrayList<LastMatches> listMatches =new ArrayList<>();
        for(int i =0;i<25;i++){
            LastMatches l =new LastMatches((long) i,i,true,123123,50+i,i,i,i);
            listMatches.add(l);
        }
        ControllerMatches.setListMatches(listMatches);
        PlayerStatistics playerStatistics = new PlayerStatistics("Beach", 200.0, 300.0, 400.0, 500.0, 600.0);
        ControllerMatches.setPlayer(playerStatistics);
        ControllerMatches con = new ControllerMatches();
        con.show(new Stage());
        //Controller.heroMenu(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
