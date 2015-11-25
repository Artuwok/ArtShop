package art.store.data.order;


public interface OrderDAO {
    int saveOrder(Order order, String itemsCodes);
}
