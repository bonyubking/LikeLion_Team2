
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    // 문제11 정답
	@Transactional
	//LazyInitalization -> 
    public List<String> getPosts() {
        System.out.println("[게시글 전체 조회]");
        return List.of("글1", "글2");
    }
}
