CREATE TABLE IF NOT EXISTS categories (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(128),
  description text,
  updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by bigint,
  created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by bigint,
  deleted_at datetime,
  deleted_by bigint,
  primary key (id)
) engine = InnoDB;