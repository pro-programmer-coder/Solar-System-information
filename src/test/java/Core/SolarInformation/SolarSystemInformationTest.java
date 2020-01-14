package Core.SolarInformation;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    @Test
    public void validUserID(){
        String actualUserId = "AB1234";

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(actualUserId);

        expect(solarSystemInformation.authenticate().once());
        replay(solarSystemInformation);

    }
}