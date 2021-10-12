package ru.blogic.blogicspring.entity.document;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.blogic.blogicspring.entity.staff.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс поручения
 *
 * @author evaleev
 */
@Entity
@Table(name = "task")
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Task extends Document {

    /**
     * Поле даты выдачи поручения
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    /**
     * Поле периода выполнения поручения
     */
    @Column(name = "period_of_execution")
    private String periodOfExecution;

    /**
     * Поле признака контрольности поручения
     */
    @Column(name = "control_sign")
    private boolean controlSign;

    /**
     * Поле исполнителя поручения
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "executor_id", referencedColumnName = "id", nullable = false)
    private Person executor;

    /**
     * Поле контроллера поручения
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "controller_id", referencedColumnName = "id", nullable = false)
    private Person controller;
}
