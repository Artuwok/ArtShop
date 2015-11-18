package art.store.data.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*This class is a IMPLEMENTATION of ItemDAO interface*/
@Repository
public class ItemDAOImpl implements ItemDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM ITEMS";
        return this.jdbcTemplate.query(sql, new ItemRowMapper());
    }

    @Override
    public List<Item> getItemToView(int id) {

        String sql = "SELECT * FROM ITEMS WHERE ID = " + id;
        System.out.println("Hello from my SQL 1 item select!!");

        return this.jdbcTemplate.query(sql, new ItemRowMapper());
    }


}
