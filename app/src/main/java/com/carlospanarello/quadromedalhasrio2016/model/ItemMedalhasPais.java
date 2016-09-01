package com.carlospanarello.quadromedalhasrio2016.model;

/**
 * Created by carlospanarello on 10/08/16.
 */
public class ItemMedalhasPais {
    private int id;
    private int gold_count;
    private int silver_count;
    private int bronze_count;
    private String id_sport;
    private String sport_name;
    private String id_country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGold_count() {
        return gold_count;
    }

    public void setGold_count(int gold_count) {
        this.gold_count = gold_count;
    }

    public int getSilver_count() {
        return silver_count;
    }

    public void setSilver_count(int silver_count) {
        this.silver_count = silver_count;
    }

    public int getBronze_count() {
        return bronze_count;
    }

    public void setBronze_count(int bronze_count) {
        this.bronze_count = bronze_count;
    }

    public String getId_sport() {
        return id_sport;
    }

    public void setId_sport(String id_sport) {
        this.id_sport = id_sport;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
    }
}
