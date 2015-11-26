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
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    CartDAO cartDAO;
    @Autowired
    OrderDAO orderDAO;
    private int id;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/data/.json", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    ResponseEntity<List<Item>> list() {
        List<Item> list = itemDAO.getAllItems();
        return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/notebooks/{id}", method = RequestMethod.GET)
    public String notebook(@PathVariable("id") int id) {
        this.id = id;

        System.out.println("--From notebooks id--" + id);
        return "notebook.html";
    }

    @RequestMapping(value = "/notebooks/currentItem.json", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    ArrayList<Item> listID() {
        return (ArrayList) itemDAO.getItemToView(id);
    }

    @RequestMapping(value = "/addToShoppingCart/{id}", method = RequestMethod.GET)
    public void addToShoppingCart(@PathVariable("id") int id) {
        this.id = id;
        cartDAO.addToCart(id);
    }

    @RequestMapping(value = "/showCart", method = RequestMethod.GET)
    public String showCartPage() {
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
    public String removeItemFromCart(@PathVariable("itemToRemoveID") int itemToRemoveID) {
        cartDAO.removeFromCart(itemToRemoveID);
        return "showCart.html";
    }

    @RequestMapping(value = "/addClientOrder", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    List<Integer> addClientOrder(@RequestBody Order json) {
//        TODO refactor method to return no list. but JSON String

        List<Integer> listToreturn = new ArrayList<Integer>();
        int orderNumber = orderDAO.saveOrder(json, cartDAO.getItemsToOrderSave());
        listToreturn.add(orderNumber);
        return listToreturn;
    }

}
