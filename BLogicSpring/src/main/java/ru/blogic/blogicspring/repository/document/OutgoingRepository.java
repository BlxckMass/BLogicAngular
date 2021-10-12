package ru.blogic.blogicspring.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.document.Outgoing;

@Repository
public interface OutgoingRepository extends JpaRepository<Outgoing, Long> {

    /**
     * Метод для получения исходящего документа по идентификатору
     * @param id идентификатор документа
     * @return найденный исходящий документ
     */
    Outgoing findOutgoingById(Long id);
}
