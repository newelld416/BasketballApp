package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


/**
 * Created by Daniel on 11/29/2014.
 */
public class Utility {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void saveEngine(Engine engine){
        try {
            mapper.writeValue(new File("PlayerData\\engine.json"), engine);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static Engine getEngine(){
        Engine engine = null;
        try {
            engine = mapper.readValue(new File("PlayerData\\engine.json"), Engine.class);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return engine;
    }

    public static void SavePlayer(Player player){
        try {
            mapper.writeValue(new File("PlayerData\\" + getFileName(player) + ".json"), player);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static Player GetPlayer(Player player){
        Player returnPlayer = null;
        try {
            returnPlayer = mapper.readValue(new File("PlayerData\\" + getFileName(player) + ".json"), Player.class);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return returnPlayer;
    }

    public static Player GetPlayer(String fileName){
        Player returnPlayer = null;
        try {
            returnPlayer = mapper.readValue(new File("PlayerData\\" + fileName + ".json"), Player.class);
        } catch ( Exception e ) {
            System.out.println("Error:" + e.toString());
        }
        return returnPlayer;
    }

    public static String getSelectedPlayerFileName(){
        SelectedPlayer selectedPlayer = null;
        try {
            selectedPlayer = mapper.readValue(new File("PlayerData\\selectedPlayer.json"), SelectedPlayer.class);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return selectedPlayer.getSelectedPlayerFileName();
    }

    public static void saveSelectedPlayerFileName (Player player){
        try {
            mapper.writeValue(new File("PlayerData\\selectedPlayer.json"), getFileName(player));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private static String getFileName(Player player){
        return player.getFirstName() + player.getLastName() + player.getNumber() + player.getTeamName();
    }
}

