package art.store.data.cart;

import art.store.data.item.Item;
import art.store.data.item.ItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CartDAOImpl() {
        System.out.println("Cart DAOImpl created");
    }

    private List<Item> cartList = new ArrayList<Item>();


    @Override
    public List<Item> addToCart(int id) {
        String sql = "SELECT * FROM ITEMS WHERE ID = " + id;
        cartList.addAll(this.jdbcTemplate.query(sql, new ItemRowMapper()));
        return cartList;
    }

    @Override
    public List<Item> showCart() {
        return cartList;
    }

    @Override
    public List<Item> removeFromCart(int itemId) {
        Iterator iterator = cartList.iterator();

        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            System.out.println("Iterator work");
            if (item.getId() == itemId){
                iterator.remove();
                System.out.println("Iterator worked removed " + cartList.size());
            }
            break;
        }
        return cartList;
    }
}
