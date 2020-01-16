package Core.SolarInformation;

import Core.WebService.IWebService;
import Core.WebService.StubWebServiceAuthenticateFail;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.*;

//With some of the test using the WebService interface the inputs and outputs may not match correct for actual data but they pass validation
//May use Earth AOC code but get information back about Mercury. Essentially for the tests this is not important. Testing the external method gets called but the return value needs to be correct format not factual information. just for the tests
class SolarSystemInformationTest {

    static IWebService mockWebService;

    //used where the mocking is not being tested but need the mock object for the test
    @BeforeAll
    public static void setup(){
        mockWebService = EasyMock.createMock(IWebService.class);
    }

    //user authentication
    @Test
    public void validUserIDWhichDoesntSetTheObjectNameOrType(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        //Name and Type not set yet if usr/password is valid
        String expectedObjectNaming = null;
        String expectedObjectType = null;
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectType, solarSystemInformation.getObjectType());

        verify(mockWebService);
    }

    @Test
    public void invalidUserIDTooManyLetters(){
        String actualUserID = "ABC1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooLittleLetters(){
        String actualUserID = "A1234";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooLittleNumbers(){
        String actualUserID = "AB123";
        String actualUserPassword = "AaBbCc1!2?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void invalidUserIDTooManyNumbers(){
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
    public void invalidUserID4ConsecutiveZerosForNumbers(){
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

        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());

        verify(mockWebService);
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
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());

        verify(mockWebService);
    }

    @Test
    public void testValidPassword30Characters(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?AaBbCc1!2?AaBbCc1!2?";
        String expectedObjectNaming = null;
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());

        verify(mockWebService);
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
    public void testInValidPasswordNotIncludesOneOrMoreLowerCaseCharacters(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AABBCC123456?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInValidPasswordNotIncludesOneOrMoreUpperCase(){
        String actualUserID = "AB1234";
        String actualUserPassword = "aabbcc123456?";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    @Test
    public void testInValidPasswordNotIncludesOneOrMoreSymbol(){
        String actualUserID = "AB1234";
        String actualUserPassword = "aabbcC123456";
        String expectedObjectNaming = "Not Allowed";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectName());
        assertEquals(expectedObjectNaming, solarSystemInformation.getObjectType());
    }

    //AOC validation
    @Test
    public void initialiseAOCDetailsValidateObjectType() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";

        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsInValidAOCCodeNotCorrectObjectType() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "Z";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);


        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such astronomical object classification code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsValidateObjectName() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "A99942Apo138M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);    }

    @Test
    public void initialiseAOCDetailsInValidObjectNameNumbers() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);


        assertEquals("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsValidateSmaNumbers() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);

    }

    @Test
    public void initialiseAOCDetailsValidateSmaLetters() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);
    }

    @Test
    public void getStatusInfoWebService() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode);

        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsInvalidateNotObjectName() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEarth150M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such astronomical object classification code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));

        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsInvalidateSmaCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEar1500M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such astronomical object classification code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsInvalidateDistanceCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEar150E";

        IWebService mockWebService = EasyMock.createMock(IWebService.class);
        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("No such astronomical object classification code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsCantFindInformationOnInterface() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PEvr560T";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("No such classification or SMA code");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);


        assertEquals("No such astronomical object classification code",solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode));
        verify(mockWebService);
    }

    @Test
    public void initialiseAOCDetailsRaisedExceptionWithInterfaceReturnValue() throws SolarInformationException {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andThrow(new SolarInformationException());
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        Assertions.assertThrows(SolarInformationException.class, () -> solarSystemInformation.initialiseAOCDetailsValidate("PMer58M"));

        verify(mockWebService);
    }

    @Test
    public void testReturnRightAmountOfInformationForAOC() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");

        verify(mockWebService);
    }

    @Test
    public void testReturnWrongAmountOfInformationForAOC() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);


        assertThrows(Exception.class, () -> solarSystemInformation.initialiseAOCDetailsValidate("PMer58M"));

        verify(mockWebService);
    }

    //Test setters. Mock is run as well as the setters are private so has to be called from a method within the class. Not test
    @Test
    public void testSetterForAstronomicalValidObjectClassificationCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);


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

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("Not Allowed", solarSystemInformation.getAstronomicalObjectClassificationCode());

        verify(mockWebService);
    }

    @Test
    public void testSetterForObjectTypeWithValidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

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

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Big Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

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

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

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

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury planet,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

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

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,99942 Apophis,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);


        solarSystemInformation.initialiseAOCDetailsValidate(actualAstronomicalObjectClassificationCode);
        assertEquals("99942 Apophis", solarSystemInformation.getObjectName());

        verify(mockWebService);
    }

    @Test
    public void testSetterOrbitalPeriodValid() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(88, solarSystemInformation.getOrbitalPeriod());

        verify(mockWebService);
    }

    @Test
    public void testSetterOrbitalPeriodInValidNegativeNumber() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,-88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(0, solarSystemInformation.getOrbitalPeriod());

        verify(mockWebService);
    }


    @Test
    public void testSetterRadiusValid() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(2439.4), solarSystemInformation.getRadius());

        verify(mockWebService);
    }

    @Test
    public void testSetterRadiusInValidNumberNegative() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,-2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(0), solarSystemInformation.getRadius());

        verify(mockWebService);
    }

    @Test
    public void testSetterMassValidNumber() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(3.3011e23), solarSystemInformation.getMass());

        verify(mockWebService);
    }

    @Test
    public void testSetterMassInValidNegativeNumber() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,-3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(0), solarSystemInformation.getMass());

        verify(mockWebService);
    }

    @Test
    public void testSetterSMAValidCode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(5.79e7), solarSystemInformation.getSemiMajorAxis());

        verify(mockWebService);
    }

    @Test
    public void testSetterSMAInValidSMACode() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,-5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals(BigDecimal.valueOf(0), solarSystemInformation.getSemiMajorAxis());

        verify(mockWebService);
    }

    //ToString
    @Test void SolarSystemInformationToStringTest() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String actualAstronomicalObjectClassificationCode = "PMer58M";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(actualAstronomicalObjectClassificationCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        solarSystemInformation.initialiseAOCDetailsValidate("PMer58M");
        assertEquals("Planet, Mercury[PMer58M] 5.79E+7 km, 3.3011E+23 kg", solarSystemInformation.toString());

        verify(mockWebService);
    }

    //Authenticate service
    @Test
    public void validAuthenticateMethodUserHasBeenFound(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        verify(mockWebService);
    }

    @Test
    public void userOrPasswordNotFoundByWebServiceInterface(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(false);
        replay(mockWebService);

        SolarSystemInformation solarInformationException = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);

        assertEquals("Not Allowed", solarInformationException.getObjectName());
        assertEquals("Not Allowed", solarInformationException.getObjectType());

        verify(mockWebService);
    }

    @Test
    public void userOrPasswordNotFoundUsingStubForExample(){
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";

        IWebService stubWebService = new StubWebServiceAuthenticateFail();

        SolarSystemInformation solarInformationException = new SolarSystemInformation(actualUserID, actualUserPassword, stubWebService);

        assertEquals("Not Allowed", solarInformationException.getObjectName());
        assertEquals("Not Allowed", solarInformationException.getObjectType());

    }

    @Test
    public void AOCCodeIncorrectSoSetsPlanetExistenceToFalse() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String AOCCode = "PMar78B";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(AOCCode)).andReturn("No such classification or SMA code");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);
        solarSystemInformation.initialiseAOCDetailsValidate(AOCCode);

        assertFalse(solarSystemInformation.isExists());

        verify(mockWebService);
    }

    @Test
    public void AOCCodeInvalidSoSetsPlanetExistenceToFalse() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String AOCCode = "PMars78B";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);
        solarSystemInformation.initialiseAOCDetailsValidate(AOCCode);

        assertFalse(solarSystemInformation.isExists());

        verify(mockWebService);
    }

    @Test
    public void AOCCodeCorrectSoSetsPlanetExistenceToTrue() throws Exception {
        String actualUserID = "AB1234";
        String actualUserPassword = "AaBbCc1!2?";
        String AOCCode = "PMar78B";
        IWebService mockWebService = EasyMock.createMock(IWebService.class);

        expect(mockWebService.authenticate(actualUserID,actualUserPassword)).andReturn(true);
        expect(mockWebService.getStatusInfo(AOCCode)).andReturn("PMer58M,Planet,Mercury,88,2439.4,5.79e7,3.3011e23");
        replay(mockWebService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserID, actualUserPassword, mockWebService);
        solarSystemInformation.initialiseAOCDetailsValidate(AOCCode);

        assertTrue(solarSystemInformation.isExists());

        verify(mockWebService);
    }
}