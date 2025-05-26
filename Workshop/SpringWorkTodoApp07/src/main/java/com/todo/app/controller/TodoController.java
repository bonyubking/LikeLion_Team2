package com.todo.app.controller;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {

  private final TodoMapper todoMapper;

  @RequestMapping(value = "/")
  public String index(Model model) {
//    List<Todo> list = todoMapper.selectAll();
    List<Todo> list = todoMapper.selectIncomplete();
    List<Todo> doneList = todoMapper.selectComplete();
    model.addAttribute("todos", list);
    model.addAttribute("doneTodos", doneList);
    return "index";
  }

  @RequestMapping(value = "/add")
  public String add(Todo todo) {
    todoMapper.add(todo);
    return "redirect:/";
  }

  @RequestMapping(value = "/update")
  public String update(Todo todo) {
    System.out.println("todo done_flag=" + todo.getDone_flg());
    todoMapper.update(todo);
    return "redirect:/";
  }

  @RequestMapping(value = "/delete")
  public String delete() {
    todoMapper.delete();
    return "redirect:/";
  }
}
