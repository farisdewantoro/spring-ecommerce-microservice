CREATE TABLE IF NOT EXISTS products (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(128),
  price double,
  quantity int,
  description text,
  category_id bigint,
  updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by bigint,
  created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by bigint,
  deleted_at datetime,
  deleted_by bigint,
  primary key (id),
  constraint fk_products_categories foreign key (category_id) references categories (id)
) engine = InnoDB;