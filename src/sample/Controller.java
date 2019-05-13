package sample;

import Heroes.ControllerHero;
import Matches.ControllerMatches;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    static private Stage stage;


    static public void heroMenu(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(Controller.class.getResource("sample.fxml"));
        stage.setTitle("DotaBuff");
        stage.setScene(new Scene(root, 960, 540));
        stage.show();
    }

    public void ClickOnHero(String heroName) throws IOException {
        ControllerHero ch = new ControllerHero();
        Stage primaryStage = new Stage();
        ch.ReadFile(heroName);
        ch.show(primaryStage);
        stage.close();
    }

    public void chooseMatch(ActionEvent actionEvent) throws IOException {
        ControllerMatches cm = new ControllerMatches();
        cm.show(new Stage());
        stage.close();
    }

    public void ClickOnHeroAbaddon() throws IOException {
        ClickOnHero("Abaddon");
    }

    public void ClickOnHeroBristleback() throws IOException {
        ClickOnHero("Bristleback");
    }

    public void ClickOnHeroAxe() throws IOException {
        ClickOnHero("Axe");
    }

    public void ClickOnHeroArc() throws IOException {
        ClickOnHero("Arc");
    }

    public void ClickOnHeroAnti() throws IOException {
        ClickOnHero("Anti");
    }

    public void ClickOnHeroAlchemist() throws IOException {
        ClickOnHero("Alchemist");
    }

    public void ClickOnHeroAncient() throws IOException {
        ClickOnHero("Ancient");
    }

    public void ClickOnHeroBane() throws IOException {
        ClickOnHero("Bane");
    }

    public void ClickOnHeroWitch() throws IOException {
        ClickOnHero("Witch");
    }

    public void ClickOnHeroWinter() throws IOException {
        ClickOnHero("Winter");
    }

    public void ClickOnHeroWindranger(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Windranger");
    }

    public void ClickOnHeroWeaver(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Weaver");
    }

    public void ClickOnHeroWarlock(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Warlock");
    }

    public void ClickOnHeroVisage(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Visage");
    }

    public void ClickOnHeroZeus(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Zeus");
    }

    public void ClickOnHeroWraith(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Wraith");
    }

    public void ClickOnHeroViper(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Viper");
    }

    public void ClickOnHeroVenomancer(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Venomancer");
    }

    public void ClickOnHeroVengerful(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Vengerful");
    }

    public void ClickOnHeroUrsa(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Ursa");
    }

    public void ClickOnHeroUndying(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Undying");
    }

    public void ClickOnHeroUnderlord(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Underlord");
    }

    public void ClickOnHeroTusk(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Tusk");
    }

    public void ClickOnHeroTroll(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTreant(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTiny(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTinker(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTimbersaw(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSven(ActionEvent actionEvent) {
    }

    public void ClickOnHeroStorm(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTidehunter(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTerrorblade(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTemplar(ActionEvent actionEvent) {
    }

    public void ClickOnHeroTechies(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSpirit(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSpectre(ActionEvent actionEvent) {
    }

    public void ClickOnHerosniper(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSkywrath(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSlark(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSlardar(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSilencer(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSwadow_shaman(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSwadow_demon(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSwadow_fiend(ActionEvent actionEvent) {
    }

    public void ClickOnHeroSand(ActionEvent actionEvent) {
    }

    public void ClickOnHeroRubick(ActionEvent actionEvent) {
    }

    public void ClickOnHeroRiki(ActionEvent actionEvent) {
    }

    public void ClickOnHeroRazor(ActionEvent actionEvent) {
    }

    public void ClickOnHeroQueen(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPugna(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPudge(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPuck(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPhoenix(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPhantom_lancer(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPhantom_assassin(ActionEvent actionEvent) {
    }

    public void ClickOnHeroPangolier(ActionEvent actionEvent) {
    }

    public void ClickOnHeroOutword(ActionEvent actionEvent) {
    }

    public void ClickOnHeroOracle(ActionEvent actionEvent) {
    }

    public void ClickOnHeroOmniknight(ActionEvent actionEvent) {
    }

    public void ClickOnHeroOgre(ActionEvent actionEvent) {
    }

    public void ClickOnHeroNyx(ActionEvent actionEvent) {
    }

    public void ClickOnHeroNight(ActionEvent actionEvent) {
    }

    public void ClickOnHeroNecrophos(ActionEvent actionEvent) {
    }

    public void ClickOnHeroNatures(ActionEvent actionEvent) {
    }

    public void ClickOnHeroNaga(ActionEvent actionEvent) {
    }

    public void ClickOnHeroMorphling(ActionEvent actionEvent) {
    }

    public void ClickOnHeroMonkey(ActionEvent actionEvent) {
    }

    public void ClickOnHeroMirana(ActionEvent actionEvent) {
    }

    public void ClickOnHeroMeepo(ActionEvent actionEvent) {
    }

    public void ClickOnHeroMedusa(ActionEvent actionEvent) {
    }

    public void ClickOnHeroMagnus(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLycan(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLuna(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLone(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLion(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLina(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLifestealer(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLich(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLeshrac(ActionEvent actionEvent) {
    }

    public void ClickOnHeroLegion(ActionEvent actionEvent) {
    }

    public void ClickOnHeroKunkka(ActionEvent actionEvent) {
    }

    public void ClickOnHeroKeeper(ActionEvent actionEvent) {
    }

    public void ClickOnHeroJaggernaut(ActionEvent actionEvent) {
    }

    public void ClickOnHeroJakiro(ActionEvent actionEvent) {
    }

    public void ClickOnHeroIo(ActionEvent actionEvent) {
    }

    public void ClickOnHeroInvoker(ActionEvent actionEvent) {
    }

    public void ClickOnHeroHuskar(ActionEvent actionEvent) {
    }

    public void ClickOnHeroGyrocopter(ActionEvent actionEvent) {
    }

    public void ClickOnHeroGrimstroke(ActionEvent actionEvent) {
    }

    public void ClickOnHeroFaceless(ActionEvent actionEvent) {
    }

    public void ClickOnHeroEnigma(ActionEvent actionEvent) {
    }

    public void ClickOnHeroEnchantres(ActionEvent actionEvent) {
    }

    public void ClickOnHeroEmder(ActionEvent actionEvent) {
    }

    public void ClickOnHeroElder(ActionEvent actionEvent) {
    }

    public void ClickOnHeroEarthshaker(ActionEvent actionEvent) {
    }

    public void ClickOnHeroEarth(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDrow(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDragon(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDoom(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDazzle(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDark_willow(ActionEvent actionEvent) {
    }

    public void ClickOnHeroClockwerk(ActionEvent actionEvent) {
    }

    public void ClickOnHeroClinkz(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDisruptor(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDeath(ActionEvent actionEvent) {
    }

    public void ClickOnHeroDark_seer(ActionEvent actionEvent) {
    }

    public void ClickOnHeroCrystal(ActionEvent actionEvent) {
    }

    public void ClickOnHeroChen(ActionEvent actionEvent) {
    }

    public void ClickOnHeroChaos(ActionEvent actionEvent) {
    }

    public void ClickOnHeroCentaur(ActionEvent actionEvent) {
    }

    public void ClickOnHeroBroodmother(ActionEvent actionEvent) {
    }

    public void ClickOnHeroBrewmaster(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Brewmaster");
    }

    public void ClickOnHeroBounty(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Bounty");
    }

    public void ClickOnHeroBlood(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Blood");
    }

    public void ClickOnHeroBeastmaster(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Beastmaster");
    }

    public void ClickOnHeroBatrider(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Batrider");
    }

    public void ClickOnHeroMars(ActionEvent actionEvent) throws IOException {
        ClickOnHero("Mars");
    }
}
