package Core.SolarInformation;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    @Test
    public void validUserID(){
        String actualUserID = "AB1234";
        String expectedUserID = "AB1234";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expectedUserID, solarSystemInformation.getUserID());
    }

    @Test
    public void invalidUserIDTooLongLetters(){
        String actualUserID = "ABC1234";
        String expectedUserID = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expectedUserID, solarSystemInformation.getUserID());
    }

    @Test
    public void invalidUserIDTooShortLetters(){
        String actualUserID = "A1234";
        String expectedUserID = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expectedUserID, solarSystemInformation.getUserID());
    }

    @Test
    public void invalidUserIDTooShortNumbers(){
        String actualUserID = "AB123";
        String expectedUserID = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expectedUserID, solarSystemInformation.getUserID());
    }

    @Test
    public void invalidUserIDTooLongNumbers(){
        String actualUserID = "AB12345";
        String expectedUserID = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expectedUserID, solarSystemInformation.getUserID());
    }

    @Test
    public void invalidUserIDIncorrectCase(){
        String actualUserID = "Ab1234";
        String expectedUserID = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        String actualUserID1 = "bA1234";
        String expectedUserID1 = "Not allowed";
        SolarSystemInformation solarSystemInformation1 = new SolarSystemInformation(actualUserID1);

        assertEquals(expectedUserID1, solarSystemInformation1.getUserID());
    }

    @Test
    public void invalidUserID4ConsecutiveZeros(){
        String actualUserID = "AB0000";
        String expectedUserID = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expectedUserID, solarSystemInformation.getUserID());
    }
}