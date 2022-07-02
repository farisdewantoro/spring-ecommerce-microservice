CREATE TABLE IF NOT EXISTS orders (
  id bigint NOT NULL AUTO_INCREMENT,
  customer_id bigint,
  total_amount decimal NOT NULL,
  order_date datetime NOT NULL,
  status int NOT NULL,
  updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by bigint,
  created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by bigint,
  deleted_at datetime,
  deleted_by bigint,
  primary key (id)
) engine = InnoDB;