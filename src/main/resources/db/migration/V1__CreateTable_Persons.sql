CREATE TABLE `persons` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` longtext NOT NULL,
  `address` longtext NOT NULL,
  `gender` varchar(10) NOT NULL
);