package rest.model;

import java.util.ArrayList;
import java.util.List;

public class VoteData {

    private String regionID;
    private String regionName;
    private String regionAddress;
    private String regionPostalCode;
    private String federalState;
    private String timestamp;
    private List<PartyData> countingData;

    /**
     * Constructor
     */
    public VoteData() {
        this.countingData = new ArrayList<>();
    }

    /**
     * Setter and Getter Methods
     */
    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionAddress() {
        return regionAddress;
    }

    public void setRegionAddress(String regionAddress) {
        this.regionAddress = regionAddress;
    }

    public String getRegionPostalCode() {
        return regionPostalCode;
    }

    public void setRegionPostalCode(String regionPostalCode) {
        this.regionPostalCode = regionPostalCode;
    }

    public String getFederalState() {
        return federalState;
    }

    public void setFederalState(String federalState) {
        this.federalState = federalState;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<PartyData> getCountingData() {
        return countingData;
    }

    public void setCountingData(List<PartyData> countingData) {
        this.countingData = countingData;
    }

    /**
     * Converts the object to XML format
     */
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<electionData>\n");
        xml.append(String.format("  <regionID>%s</regionID>\n", regionID));
        xml.append(String.format("  <regionName>%s</regionName>\n", regionName));
        xml.append(String.format("  <regionAddress>%s</regionAddress>\n", regionAddress));
        xml.append(String.format("  <regionPostalCode>%s</regionPostalCode>\n", regionPostalCode));
        xml.append(String.format("  <federalState>%s</federalState>\n", federalState));
        xml.append(String.format("  <timestamp>%s</timestamp>\n", timestamp));
        xml.append("  <countingData>\n");
        for (PartyData party : countingData) {
            xml.append(party.toXML());
        }
        xml.append("  </countingData>\n");
        xml.append("</electionData>");
        return xml.toString();
    }

    /**
     * Converts the object to JSON format
     */
    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append(String.format("  \"regionID\": \"%s\",\n", regionID));
        json.append(String.format("  \"regionName\": \"%s\",\n", regionName));
        json.append(String.format("  \"regionAddress\": \"%s\",\n", regionAddress));
        json.append(String.format("  \"regionPostalCode\": \"%s\",\n", regionPostalCode));
        json.append(String.format("  \"federalState\": \"%s\",\n", federalState));
        json.append(String.format("  \"timestamp\": \"%s\",\n", timestamp));
        json.append("  \"countingData\": [\n");
        for (int i = 0; i < countingData.size(); i++) {
            json.append(countingData.get(i).toJSON());
            if (i < countingData.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        json.append("  ]\n");
        json.append("}");
        return json.toString();
    }

    /**
     * Inner Class for Party Data
     */
    public static class PartyData {
        private String partyID;
        private int amountVotes;

        public String getPartyID() {
            return partyID;
        }

        public void setPartyID(String partyID) {
            this.partyID = partyID;
        }

        public int getAmountVotes() {
            return amountVotes;
        }

        public void setAmountVotes(int amountVotes) {
            this.amountVotes = amountVotes;
        }

        public String toXML() {
            return String.format("    <party>\n      <partyID>%s</partyID>\n      <amountVotes>%d</amountVotes>\n    </party>\n", partyID, amountVotes);
        }

        public String toJSON() {
            return String.format("    {\n      \"partyID\": \"%s\",\n      \"amountVotes\": %d\n    }", partyID, amountVotes);
        }
    }

}