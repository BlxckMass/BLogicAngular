package ru.blogic.blogicspring.api.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.blogic.blogicspring.entity.document.Document;
import ru.blogic.blogicspring.service.document.DocumentService;

import java.util.List;

/**
 * Контроллер для обработки запросов, связанных с документами
 *
 * @author evaleev
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/document")
public class DocumentAPI {

    private final static String STATUS_NOT_FOUND_ERROR_JSON = "{\"status\":\"404\", \"message\":\"Документы не найдены\"}";
    private DocumentService documentService;

    @Autowired
    public DocumentAPI(DocumentService documentService) {
        this.documentService = documentService;
    }

    /**
     * Метод для обработки запроса на получение сформированного JSON-объекта для древовидной структуры
     *
     * @return объект типа ResponseEntity, содержащий массив документов
     */
    @GetMapping("/tree/getAll")
    public ResponseEntity<?> getAllDocumentsForTreeNodes() {
        List<? extends Document> documents = documentService.readAllDocuments();
        if (documents != null) {
            return new ResponseEntity<>(documentService.createJsonForTreeNodes(documents), HttpStatus.OK);
        }
        return new ResponseEntity<>(STATUS_NOT_FOUND_ERROR_JSON, HttpStatus.NOT_FOUND);
    }
}
