package com.anshumanprajapati.problem.InvestmentPortfolioManager;

import java.util.HashMap;
import java.util.Map;

import static com.anshumanprajapati.problem.InvestmentPortfolioManager.AssetType.MUTUAL_FUND;
import static com.anshumanprajapati.problem.InvestmentPortfolioManager.AssetType.STOCK;

public class Main {

    public  static void  main(String[] args){
        AssetManager manager = new AssetManager("INDMoney");
        manager.listStock("AAPL", STOCK, 180.00);
        manager.listStock("GOOG", STOCK, 150.00);
        manager.listStock("VTSAX", MUTUAL_FUND, 90.00);
        manager.listStock("FXAIX", MUTUAL_FUND, 80.00);
        manager.listAllAssets();

        User user1 = new User("anshu", "Anshuman");
        user1.manager.addFund(10000);
        user1.manager.buy(manager.getAsset("AAPL"), 10.00, 170);

        user1.listPortFolio();
    }
}

enum AssetType{
    STOCK,
    MUTUAL_FUND
}

class Asset{
    private String name;
    private AssetType type;
    private double dayClosingPrice;
    private double currentPrice;

    Asset(String name, AssetType type, double listingPrice){
        this.name = name;
        this.type = type;
        this.currentPrice = listingPrice;
        this.dayClosingPrice = listingPrice;
    }

    public String getName(){
        return this.name;
    }

    public AssetType getType(){
        return this.type;
    }

    public double getCurrentPrice(){
        return this.currentPrice;
    }

    public void setCurrentPrice(double price){
        currentPrice = price;
    }

    //@Scheduled() for 4:30 PM
    public void setClosingPrice(){
        dayClosingPrice = currentPrice;
    }

    public double getDayClosingPrice(){
        return this.dayClosingPrice;
    }
}

class ListedAssets{
    // Name and Assets
    Map<String, Asset> map = new HashMap<>();

    public String addAsset(Asset asset){
        if(map.containsKey(asset.getName())){
            return "Stock already listed";
        }else{
            map.put(asset.getName(), asset);
        }
        return "Successfully listed stock: " + asset.getName();
    }

    public String remove(String name){
        if(map.containsKey(name)){
            map.remove(name);
            return "Successfully listed stock: " + name;
        }else{
            return "Stock is not listed";
        }
    }

    public String listAllAssets(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Asset> e: map.entrySet()){
            sb.append(e.getKey())
                    .append(" - ").append(e.getValue().getType())
                    .append(" - ").append(e.getValue().getCurrentPrice())
                    .append(("\n"));
        }
        return sb.toString();
    }

    public Asset getAsset(String name){
        return map.get(name);
    }
}

class AssetManager{
    String name;
    ListedAssets listedAssets;
    AssetManager(String name){
        this.name = name;
        this.listedAssets = new ListedAssets();
    }

    public void listStock(String name, AssetType assetType, double listingPrice){
        Asset newAsset = new Asset(name, assetType, listingPrice);
        System.out.println(listedAssets.addAsset(newAsset));
    }

    public void listAllAssets(){
        System.out.println(listedAssets.listAllAssets());
    }

    public  Asset getAsset(String name){
        return listedAssets.getAsset(name);
    }

}

class MyAsset {
    public Asset asset;
    public double quantity;
    public double buyingPrice;

    MyAsset(Asset asset, double quantity, double buyingPrice){
        this.asset = asset;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getBuyingPrice(){
        return buyingPrice;
    }
}

class Portfolio{
    Map<String, MyAsset> assetsList;

    Portfolio(){
        this.assetsList = new HashMap<>();
    }

    String getData(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, MyAsset> e: assetsList.entrySet()){
            sb.append(e.getKey())
                    .append(" - ").append(e.getValue().getQuantity())
                    .append(" - ").append(e.getValue().getBuyingPrice())
                    .append(("\n"));
        }
        return sb.toString();
    }

}



class PortfolioManager{
    Portfolio portfolio;
    double fund;
    PortfolioManager(Portfolio portfolio){
        this.portfolio = portfolio;
        this.fund = 0.0;
    }
    void addFund(double amount){
        fund+=amount;
    }

    void buy(Asset asset, double quantity){
        buy(asset, quantity, asset.getCurrentPrice());
    }

    void buy(Asset asset, double quantity, double price){
        MyAsset myAsset = new MyAsset(asset, quantity, price);
        portfolio.assetsList.put(asset.getName(), myAsset);
    }

    void sell(Asset asset, double quantity){
        sell(asset, quantity, asset.getCurrentPrice());
    }

    void sell(Asset asset, double quantity, double price){
        if(portfolio.assetsList.containsKey(asset.getName())){
            MyAsset myAsset = portfolio.assetsList.get(asset.getName());

            if(myAsset.quantity >= quantity){
                if(myAsset.quantity == quantity) portfolio.assetsList.remove(asset.getName());
                else myAsset.quantity -= quantity;
            }else{
                System.out.println("Trying to sell more quantity");
            }
        }else{
            System.out.println("Asset is not available");
        }
    }


}

class User{

    String userId;
    String userName;
    public PortfolioManager manager;
    Portfolio portfolio;

    User(String userId, String userName){
        this.userName = userName;
        this.userId = userId;
        this.portfolio = new Portfolio();
        this.manager = new PortfolioManager(portfolio);
    }


    public void listPortFolio(){
        System.out.println(portfolio.getData());
    }
}
