package com.example.controller; 

import com.example.model.Task; 
import com.example.service.TaskService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.*; 

import java.util.List; 

@Controller
@RequestMapping("/api/v1/tasks/") 
public class TaskController { 

	@Autowired
	private TaskService taskService; 
	@GetMapping("/") 
	public ResponseEntity<List<Task>> getAllTasks() { 
		return ResponseEntity.ok(taskService.getAllTask()); 
	} 
	@GetMapping("/completed") 
	public ResponseEntity<List<Task>> getAllCompletedTasks() { 
		return ResponseEntity.ok(taskService.findAllCompletedTask()); 
	} 
	@GetMapping("/incomplete") 
	public ResponseEntity<List<Task>> getAllIncompleteTasks() { 
		return ResponseEntity.ok(taskService.findAllInCompleteTask()); 
	} 
	@PostMapping("/add") 
	public ResponseEntity<Task> createTask(@RequestBody Task task) { 
		return ResponseEntity.ok(taskService.createNewTask(task)); 
	} 
	@PutMapping("/{id}") 
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) { 
		task.setId(id); 
		return ResponseEntity.ok(taskService.updateTask(task)); 
	} 
	@DeleteMapping("/{id}") 
	public ResponseEntity<Boolean> deletetask(@PathVariable Long id) { 
		taskService.deleteTask(id); 
		return ResponseEntity.ok(true); 
	} 
}

