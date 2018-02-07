package model;

public class BusinessError {

    private String ErrorID;
    private model.Description Description;
    private String Severity;

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getErrorID() {
        return ErrorID;
    }

    public void setErrorID(String errorID) {
        ErrorID = errorID;
    }

    public model.Description getDescription() {
        return Description;
    }

    public void setDescription(model.Description description) {
        Description = description;
    }
}
