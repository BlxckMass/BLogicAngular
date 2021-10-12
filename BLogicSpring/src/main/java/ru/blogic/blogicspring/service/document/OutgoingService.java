package ru.blogic.blogicspring.service.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blogic.blogicspring.entity.document.Outgoing;
import ru.blogic.blogicspring.repository.document.OutgoingRepository;
import ru.blogic.blogicspring.service.ICrudService;

import java.util.List;

@Service
public class OutgoingService implements ICrudService<Outgoing, Long> {

    private OutgoingRepository outgoingRepository;

    @Autowired
    public OutgoingService(OutgoingRepository outgoingRepository) {
        this.outgoingRepository = outgoingRepository;
    }

    @Override
    public Outgoing save(Outgoing entity) {
        return outgoingRepository.save(entity);
    }

    @Override
    public void saveAll(List<Outgoing> entities) {
        outgoingRepository.saveAll(entities);
    }

    @Override
    public Outgoing readById(Long id) {
        return outgoingRepository.findOutgoingById(id);
    }

    @Override
    public void deleteById(Long id) {
        outgoingRepository.deleteById(id);
    }

    @Override
    public List<Outgoing> readAll() {
        return outgoingRepository.findAll();
    }
}
