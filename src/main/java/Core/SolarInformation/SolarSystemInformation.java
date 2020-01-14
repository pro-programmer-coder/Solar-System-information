package Core.SolarInformation;

public class SolarSystemInformation {
    private String objectType;
    private String objectName;

    public SolarSystemInformation(String userID) {
        if(userID.matches("[A-Z][A-Z]\\d\\d\\d\\d") && !userID.substring(2).equals("0000")) {
        }
        else{
            objectName = "Not allowed";
            objectType = "Not allowed";
        }
    }

    public String getObjectType() {
        return objectType;
    }

    public String getObjectName() {
        return objectName;
    }
}
