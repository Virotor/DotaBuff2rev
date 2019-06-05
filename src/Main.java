import controller.Menu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
      /*  ControllerHero controllerHero =  new ControllerHero();
        controllerHero.ReadFile("2");
        controllerHero.show(primaryStage);*/
         Menu menu = new Menu();
         menu.goMenu(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
