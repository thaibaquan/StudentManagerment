ALTER TABLE `organization`
    MODIFY COLUMN `org_type` ENUM('SCHOOL', 'CLASS') NULL DEFAULT NULL;
