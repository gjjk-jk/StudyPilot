package com.wym.studypilot.controller;

import com.wym.studypilot.model.StudyTask;
import com.wym.studypilot.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/api/tasks")
    public List<StudyTask> getTasks() {

        return taskService.getTasks();
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<StudyTask> getTaskById(@PathVariable Long id) {

        StudyTask task = taskService.getTaskById(id);

        if (task != null) {
            return ResponseEntity.ok(task);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/tasks")
    public StudyTask addTask(@RequestBody StudyTask task) {

        return taskService.addTask(task);
    }

    @PutMapping("/api/tasks/{id}")
    public ResponseEntity<StudyTask> updateTask(
            @PathVariable Long id,
            @RequestBody StudyTask updatedTask) {

        StudyTask task = taskService.updateTask(id, updatedTask);

        if (task != null) {
            return ResponseEntity.ok(task);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        boolean removed = taskService.deleteTask(id);

        if (removed) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}