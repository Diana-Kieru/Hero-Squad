package tech.diana.domain;

import tech.diana.domain.enumerations.Strength;
import tech.diana.domain.enumerations.Weaknesses;

public class Hero {
    private String name;
    private int age;
    private Strength strength;
    private Weaknesses weakness;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public Weaknesses getWeakness() {
        return weakness;
    }

    public void setWeakness(Weaknesses weakness) {
        this.weakness = weakness;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", strength=" + strength +
                ", weakness=" + weakness +
                '}';
    }
}
