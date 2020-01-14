package Core.SolarInformation;

import java.math.BigDecimal;

public class SolarSystemInformation {
    private String astronomicalObjectClassificationCode;
    private String objectType;
    private String objectName;
    private boolean exists;
    private int orbitalPeriod;
    private BigDecimal radius;
    private BigDecimal semiMajorAxis;
    private BigDecimal mass;



    public SolarSystemInformation(String userID, String password) {
        if(userID.matches("[A-Z][A-Z]\\d\\d\\d\\d") && !userID.substring(2).equals("0000") && password.length() >= 10 && validatePassword(password)) {
        }
        else{
            objectName = "Not allowed";
            objectType = "Not allowed";
            astronomicalObjectClassificationCode = "N\\A";
            exists = false;
            orbitalPeriod = 0;
            radius = new BigDecimal("0");
            semiMajorAxis = new BigDecimal("0");
            mass = new BigDecimal("0");
        }
    }

    public String getObjectType() {
        return objectType;
    }

    public String getObjectName() {
        return objectName;
    }

    private boolean validatePassword(String password){
        boolean lower = false;
        boolean upper = false;
        boolean symbol = false;
        for(char character : password.toCharArray()){
            if(String.valueOf(character).matches("[A-Z]")){
                upper = true;
            }
            if(String.valueOf(character).matches("[a-z]")){
                lower = true;
            }
            if(String.valueOf(character).matches("\\W")){
                symbol = true;
            }
            if(!String.valueOf(character).matches("[A-Za-z1-9\\W]")){
                return false;
            }
        }
        if(lower && upper && symbol) {
            return true;
        }
        else{
            return false;
        }
    }

    public String getAstronomicalObjectClassificationCode() {
        return astronomicalObjectClassificationCode;
    }

    public boolean isExists() {
        return exists;
    }

    public int getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public BigDecimal getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public BigDecimal getMass() {
        return mass;
    }
}
