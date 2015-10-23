package art.store.data.order;


import java.io.Serializable;

public class Order implements Serializable {

    private String clientName;
    private String clientTelephone;
    private String deliveryAddress;
    private String clientEmail;

    public Order() {
    }

    public Order(String clientName, String clientTelephone, String deliveryAddress, String clientEmail) {
        this.clientEmail = clientEmail;
        this.clientName = clientName;
        this.clientTelephone = clientTelephone;
        this.deliveryAddress = deliveryAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }


}
