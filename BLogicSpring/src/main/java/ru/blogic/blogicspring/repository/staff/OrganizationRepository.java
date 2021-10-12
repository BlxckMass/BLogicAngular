package ru.blogic.blogicspring.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.staff.Organization;

/**
 * Репозиторий для работы с организациями в базе данных
 *
 * @author evaleev
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    /**
     * Метод для получения организации по идентификатору
     *
     * @param id идентификатор организации
     * @return найденную организацию
     */
    Organization findOrganizationById(Long id);

}
