package Core.SolarInformation;

public class SolarSystemInformation {
    private String objectType;
    private String objectName;

    public SolarSystemInformation(String userID, String password) {
        if(userID.matches("[A-Z][A-Z]\\d\\d\\d\\d") && !userID.substring(2).equals("0000") && password.length() >= 10 && validatePassword(password)) {
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

    private boolean validatePassword(String password){
        for(char character : password.toCharArray()){
            if(!String.valueOf(character).matches("[A-Za-z1-9\\W]")){
                return false;
            }
        }
        return true;
    }
}
