package ru.blogic.blogicspring.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import ru.blogic.blogicspring.entity.staff.Person;
import ru.blogic.blogicspring.entity.staff.Post;
import ru.blogic.blogicspring.service.document.DocumentService;
import ru.blogic.blogicspring.service.staff.DepartmentService;
import ru.blogic.blogicspring.service.staff.OrganizationService;
import ru.blogic.blogicspring.service.staff.PersonService;
import ru.blogic.blogicspring.service.staff.PostService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Конфигурация для отслеживания запуска приложения и выполнения логики
 *
 * @author evaleev
 */
@Configuration
public class StartupInitializerConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(StartupInitializerConfiguration.class);
    private static final int DOCUMENT_COUNT = 1000;
    /**
     * Класс для работы с xml-документами
     */
    private XmlMapper xmlMapper;
    /**
     * Сервис для работы с сотрудниками
     */
    private PersonService personService;
    /**
     * Сервис для работы с должностями
     */
    private PostService postService;
    /**
     * Сервис для работы с подразделениями
     */
    private DepartmentService departmentService;
    /**
     * Сервис для работы с организациями
     */
    private OrganizationService organizationService;
    /**
     * Сервис для работы с организациями
     */
    private DocumentService documentService;
    /**
     * Путь до файла xml с сотрудниками
     */
    @Value(value = "classpath:/static/xml-files/person.xml")
    private Resource personXml;
    /**
     * Путь до файла xml с должностями
     */
    @Value(value = "classpath:/static/xml-files/post.xml")
    private Resource postXml;
    /**
     * Путь до файла xml с организациями
     */
    @Value(value = "classpath:/static/xml-files/organization.xml")
    private Resource organizationXml;
    /**
     * Путь до файла xml с подразделениями
     */
    @Value(value = "classpath:/static/xml-files/department.xml")
    private Resource departmentXml;

    public StartupInitializerConfiguration(PersonService personService,
                                           PostService postService,
                                           DepartmentService departmentService,
                                           OrganizationService organizationService, DocumentService documentService) {
        this.personService = personService;
        this.postService = postService;
        this.departmentService = departmentService;
        this.organizationService = organizationService;
        this.documentService = documentService;
        this.xmlMapper = new XmlMapper();
    }

    /**
     * Слушатель старта приложения и выполнение загрузки данных из xml-документов в базу данных
     */
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        try {
            List<Post> posts = Arrays.asList(xmlMapper.readValue(postXml.getURL(), Post[].class));
            postService.saveAll(posts);
        } catch (IOException e) {
            LOG.error("Ошибка при чтении файла post.xml", e);
        }
        try {
            List<Person> people = Arrays.asList(xmlMapper.readValue(personXml.getURL(), Person[].class));
            personService.saveAll(people);
        } catch (IOException e) {
            LOG.error("Ошибка при чтении файла person.xml", e);
        }
        documentService.generateAndSaveDifferentDocuments(DOCUMENT_COUNT);
//        try {
//            organizationService.saveAll(Arrays.asList(xmlMapper.readValue(organizationXml.getURL(), Organization[].class)));
//        } catch (IOException e) {
//            LOG.error("Ошибка при чтении файла organization.xml", e);
//        }
//        try {
//            departmentService.saveAll(Arrays.asList(xmlMapper.readValue(departmentXml.getURL(), Department[].class)));
//        } catch (IOException e) {
//            LOG.error("Ошибка при чтении файла department.xml", e);
//        }
    }
}
