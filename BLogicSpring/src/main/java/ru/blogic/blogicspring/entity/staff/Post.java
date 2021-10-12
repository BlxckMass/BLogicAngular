package ru.blogic.blogicspring.entity.staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Класс должности сотрудника
 *
 * @author evaleev
 */
@Entity
@Table(name = "post")
@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    /**
     * Идентификатор должности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name = "post_generator", sequenceName = "post_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Название должности
     */
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
