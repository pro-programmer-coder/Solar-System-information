package Core.SolarInformation;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    @Test
    public void validUserID(){
        String actualUserID = "AB1234";
        String expected = "AB1234";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID);

        assertEquals(expected, solarSystemInformation.getUserID());
    }
}