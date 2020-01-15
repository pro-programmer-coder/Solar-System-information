package Core.WebService;

import Core.SolarInformation.SolarInformationException;

public interface IWebService {
    boolean authenticate ( String userID, String password );
    String getStatusInfo ( String astronomicalObjectClassificationCode) throws SolarInformationException;
}
