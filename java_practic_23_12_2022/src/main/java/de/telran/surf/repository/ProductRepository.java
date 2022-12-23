package de.telran.surf.repository;

import de.telran.surf.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository implements CommonRepository<Product> {

    // Could not autowire. No beans of 'NamedParameterJdbcTemplate' type found.

    private static final String SQL_INSERT = "INSERT INTO product (id, name, price, " +
            "old_price, is_new, is_hot, picture, description) VALUES (:id, :name, :price, " +
            ":old_price, :is_new, :is_hot, :picture, :description)";
    private static final String SQL_FIND_ALL = "SELECT * FROM product";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM product WHERE id = :id";
    private static final String SQL_UPDATE = "UPDATE product SET name = :name, price = :price, " +
            "old_price = :old_price, is_new = :is_new, is_hot = :is_hot, picture = :picture, " +
            "description = :description WHERE id = :id";
    private static final String SQL_DELETE = "DELETE FROM product WHERE id = :id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Product> productRowMapper = (ResultSet rs, int rowNum) -> {
        Product product = new Product();
        product.setId(rs.getString("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setOldPrice(rs.getDouble("old_price"));
        product.setHot(rs.getBoolean("is_hot"));
        product.setNew(rs.getBoolean("is_new"));
        product.setPicture(rs.getString("picture"));
        product.setDescription(rs.getString("description"));
        return product;
    };

    @Override
    public Product save(Product entity) {
        Product product = findById(entity.getId());
        if (product != null) {
            // Такой товар уже есть в БД. Надо только его оьновить
            return upsert(entity, SQL_UPDATE);
        }
        // Такого товара в БД нет - добавим его
        return upsert(entity, SQL_INSERT);
    }

    private Product upsert(Product product, String sql) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", product.getId());
        parameters.put("name", product.getName());
        parameters.put("price", product.getPrice());
        parameters.put("old_price", product.getOldPrice());
        parameters.put("is_new", product.isNew());
        parameters.put("is_hot", product.isHot());
        parameters.put("picture", product.getPicture());
        parameters.put("description", product.getDescription());
        jdbcTemplate.update(sql, parameters);
        return findById(product.getId());
    }

    @Override
    public Iterable<Product> save(Collection<Product> entities) {
        entities.forEach(this::save);
        return findAll();
    }

    @Override
    public void delete(Product entity) {
        Map<String, String> parameters = Collections.singletonMap("id", entity.getId());
        jdbcTemplate.update(SQL_DELETE, parameters);
    }

    @Override
    public Product findById(String id) {
        try {
            Map<String, String> parameters = Collections.singletonMap("id", id);
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, parameters, productRowMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Iterable<Product> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, productRowMapper);
    }

}
