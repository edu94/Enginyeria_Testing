package kiosk;

import data.Party;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class VoteCounterTest {

    static Set<Party> partitsTest;
    static Party PP;
    static Party PSOE;
    static VoteCounter contadorVots;
    @Before
    public void setVoteCounter() throws Exception {
        Party [] partitsArray = new Party[2];
        PP = new Party("PP");
        PSOE = new Party("PSOE");
        partitsArray[0]=PP;
        partitsArray[1]=PSOE;
        partitsTest = new HashSet<Party>(Arrays.asList(partitsArray));
        try {
            contadorVots = new VoteCounter(partitsTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countPartyTest() throws Exception {
        contadorVots.countParty(PP);
        assertEquals(contadorVots.getVotesFor(PP),1);
    }

    @Test
    public void countNullTest() {
        contadorVots.countNull();
        assertEquals(contadorVots.getNulls(), 1);
    }

    @Test
    public void countBlankTest() {
        contadorVots.countBlank();
        assertEquals(contadorVots.getBlanks(),1);
    }



}
