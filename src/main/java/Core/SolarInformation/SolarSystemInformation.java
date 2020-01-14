package Core.SolarInformation;

public class SolarSystemInformation {
    private String userID;

    public SolarSystemInformation(String userID) {
        if(userID.matches("\\w\\w\\d\\d\\d\\d")) {
            this.userID = userID;
        }
        else{
            this.userID = "Not allowed";
        }
    }

    public String getUserID() {
        return userID;
    }
}
