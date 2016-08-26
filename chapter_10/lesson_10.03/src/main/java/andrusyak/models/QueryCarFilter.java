package andrusyak.models;

/**
 * TODO: comment.
 * Created by Bogdan on 8/26/2016.
 */
public class QueryCarFilter {
    private int id;
    private String typeBody;
    private String brand;
    private String model;
    private String yearFrom;
    private String yearTo;
    private String priceFrom;
    private String priceTo;
    private User user;

    public QueryCarFilter() {
    }

    public QueryCarFilter(String typeBody, String brand, String model, String yearFrom, String yearTo, String priceFrom, String priceTo, User user) {
        this.typeBody = typeBody;
        this.brand = brand;
        this.model = model;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(String typeBody) {
        this.typeBody = typeBody;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(String yearFrom) {
        this.yearFrom = yearFrom;
    }

    public String getYearTo() {
        return yearTo;
    }

    public void setYearTo(String yearTo) {
        this.yearTo = yearTo;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
