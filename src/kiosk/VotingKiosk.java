package kiosk;


import data.*;
import services.*;

public class VotingKiosk {
    private ElectoralOrganism eO;
    private MailerService mService;
    private VoteCounter voteCounter;
    private Party party;

    public VotingKiosk(VoteCounter voteCounter) {
        this.voteCounter= voteCounter;
    }

    public void setElectoralOrganism(ElectoralOrganism eO) {
        this.eO = eO;
    }
    public void setMailerService(MailerService mService){
        this.mService= mService;
    }




    public void vote(Party party) {
        this.party = party;
        this.voteCounter.scrutinize(party);

    }
    public void sendeReceipt(MailAddress address) {

        DigitalSignature sign = eO.askForDigitalSignature(party);
        mService.send(address,sign);
    }
}









