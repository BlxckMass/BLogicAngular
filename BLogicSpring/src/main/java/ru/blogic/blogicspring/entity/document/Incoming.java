package ru.blogic.blogicspring.entity.document;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.blogic.blogicspring.entity.staff.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс входящего документа
 *
 * @author evaleev
 */
@Entity
@Table(name = "incoming")
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Incoming extends Document {

    /**
     * Поле отправителя входящего документа
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    private Person sender;

    /**
     * Поле адресата входящего документа
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "addressee_id", referencedColumnName = "id", nullable = false)
    private Person addressee;

    /**
     * Поле исходящего номера входящего документа
     */
    @Column(name = "outgoing_number")
    private Long outgoingNumber;

    /**
     * Поле исходящей даты регистрации входящего документа
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "outgoing_date_of_registration")
    private Date outgoingDateOfRegistration;

    @PreRemove
    public void preRemove() {
        this.setAuthor(null);
        this.setSender(null);
        this.setAddressee(null);
    }

}
