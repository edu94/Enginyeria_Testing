package kiosk;


import data.*;
import services.*;

public class VotingKiosk {

    private ElectoralOrganism eO;
    private MailerService mService;
    private VoteCounter voteCounter;


    public VotingKiosk() {

    }
    public void setElectoralOrganism(ElectoralOrganism eO) {
        this.eO = eO;
    }
    public void setMailerService(MailerService mService){
        this.mService= mService;
    }

    public void vote(Party party) {
        voteCounter.scrutinize(party);
    }
    public void sendeReceipt(MailAddress address) {

    }
}
