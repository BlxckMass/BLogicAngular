package ru.blogic.blogicspring.api.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.blogic.blogicspring.entity.staff.Post;
import ru.blogic.blogicspring.service.staff.PostService;

import java.util.List;

/**
 * Контроллер для обработки запросов, связанных с должностями
 *
 * @author evaleev
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/post")
public class PostAPI {

    /**
     * Сервис для работы с должностями
     */
    private PostService postService;

    @Autowired
    public PostAPI(PostService postService) {
        this.postService = postService;
    }

    /**
     * Метод для обработки запроса на получение всех должностей
     *
     * @return объект типа ResponseEntity, содержащий список должностей
     */
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPosts() {
        List<Post> allPosts = postService.readAll();
        if (!allPosts.isEmpty()) {
            return new ResponseEntity<>(allPosts, HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"404\"}", HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для обработки запроса на получение должности по идентификатору
     *
     * @param id идентификатор должности
     * @return объект типа ResponseEntity, содержащий должность
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        Post post = postService.readById(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"404\"}", HttpStatus.NOT_FOUND);
    }

    /**
     * Метод для обработки запроса на изменение должности
     *
     * @param post объект должности
     * @return объект типа ResponseEntity, содержащий код статуса запроса
     */
    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody Post post) {
        Post savedPost = postService.save(post);
        if (savedPost != null) {
            return new ResponseEntity<>("{\"status\":\"200\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"status\":\"500\"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Метод для обработки запроса на удаление должности
     *
     * @param id идентификатор должности
     * @return объект типа ResponseEntity, содержащий код статуса запроса
     */
    @DeleteMapping("/delete}")
    public ResponseEntity<?> deletePostById(@RequestParam Long id) {
        postService.deleteById(id);
        return new ResponseEntity<>("{\"status\":\"200\"}", HttpStatus.OK);
    }
}
