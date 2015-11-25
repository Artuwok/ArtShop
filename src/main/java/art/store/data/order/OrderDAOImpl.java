package art.store.data.order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public OrderDAOImpl() {
    }

    @Override
    public int saveOrder(final Order order, final String itemsCodes) {

        order.setOrderedItems(itemsCodes);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();

        return order.getId();
    }
}
