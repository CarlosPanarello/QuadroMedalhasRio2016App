package com.carlospanarello.quadromedalhasrio2016.model;

/**
 * Created by carlospanarello on 10/08/16.
 */
public class ItemQuadroMedalha {

    private int id;
    private String id_country;
    private int gold_count;
    private int silver_count;
    private int bronze_count;
    private int total_medals;
    private int position;
    private String name_country;

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
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

    public int getTotal_medals() {
        return total_medals;
    }

    public void setTotal_medals(int total_medals) {
        this.total_medals = total_medals;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
