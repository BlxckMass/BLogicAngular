package ru.blogic.blogicspring.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.staff.Person;

/**
 * Репозиторий для работы с сотрудниками в базе данных
 *
 * @author evaleev
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Метод для получения сотрудника по идентификатору
     *
     * @param id идентификатор сотрудника
     * @return найденного сотрудника
     */
    Person findPersonById(Long id);

}
