package edu.du.shop.repository;

import edu.du.shop.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShopRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products", new UserRowMapper());
    }

    public product findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM products WHERE id = ?",
                new UserRowMapper(),
                id
        );
    }

    public void save(product user) {
        if (user.getId() == null) {
            jdbcTemplate.update(
                    "INSERT INTO products (name, price, description) VALUES (?, ?, ?)",
                    user.getName(), user.getPrice(), user.getDescription()
            );
        } else {
            jdbcTemplate.update(
                    "UPDATE products SET name = ?, price = ?, description = ? WHERE id = ?",
                    user.getName(), user.getPrice(), user.getDescription(), user.getId()
            );
        }
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }

    private static class UserRowMapper implements RowMapper<product> {
        @Override
        public product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new product(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("price"),
                    rs.getString("image")


            );
        }
    }
}