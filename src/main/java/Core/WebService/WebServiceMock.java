package Core.WebService;

public class WebServiceMock implements IWebService {
    @Override
    public boolean authenticate(String userID, String password) {
        return false;
    }

    @Override
    public String getStatusInfo(String astronomicalObjectClassificationCode) {
        return null;
    }
}
