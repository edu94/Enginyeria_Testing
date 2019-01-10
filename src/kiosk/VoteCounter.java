package kiosk;

import data.Party;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;


public class VoteCounter {

    private int blancks;
    private int nulls;
    private int contparty;
    private HashMap<Party, Integer> vots;
    private ArrayList<Party> listParties;



    public VoteCounter(Set<Party> validParties) {
        vots = new HashMap<>();
        listParties.addAll(validParties);

    }

    public void countParty(Party party) throws Exception {
        if (listParties.contains(party)) {
            if (vots.containsKey(party)) {
                vots.put(party, vots.get(party) + 1);

            }else{
                vots.put(party,1);
            }
        }else{
            throw new Exception("The party doesn't exist");
        }
        this.contparty++;
    }

    public void countNull() {
        this.nulls++;
    }

    public void countBlank() {
        this.blancks++;
    }

    public void scrutinize(Party party) {
        if (party.equals("")) {
            countBlank();
        }else if (party.equals("null")){
            countNull();
        }else{
            try {
                countParty(party);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getVotesFor(Party party) {
        if(!vots.containsKey(party)) {
            return 0;
        }
        return vots.get(party);
    }

    public int getNulls() {
        return nulls;
    }

    public int getBlanks() {
        return blancks;
    }

    public int getTotal() {
        int total = this.blancks + this.nulls + this.contparty;
        return total;
    }
}


