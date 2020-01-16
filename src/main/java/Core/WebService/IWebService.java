package Core.WebService;

import Core.SolarInformation.SolarInformationException;

//interface for the WebService. This allows for dependency injection
public interface IWebService {
    boolean authenticate ( String userID, String password );
    String getStatusInfo ( String astronomicalObjectClassificationCode) throws SolarInformationException;
}
