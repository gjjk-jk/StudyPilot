package com.wym.studypilot.service;

import com.wym.studypilot.mapper.TaskMapper;
import com.wym.studypilot.model.StudyTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<StudyTask> getTasks() {
        return taskMapper.findAll();
    }

    public StudyTask getTaskById(Long id) {
        return taskMapper.findById(id);
    }

    public StudyTask addTask(StudyTask task) {

        task.setId(null);

        taskMapper.insert(task);

        return task;
    }

    public StudyTask updateTask(Long id, StudyTask updatedTask) {

        StudyTask existingTask = taskMapper.findById(id);

        if (existingTask == null) {
            return null;
        }

        updatedTask.setId(id);

        taskMapper.update(updatedTask);

        return updatedTask;
    }

    public boolean deleteTask(Long id) {

        return taskMapper.deleteById(id) > 0;
    }
}