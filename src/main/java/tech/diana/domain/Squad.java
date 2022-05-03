package tech.diana.domain;

import tech.diana.domain.enumerations.FightingCause;

public class Squad {
    private String name;
    private int size;
//
    private FightingCause fightingCause;

    public Squad(String name, int size, FightingCause fightingCause) {
        this.name = name;
        this.size = size;
//
        this.fightingCause = fightingCause;
    }

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

//
    public FightingCause getFightingCause() {
        return fightingCause;
    }

    public void setFightingCause(FightingCause fightingCause) {
        this.fightingCause = fightingCause;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", size=" + size +

                ", fight=" + fightingCause +
                '}';
    }
}
