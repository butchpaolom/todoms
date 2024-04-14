package com.todo.taskcore.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.todo.taskcore.models.TaskEntity;
import com.todo.taskcore.repository.TaskRepository;
import com.todo.taskcore.security.UserContext;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;
    
    public TaskEntity getTask(Long id){
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isPresent())
            return task.get();
        throw new EntityNotFoundException();
    }

	public TaskEntity createTask(TaskEntity taskEntity) {
		taskEntity.setUserId(UserContext.getUserId());
		taskEntity.setCreatedDate(LocalDate.now());
		return taskRepository.save(taskEntity);
	}

	public TaskEntity partialTask(Long id, TaskEntity taskEntity) {
		Optional<TaskEntity> task = taskRepository.findById(id);
		if (task.isEmpty()) 
			throw new EntityNotFoundException();
		TaskEntity actualTask = task.get();
		actualTask.setDescription(taskEntity.getDescription());
		actualTask.setTitle(taskEntity.getTitle());
		return taskRepository.save(actualTask);
	}
}
