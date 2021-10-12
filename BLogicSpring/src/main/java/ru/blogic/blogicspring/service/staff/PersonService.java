package ru.blogic.blogicspring.service.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.blogic.blogicspring.entity.document.Document;
import ru.blogic.blogicspring.entity.staff.Person;
import ru.blogic.blogicspring.repository.staff.PersonRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.text.MessageFormat;
import java.util.*;

/**
 * Сервис для работы с сотрудниками
 *
 * @author evaleev
 */
@Service
public class PersonService implements ICrudService<Person, Long> {

    private final String PERSON_JSON_KEY = "person";
    private final String TAB_ID_JSON_KEY = "tabId";
    private final String TYPE_JSON_KEY = "type";
    private final String NODE_NAME_JSON_KEY = "nodeName";
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Person save(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    public void saveAll(List<Person> entities) {
        personRepository.saveAll(entities);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Person readById(Long id) {
        return personRepository.findPersonById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public List<Person> readAll() {
        return personRepository.findAll();
    }

    public List<Object> createJsonForTreeNodes(List<Person> personList) {
        List<Object> jsonArray = new ArrayList<>();
        personList.forEach(person -> {
            Map<Object, Object> map = new HashMap<>();
            map.put(PERSON_JSON_KEY, person);
            map.put(TAB_ID_JSON_KEY, person.getId());
            map.put(TYPE_JSON_KEY, person.getClass().getSimpleName());
            map.put(NODE_NAME_JSON_KEY, MessageFormat.format("{0} {1} {2}",
                    person.getLastName(), person.getFirstName(), person.getPatronymic()));
            jsonArray.add(map);
        });
        return jsonArray;
    }

    /**
     * Метод для получения случайного значения из переданной коллекции сотрудников
     *
     * @return возвращает случайного сотрудника из коллекции
     */
    public Person getRandomPerson() {
        List<Person> personList = personRepository.findAll();
        if (personList.size() != 0) {
            return personList.get(new Random().nextInt(personList.size()));
        }
        return null;
    }
}
