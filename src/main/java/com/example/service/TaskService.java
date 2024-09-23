package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Task;
import com.example.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
    private TaskRepository taskRepository; 
      
    public Task createNewTask(Task task) { 
        return taskRepository.save(task); 
    } 
      
    public List<Task> getAllTask() { 
        return taskRepository.findAll(); 
    } 
      
    public Task findTaskById(Long id) { 
        return taskRepository.getById(id); 
    } 
      
    public List<Task> findAllCompletedTask() { 
        return taskRepository.findByCompletedTrue(); 
    } 
      
    public List<Task> findAllInCompleteTask() { 
        return taskRepository.findByCompletedFalse(); 
    } 
      
    public void deleteTask(Long id) { 
        taskRepository.deleteById(id); 
    } 
      
    public Task updateTask(Task task) { 
        return taskRepository.save(task); 
    } 
}
