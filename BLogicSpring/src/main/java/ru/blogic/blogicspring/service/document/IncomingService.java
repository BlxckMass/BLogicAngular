package ru.blogic.blogicspring.service.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.document.Incoming;
import ru.blogic.blogicspring.repository.document.IncomingRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.util.List;

/**
 * Сервис для работы с входящими документами
 *
 * @author evaleev
 */
@Service
public class IncomingService implements ICrudService<Incoming, Long> {

    private IncomingRepository incomingRepository;

    @Autowired
    public IncomingService(IncomingRepository incomingRepository) {
        this.incomingRepository = incomingRepository;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Incoming save(Incoming entity) {
        return incomingRepository.save(entity);
    }

    @Override
    public void saveAll(List<Incoming> entities) {
        incomingRepository.saveAll(entities);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Incoming readById(Long id) {
        return incomingRepository.findIncomingById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        incomingRepository.deleteById(id);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public List<Incoming> readAll() {
        return incomingRepository.findAll();
    }
}
