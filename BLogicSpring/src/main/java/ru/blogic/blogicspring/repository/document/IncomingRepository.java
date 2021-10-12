package ru.blogic.blogicspring.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.document.Incoming;

@Repository
public interface IncomingRepository extends JpaRepository<Incoming, Long> {

    /**
     * Метод для получения входящего документа по идентификатору
     * @param id идентификатор документа
     * @return найденный входящий документ
     */
    Incoming findIncomingById(Long id);
}
