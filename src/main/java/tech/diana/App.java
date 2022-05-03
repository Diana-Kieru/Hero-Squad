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
        staticFileLocation("/public");
        Hero hero = new Hero("Diana", 25, Strength.A, Weaknesses.F);


        Hero hero1 = new Hero("Kieru", 23, Strength.B, Weaknesses.F);


        Hero hero2 = new Hero("Maureen", 24, Strength.C, Weaknesses.H);


        List<Hero> heroList = new ArrayList<>();
        heroList.add(hero);
        heroList.add(hero1);
        heroList.add(hero2);

        Map<String, Object> model = new HashMap<>();
        get("/hello", (req, res) -> {

            model.put("heroList", heroList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("heroes", (req, res) -> {
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            Strength strength = Strength.valueOf(req.queryParams("strength"));
            Weaknesses weakness = Weaknesses.valueOf(req.queryParams("weakness"));
            Hero newhero = new Hero(name, age, strength, weakness);
            heroList.add(newhero);
            model.put("heroList", heroList);


            res.redirect("/hello");
            return null;
        }, new HandlebarsTemplateEngine());


    }
}
