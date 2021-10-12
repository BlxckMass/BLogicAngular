package ru.blogic.blogicspring.api.document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.blogic.blogicspring.entity.document.Outgoing;
import ru.blogic.blogicspring.service.document.OutgoingService;

/**
 * Контроллер для обработки запросов, связанных с исходящими документами
 *
 * @author evaleev
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/document/outgoing")
public class OutgoingAPI {

    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static String STATUS_NOT_FOUND_ERROR_JSON = "{\"status\":\"404\", \"message\":\"Документ не найден\"}";
    private final static String STATUS_OK_JSON = "{\"status\":\"200\"}";
    private OutgoingService outgoingService;
    private Gson gson;

    @Autowired
    public OutgoingAPI(OutgoingService outgoingService) {
        this.outgoingService = outgoingService;
        this.gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    /**
     * Метод для получения исходящего документа по идентификатору
     *
     * @param id идентификатор документа
     * @return объект типа ResponseEntity со статусом ответа и с объектом документа, если он был найден
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOutgoingDocumentById(@PathVariable Long id) {
        Outgoing outgoing = outgoingService.readById(id);
        if (outgoing != null) {
            return new ResponseEntity<>(gson.toJson(outgoing), HttpStatus.OK);
        }
        return new ResponseEntity<>(STATUS_NOT_FOUND_ERROR_JSON, HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для удаления исходящего документа
     *
     * @param outgoing объект документа, содержащий идентификатор
     * @return объект типа ResponseEntity со статусом ответа
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOutgoingDocument(@RequestBody Outgoing outgoing) {
        outgoingService.deleteById(outgoing.getId());
        return new ResponseEntity<>(STATUS_OK_JSON, HttpStatus.OK);
    }
}
