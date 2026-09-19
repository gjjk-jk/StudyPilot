package com.wym.studypilot.service;

import com.wym.studypilot.model.StudyTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<StudyTask> tasks = new ArrayList<>();

    private long nextId = 4L;

    public TaskService() {

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
                3L,
                "学习Spring Boot",
                "理解Controller和REST API",
                true
        ));
    }

    public List<StudyTask> getTasks() {
        return tasks;
    }

    public StudyTask getTaskById(Long id) {

        for (StudyTask task : tasks) {

            if (task.getId().equals(id)) {
                return task;
            }
        }

        return null;
    }

    public StudyTask addTask(StudyTask task) {

        task.setId(nextId);

        nextId++;

        tasks.add(task);

        return task;
    }

    public StudyTask updateTask(Long id, StudyTask updatedTask) {

        for (StudyTask task : tasks) {

            if (task.getId().equals(id)) {

                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());

                return task;
            }
        }

        return null;
    }

    public boolean deleteTask(Long id) {

        return tasks.removeIf(
                task -> task.getId().equals(id)
        );
    }
}