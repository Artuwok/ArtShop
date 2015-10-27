package art.store.data.order;


import java.util.ArrayList;

public interface OrderDAO {

    int saveOrder(Order order, String itemsCodes);

    ArrayList<Integer> getOrderNumber();

    void setOrderNumber(int orderNumber);
}
