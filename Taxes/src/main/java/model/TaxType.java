package model;

public enum TaxType {
    SALARY_TAX(43.0),
    GIFT_TAX(9.0),
    SOLD_ITEM_TAX(18.0),
    SALARY_SECOND_TAX(13.0),
    ROYALTIES_TAX(15.0),
    MONEY_TRANSFER_FROM_ABROAD_TAX(0.3);

    private final double taxIndex;

    TaxType(double taxIndex) {
        this.taxIndex = taxIndex;
    }

    public double getTaxIndex() {
        return this.taxIndex;
    }
}
