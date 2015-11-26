package art.store.data.item;

/* This class represents business logic and serves as MODEL in MVC
* Class represent ItemToSell to be viewed in the online store (web-app) */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    private int id;
    private float price;
    private String name;
    private String image_url;
    private String description;


    public Item() {
    }

    public Item(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String imageUlr) {
        this.image_url = imageUlr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
