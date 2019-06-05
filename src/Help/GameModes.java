package Help;

public enum GameModes {

     g0( "No Game Mode"),
     g1( "All Pick"),
     g2( "Captain's Mode"),
     g3( "Random Draft"),
     g4( "Single Draft"),
     g5( "All Random"),
     g7( "Diretide"),
     g8( "Reverse Captain's Mode"),
     g9( "Greeviling"),
     g10( "Tutorial"),
     g11( "Mid Only"),
     g12( "Least Played"),
     g13( "New Player Pool"),
     g14( "Compendium Matchmaking"),
     g15( "Custom"),
     g16( "Captain's Draft"),
     g17( "Balanced Draft"),
     g18( "Ability Draft"),
     g20( "All Random Deathmatch"),
     g21( "Solo Mid 1v1"),
     g22( "Ranked All Pick");
     private String GameMode;

    GameModes(String GameMode) {
        this.GameMode = GameMode;
    }

    @Override
    public String toString() {
        return this.GameMode;
    }
}
