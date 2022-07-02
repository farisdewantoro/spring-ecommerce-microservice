package com.faris.spring.ecommerce.order.config;

import com.faris.spring.ecommerce.core.config.BaseAuditConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig extends BaseAuditConfig {
}
