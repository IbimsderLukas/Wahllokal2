package rest.warehouse;

import org.springframework.stereotype.Service;
import rest.model.VoteData;
import rest.model.VoteData.PartyData;
import java.util.Arrays;

@Service
public class VoteService {

    /**
     * Liefert simulierte Wahldaten für eine Region
     */
    public VoteData getVoteData(String regionID) {
        VoteData data = new VoteData();
        data.setRegionID(regionID);
        data.setRegionName("Linz Bahnhof");
        data.setRegionAddress("Bahnhofsstrasse 27/9");
        data.setRegionPostalCode("Linz");
        data.setFederalState("Austria");
        data.setTimestamp("2024-09-12 11:48:21");

        // Simulierte Parteien und Stimmen
        PartyData party1 = new PartyData();
        party1.setPartyID("OEVP");
        party1.setAmountVotes(322);

        PartyData party2 = new PartyData();
        party2.setPartyID("SPOE");
        party2.setAmountVotes(301);

        PartyData party3 = new PartyData();
        party3.setPartyID("FPOE");
        party3.setAmountVotes(231);

        PartyData party4 = new PartyData();
        party4.setPartyID("GRUENE");
        party4.setAmountVotes(211);

        PartyData party5 = new PartyData();
        party5.setPartyID("NEOS");
        party5.setAmountVotes(182);

        // Daten hinzufügen
        data.setCountingData(Arrays.asList(party1, party2, party3, party4, party5));

        return data;
    }
}
