package ru.blogic.blogicspring.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.document.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Метод для получения поручения по идентификатору
     * @param id идентификатор документа
     * @return найденное поручение
     */
    Task findTaskById(Long id);
}
