package art.store.data.item;

import java.util.List;

/* The interface implements the strategy of lose coupling (coding through the interfaces) in Spring
* MUST be implemented in particular class */

public interface ItemDAO {

    List<Item> getAllItems();
    List<Item> getItemToView(int id);
}
