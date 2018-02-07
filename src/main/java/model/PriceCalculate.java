package model;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculate {
    private int InternalMajorVersion;
    private int InternalMinorVersion;
    private ARTSCommonHeaderType ARTSHeader;
    private List<PriceCalculateBase> PriceCalculateBody;


    public PriceCalculate() {
        PriceCalculateBody = new ArrayList<PriceCalculateBase>();
    }

    public void setInternalMajorVersion(int internalMajorVersion) {
        InternalMajorVersion = internalMajorVersion;
    }

    public void setInternalMinorVersion(int internalMinorVersion) {
        InternalMinorVersion = internalMinorVersion;
    }

    public int getInternalMajorVersion() {
        return InternalMajorVersion;
    }

    public int getInternalMinorVersion() {
        return InternalMinorVersion;
    }

    public ARTSCommonHeaderType getARTSHeader() {
        return ARTSHeader;
    }

    public List<PriceCalculateBase> getPriceCalculateBody() {
        return PriceCalculateBody;
    }

    public void setPriceCalculateBody(List<PriceCalculateBase> priceCalculateBody) {
        PriceCalculateBody = priceCalculateBody;
    }

    public void addPriceCalculate(PriceCalculateBase PriceCalculate) {
        PriceCalculateBody.add(PriceCalculate);
    }

    public void setARTSHeader(ARTSCommonHeaderType ARTSHeader) {
        this.ARTSHeader = ARTSHeader;
    }

}
