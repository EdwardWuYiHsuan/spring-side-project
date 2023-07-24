-- +goose Up
-- +goose StatementBegin
CREATE TABLE user (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(36) NOT NULL COMMENT 'user random ID',
    `email` varchar(128) NOT NULL COMMENT 'email',
    `nickname` varchar(255) NOT NULL NULL COMMENT 'nickname',
    `first_name` varchar(255) DEFAULT NULL COMMENT 'first name',
    `last_name` varchar(255) DEFAULT NULL COMMENT 'last name',
    `mobile_number` varchar(16) NOT NULL COMMENT 'mobile number',
    `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_user_id` (`user_id`),
    UNIQUE KEY `uk_user_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
drop table user;
-- +goose StatementEnd
