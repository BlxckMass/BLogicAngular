package ru.blogic.blogicspring.api.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.blogic.blogicspring.entity.staff.Person;
import ru.blogic.blogicspring.service.staff.PersonService;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Контроллер для обработки запросов, связанных с сотрудниками
 *
 * @author evaleev
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/person")
public class PersonAPI {

    /**
     * Сервис для работы с сотрудниками
     */
    private PersonService personService;

    @Autowired
    public PersonAPI(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Метод для обработки запроса на получение всех сотрудников
     *
     * @return объект типа ResponseEntity, содержащий список пользователей
     */
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPersons() {
        List<Person> allPersons = personService.readAll();
        if (!allPersons.isEmpty()) {
            return new ResponseEntity<>(allPersons, HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"404\"}", HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для обработки запроса на получение сформированного JSON-объекта для древовидной структуры
     *
     * @return объект типа ResponseEntity, содержащий массив сотрудников
     */
    @GetMapping("/tree/getAll")
    public ResponseEntity<?> getAllPersonsForTreeNodes() {
        List<Person> personList = personService.readAll();
        if (personList != null) {
            return new ResponseEntity<>(personService.createJsonForTreeNodes(personList), HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"404\"}", HttpStatus.OK);
    }

    /**
     * Метод для обработки запроса на получение сотрудника по идентификатору
     *
     * @param id идентификатор сотрудника
     * @return объект типа ResponseEntity, содержащий пользователя
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        Person person = personService.readById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"404\"}", HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для обработки запроса на изменение сотрудника
     *
     * @param person объект сотрудника
     * @return объект типа ResponseEntity, содержащий код статуса запроса
     */
    @PutMapping("/update")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        Person savedPerson = personService.save(person);
        if (savedPerson != null) {
            return new ResponseEntity<>("{\"status\":\"200\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"500\"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Метод для обработки запроса на удаление сотрудника
     *
     * @param person данные в формате JSON, содержащие идентификатор сотрудника
     * @return объект типа ResponseEntity, содержащий код статуса запроса
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePerson(@RequestBody Person person) {
        personService.deleteById(person.getId());
        return new ResponseEntity<>("{\"status\":\"200\"}", HttpStatus.OK);
    }
}
