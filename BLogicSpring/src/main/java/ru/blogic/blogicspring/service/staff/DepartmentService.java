package ru.blogic.blogicspring.service.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.staff.Department;
import ru.blogic.blogicspring.repository.staff.DepartmentRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.util.List;

/**
 * Сервис для работы с подразделениями
 *
 * @author evaleev
 */
@Service
public class DepartmentService implements ICrudService<Department, Long> {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public void saveAll(List<Department> entities) {
        departmentRepository.saveAll(entities);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Department readById(Long id) {
        return departmentRepository.findDepartmentById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public List<Department> readAll() {
        return departmentRepository.findAll();
    }
}
