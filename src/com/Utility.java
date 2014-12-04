package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Daniel on 11/29/2014.
 */
public class Utility {

    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * This util method allows you to save the game Engine object
     * @param engine
     */
    public static void saveEngine(Engine engine){
        if (engine != null) {
            try {
                mapper.writeValue(new File(Constants.ENGINE_FILE_PATH), engine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This util method allows you to access the game Engine object
     */
    public static Engine getEngine(){
        Engine engine = null;
        try {
            engine = mapper.readValue(new File(Constants.ENGINE_FILE_PATH), Engine.class);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return engine;
    }

    /**
     * This util method allows you to save a player object to be accessed later
     */
    public static void savePlayer(Player player){
        if (player != null){
            try {
                mapper.writeValue(new File("Data\\PlayerData\\" + getFileName(player) + ".json"), player);
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This util method allows you to access a Player Object that has been saved
     */
    public static Player getPlayer(Player player){
        Player returnPlayer = null;
        if (player != null) {
            try {
                returnPlayer = mapper.readValue(new File("Data\\PlayerData\\" + getFileName(player) + ".json"), Player.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnPlayer;
    }

    /**
     * This method gets the initial player data for a given team
     * @param teamName
     * @return
     */
    public static List<String> getTeamPlayerInfo(String teamName){
        List<String> input = null;
        try {
            Path path = Paths.get("Data/TeamInfo/" + teamName + ".txt");
            input = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (Exception e){
            System.out.println("Exception: " + e.toString());
        }
        return input;
    }

    /**
     * This method returns an array of available teams
     * @return
     */
    public static String[] getTeamInfo(){
        List<String> input = null;
        String[] output = null;
        try {
            Path path = Paths.get(Constants.TEAM_FILE_PATH);
            input = Files.readAllLines(path, StandardCharsets.UTF_8);
            output = input.get(0).split(",");
        } catch (Exception e){
            System.out.println("Exception: " + e.toString());
        }
        return output;
    }

    /**
     * This method saves the boxScore when the game is over
     */
    public static void saveBoxScore(){
        Engine engine = Utility.getEngine();
        ArrayList<Player> homePlayers = engine.getHomePlayers();
        ArrayList<Player> awayPlayers = engine.getAwayPlayers();
        ArrayList<String> output = new ArrayList<String>();
        output.add("Home team");
        for(Player player : homePlayers){
            Player upToDatePlayer = Utility.getPlayer(player);
            output.add(upToDatePlayer.toString());
        }

        output.add("Away team");
        for(Player player : awayPlayers){
            Player upToDatePlayer = Utility.getPlayer(player);
            output.add(upToDatePlayer.toString());
        }

        try {
            Path path = Paths.get(Constants.OUTPUT_FILE_PATH);
            Files.write(path,output,StandardCharsets.UTF_8);
        } catch (Exception e){
            System.out.println("Exception: " + e.toString());
        }

        System.exit(0);
    }

    /**
     * This private method returns key that the player information will be saved under.
     * @param player
     * @return
     */
    private static String getFileName(Player player){
        if (player != null) {
            return (player != null) ? player.getFirstName() + player.getLastName() + player.getNumber() + player.getTeamName() : "";
        } else {
            return null;
        }
    }
}

