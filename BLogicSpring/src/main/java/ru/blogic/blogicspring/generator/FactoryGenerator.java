package ru.blogic.blogicspring.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blogic.blogicspring.factory.document.DocumentFactory;
import ru.blogic.blogicspring.factory.document.IncomingFactory;
import ru.blogic.blogicspring.factory.document.OutgoingFactory;
import ru.blogic.blogicspring.factory.document.TaskFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс для генерирования различных фабрик
 *
 * @author evaleev
 */
@Component
public class FactoryGenerator {

    private List<DocumentFactory> documentFactories;
    private IncomingFactory incomingFactory;
    private OutgoingFactory outgoingFactory;
    private TaskFactory taskFactory;
    private Random random;

    @Autowired
    public FactoryGenerator(IncomingFactory incomingFactory, OutgoingFactory outgoingFactory, TaskFactory taskFactory) {
        this.incomingFactory = incomingFactory;
        this.outgoingFactory = outgoingFactory;
        this.taskFactory = taskFactory;
        documentFactories = Arrays.asList(incomingFactory, outgoingFactory, taskFactory);
        random = new Random();
    }

    /**
     * Метод для получения случайной фабрики
     *
     * @return возвращает случайную фабрику
     */
    public DocumentFactory getRandomDocumentFactory() {
        return documentFactories.get(random.nextInt(documentFactories.size()));
    }

}
