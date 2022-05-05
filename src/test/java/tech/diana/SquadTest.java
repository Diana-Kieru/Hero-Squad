//package tech.diana;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import tech.diana.domain.Squad;
//
//import static org.junit.Assert.assertEquals;
//
//public class SquadTest {
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    public Squad setupSquad(){
//        return new Squad(5, 1,"flash", "save lives");
//    }
//
//    @Test
//    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception{
//        Squad squad = new Squad(5, 1, "flash", "save lives");
//        assertEquals(true, squad instanceof Squad);
//    }
//
//    @Test
//    public void SquadInstantiatesWithMaxSize_true() {
//        Squad squad = setupSquad();
//        assertEquals(5, squad.getMaxSize());
//    }
//
//    @Test
//    public void SquadInstantiatesWithName_true() {
//        Squad squad = setupSquad();
//        assertEquals("flash", squad.getName());
//    }
//
//    @Test
//    public void SquadInstantiatesWithCause_true() {
//        Squad squad = setupSquad();
//        assertEquals("save lives", squad.getCause());
//    }
//}