package work05.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import work05.domain.Post;

@Repository
public class PostRepository {
  private final JdbcTemplate jdbcTemplate;
  private final RowMapper<Post> postRowMapper = (rs, rowNum) -> new Post(
      rs.getLong("id"),
      rs.getString("title"),
      rs.getString("content"),
      rs.getString("author")
  );

  @Autowired
  public PostRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Post> findAll(){
    String sql = "select * from post";
    return jdbcTemplate.query(sql,postRowMapper);
  }

}
