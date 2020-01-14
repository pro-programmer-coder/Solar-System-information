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
            objectName = "Not Allowed";
            objectType = "Not Allowed";
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

    private void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectName() {
        return objectName;
    }

    private void setObjectName(String objectName) {
        this.objectName = objectName;
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

    private void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) {
        this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
    }

    public boolean isExists() {
        return exists;
    }

    private void setExists(boolean exists) {
        this.exists = exists;
    }

    public int getOrbitalPeriod() {
        return orbitalPeriod;
    }

    private void setOrbitalPeriod(int orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    private void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public BigDecimal getSemiMajorAxis() {
        return semiMajorAxis;
    }

    private void setSemiMajorAxis(BigDecimal semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public BigDecimal getMass() {
        return mass;
    }

    private void setMass(BigDecimal mass) {
        this.mass = mass;
    }

    public boolean initialiseAOCDetailsValidate(String AstronomicalObjectClassificationCode) {
        if(AstronomicalObjectClassificationCode.toCharArray()[0] == 'S' ||
                AstronomicalObjectClassificationCode.toCharArray()[0] == 'P' ||
                AstronomicalObjectClassificationCode.toCharArray()[0] == 'M' ||
                AstronomicalObjectClassificationCode.toCharArray()[0] == 'D' ||
                AstronomicalObjectClassificationCode.toCharArray()[0] == 'A' ||
                AstronomicalObjectClassificationCode.toCharArray()[0] == 'C'){
            return true;
        }
        return false;
    }
}
