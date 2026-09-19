package com.wym.studypilot.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.wym.studypilot.model.StudyTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private final List<StudyTask> tasks = new ArrayList<>();

    private long nextId = 4l;
    public TaskController() {

        tasks.add(new StudyTask(
                1L,
                "学习Java",
                "学习Java面向对象",
                false
        ));

        tasks.add(new StudyTask(
                2L,
                "刷算法题",
                "完成两道数组相关算法题",
                false
        ));

        tasks.add(new StudyTask(
                3l,
                "学习Spring Boot",
                "理解Controller和REST API",
                true
        ));
    }

    @GetMapping("/api/tasks")
    public List<StudyTask> getTask() {
        return tasks;
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<StudyTask> getTaskById(@PathVariable Long id) {

        for (StudyTask task : tasks) {

            if (task.getId().equals(id)) {
                return ResponseEntity.ok(task);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/tasks")
    public StudyTask addTask(@RequestBody StudyTask task) {

        task.setId(nextId);

        nextId++;

        tasks.add(task);

        return task;
    }

    @PutMapping("/api/tasks/{id}")
    public ResponseEntity<StudyTask> updateTask(
            @PathVariable Long id,
            @RequestBody StudyTask updatedTask) {

        for (StudyTask task : tasks) {

            if (task.getId().equals(id)) {

                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());

                return ResponseEntity.ok(task);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        boolean removed = tasks.removeIf(
                task -> task.getId().equals(id)
        );

        if (removed) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
