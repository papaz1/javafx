package model;

public class RegularSalesUnitPriceRoundingRule {
    private String RoundingMethod;
    private double Multiple;

    public String getRoundingMethod() {
        return RoundingMethod;
    }

    public void setRoundingMethod(String roundingMethod) {
        RoundingMethod = roundingMethod;
    }

    public double getMultiple() {
        return Multiple;
    }

    public void setMultiple(double multiple) {
        Multiple = multiple;
    }
}
