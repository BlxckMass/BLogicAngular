package ru.blogic.blogicspring.api.document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.blogic.blogicspring.entity.document.Task;
import ru.blogic.blogicspring.service.document.TaskService;

/**
 * Контроллер для обработки запросов, связанных с поручениями
 *
 * @author evaleev
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/document/task")
public class TaskAPI {

    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static String STATUS_NOT_FOUND_ERROR_JSON = "{\"status\":\"404\", \"message\":\"Документ не найден\"}";
    private final static String STATUS_OK_JSON = "{\"status\":\"200\"}";
    private TaskService taskService;
    private Gson gson;

    @Autowired
    public TaskAPI(TaskService taskService) {
        this.taskService = taskService;
        this.gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    /**
     * Метод для получения поручения по идентификатору
     *
     * @param id идентификатор документа
     * @return объект типа ResponseEntity со статусом ответа и с объектом документа, если он был найден
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTaskDocumentById(@PathVariable Long id) {
        Task task = taskService.readById(id);
        if (task != null) {
            return new ResponseEntity<>(gson.toJson(task), HttpStatus.OK);
        }
        return new ResponseEntity<>(STATUS_NOT_FOUND_ERROR_JSON, HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для удаления поручения
     *
     * @param task объект документа, содержащий идентификатор
     * @return объект типа ResponseEntity со статусом ответа
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTaskDocument(@RequestBody Task task) {
        taskService.deleteById(task.getId());
        return new ResponseEntity<>(STATUS_OK_JSON, HttpStatus.OK);
    }

}
