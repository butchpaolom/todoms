package com.todo.taskcore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.taskcore.models.TaskEntity;
import com.todo.taskcore.security.UserContext;
import com.todo.taskcore.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{id}")
    public TaskEntity getTask(@PathVariable("id") Long id){
        return taskService.getTask(id);
    }
    
    @PostMapping("/tasks")
    public TaskEntity createTask(@RequestBody TaskEntity taskEntity){
    	return taskService.createTask(taskEntity);
    }
    
    @PatchMapping("/tasks/{id}")
    public TaskEntity updateTask(@PathVariable("id") Long id, @RequestBody TaskEntity taskEntity) {
    	return taskService.partialTask(id, taskEntity);
    }
}
