package art.store.data.cart;

import art.store.data.item.Item;

import java.util.List;


/* This interface used to describe contract methods that Cart object should have */

public interface CartDAO {

    List<Item> addToCart (int id);
    List<Item> showCart ();
    List<Item> removeFromCart(int itemId);

    String getItemsToOrderSave();
}

