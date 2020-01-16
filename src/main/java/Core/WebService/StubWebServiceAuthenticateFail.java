package Core.WebService;

import Core.SolarInformation.SolarInformationException;

//Stub purely for an example of Stubbing
public class StubWebServiceAuthenticateFail implements IWebService{

    //Authentication failed in interface
    @Override
    public boolean authenticate(String userID, String password) {
        return false;
    }

    @Override
    public String getStatusInfo(String astronomicalObjectClassificationCode) throws SolarInformationException {
        return null;
    }
}
