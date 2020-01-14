package Core.SolarInformation;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    @Test
    public void validUserID(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = null;
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooLongLetters(){
        String actualUserID = "ABC1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooShortLetters(){
        String actualUserID = "A1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooShortNumbers(){
        String actualUserID = "AB123";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooLongNumbers(){
        String actualUserID = "AB12345";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDIncorrectCase(){
        String actualUserID = "Ab1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        String actualUserID1 = "bA1234";
        SolarSystemInformation solarSystemInformation1 = new SolarSystemInformation(actualUserID1, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());

        assertEquals(expectedObjectNaming, solarSystemInformation1.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation1.getObjectType());
    }

    @Test
    public void invalidUserID4ConsecutiveZeros(){
        String actualUserID = "AB0000";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testValidPassword(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = null;
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }
}