package kiosk;

import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import org.junit.Test;
import org.junit.Before;

import services.ElectoralOrganism;
import services.MailerService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class VotingKioskTest {

    public VoteCounter voteCounter;
    private Party party;

    String sign;

    class ElectoralOrganismImp implements ElectoralOrganism{

        private Nif voted = new Nif("12341234C");

        ElectoralOrganismImp() throws Exception {
        }

        @Override
        public boolean canVote(Nif nif) {
            return (nif != voted);
        }

        @Override
        public void disableVoter(Nif nif) {
            voted = nif;
        }

        @Override
        public DigitalSignature askForDigitalSignature(Party party) {

            DigitalSignature signature = null;
            try {
                signature = new DigitalSignature(sign);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return signature;
        }
    }

    class MailerServiceImp implements MailerService{
        private boolean sent = false;
        @Override
        public void send(MailAddress address, DigitalSignature signature) {
            sent = !sent;
        }

        boolean isSent(){
            return sent;
        }
    }


    @Before
    public void setup() throws Exception {
        Set<Party> parties = new HashSet<>();
        this.party = new Party("test");
        parties.add(party);

        this.voteCounter = new VoteCounter(parties);
    }

    @Test
    public void testVote(){
        VotingKiosk kiosk = new VotingKiosk(voteCounter);
        kiosk.vote(party);

        assertEquals(1, voteCounter.getVotesFor(party));
    }

    @Test
    public void testSendeReceipt() throws Exception {

        MailAddress address = new MailAddress("test@test.com");


        ElectoralOrganism electoralOrganism = new ElectoralOrganismImp();
        MailerService mailerService = new MailerServiceImp();

        VotingKiosk kiosk = new VotingKiosk(voteCounter);
        kiosk.setElectoralOrganism(electoralOrganism);
        kiosk.setMailerService(mailerService);

        kiosk.sendeReceipt(address);

        assertTrue(((MailerServiceImp) mailerService).isSent());
    }

    @Test
    public void testSendeReceiptNotValid() throws Exception {

        MailAddress address = new MailAddress("test@test.com");


        ElectoralOrganism electoralOrganism = new ElectoralOrganismImp();
        MailerService mailerService = new MailerServiceImp();

        VotingKiosk kiosk = new VotingKiosk(voteCounter);
        kiosk.setElectoralOrganism(electoralOrganism);
        kiosk.setMailerService(mailerService);

        // First time works
        kiosk.sendeReceipt(address);

        // Second time does not work
        kiosk.sendeReceipt(address);


        assertFalse(((MailerServiceImp) mailerService).isSent());
    }

    @Test
    public void testSendeReceiptNifNotValid() throws Exception {

        MailAddress address = new MailAddress("test@test.com");


        ElectoralOrganism electoralOrganism = new ElectoralOrganismImp();
        MailerService mailerService = new MailerServiceImp();

        VotingKiosk kiosk = new VotingKiosk(voteCounter);
        kiosk.setElectoralOrganism(electoralOrganism);
        kiosk.setMailerService(mailerService);

        Nif noVote = new Nif("12341234C");
        electoralOrganism.disableVoter(noVote);

        // First time works
        kiosk.sendeReceipt(address);


        assertFalse(electoralOrganism.canVote(noVote));
    }
    
}