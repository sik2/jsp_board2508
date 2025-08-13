DROP DATABASE IF EXISTS board_proj;
CREATE DATABASE board_proj;

USE board_proj;

CREATE TABLE article (
         id bigint UNSIGNED NOT NULL AUTO_INCREMENT,
         title varchar(100) NOT NULL,
         content text NOT NULL,
         regDate datetime NOT NULL,
         PRIMARY KEY (id)
);

CREATE TABLE `member` (
          id bigint UNSIGNED NOT NULL AUTO_INCREMENT,
          username varchar(50) NOT NULL,
          password varchar(100) NOT NULL,
          name varchar(50) NOT NULL,
          regDate datetime NOT NULL,
          PRIMARY KEY (id)
);

INSERT INTO article
SET title = "제목1",
content = "내용1",
regDate = now();


INSERT INTO article
SET title = "제목2",
content = "내용2",
regDate = now();