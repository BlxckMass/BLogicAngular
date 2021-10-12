package ru.blogic.blogicspring.service.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.staff.Post;
import ru.blogic.blogicspring.repository.staff.PostRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.util.List;

/**
 * Сервис для работы с должностями
 *
 * @author evaleev
 */
@Service
public class PostService implements ICrudService<Post, Long> {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Post save(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public void saveAll(List<Post> entities) {
        postRepository.saveAll(entities);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Post readById(Long id) {
        return postRepository.findPostById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }
}
