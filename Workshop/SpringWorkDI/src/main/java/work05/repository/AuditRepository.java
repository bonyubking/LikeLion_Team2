package work05.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import work05.domain.AuditLog;

@Repository
public class AuditRepository {
  private final JdbcTemplate jdbcTemplate;
  @Autowired
  public AuditRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  public void save(AuditLog log){
    String sql = "INSERT INTO audit_log (message) VALUES (?)";
    jdbcTemplate.update(sql, log.getMessage());
  }

}
