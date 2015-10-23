package art.store.web;


import art.store.data.cart.CartDAO;
import art.store.data.item.Item;
import art.store.data.item.ItemDAO;
import art.store.data.order.Order;
import art.store.data.order.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {
    int id;
    @Autowired
    ItemDAO itemDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/data.json", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    ResponseEntity<List<Item>> list() {
        List<Item> list = itemDAO.getAllItems();
        return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/notebooks/{id}", method = RequestMethod.GET)
    public String notebook(@PathVariable("id") int id) {
            this.id = id;

        System.out.println(id);
        return "notebook.html";
    }

    @RequestMapping(value = "/notebooks/currentItem.json", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    ArrayList<Item> listID() {
        ArrayList<Item> itemToViewList = (ArrayList)itemDAO.getItemToView(id);
        return itemToViewList;

    }

    @Autowired CartDAO cartDAO;
    @RequestMapping(value = "/addToShoppingCart/{id}", method = RequestMethod.GET)
    public void addToShoppingCart (@PathVariable("id") int id) {
        this.id = id;

        System.out.println("Hello from addToShopping cart Controller!!: " + id);
        List<Item> list = cartDAO.addToCart(id);
        System.out.println(list.size());
    }

    @RequestMapping(value = "/showCart", method = RequestMethod.GET)
    public String showCartPage(){
        return "showCart.html";
    }


    @RequestMapping(value = "/showCart.json", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    ResponseEntity<List<Item>> cartList() {
        List<Item> cartList = cartDAO.showCart();
        return new ResponseEntity<List<Item>>(cartList, HttpStatus.OK);

    }

    @RequestMapping(value = "/removeFromCart/{itemToRemoveID}", method = RequestMethod.GET)
    public String removeItemFromCart(@PathVariable ("itemToRemoveID") int itemToRemoveID) {

        System.out.println("Before cart.Dao.removefromCart: " + itemToRemoveID);
        cartDAO.removeFromCart(itemToRemoveID);

        System.out.println("The item has been removed: " + itemToRemoveID);
        return "showCart.html";
    }

    @Autowired OrderDAO orderDAO;
    @RequestMapping(value = "/addClientOrder", method = RequestMethod.POST)
    public void addClientOrder(@RequestBody Order json){
       int orderID = orderDAO.saveOrder(json);
        System.out.println("Order was confermed! Order number is: " + orderID);
    }
}
