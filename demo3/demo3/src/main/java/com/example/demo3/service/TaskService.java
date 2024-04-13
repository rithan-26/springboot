package com.example.demo3.service;

import com.example.demo3.model.Adoption;
import com.example.demo3.repository.AdoptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final AdoptionRepo taskRepo;

    public TaskService(AdoptionRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Adoption saveTask(Adoption task) {
        return taskRepo.save(task);
    }

    public List<Adoption> getAllTasks() {
        return taskRepo.findAll();
    }

    public Optional<Adoption> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    public void deleteTaskById(Long id) {
        taskRepo.deleteById(id);
    }
}
