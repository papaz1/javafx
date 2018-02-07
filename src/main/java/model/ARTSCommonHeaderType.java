package model;

import java.util.ArrayList;
import java.util.List;

public class ARTSCommonHeaderType {
    private MessageID MessageID;
    private List<DateTime> DateTime;
    private String ActionCode;
    private String MessageType;
    private List<BusinessUnitCommonData> BusinessUnit;
    private ResponseType Response;

    public ARTSCommonHeaderType() {
        BusinessUnit = new ArrayList<BusinessUnitCommonData>();
    }

    public void setMessageID(model.MessageID messageID) {
        MessageID = messageID;
    }

    public void setActionCode(String actionCode) {
        ActionCode = actionCode;
    }

    public void setMessageType(String messageType) {
        MessageType = messageType;
    }

    public MessageID getMessageID() {
        return MessageID;
    }

    public List<model.DateTime> getDateTime() {
        return DateTime;
    }

    public void setDateTime(List<model.DateTime> dateTime) {
        DateTime = dateTime;
    }

    public String getActionCode() {
        return ActionCode;
    }

    public String getMessageType() {
        return MessageType;
    }

    public List<BusinessUnitCommonData> getBusinessUnit() {
        return BusinessUnit;
    }

    public void setBusinessUnit(List<BusinessUnitCommonData> businessUnit) {
        BusinessUnit = businessUnit;
    }

    public ResponseType getResponse() {
        return Response;
    }

    public void setResponse(ResponseType response) {
        Response = response;
    }

    public void addBusinessUnit(BusinessUnitCommonData newBusinessUnit) {
        BusinessUnit.add(newBusinessUnit);
    }
}
