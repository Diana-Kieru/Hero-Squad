package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private int id;
    private ArrayList<String> powers = new ArrayList<String>();
    private ArrayList<String> weaknesses = new ArrayList<String>();
    private static ArrayList<Hero> instances = new ArrayList<Hero>();
    private int squadId;

    public Hero(String name, int age, ArrayList<String> powers, ArrayList<String> weaknesses, int squadId){
        this.name = name;
        this.age = age;
        this.powers = powers;
        this.weaknesses = weaknesses;
        this.squadId = squadId;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getPowers() {
        return powers;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void clearAllHeros(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Hero findById(int id){
        return  instances.get(id-1);
    }

    public void update(String name, int age, ArrayList<String> powers, ArrayList<String> weaknesses){
        this.name = name;
        this.age = age;
        this.powers = powers;
        this.weaknesses = weaknesses;
    }

    public void deleteHero(){
        instances.remove(id-1);
    }

    public int getSquadId() {
        return squadId;
    }
}
