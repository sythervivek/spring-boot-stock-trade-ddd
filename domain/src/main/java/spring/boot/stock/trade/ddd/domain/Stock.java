package spring.boot.stock.trade.ddd.domain;

public class Stock {
    private Identifier stockId;
    private StockTickerSymbol stockTickerSymbol;
    private String companyName;
    private Market market;
    private Sector sector;

    public Identifier getStockId() {
        return stockId;
    }

    public StockTickerSymbol getStockTickerSymbol() {
        return stockTickerSymbol;
    }

    public void setStockTickerSymbol(StockTickerSymbol stockTickerSymbol) {
        this.stockTickerSymbol = stockTickerSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
