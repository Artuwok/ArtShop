package art.store.data.item;

/* This class represents business logic and serves as MODEL in MVC
* Class represent ItemToSell to be viewed in the online store (web-app) */

public class Item {

    private long id;
    private float price;
    private String name;
    private String imageUrl;


    public Item() {
    }

    public Item(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImageUrl(String imageUlr) {
        this.imageUrl = imageUlr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
