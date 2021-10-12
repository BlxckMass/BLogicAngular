package ru.blogic.blogicspring.entity.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.blogic.blogicspring.entity.document.Document;
import ru.blogic.blogicspring.entity.document.Incoming;
import ru.blogic.blogicspring.entity.document.Outgoing;
import ru.blogic.blogicspring.entity.document.Task;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Класс сотрудника
 *
 * @author evaleev
 */
@Entity
@Table(name = "person")
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Staff {

    /**
     * Фамилия сотрудника
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Имя сотрудника
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Отчество сотрудника
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Должность сотрудника
     */
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    /**
     * День рождения сотрудника
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_day")
    private Date birthDay;

    /**
     * Телефон сотрудника
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Путь к фото сотрудника
     */
    @Column(name = "photo_url")
    private String photoURL;

    @JsonIgnore
    @OneToOne(mappedBy = "leader")
    private Organization organization;

    @JsonIgnore
    @OneToOne(mappedBy = "leader")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private transient List<Document> authorDocumentList;

    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    @ToString.Exclude
    private transient List<Incoming> senderDocumentList;

    @JsonIgnore
    @OneToMany(mappedBy = "addressee")
    @ToString.Exclude
    private transient List<Incoming> addresseeIncomingDocumentList;

    @JsonIgnore
    @OneToMany(mappedBy = "addressee")
    @ToString.Exclude
    private transient List<Outgoing> addresseeOutgoingDocumentList;

    @JsonIgnore
    @OneToMany(mappedBy = "executor")
    @ToString.Exclude
    private transient List<Task> executorDocumentList;

    @JsonIgnore
    @OneToMany(mappedBy = "controller")
    @ToString.Exclude
    private transient List<Task> controllerDocumentList;

    @PreRemove
    private void preRemove() {
        if (this.authorDocumentList != null) {
            System.out.println("authorDocumentList");
            this.authorDocumentList.forEach(document -> document.setAuthor(null));
        }
        if (this.senderDocumentList != null) {
            this.senderDocumentList.forEach(incoming -> incoming.setSender(null));
        }
        if (this.addresseeIncomingDocumentList != null) {
            this.addresseeIncomingDocumentList.forEach(incoming -> incoming.setAddressee(null));
        }
        if (this.addresseeOutgoingDocumentList != null) {
            this.addresseeOutgoingDocumentList.forEach(outgoing -> outgoing.setAddressee(null));
        }
        if (this.executorDocumentList != null) {
            this.executorDocumentList.forEach(task -> task.setExecutor(null));
        }
        if (this.controllerDocumentList != null) {
            this.controllerDocumentList.forEach(task -> task.setController(null));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(patronymic, person.patronymic) && Objects.equals(post, person.post) && Objects.equals(birthDay, person.birthDay) && Objects.equals(phone, person.phone) && Objects.equals(photoURL, person.photoURL) && Objects.equals(organization, person.organization) && Objects.equals(department, person.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lastName, firstName, patronymic, post, birthDay, phone, photoURL, organization, department);
    }
}
