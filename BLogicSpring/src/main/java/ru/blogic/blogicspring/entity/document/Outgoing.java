package ru.blogic.blogicspring.entity.document;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.blogic.blogicspring.entity.staff.Person;

import javax.persistence.*;

/**
 * Класс исходящего документа
 *
 * @author evaleev
 */
@Entity
@Table(name = "outgoing")
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Outgoing extends Document {

    /**
     * Поле адресата исходящего документа
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "addressee_id")
    private Person addressee;
    /**
     * Поле метода доставки исходящего документа
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_method")
    private DeliveryMethod deliveryMethod;

}
