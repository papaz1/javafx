package model;

public class QuantityCommonData {
    private int value;
    private int Units;
    private String UnitOfMeasureCode;

    public void setUnits(int units) {
        Units = units;
    }

    public void setUnitOfMeasureCode(String unitOfMeasureCode) {
        UnitOfMeasureCode = unitOfMeasureCode;
    }

    public int getValue() {
        return value;
    }

    public int getUnits() {
        return Units;
    }

    public String getUnitOfMeasureCode() {
        return UnitOfMeasureCode;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
