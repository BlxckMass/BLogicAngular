create table if not exists blogic.post
(
    id   bigint not null
            constraint post_pkey
                primary key,
    name varchar(255)
    );

alter table blogic.post owner to postgres;

create table if not exists blogic.staff
(
    id bigint not null
            constraint staff_pkey
                primary key
);

alter table blogic.staff owner to postgres;

create table if not exists blogic.person
(
    id         bigint not null
                    constraint person_pkey
                        primary key
                    constraint fk4bxhy4mmilwwvwb6ftms61i1w
                        references blogic.staff,
    birth_day  date,
    first_name varchar(255),
    last_name  varchar(255),
    patronymic varchar(255),
    phone      varchar(255),
    photo_url  varchar(255),
    post_id    bigint
                    constraint fk5klpdar1iktdrkkutan052hlr
                        references blogic.post
                            on delete set null
    );

alter table blogic.person owner to postgres;

create table if not exists blogic.department
(
    id            bigint not null
                    constraint department_pkey
                        primary key
                    constraint fkrg1ymkyik97d84ppvby6uigf
                        references blogic.staff,
    name          varchar(255),
    phone_numbers varchar(255),
    short_name    varchar(255),
    leader_id     bigint
                        constraint fkryw2m3yngf2937pj80tilo34q
                            references blogic.person
    );

alter table blogic.department owner to postgres;

create table if not exists blogic.document
(
    id                   bigint not null
                            constraint document_pkey
                                primary key,
    date_of_registration date,
    name                 varchar(255),
    registration_number  bigint,
    text                 varchar(255),
    author_id            bigint
                            constraint fkqq5dsxg410lxc476kj8fgtno5
                                references blogic.person
                                    on delete set null
    );

alter table blogic.document owner to postgres;

create table if not exists blogic.incoming
(
    id                            bigint not null
                                    constraint incoming_pkey
                                        primary key
                                    constraint fktdm66sd5jp9dk0kc9s82sn68b
                                        references blogic.document,
    outgoing_date_of_registration date,
    outgoing_number               bigint,
    addressee_id                  bigint
                                    constraint fk4r04xaq95mqbbcn9odjd9qsus
                                        references blogic.person
                                            on delete set null,
    sender_id                     bigint
                                    constraint fkqlettf2008tx6yh4cl7ar47x2
                                        references blogic.person
                                            on delete set null
);

alter table blogic.incoming owner to postgres;

create table if not exists blogic.organization
(
    id            bigint not null
                    constraint organization_pkey
                        primary key
                    constraint fkdar1slnjy340d4mq6uk7mfm6r
                        references blogic.staff,
    name          varchar(255),
    phone_numbers varchar(255),
    short_name    varchar(255),
    leader_id     bigint
                    constraint fkqlyg8damucorlbgbvm68dbb03
                        references blogic.person
                            on delete set null
    );

alter table blogic.organization owner to postgres;

create table if not exists blogic.outgoing
(
    id              bigint not null
                        constraint outgoing_pkey
                            primary key
                        constraint fkjpt6sj7ddx4i5wjm54qadq5t9
                            references blogic.document,
    delivery_method varchar(255),
    addressee_id    bigint
                        constraint fkeqyv85utw70tjefjcue74aa3u
                            references blogic.person
                                on delete set null
    );

alter table blogic.outgoing owner to postgres;

create table if not exists blogic.task
(
    id                  bigint not null
                            constraint task_pkey
                                primary key
                            constraint fklbcn9cpdsycplk2bgn392dxd2
                                references blogic.document,
    control_sign        boolean,
    date_of_issue       timestamp,
    period_of_execution varchar(255),
    controller_id       bigint
                        constraint fkrkvby74jfeup9gy9duaoi6xl2
                            references blogic.person
                                on delete set null,
    executor_id         bigint
                        constraint fkpdr97an4wkj5mieo2375rkee7
                            references blogic.person
                                on delete set null
    );

alter table blogic.task owner to postgres;

create sequence if not exists blogic.document_sequence;
alter sequence blogic.document_sequence owner to postgres;

create sequence if not exists blogic.post_sequence;
alter sequence blogic.post_sequence owner to postgres;

create sequence if not exists blogic.staff_sequence;
alter sequence blogic.staff_sequence owner to postgres;


