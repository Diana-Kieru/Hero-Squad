package tech.diana;

import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.template.handlebars.HandlebarsTemplateEngine;
import tech.diana.domain.Hero;
import tech.diana.domain.enumerations.Strength;
import tech.diana.domain.enumerations.Weaknesses;


import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("Diana");
        hero.setAge(25);
        hero.setStrength(Strength.A);
        hero.setWeakness(Weaknesses.F);

        Hero hero1 =new Hero();
        hero1.setName("Kieru");
        hero1.setAge(23);
        hero1.setStrength(Strength.B);
        hero1.setWeakness(Weaknesses.G);

        Hero hero2 = new Hero();
        hero2.setName("Maureen");
        hero2.setAge(24);
        hero2.setStrength(Strength.B);
        hero2.setWeakness(Weaknesses.H);

        List<Hero> heroList = new ArrayList<>();
        heroList.add(hero);
        heroList.add(hero1);
        heroList.add(hero2);


        get("/hello", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("heroList", heroList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
