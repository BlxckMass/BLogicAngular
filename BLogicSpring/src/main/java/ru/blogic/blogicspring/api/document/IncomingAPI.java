package ru.blogic.blogicspring.api.document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.blogic.blogicspring.entity.document.Incoming;
import ru.blogic.blogicspring.service.document.IncomingService;

/**
 * Контроллер для обработки запросов, связанных с входящими документами
 *
 * @author evaleev
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/document/incoming")
public class IncomingAPI {

    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static String STATUS_NOT_FOUND_ERROR_JSON = "{\"status\":\"404\", \"message\":\"Документ не найден\"}";
    private final static String STATUS_OK_JSON = "{\"status\":\"200\"}";
    private IncomingService incomingService;
    private Gson gson;

    @Autowired
    public IncomingAPI(IncomingService incomingService) {
        this.incomingService = incomingService;
        this.gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    /**
     * Метод для получения входящего документа по идентификатору
     *
     * @param id идентификатор документа
     * @return объект типа ResponseEntity со статусом ответа и с объектом документа, если он был найден
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getIncomingDocumentById(@PathVariable Long id) {
        Incoming incoming = incomingService.readById(id);
        if (incoming != null) {
            return new ResponseEntity<>(gson.toJson(incoming), HttpStatus.OK);
        }
        return new ResponseEntity<>(STATUS_NOT_FOUND_ERROR_JSON, HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для удаления входящего документа
     *
     * @param incoming объект документа, содержащий идентификатор
     * @return объект типа ResponseEntity со статусом ответа
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteIncomingDocument(@RequestBody Incoming incoming) {
        incomingService.deleteById(incoming.getId());
        return new ResponseEntity<>(STATUS_OK_JSON, HttpStatus.OK);
    }
}
