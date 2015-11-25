package art.store.data.cart;

import art.store.data.item.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private List<Item> cartList = new ArrayList<Item>();

    public CartDAOImpl() {
    }

    @Override
    public List<Item> addToCart(int id) {
        Session session = sessionFactory.openSession();
        cartList.add((Item) session.get(Item.class, id));
        return cartList;
    }

    @Override
    public List<Item> showCart() {
        return cartList;
    }

    @Override
    public List<Item> removeFromCart(int itemToRemoveId) {

        for (Item itemInCart : cartList) {
            if (itemInCart.getId() == itemToRemoveId) {
                cartList.remove(itemInCart);
                break;
            }
        }
        return cartList;
    }

    @Override
    public String getItemsToOrderSave() {
        StringBuilder sb = new StringBuilder();

        for (Item item : cartList) {
            sb.append(item.getId() + " ");
        }
        return sb.toString();
    }

}
