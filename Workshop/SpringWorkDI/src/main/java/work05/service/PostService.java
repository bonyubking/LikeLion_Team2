package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepo;

  @Transactional(readOnly = true)
  public List<Post> getPosts() {
    return postRepo.findAllWithAuthor(); // fetch join 사용
  }
}