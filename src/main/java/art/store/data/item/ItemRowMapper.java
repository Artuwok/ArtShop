package art.store.data.item;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemRowMapper implements RowMapper {
    @Override
    public Item mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getLong(1));
        item.setName(resultSet.getString(2));
        item.setPrice(resultSet.getFloat(3));
        item.setImageUrl(resultSet.getString(4));
        item.setDescription(resultSet.getString(5));

        return item;
    }
}
