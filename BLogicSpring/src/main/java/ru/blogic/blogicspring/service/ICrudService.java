package ru.blogic.blogicspring.service;

import java.util.List;

/**
 * Интерфейс для сервисов с методами доступа к данным
 *
 * @param <T> тип сущности
 * @param <K> тип идентификатора
 * @author evaleev
 */
public interface ICrudService<T, K> {

    /**
     * Метод для сохранения сущности
     *
     * @param entity сущность, необходимую сохранить
     * @return сохраненную сущность
     */
    T save(T entity);

    /**
     * Метод для сохранения сущности
     *
     * @param entities сущности, необходимые сохранить
     */
    void saveAll(List<T> entities);

    /**
     * Метод для получения сущности по идентификатору
     *
     * @param id идентификатор сущности
     * @return найденную сущность
     */
    T readById(K id);

    /**
     * Метод для удаления сущности по идентификатору
     *
     * @param id идентификатор сущности, необходимую удалить
     */
    void deleteById(K id);

    /**
     * Метод для получения всех сущностей
     *
     * @return все найденные сущности
     */
    List<T> readAll();

}
