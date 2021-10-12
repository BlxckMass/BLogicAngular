package ru.blogic.blogicspring.service.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.document.Document;
import ru.blogic.blogicspring.entity.document.Incoming;
import ru.blogic.blogicspring.entity.document.Outgoing;
import ru.blogic.blogicspring.entity.document.Task;
import ru.blogic.blogicspring.factory.document.DocumentFactory;
import ru.blogic.blogicspring.generator.FactoryGenerator;
import ru.blogic.blogicspring.repository.document.DocumentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService {

    private final String TAB_ID_JSON_KEY = "tabId";
    private final String TYPE_JSON_KEY = "type";
    private final String NODE_NAME_JSON_KEY = "nodeName";
    private IncomingService incomingService;
    private OutgoingService outgoingService;
    private TaskService taskService;
    private FactoryGenerator factoryGenerator;
    private DocumentRepository documentRepository;

    @Autowired
    public DocumentService(IncomingService incomingService, OutgoingService outgoingService, TaskService taskService, FactoryGenerator factoryGenerator, DocumentRepository documentRepository) {
        this.incomingService = incomingService;
        this.outgoingService = outgoingService;
        this.taskService = taskService;
        this.factoryGenerator = factoryGenerator;
        this.documentRepository = documentRepository;
    }

    public List<? extends Document> readAllDocuments() {
        List<Document> documents = new ArrayList<>();
        documents.addAll(incomingService.readAll());
        documents.addAll(outgoingService.readAll());
        documents.addAll(taskService.readAll());
        return documents;
    }

    public Incoming readInc(Long id) {
        return incomingService.readById(id);
    }

    public Outgoing readOut(Long id) {
        return outgoingService.readById(id);
    }

    public Task readTask(Long id) {
        return taskService.readById(id);
    }

    public List<Object> createJsonForTreeNodes(List<? extends Document> documents) {
        List<Object> jsonArray = new ArrayList<>();
        documents.forEach(document -> {
            Map<Object, Object> map = new HashMap<>();
            map.put(TYPE_JSON_KEY, document.getClass().getSimpleName());
            map.put(TAB_ID_JSON_KEY, document.getId());
            map.put(NODE_NAME_JSON_KEY, document.getName());
            jsonArray.add(map);
        });
        return jsonArray;
    }

    /**
     * Метод для генерирования определенного количества документов, каждый проход цикла - случайный документ
     *
     * @param documentCount - количество документов
     */
    public void generateAndSaveDifferentDocuments(int documentCount) {
        for (int i = 0; i < documentCount; i++) {
            generateAndSaveDocument(factoryGenerator.getRandomDocumentFactory());
        }
    }

    /**
     * Метод для генерации документов определенной фабрики
     *
     * @param documentFactory - конкретная реализация фабрики документов
     */
    private void generateAndSaveDocument(DocumentFactory documentFactory) {
        Document document = documentFactory.createDocument();
        documentRepository.save(document);
    }
}
