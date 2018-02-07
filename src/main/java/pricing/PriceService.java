package pricing;

import integration.Poster;
import model.BusinessError;
import model.PriceCalculate;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import util.JSONConverter;
import util.Settings;

import java.net.URL;
import java.util.List;

public class PriceService {
    public PriceCalculate readPrice(List<String> saleItemIds, String businessUnitValue) throws Exception {
        String username;
        String password;
        String url;

        Settings settings = Settings.getInstance();
        username = settings.getSetting("username");
        password = settings.getSetting("password");
        url = settings.getSetting("url");

        PriceCalculate PriceCalculate = PriceCalculateFactory.createPriceCalculate(saleItemIds,
                businessUnitValue);
        String JSONString = JSONConverter.convertToJson(PriceCalculate);
        Poster integration = new Poster(username, password);
        HttpResponse response = null;
        response = integration.postMessage(JSONString, new URL(url));
        String responseBody = EntityUtils.toString(response.getEntity());

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            PriceCalculate error = JSONConverter.convertFromJson(responseBody, PriceCalculate.getClass());
            List<BusinessError> businessErrors = error.getARTSHeader().getResponse().getBusinessError();
            BusinessError businessError = businessErrors.get(0);
            if (businessError != null) {
                throw new Exception(businessError.getErrorID() + ": " + businessError.getDescription().getValue());
            } else {
                throw new Exception("Unknown error");
            }
        }
        return JSONConverter.convertFromJson(responseBody, PriceCalculate.getClass());
    }
}
