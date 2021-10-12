package ru.blogic.blogicspring.service.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.document.Task;
import ru.blogic.blogicspring.repository.document.TaskRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.util.List;

@Service
public class TaskService implements ICrudService<Task, Long> {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public void saveAll(List<Task> entities) {
        taskRepository.saveAll(entities);
    }

    @Override
    public Task readById(Long id) {
        return taskRepository.findTaskById(id);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> readAll() {
        return taskRepository.findAll();
    }
}
