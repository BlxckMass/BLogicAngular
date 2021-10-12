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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Класс элемента орг.структуры
 *
 * @author evaleev
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "staff")
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Staff {

    /**
     * Идентификатор оргштатной единицы
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_generator")
    @SequenceGenerator(name = "staff_generator", sequenceName = "staff_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(id, staff.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
