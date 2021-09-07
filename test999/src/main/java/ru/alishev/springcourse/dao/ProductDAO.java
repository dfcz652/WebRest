package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.models.Product;

import javax.validation.Valid;
import java.util.List;

@Component
public class ProductDAO {

        private final JdbcTemplate jdbcTemplate2;

        @Autowired
        public ProductDAO(JdbcTemplate jdbcTemplate2) {
            this.jdbcTemplate2 = jdbcTemplate2;
        }


    public List<Product> index() {
            return jdbcTemplate2.query("SELECT * FROM tablewebrest", new BeanPropertyRowMapper<>(Product.class));
        }

        public Product show(int id) {
            return jdbcTemplate2.query("SELECT * FROM tablewebrest WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Product.class))
                    .stream().findAny().orElse(null);
        }

        public void save(Product product) {
            jdbcTemplate2.update("INSERT INTO tablewebrest(product, s1price, s1rest , s2price,s2rest,s3price,s3rest,barcode) VALUES(?, ?, ?,?,?,?,?)",product.getProduct(), product.getS1price(),
                    product.getS1rest(),product.getS2price(),product.getS2rest(),product.getS3price(),product.getS3rest());
        }

        public void update(Product updatedProduct) {
            jdbcTemplate2.update("UPDATE tablewebrest SET product=?, s1price=?, s1price=? WHERE id=?", updatedProduct.getProduct(),
                    updatedProduct.getS1price(), updatedProduct.getS2price(), updatedProduct.getId());
        }

        public void delete(int id) {
            jdbcTemplate2.update("DELETE FROM Product WHERE id=?", id);
        }
    }
