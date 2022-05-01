package tech.diana.domain;

import tech.diana.domain.enumerations.Fighting;

public class Squad {
    private String name;
    private int size;
    private int age;
    private Fighting fight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Fighting getFight() {
        return fight;
    }

    public void setFight(Fighting fight) {
        this.fight = fight;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", age=" + age +
                ", fight=" + fight +
                '}';
    }
}
