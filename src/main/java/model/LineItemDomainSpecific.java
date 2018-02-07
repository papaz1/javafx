package model;

import java.util.ArrayList;
import java.util.List;

public class LineItemDomainSpecific {
    private List<Integer> SequenceNumber;
    private List<MerchandiseHierarchyCommonData> MerchandiseHierarchy;
    private SaleBase Sale;
    private RegularSalesUnitPrice RegularSalesUnitPrice;

    public LineItemDomainSpecific() {
        SequenceNumber = new ArrayList<Integer>();
        MerchandiseHierarchy = new ArrayList<MerchandiseHierarchyCommonData>();
    }

    public void setSale(SaleBase sale) {
        Sale = sale;
    }

    public List<Integer> getSequenceNumber() {
        return SequenceNumber;
    }

    public void setSequenceNumber(List<Integer> sequenceNumber) {
        SequenceNumber = sequenceNumber;
    }

    public List<MerchandiseHierarchyCommonData> getMerchandiseHierarchy() {
        return MerchandiseHierarchy;
    }

    public void setMerchandiseHierarchy(List<MerchandiseHierarchyCommonData> merchandiseHierarchy) {
        MerchandiseHierarchy = merchandiseHierarchy;
    }

    public SaleBase getSale() {
        return Sale;
    }

    public model.RegularSalesUnitPrice getRegularSalesUnitPrice() {
        return RegularSalesUnitPrice;
    }

    public void setRegularSalesUnitPrice(model.RegularSalesUnitPrice regularSalesUnitPrice) {
        RegularSalesUnitPrice = regularSalesUnitPrice;
    }

    public void addSequenceNumber(Integer newSequenceNumber) {
        SequenceNumber.add(newSequenceNumber);
    }

    public void addMerchandiseHierarchy(MerchandiseHierarchyCommonData newMerchandiseHierarchy) {
        MerchandiseHierarchy.add(newMerchandiseHierarchy);
    }
}
