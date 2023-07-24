
CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(36) NOT NULL,
    `email` varchar(128) NOT NULL,
    `nickname` varchar(255) NOT NULL NULL,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name` varchar(255) DEFAULT NULL,
    `mobile_number` varchar(16) NOT NULL,
    `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_user_id` (`user_id`),
    UNIQUE KEY `uk_user_email` (`email`)
);
