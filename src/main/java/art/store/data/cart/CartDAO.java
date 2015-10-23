package art.store.data.cart;

import art.store.data.item.Item;

import java.util.List;

/**
 * Created by art on 20/10/15.
 */
public interface CartDAO {

    List<Item> addToCart (int id);
    List<Item> showCart ();
    List<Item> removeFromCart(int itemId);
}
