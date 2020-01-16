package Core.WebService;

import Core.SolarInformation.SolarInformationException;

public class StubWebService implements IWebService{

    @Override
    public boolean authenticate(String userID, String password) {
        return false;
    }

    @Override
    public String getStatusInfo(String astronomicalObjectClassificationCode) throws SolarInformationException {
        return null;
    }
}
