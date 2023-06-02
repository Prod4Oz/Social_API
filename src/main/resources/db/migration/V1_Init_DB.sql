
create table post_images
(
    post_id int8 not null,
    images  varchar(255)

create table posts
(
    id         bigserial not null,
    created_at timestamp,
    text       varchar(255),
    title      varchar(255),
    updated_at timestamp,
    user_id    int8,
    primary key (id)
)

create table user_friends
(
    user_id   int8 not null,
    friend_id int8 not null
)

create table users
(
    id       bigserial not null,
    email    varchar(255),
    password varchar(255),
    username varchar(100),
    primary key (id)
)

alter table post_images
    add constraint FKo1i5va2d8de9mwq727vxh0s05 foreign key (post_id) references posts Hibernate:
alter table posts
    add constraint FK5lidm6cqbc7u4xhqpxm898qme foreign key (user_id) references users Hibernate:
alter table user_friends
    add constraint FK11y5boh1e7gh60rdqixyetv3x foreign key (friend_id) references users Hibernate:
alter table user_friends
    add constraint FKk08ugelrh9cea1oew3hgxryw2 foreign key (user_id) references users
