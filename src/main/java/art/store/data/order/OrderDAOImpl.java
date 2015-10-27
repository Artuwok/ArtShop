package art.store.data.order;

import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class OrderDAOImpl implements OrderDAO {
    private ArrayList<Integer> orderNumber;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDAOImpl() {
    }

    @Override
    public int saveOrder(final Order order, final String itemsCodes) {

        KeyHolder keyHolder = new GeneratedKeyHolder(); // returns id of the inserted sql
        final String sql = "INSERT INTO ORDERS (ClientName, ClientTelephone, ClientAddress, ClientEmail, OrderedItems) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, order.getClientName());
                ps.setString(2, order.getClientTelephone());
                ps.setString(3, order.getDeliveryAddress());
                ps.setString(4, order.getClientEmail());
                ps.setString(5, itemsCodes);
                return ps;
            }
        }, keyHolder);

        int orderNumberInDatabase = keyHolder.getKey().intValue();
        this.setOrderNumber(orderNumberInDatabase);

        return orderNumberInDatabase;
    }

    @Override
    public ArrayList<Integer> getOrderNumber() {
        return this.orderNumber;
    }

    // This method intended to return order member from database
    @Override
    public void setOrderNumber(int order) {
        orderNumber = new ArrayList<Integer>(order);

    }


}
