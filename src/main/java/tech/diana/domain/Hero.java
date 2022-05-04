package tech.diana.domain;

import tech.diana.domain.enumerations.Strength;
import tech.diana.domain.enumerations.Weaknesses;

public class Hero {
    private int heroAge;
    private String heroStrength;
    private String heroWeakness;
    private int heroId;

    public Hero(int heroAge, String heroStrength, String heroWeakness, int heroId) {
        this.heroAge = heroAge;
        this.heroStrength = heroStrength;
        this.heroWeakness = heroWeakness;
        this.heroId = heroId;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public void setHeroAge(int heroAge) {
        this.heroAge = heroAge;
    }

    public String getHeroStrength() {
        return heroStrength;
    }

    public void setHeroStrength(String heroStrength) {
        this.heroStrength = heroStrength;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public void setHeroWeakness(String heroWeakness) {
        this.heroWeakness = heroWeakness;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }
}

