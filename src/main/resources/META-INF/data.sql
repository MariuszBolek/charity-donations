CREATE SCHEMA `charity-donation` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

INSERT INTO `charity-donation`.`institution` (`description`, `name`) VALUES ('Pomoc dzieciom z ubogich rodzin', 'Fundacja \'Szary Miś\'');
INSERT INTO `charity-donation`.`institution` (`description`, `name`) VALUES ('Pomoc osobom bezdomnym', 'Fundacja \'Bez Domu\'');
INSERT INTO `charity-donation`.`institution` (`description`, `name`) VALUES ('Poszukiwanie osób zaginionych', 'Fundacja \'A Kogo\'');
INSERT INTO `charity-donation`.`institution` (`description`, `name`) VALUES ('Propagowanie zdrowego trybu życia', 'Fundacja \'Zdrowo!\'');


INSERT INTO `charity-donation`.`category` (`name`) VALUES ('Ubrania nadające się do ponownego użycia');
INSERT INTO `charity-donation`.`category` (`name`) VALUES ('Zużyte ubrania');
INSERT INTO `charity-donation`.`category` (`name`) VALUES ('Książki');
INSERT INTO `charity-donation`.`category` (`name`) VALUES ('Zabawki i przyrządy sportowe');
INSERT INTO `charity-donation`.`category` (`name`) VALUES ('Inne');

INSERT INTO role(role_id, role)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');
