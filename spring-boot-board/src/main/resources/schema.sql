drop database codingon;

create database codingon default character set utf8 default collate utf8_general_ci;
use codingon;
-- users 테이블 생성
create table users (
id bigint auto_increment primary key,
username varchar(50) not null,
email varchar(100) not null,
created_at timestamp default current_timestamp
);

-- board 테이블 생성
CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20) NOT NULL,
    content VARCHAR(100) NOT NULL,
    writer VARCHAR(10) NOT NULL,
    registered TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);

-- 더미 데이터 삽입
insert into users (username, email) values
('john_doe', 'john.doe@example.com'),
('jane_smith', 'jane.smith@example.com'),
('bob_johnson', 'bob.johnson@example.com');

select * from users;
desc board;