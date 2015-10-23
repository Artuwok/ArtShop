package art.store.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DAOConfig {

    @Bean
    @Autowired
    @Description("Bean intended to create JDBCTemplate and pass the datasource in the constructor")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Description("This bean is used to provide information for datasource (DB name, location, login) ")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/EMP");
        dataSource.setUsername("root");
        dataSource.setPassword("Civilization");

        System.out.println("Datasource created!!!!!!!!!!!!!!!!");

        return dataSource;
    }
}
