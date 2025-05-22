package work05.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import work05.domain.Order;

@Repository
public class OrderRepository {
  private final JdbcTemplate jdbcTemplate;

  public OrderRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  public void save(Order order) {
    String sql = "INSERT INTO orders (id, item_id, quantity) VALUES (?, ?, ?)";
    jdbcTemplate.update(sql, order.getId(), order.getItemId(), order.getQuantity());
  }
}
