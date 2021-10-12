package ru.blogic.blogicspring.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.blogic.blogicspring.entity.document.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
