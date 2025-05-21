package work05.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import work05.domain.Member;

@Repository
public class MemberRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public MemberRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(Member member) {
    String sql = "insert into member(id, name,email) values(?,?,?)";
    jdbcTemplate.update(sql, member.getId(), member.getName(), member.getEmail());
  }

  public Member findById(Long id) {
    String sql = "select * from member where id=?";
    return jdbcTemplate.query(sql,
            new Object[]{id},
            (rs, rowNum) -> new Member(rs.getLong("id"), rs.getString("name"), rs.getString("email")))
        .stream().findFirst().orElseThrow();
  }
}
