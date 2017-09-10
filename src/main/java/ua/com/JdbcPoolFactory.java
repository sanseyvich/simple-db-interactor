package ua.com;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by sanseyvich on 9/9/17.
 */
public class JdbcPoolFactory {
    //singleton
    private static JdbcTemplate jdbcTemplate;

    public JdbcTemplate createMysqlJdbcPool() {
        if (this.jdbcTemplate != null) {
            return this.jdbcTemplate;
        }
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/test_1?serverTimezone=UTC");
        p.setDriverClassName("com.mysql.cj.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("wtqwerty");
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource(p);
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
