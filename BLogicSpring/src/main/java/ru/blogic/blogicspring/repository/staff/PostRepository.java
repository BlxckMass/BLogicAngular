package ru.blogic.blogicspring.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.staff.Post;

/**
 * Репозиторий для работы с должностями в базе данных
 *
 * @author evaleev
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Метод для получения должности по идентификатору
     *
     * @param id идентификатор должности
     * @return найденную должность
     */
    Post findPostById(Long id);

}
