package com.todo.app.mapper;

import com.todo.app.entity.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

  public List<Todo> selectAll();

  public void add(Todo todo);

  public void update(Todo todo);

  public List<Todo> selectIncomplete();

  public List<Todo> selectComplete();

  public void delete();
}
