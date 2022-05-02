package tech.diana;

import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        get("/hello", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
