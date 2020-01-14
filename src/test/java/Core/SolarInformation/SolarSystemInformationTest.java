package Core.SolarInformation;

import Core.WebService.IWebService;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;


import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    IWebService mockWebService;

    @BeforeAll
    public void setup(){
        mockWebService = EasyMock.createMock(IWebService.class);
    }

    @Test
    public void validUserID(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = null;
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooLongLetters(){
        String actualUserID = "ABC1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooShortLetters(){
        String actualUserID = "A1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooShortNumbers(){
        String actualUserID = "AB123";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooLongNumbers(){
        String actualUserID = "AB12345";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDIncorrectCase(){
        String actualUserID = "Ab1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        String actualUserID1 = "bA1234";
        SolarSystemInformation solarSystemInformation1 = new SolarSystemInformation(actualUserID1, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());

        assertEquals(expectedObjectNaming, solarSystemInformation1.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation1.getObjectType());
    }

    @Test
    public void invalidUserID4ConsecutiveZeros(){
        String actualUserID = "AB0000";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testValidPassword(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = null;
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInvalidPasswordTooShort(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testValidPassword10Characters(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = null;
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testValidPassword30Characters(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?AaBbCc1!2?AaBbCc1!2?";
        String expectedObjectNaming = null;
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInvalidPasswordIncludeANonSymbol_(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBb_Cc1";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInValidPasswordIncludesOneOrMoreLowerCaseCharacter(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AABBCC123456?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInValidPasswordIncludesOneOrMoreUpperCase(){
        String actualUserID = "AB1234";
        String actualUserPassword = "aabbcc123456?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInValidPasswordIncludesOneOrMoreSymbol(){
        String actualUserID = "AB1234";
        String actualUserPassword = "aabbcC123456";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void initialiseAOCDetailsValidateObjectType(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "A99942Apo138M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsValidateNotObjectType(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "Z";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertFalse(solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsValidateObjectName(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "A99942Apo138M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsValidateObjectNameNumbers(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "A99942Apo138M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsValidateSmaNumbers(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "A99942Apo1M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        String actualAstronomicalObjectClassificationCode1 = "A99942Apo138M";
        SolarSystemInformation solarSystemInformation1 = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
        assertTrue(solarSystemInformation1.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode1));
    }

    @Test
    public void initialiseAOCDetailsValidateSmaLetters(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "S99942Apo138M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsTestAllExamples(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertTrue (solarSystemInformation.initialiseAOCDetailsValidate("SSun27TL"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("PMer58M"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("PEar150M"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("MMoo384T"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("MPho9T"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("DCer416M"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("DPlu6B"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("APal416M"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("A3Jun401M"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("A99942Apo138M"));
        assertTrue(solarSystemInformation.initialiseAOCDetailsValidate("CHal3B"));
    }

    @Test
    public void getStatusInfoWebService(){
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "SSun27TL";

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("Sun");
        replay(mockWebService);

        String s = solarSystemInformation.initialiseAOCDetailsValidate();
    }
}