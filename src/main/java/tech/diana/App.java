package tech.diana;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import tech.diana.domain.Hero;
import tech.diana.domain.Squad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }




   static List<Squad> instance = new ArrayList<Squad>();
   public static Squad findById(List<Squad> squads, int squadId){
       for (Squad squad: squads){
           if (squad.getId()==squadId){
               return squad;
           }
       }
       return null;
   }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));

            String[] powersAdd = request.queryMap().toMap().get("power");
            ArrayList<String> powers = new ArrayList<String>();
            for (int i=0;i<powersAdd.length;i++){
                powers.add(powersAdd[i]);
            }
            model.put("powers",powers);

            String[] weaknessAdd =  request.queryMap().toMap().get("weakness");
            ArrayList<String> weaknesses = new ArrayList<String>();
            for (String s:weaknessAdd){
                weaknesses.add(s);
            }
            model.put("weaknesses",weaknesses);

            List<Squad> squads = instance;
            model.put("squads",squads);
            int squadId = 23;

            Hero hero = new Hero(name,age,powers,weaknesses,squadId);

            model.put("hero",hero);

            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            ArrayList<Hero> heroes = Hero.getAll();
//            model.put("heroes",heroes);
//            ArrayList<Squad> squads = Squad.getAll();
//            model.put("squads",squads);
            return new ModelAndView(model, "heroes.hbs");
        },new HandlebarsTemplateEngine());

        get("/heroes/list",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            List<Squad> squads = instance;
            model.put("squads",squads);
            for (Hero hero: heroes) {
                int idOfHeroToFind = hero.getSquadId();
                Squad squad = findById(instance, idOfHeroToFind);
                model.put("squad",squad);
            }

            return new ModelAndView(model,"heroesList.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/delete", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            Hero.clearAllHeros();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params("id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            int squadId = foundHero.getSquadId();
            Squad squad = findById(instance, squadId);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("squad",squad);
            model.put("hero",foundHero);
            model.put("heroes",heroes);
            return new ModelAndView(model,"heroesList.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squads = instance;
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));

            Hero editHero = Hero.findById(idOfHeroToEdit);

            model.put("editHero", editHero);
            model.put("squads",squads);

            return  new ModelAndView(model, "heroes.hbs");

        }, new HandlebarsTemplateEngine());

        post("/heroes/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = request.queryParams("name");
            int newAge = Integer.parseInt(request.queryParams("age"));
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            String[] powersAdd = request.queryMap().toMap().get("power");
            ArrayList<String> powers = new ArrayList<String>();
            for (int i=0;i<powersAdd.length;i++){
                powers.add(powersAdd[i]);
            }
            model.put("powers",powers);

            String[] weaknessAdd =  request.queryMap().toMap().get("weakness");
            ArrayList<String> weaknesses = new ArrayList<String>();
            for (String s:weaknessAdd){
                weaknesses.add(s);
            }
            Hero editHero = Hero.findById(idOfHeroToEdit);
            editHero.update(newName, newAge, powers, weaknesses);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("id"));

            Hero deleteHero = Hero.findById(idOfHeroToDelete);
            deleteHero.deleteHero();

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //squad
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad.hbs");
        },new HandlebarsTemplateEngine());

        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String cause = request.queryParams("cause");
            Squad squad = new Squad( instance.size()+1, maxSize,name,cause);
            instance.add(squad);
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Squad> squads = instance;
            model.put("squads", instance);
            System.out.println("squads" + instance);

            return new ModelAndView(model, "squadList.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/:id",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            int squadId =Integer.parseInt(request.params("squadId"));
            Hero heroes = Hero.findById(squadId);
            Squad squads = findById(instance, squadId);
            model.put("squad",squads);
            model.put("heroes", heroes);
            return new ModelAndView(model,"anything.hbs");
        },new HandlebarsTemplateEngine());


    }
}
