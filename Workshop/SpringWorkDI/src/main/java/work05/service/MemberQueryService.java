package work05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work05.domain.Member;
import work05.repository.MemberRepository;

@Service
public class MemberQueryService {

  private final MemberRepository repo;

  @Autowired
  public MemberQueryService(MemberRepository repo) {
    this.repo = repo;
  }

  @Transactional(readOnly = true)
  public Member getMemberById(Long id) {
    return repo.findById(id);
  }
}
