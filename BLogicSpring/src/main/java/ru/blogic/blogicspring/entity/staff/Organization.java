package ru.blogic.blogicspring.entity.staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Класс организации
 *
 * @author evaleev
 */
@Entity
@Table(name = "organization")
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Organization extends Staff {

    /**
     * Название организации
     */
    @Column(name = "name")
    private String name;

    /**
     * Короткое название организации
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * Лидер организации
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "leader_id", referencedColumnName = "id", nullable = false)
    private Person leader;

    /**
     * Телефонные номера организации
     */
    @Column(name = "phone_numbers")
    private String phoneNumbers;

    @PreRemove
    private void preRemove() {
        this.leader = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        if (!super.equals(o)) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) && Objects.equals(shortName, that.shortName) && Objects.equals(leader, that.leader) && Objects.equals(phoneNumbers, that.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, shortName, leader, phoneNumbers);
    }
}
