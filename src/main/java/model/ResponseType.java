package model;

import java.util.Date;
import java.util.List;

public class ResponseType {
    private String ReuqestID;
    private Date ResponseTimestamp;
    private String ResponseCode;
    private List<BusinessError> BusinessError;

    public Date getResponseTimestamp() {
        return ResponseTimestamp;
    }

    public void setResponseTimestamp(Date responseTimestamp) {
        ResponseTimestamp = responseTimestamp;
    }

    public String getReuqestID() {
        return ReuqestID;
    }

    public List<BusinessError> getBusinessError() {
        return BusinessError;
    }

    public void setBusinessError(List<BusinessError> businessError) {
        BusinessError = businessError;
    }

    public void setReuqestID(String reuqestID) {
        ReuqestID = reuqestID;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }
}
