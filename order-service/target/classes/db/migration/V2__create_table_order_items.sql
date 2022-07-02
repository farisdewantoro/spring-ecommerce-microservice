CREATE TABLE IF NOT EXISTS order_items (
  id bigint NOT NULL AUTO_INCREMENT,
  product_id bigint NOT NULL,
  product_name varchar(128) NOT NULL,
  quantity int NOT NULL,
  unit_price decimal NOT NULL,
  total_price decimal NOT NULL,
  order_id bigint NOT NULL,
  updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by bigint,
  created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by bigint,
  deleted_at datetime,
  deleted_by bigint,
  primary key (id),
  constraint fk_order_items_orders foreign key (order_id) references orders (id)
) engine = InnoDB;