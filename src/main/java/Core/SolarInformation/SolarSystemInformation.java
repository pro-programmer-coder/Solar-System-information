package Core.SolarInformation;

import Core.WebService.IWebService;
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

    private IWebService webService;

    //Brief has 2 parameters but this needs three. The webservice has to be passed for every constructor to authenticate the user
    public SolarSystemInformation(String userID, String password, IWebService webService) {
        //validating username and password using Regular Expressions
        //2capital letters followed by 4 digits.  user not equal to 0000      password length larger then 10   validate password method
        if(userID.matches("[A-Z][A-Z]\\d\\d\\d\\d") && !userID.substring(2).equals("0000") && password.length() >= 10 && validatePassword(password)) {
            this.webService = webService;
            //WebService can't find user from username and password combination
            if(!this.webService.authenticate(userID,password)){
                //run setters for invalid password
                inValidUsrPasswordOrAOC();
            }
        }
        else{
            inValidUsrPasswordOrAOC();
        }

    }

    //default values for user/password not validated by program or webservice interface
    public void inValidUsrPasswordOrAOC(){
        objectName = "Not Allowed";
        objectType = "Not Allowed";
        astronomicalObjectClassificationCode = " ";
        exists = false;
        orbitalPeriod = 0;
        radius = new BigDecimal(0);
        semiMajorAxis = new BigDecimal(0);
        mass = new BigDecimal(0);
    }

    public String getObjectType() {
        return objectType;
    }

    private void setObjectType(String objectType) {
        //Has to be certain types
        if(objectType.equals("Planet") ||objectType.equals("Star") ||objectType.equals("Moon") ||objectType.equals("Dwarf Planet") ||objectType.equals("Asteroid") ||objectType.equals("Comet")) {
            this.objectType = objectType;
        }
        else{
            this.objectType = "Not Allowed";
        }
    }

    public String getObjectName() {
        return objectName;
    }

    private void setObjectName(String objectName) {
        //same regular expression
        if(objectName.matches("\\d{0,8}\\s?([A-Z][a-z]+)+")) {
            this.objectName = objectName;
        }
        else{
            this.objectName = "Not Allowed";
        }
    }

    //validating the password
    private boolean validatePassword(String password){
        boolean lower = false;
        boolean upper = false;
        boolean symbol = false;
        //each character in password
        for(char character : password.toCharArray()){
            //if match a regular expression format set that to true
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
        //all three formats have to be included and thus true
        return lower && upper && symbol;
    }

    public String getAstronomicalObjectClassificationCode() {
        return astronomicalObjectClassificationCode;
    }

    private void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) throws Exception {
        //validate AOC before setting it
        try {
            if (validateAOC(astronomicalObjectClassificationCode)) {
                this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
            }
            //validation fails
            else {
                this.astronomicalObjectClassificationCode = "Not Allowed";
            }
        }catch(Exception e){
            this.astronomicalObjectClassificationCode = "Not Allowed";
        }
    }

    //validate AOC
    private boolean validateAOC(String astronomicalObjectClassificationCode) throws Exception {
        //Start with Object Type Letter, 0-8 digits, Planet name Capital letter followed by 2 lower case letter, SMA 1-3 digits, SMA unit Letter
        if (astronomicalObjectClassificationCode.matches("^([SPMDAC])\\d{0,8}([A-Z][a-z][a-z])\\d{1,3}(T|M|B|L|TL)")) {
            return true;
        } else {
            throw new Exception("AOC Not Formatted Correctly");
        }
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
        //if not negative number. this can't be negative
        if(orbitalPeriod > 0) {
            this.orbitalPeriod = orbitalPeriod;
        }
        else{
            this.orbitalPeriod = 0;
        }
    }

    public BigDecimal getRadius() {
        return radius;
    }

    private void setRadius(BigDecimal radius) {
        //if not negative number. this can't be negative
        if(radius.compareTo(BigDecimal.valueOf(0)) > 0){
            this.radius = radius;
        }
        else{
            this.radius = BigDecimal.valueOf(0);
        }
    }

    public BigDecimal getSemiMajorAxis() {
        return semiMajorAxis;
    }

    private void setSemiMajorAxis(BigDecimal semiMajorAxis) {
        //if not negative number. this can't be negative
        if(semiMajorAxis.compareTo(BigDecimal.valueOf(0)) > 0) {
            this.semiMajorAxis = semiMajorAxis;
        }
        else{
            this.semiMajorAxis = BigDecimal.valueOf(0);
        }
    }

    public BigDecimal getMass() {
        return mass;
    }

    private void setMass(BigDecimal mass) {
        //if not negative number. this can't be negative
        if(mass.compareTo(BigDecimal.valueOf(0)) > 0) {
            this.mass = mass;
        }
        else{
            this.mass = BigDecimal.valueOf(0);
        }
    }


    //uses webservice interface
    public String initialiseAOCDetailsValidate(String astronomicalObjectClassificationCode) throws Exception {
        //validate AOC code first before call to interface
        if(validateAOC(astronomicalObjectClassificationCode)){
            String AocReturn = null;
            //return from web service
            AocReturn = webService.getStatusInfo(astronomicalObjectClassificationCode);
            //split return using ',' as this is what gets returned
            String[] AocReturnSplit = AocReturn.split(",");
            //if no ','
            if(AocReturnSplit.length == 1){
                inValidUsrPasswordOrAOC();
                setExists(false);
                return "No such astronomical object classification code";
            }
            //if return doesn't return right amount of data
            else if(AocReturnSplit.length != 7){
                inValidUsrPasswordOrAOC();
                setExists(false);
                throw new Exception("No such astronomical object classification code");
            }

            //setters for the return data
            setAstronomicalObjectClassificationCode(AocReturnSplit[0]);
            setObjectType(AocReturnSplit[1]);
            setObjectName(AocReturnSplit[2]);
            setOrbitalPeriod(Integer.parseInt(AocReturnSplit[3]));
            setRadius(new BigDecimal(AocReturnSplit[4]));
            setSemiMajorAxis(new BigDecimal(AocReturnSplit[5]));
            setMass(new BigDecimal(AocReturnSplit[6]));
            setExists(true);
            return AocReturn;
        }
        setExists(false);
        return "No such astronomical object classification code";
    }

    // toString as detailed in requirements
    @Override
    public String toString() {
        return objectType + ", " + objectName + "[" + astronomicalObjectClassificationCode + "] " + semiMajorAxis + " km, " + mass + " kg";
    }
}
