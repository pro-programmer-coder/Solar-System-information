package Core.SolarInformation;

import Core.WebService.IWebService;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class SolarSystemInformation {
    private String astronomicalObjectClassificationCode;
    private String objectType;
    private String objectName;
    private boolean exists;
    private int orbitalPeriod;
    private BigDecimal radius;
    private BigDecimal semiMajorAxis;
    private BigDecimal mass;

    private IWebService webService;

    public SolarSystemInformation(String userID, String password, IWebService webService) {
        if(userID.matches("[A-Z][A-Z]\\d\\d\\d\\d") && !userID.substring(2).equals("0000") && password.length() >= 10 && validatePassword(password)) {
            this.webService = webService;
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

    public String initialiseAOCDetailsValidate(String AstronomicalObjectClassificationCode) throws Exception {
        if(AstronomicalObjectClassificationCode.matches("^(S|P|M|D|A|C)\\d{0,8}([A-Z][a-z][a-z])\\d{1,3}(T|M|B|L|TL)")){
                String AocReturn = null;
                AocReturn = webService.getStatusInfo(AstronomicalObjectClassificationCode);
                String[] AocReturnSplit = AocReturn.split(",");
                if(AocReturnSplit.length != 7){
                    throw new Exception("Not right amount of information");
                }
                setAstronomicalObjectClassificationCode(AocReturnSplit[0]);
                setObjectType(AocReturnSplit[1]);
                setObjectName(AocReturnSplit[2]);
                setOrbitalPeriod(Integer.valueOf(AocReturnSplit[3]));
                setRadius(new BigDecimal(AocReturnSplit[4]));
                setSemiMajorAxis(new BigDecimal(AocReturnSplit[5]));
                setMass(new BigDecimal(AocReturnSplit[6]));
                setExists(true);
                return AocReturn;
        }
        return "No such classification or SMA code";
    }
}
