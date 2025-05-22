package work05.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import work05.config.AppConfig;
import work05.service.PostService;

public class Main11 {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    PostService postService = context.getBean("postService",PostService.class);
    postService.getPosts();
  }
}

/*
* JPA Lazy 로딩으로 인한 N+1 : 처음 하나의 쿼리로 N개의 엔티티를 가져온 후
* N개의 엔티티 각각에 대해 연관된 데이터를 다시 1개씩 조회하는 쿼리가 추가적으로 발생되는 상황
* @OneToMany(mappedBy='emp', fetch=FetchType.LAZY)
*
* 뜻
* 한 사원은 여러 개의 프로젝트를 가질 수 있다.
* 해당 쿼리 실행 : select * from employee;
* 직원마다 프로젝트 조회 쿼리 실행
* select * from project where employee_id = 1;
* ... 직원 수 N개 쿼리 발생
* => 총 N+1(select * from employee) 개 실행됨
*
* */
