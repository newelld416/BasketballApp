package com;

/**
 * Created by Daniel on 11/10/2014.
 */
public class Player extends Object{

    //Player info properties
    private String firstName;
    private String lastName;
    private int number;
    private String teamName;

    //Stat properties
    private int totalPoints;
    private int fieldGoalsAttempted;
    private int fieldGoalsMade;
    private int threePointersAttempted;
    private int threePointersMade;
    private int freeThrowsAttempted;
    private int freeThrowsMade;
    private int offensiveRebounds;
    private int defensiveRebounds;
    private int assists;
    private int steals;
    private int fouls;
    private int turnovers;
    private int blocks;
    private int chargesTaken;
    private int personalFouls;

    /**
     * Empty Player Constructor
     *  This is needed to work with the JSON convert library used (Jackson)
     */
    public Player(){

    }

    /**
     * Player constructor
     * @param firstName
     * @param lastName
     * @param number
     * @param teamName
     */
    public Player(String firstName, String lastName, int number, String teamName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.teamName = teamName;
        this.totalPoints = 0;
        this.fieldGoalsAttempted = 0;
        this.fieldGoalsMade = 0;
        this.threePointersAttempted = 0;
        this.threePointersMade = 0;
        this.freeThrowsAttempted = 0;
        this.freeThrowsMade = 0;
        this.offensiveRebounds = 0;
        this.defensiveRebounds = 0;
        this.assists = 0;
        this.steals = 0;
        this.fouls = 0;
        this.turnovers = 0;
        this.blocks = 0;
        this.chargesTaken = 0;
        this.personalFouls = 0;
    }

    /**
     * Player Constructor
     * @param firstName
     * @param lastName
     * @param number
     * @param teamName
     * @param totalPoints
     * @param fieldGoalsAttempted
     * @param fieldGoalsMade
     * @param threePointersAttempted
     * @param threePointersMade
     * @param freeThrowsAttempted
     * @param freeThrowsMade
     * @param offensiveRebounds
     * @param defensiveRebounds
     * @param assists
     * @param steals
     * @param fouls
     * @param turnovers
     * @param blocks
     * @param chargesTaken
     * @param personalFouls
     */
    public Player(String firstName,
                  String lastName,
                  int number,
                  String teamName,
                  int totalPoints,
                  int fieldGoalsAttempted,
                  int fieldGoalsMade,
                  int threePointersAttempted,
                  int threePointersMade,
                  int freeThrowsAttempted,
                  int freeThrowsMade,
                  int offensiveRebounds,
                  int defensiveRebounds,
                  int assists,
                  int steals,
                  int fouls,
                  int turnovers,
                  int blocks,
                  int chargesTaken,
                  int personalFouls){
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.teamName = teamName;
        this.totalPoints = totalPoints;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.fieldGoalsMade = fieldGoalsMade;
        this.threePointersAttempted = threePointersAttempted;
        this.threePointersMade = threePointersMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.freeThrowsMade = freeThrowsMade;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.assists = assists;
        this.steals = steals;
        this.fouls = fouls;
        this.turnovers = turnovers;
        this.blocks = blocks;
        this.chargesTaken = chargesTaken;
        this.personalFouls = personalFouls;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(int fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }

    public int getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(int fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public int getThreePointersAttempted() {
        return threePointersAttempted;
    }

    public void setThreePointersAttempted(int threePointersAttempted) {
        this.threePointersAttempted = threePointersAttempted;
    }

    public int getThreePointersMade() {
        return threePointersMade;
    }

    public void setThreePointersMade(int threePointersMade) {
        this.threePointersMade = threePointersMade;
    }

    public int getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(int freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getChargesTaken() {
        return chargesTaken;
    }

    public void setChargesTaken(int chargesTaken) {
        this.chargesTaken = chargesTaken;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstName() + "-");
        sb.append(getLastName() + "-");
        sb.append(getNumber() + ",");
        sb.append(getTotalPoints() + ",");
        sb.append(getFieldGoalsAttempted() + ",");
        sb.append(getFieldGoalsMade() + ",");
        sb.append(getThreePointersAttempted() + ",");
        sb.append(getThreePointersMade() + ",");
        sb.append(getFreeThrowsAttempted() + ",");
        sb.append(getFreeThrowsMade() + ",");
        sb.append(getOffensiveRebounds() + ",");
        sb.append(getDefensiveRebounds() + ",");
        sb.append(getAssists() + ",");
        sb.append(getSteals() + ",");
        sb.append(getFouls() + ",");
        sb.append(getTurnovers() + ",");
        sb.append(getBlocks() + ",");
        sb.append(getChargesTaken() + ",");
        sb.append(getPersonalFouls());
        return sb.toString();
    }

}
