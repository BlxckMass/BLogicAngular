package ru.blogic.blogicspring.factory.document;

import ru.blogic.blogicspring.entity.document.Document;

/**
 * Интерфейс фабрики документа
 *
 * @author evaleev
 */
public interface DocumentFactory {
    /**
     * Метод для создания документа фабрикой
     *
     * @return возвращает созданный документ определенной фабрики
     */
    Document createDocument();
}
