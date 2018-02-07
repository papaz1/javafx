package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasketBase {

    private List<LineItemDomainSpecific> LineItem;

    public ShoppingBasketBase() {
        LineItem = new ArrayList<LineItemDomainSpecific>();
    }

    public List<LineItemDomainSpecific> getLineItem() {
        return LineItem;
    }

    public void setLineItem(List<LineItemDomainSpecific> lineItem) {
        LineItem = lineItem;
    }

    public void addLineItem(LineItemDomainSpecific newLineItem) {
        LineItem.add(newLineItem);
    }
}
