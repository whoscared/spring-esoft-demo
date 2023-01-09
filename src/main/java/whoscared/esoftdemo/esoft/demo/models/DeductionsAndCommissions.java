package whoscared.esoftdemo.esoft.demo.models;

import whoscared.esoftdemo.esoft.demo.models.immovables.TypeOfRealEstate;

public class DeductionsAndCommissions {
    private double priceForSalesman;
    private final double priceForCustomer;
    private final double commissionForRealtorSalesman;
    private final double commissionForRealtorCustomer;
    private final double deductionsCompany;

    public DeductionsAndCommissions(Deal deal) {
        int priceRealEstate = deal.getOffer().getPrice();

        TypeOfRealEstate tempType = deal.getOffer().getRealEstate().getTypeOfRealEstate();

        switch (tempType) {
            case APARTMENT -> priceForSalesman = 36000 + priceRealEstate * 0.01;
            case LAND -> priceForSalesman = 30000 + priceRealEstate * 0.02;
            case HOUSE -> priceForSalesman = 30000 + priceRealEstate * 0.01;
        }

        priceForCustomer = (priceRealEstate * 0.03);

        commissionForRealtorSalesman = priceForSalesman * deal.getOffer().getRealtor().getShareOfCommission()*0.01;
        commissionForRealtorCustomer = priceForCustomer * deal.getDemand().getRealtor().getShareOfCommission()*0.01;

        deductionsCompany = (priceForSalesman - commissionForRealtorSalesman) + (priceForCustomer - commissionForRealtorCustomer);
    }

    public double getPriceForSalesman() {
        return priceForSalesman;
    }

    public double getPriceForCustomer() {
        return priceForCustomer;
    }

    public double getCommissionForRealtorSalesman() {
        return commissionForRealtorSalesman;
    }

    public double getCommissionForRealtorCustomer() {
        return commissionForRealtorCustomer;
    }

    public double getDeductionsCompany() {
        return deductionsCompany;
    }
}
