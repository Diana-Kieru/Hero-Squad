package tech.diana;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public models.Squad setupSquad(){
        return new models.Squad(5, "flash", "save lives");
    }

    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception{
        models.Squad squad = new models.Squad(5, "flash", "save lives");
        assertEquals(true, squad instanceof models.Squad);
    }

    @Test
    public void SquadInstantiatesWithMaxSize_true() {
        models.Squad squad = setupSquad();
        assertEquals(5, squad.getMaxSize());
    }

    @Test
    public void SquadInstantiatesWithName_true() {
        models.Squad squad = setupSquad();
        assertEquals("flash", squad.getName());
    }

    @Test
    public void SquadInstantiatesWithCause_true() {
        models.Squad squad = setupSquad();
        assertEquals("save lives", squad.getCause());
    }
}