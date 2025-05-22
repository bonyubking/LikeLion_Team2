package work05.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work05.domain.Post;
import work05.repository.PostRepository;

@Service("postService")
public class PostService {

  @Autowired
  private PostRepository postRepo;

  @Transactional(readOnly = true)
  public List<Post> getPosts() {
    return postRepo.findAll(); // fetch join 사용
  }
}