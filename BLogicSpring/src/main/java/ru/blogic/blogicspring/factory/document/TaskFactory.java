package ru.blogic.blogicspring.factory.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.blogic.blogicspring.entity.document.Document;
import ru.blogic.blogicspring.entity.document.Task;
import ru.blogic.blogicspring.service.staff.PersonService;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Фабрика для создания поручений
 *
 * @author evaleev
 */
@Component
public class TaskFactory implements DocumentFactory {

    private PersonService personService;
    private Random random;

    @Autowired
    public TaskFactory(PersonService personService) {
        this.personService = personService;
        random = new Random();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Document createDocument() {
        Date date = new Date(ThreadLocalRandom.current().nextLong(0L, 1629284699L * 1000));
        return Task.builder()
                .id(Math.abs(random.nextLong()))
                .author(personService.getRandomPerson())
                .name(UUID.randomUUID().toString())
                .text(UUID.randomUUID().toString())
                .registrationNumber(Math.abs(random.nextLong()))
                .dateOfRegistration(date)
                .executor(personService.getRandomPerson())
                .controller(personService.getRandomPerson())
                .controlSign(random.nextBoolean())
                .dateOfIssue(date)
                .periodOfExecution(random.nextInt(365) + " days")
                .build();
    }
}
