package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by Daniel on 11/29/2014.
 */
public class Utility {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void saveEngine(Engine engine){
        if (engine != null) {
            try {
                mapper.writeValue(new File(Constants.ENGINE_FILE_PATH), engine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Engine getEngine(){
        Engine engine = null;
        try {
            engine = mapper.readValue(new File(Constants.ENGINE_FILE_PATH), Engine.class);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return engine;
    }

    public static void savePlayer(Player player){
        if (player != null){
            try {
                mapper.writeValue(new File("Data\\PlayerData\\" + getFileName(player) + ".json"), player);
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }

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

    public static void saveBoxScore(){

    }

    private static String getFileName(Player player){
        if (player != null) {
            return (player != null) ? player.getFirstName() + player.getLastName() + player.getNumber() + player.getTeamName() : "";
        } else {
            return null;
        }
    }
}

