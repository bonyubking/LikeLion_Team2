package work03.sec01;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

  private final Map<Integer, String> members = new HashMap<>();

  public MemoryMemberRepository() {
    members.put(1, "홍길동");
    members.put(2, "정길동");
    members.put(3, "김길동");
  }

  @Override
  public String findMemberById(int id) {
    return members.get(id);
  }
}
