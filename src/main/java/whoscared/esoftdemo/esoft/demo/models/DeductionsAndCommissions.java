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

        //комиссия для риелтора предложения
        commissionForRealtorSalesman = priceForSalesman * deal.getOffer().getRealtor().getShareOfCommission() * 0.01;
        //комиссия для риелтора потребности
        commissionForRealtorCustomer = priceForCustomer * deal.getDemand().getRealtor().getShareOfCommission() * 0.01;

        //из суммы покупателя и продавца вычитаем комиссию риелторов и получаем отчисление для компании
        deductionsCompany = (priceForSalesman - commissionForRealtorSalesman) + (priceForCustomer - commissionForRealtorCustomer);
    }

    public String getPriceForSalesman() {
        return String.format("%.2f", priceForSalesman);
    }

    public String getPriceForCustomer() {
        return String.format("%.2f", priceForCustomer);
    }

    public String getCommissionForRealtorSalesman() {
        return String.format("%.2f", commissionForRealtorSalesman);
    }

    public String getCommissionForRealtorCustomer() {
        return String.format("%.2f", commissionForRealtorCustomer);
    }

    public String getDeductionsCompany() {
        return String.format("%.2f", deductionsCompany);
    }
}
