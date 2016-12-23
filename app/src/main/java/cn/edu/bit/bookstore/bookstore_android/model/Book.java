package cn.edu.bit.bookstore.bookstore_android.model;

public class Book {

    /**
     * desp : gg
     * price : 2.20
     * name : itbook2
     * classification : all
     * userid : uu
     * url : baidu.com
     * bookid : 2
     */

    private String desp;
    private Double price;
    private String name;
    private String classification;
    private String userid;
    private String url;
    private String bookid;

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
}
