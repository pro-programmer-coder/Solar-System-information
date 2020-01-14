package Core.WebService;

public interface IWebService {
    boolean authenticate ( String userID, String password );
    String getStatusInfo ( String astronomicalObjectClassificationCode);
}
