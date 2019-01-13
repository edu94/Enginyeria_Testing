package kiosk;

import data.Party;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class VoteCounter {

    private Map<Party, Integer> parties = new HashMap<>();
    private int null_votes = 0;
    private int blank_votes = 0;

    public VoteCounter(Set<Party> validParties) {
        for (Party p: validParties) {
            parties.put(p, 0);
        }
    }

    public void scrutinize(Party party) {
        if (party.getName().equals("null")){this.countNull();}
        else if(party.getName().equals("")){this.countBlank();}
        else{this.countParty(party);}
    }

    public void countNull() { this.null_votes ++; }
    public void countBlank() { this.blank_votes ++; }

    public void countParty(Party party) {
        int old_value = this.parties.get(party);
        this.parties.replace(party, old_value, (old_value+1));
    }

    public int getNulls() { return this.null_votes; }
    public int getBlanks() { return this.blank_votes; }
    public int getVotesFor(Party party) {
        return this.parties.get(party);
    }

    public int getTotal() {
        int total = this.getBlanks() + this.getNulls();
        for (Party p: this.parties.keySet()) {
            total += this.getVotesFor(p);
        }
        return total;
    }
}


