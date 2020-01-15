package Core.SolarInformation;

import Core.WebService.IWebService;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;


import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    static IWebService mockWebService;

    @BeforeAll
    public static void setup(){
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
    public void initialiseAOCDetailsValidateObjectType() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);    }

    @Test
    public void initialiseAOCDetailsValidateNotObjectType() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "Z";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such classification or SMA code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsValidateObjectName() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "A99942Apo138M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);    }

    @Test
    public void initialiseAOCDetailsValidateObjectNameNumbers() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsValidateSmaNumbers() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);

    }

    @Test
    public void initialiseAOCDetailsValidateSmaLetters() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);
    }

    @Test
    public void getStatusInfoWebService() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode);

        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsInvalidateNotObjectName() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEarth150M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such classification or SMA code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsInvalidateSmaCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEar1500M";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such classification or SMA code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsInvalidateDistanceCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEar150E";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such classification or SMA code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
    }

    @Test
    public void initialiseAOCDetailsCantFindInformationOnInterface() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEvr560T";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("No such classification or SMA code");
        replay(mockWebService);

        assertEquals("No such classification or SMA code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsRaisedExceptionWithInterfaceReturnValue() throws SolarInformationException {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andThrow(new SolarInformationException());
        replay(mockWebService);

        Assertions.assertThrows(SolarInformationException.class, () -> solarSystemInformation.initialiseAOCDetailsValidate("PMer58M"));

        verify(mockWebService);
    }

    @Test
    public void testReturnRightAmountOfInformationForAOC() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");

        verify(mockWebService);
    }

    @Test
    public void testReturnWrongAmountOfInformationForAOC() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        assertThrows(Exception.class, () -> solarSystemInformation.initialiseAOCDetailsValidate("PMer58M"));

        verify(mockWebService);
    }

    @Test
    public void testSetterForAstronomicalObjectClassificationCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("PMer58M", solarSystemInformation.getAstronomicalObjectClassificationCode());

        verify(mockWebService);
    }

    @Test
    public void testSetterForCodeWithInvalidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("N/A", solarSystemInformation.getAstronomicalObjectClassificationCode());

        verify(mockWebService);
    }

    @Test
    public void testSetterForObjectTypeWithValidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("Planet", solarSystemInformation.getObjectType());

        verify(mockWebService);
    }


    @Test
    public void testSetterForObjectTypeWithInValidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Big Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("Not Allowed", solarSystemInformation.getObjectType());

        verify(mockWebService);
    }

    @Test
    public void testSetterForObjectNameWithValidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("Mercury", solarSystemInformation.getObjectName());

        verify(mockWebService);
    }

    @Test
    public void testSetterForObjectNameWithInValidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury planet,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("Not Allowed", solarSystemInformation.getObjectName());

        verify(mockWebService);
    }

    @Test
    public void testSetterForObjectNameWithValidCodeWithANumberAtTheStart() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,99942 Apophis,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("99942 Apophis", solarSystemInformation.getObjectName());

        verify(mockWebService);
    }

    @Test
    public void testSetterOrbitalPeriodValid() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(88, solarSystemInformation.getOrbitalPeriod());

        verify(mockWebService);
    }


    @Test
    public void testSetterRadiusValid() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,57909050,330110000000000000000000");
        replay(mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(2439.4), solarSystemInformation.getRadius());

        verify(mockWebService);
    }

}