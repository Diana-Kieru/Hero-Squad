//package tech.diana;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import tech.diana.domain.Hero;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class HeroTest {
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        Hero.clearAllHeros();
//    }
//
//    @Test
//    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception{
//        ArrayList<String> powers = new ArrayList<String>();
//        ArrayList<String> weaknesses = new ArrayList<String>();
//        powers.add("fly");
//        powers.add("super strength");
//        weaknesses.add("destructive temper");
//        weaknesses.add("kryptonite");
//
//        Hero hero = new Hero("supergirl",23,powers,weaknesses,1);
//        assertEquals(true, hero instanceof Hero);
//    }
//
//    public Hero setupNewHero() throws Exception{
//        ArrayList<String> powers = new ArrayList<String>();
//        ArrayList<String> weaknesses = new ArrayList<String>();
//        powers.add("fly");
//        powers.add("super strength");
//        weaknesses.add("destructive temper");
//        weaknesses.add("kryptonite");
//
//        Hero hero = new Hero("supergirl",23,powers,weaknesses,1);
//        return  hero;
//    }
//
//    public Hero setupAnotherHero() throws Exception{
//        ArrayList<String> powers = new ArrayList<String>();
//        ArrayList<String> weaknesses = new ArrayList<String>();
//        powers.add("fly");
//        powers.add("super strength");
//        weaknesses.add("magic");
//        weaknesses.add("kryptonite");
//
//        Hero anotherHero = new Hero("superman",30,powers,weaknesses,1);
//
//        return  anotherHero;
//    }
//
//    @Test
//    public void HeroInstanceWithName_true() throws Exception{
//        Hero hero = setupNewHero();
//        assertEquals("supergirl",hero.getName());
//    }
//
//    @Test
//    public void HeroInstanceWithAge_true() throws Exception{
//        Hero hero = setupNewHero();
//        assertEquals(23,hero.getAge());
//    }
//
//    @Test
//    public void HeroInstanceWithPowers_true() throws Exception{
//        Hero hero = setupNewHero();
//        assertTrue(hero.getPowers().contains("fly"));
//    }
//
//    @Test
//    public void HeroInstanceWithWeaknesses_true() throws Exception{
//        Hero hero = setupNewHero();
//        assertTrue(hero.getWeaknesses().contains("kryptonite"));
//    }
//
//    @Test
//    public void AllHerosReturnedCorrevtly_true() throws Exception {
//        Hero hero = setupNewHero();
//        Hero anotherHero = setupAnotherHero();
//        assertEquals(2,Hero.getAll().size());
//    }
//
//    @Test
//    public void AllHerosContainsAllPosts_true() throws Exception {
//        Hero hero = setupNewHero();
//        Hero anotherHero = setupAnotherHero();
//
//        assertTrue(Hero.getAll().contains(hero));
//        assertTrue(Hero.getAll().contains(anotherHero));
//    }
//
//    @Test
//    public void getId_herosInstantiateWithAnID_1() throws Exception{
//        Hero hero =setupNewHero();
//        assertEquals(1,hero.getId());
//    }
//
//    @Test
//    public void findReturnsCorrectPost() throws Exception{
//        Hero hero = setupNewHero();
//        assertEquals(1, Hero.findById(hero.getId()).getId());
//    }
//
//    @Test
//    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception{
//        Hero hero = setupNewHero();
//        Hero anotherHero = setupAnotherHero();
//
//        assertEquals(2,Hero.findById(anotherHero.getId()).getId());
//    }
//
//    @Test
//    public void updateChangesHerosContent() throws Exception{
//        Hero hero = setupNewHero();
//        String formerName = hero.getName();
//        int formerAge = hero.getAge();
//        ArrayList<String> formerPowers = hero.getPowers();
//        ArrayList<String> formerWeaknesses = hero.getWeaknesses();
//        int formerId = hero.getId();
//
//        ArrayList<String> powers = new ArrayList<String>();
//        ArrayList<String> weaknesses = new ArrayList<String>();
//        powers.add("risk taker");
//        powers.add("fast");
//        weaknesses.add("trust too much");
//        weaknesses.add("magic");
//
//        hero.update("clare",19,powers,weaknesses);
//
//        assertEquals(formerId, hero.getId());
//        assertNotEquals(formerName, hero.getName());
//        assertNotEquals(formerAge,hero.getAge());
//    }
//
//    @Test
//    public void deleteDeletesASpecificHero() throws Exception {
//        Hero hero = setupNewHero();
//        Hero anotherHero = setupAnotherHero();
//        hero.deleteHero();
//        assertEquals(1,Hero.getAll().size());
//        assertEquals(Hero.getAll().get(0).getId(),2);
//    }
//
//    @Test
//    public void deleteAllHerosDeletesAllHeros() throws Exception{
//        Hero hero = setupNewHero();
//        Hero anotherHero = setupAnotherHero();
//
//        Hero.clearAllHeros();
//        assertEquals(0,Hero.getAll().size());
//    }
//}