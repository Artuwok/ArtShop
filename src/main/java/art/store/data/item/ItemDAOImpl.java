package art.store.data.item;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*This class is a IMPLEMENTATION of ItemDAO interface*/
@Repository
public class ItemDAOImpl implements ItemDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Item> getAllItems() {
        Session session = sessionFactory.openSession();

        //Return every object that corresponds to the Item class.
        List<Item> list = session.createCriteria(Item.class).list();
        session.close();
        return list;
    }

    @Override
    public List<Item> getItemToView(int id) {
        Session session = sessionFactory.openSession();

        List<Item> list = new ArrayList<Item>();
        list.add((Item) session.get(Item.class, id));
        session.close();
        return list;
    }
}
