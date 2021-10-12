package ru.blogic.blogicspring.service.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.staff.Organization;
import ru.blogic.blogicspring.repository.staff.OrganizationRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.util.List;

/**
 * Сервис для работы с организациями
 *
 * @author evaleev
 */
@Service
public class OrganizationService implements ICrudService<Organization, Long> {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Organization save(Organization entity) {
        return organizationRepository.save(entity);
    }

    @Override
    public void saveAll(List<Organization> entities) {
        organizationRepository.saveAll(entities);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Organization readById(Long id) {
        return organizationRepository.findOrganizationById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        organizationRepository.deleteById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public List<Organization> readAll() {
        return organizationRepository.findAll();
    }
}
