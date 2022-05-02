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
        Hero hero = new Hero("Diana", 25, Strength.A,Weaknesses.F);


        Hero hero1 =new Hero("Kieru", 23, Strength.B, Weaknesses.F) ;


        Hero hero2 = new Hero("Maureen", 24, Strength.C, Weaknesses.H);


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
