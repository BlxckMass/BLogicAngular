package ru.blogic.blogicspring.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.staff.Department;

/**
 * Репозиторий для работы с подразделениями в базе данных
 *
 * @author evaleev
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Метод для получения подразделения по идентификатору
     *
     * @param id идентификатор подразделения
     * @return найденное подразделение
     */
    Department findDepartmentById(Long id);

}
