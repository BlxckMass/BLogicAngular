package ru.blogic.blogicspring.entity.document;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.blogic.blogicspring.entity.staff.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Абстрактный класс документа
 *
 * @author evaleev
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "document")
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Document {

    /**
     * Идентификатор документа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_generator")
    @SequenceGenerator(name = "document_generator", sequenceName = "document_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Поле наименования документа
     */
    @Column(name = "name")
    private String name;

    /**
     * Поле текста документа
     */
    @Column(name = "text")
    private String text;

    /**
     * Поле регистрационного номера документа
     */
    @Column(name = "registration_number")
    private Long registrationNumber;

    /**
     * Поле даты регистрации документа
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_registration")
    private Date dateOfRegistration;

    /**
     * Поле автора документа
     */
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Person author;

    @PreRemove
    public void preRemove() {
        this.author = null;
    }
}
