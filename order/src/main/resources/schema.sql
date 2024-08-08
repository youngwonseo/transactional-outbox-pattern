CREATE TABLE `orders` (
    `id`            BIGINT NOT NULL AUTO_INCREMENT,
    `product_id`    BIGINT NOT NULL,
    `amount`        INT NOT NULL,
    `user_id`    BIGINT NOT NULL,
    `created_at`    DATETIME NOT NULL,
    `updated_at`    DATETIME NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `outbox` (
     `id`               BIGINT NOT NULL AUTO_INCREMENT,
     `type`             VARCHAR(255) NOT NULL,
     `message`          JSON NOT NULL,
     `created_at`       DATETIME NOT NULL,
     `last_published_at`DATETIME NULL,
     PRIMARY KEY(`id`)
);
