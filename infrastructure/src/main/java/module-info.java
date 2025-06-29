module spring.boot.stock.trade.ddd.infrastructure {
    requires spring.boot.stock.trade.ddd.domain;
    requires spring.context;
    requires spring.data.jpa;
    requires java.sql;
    requires static lombok;
    requires spring.data.commons;
    requires jakarta.persistence;
    requires spring.web;
    requires org.hibernate.orm.core;
    requires spring.boot;
    requires com.h2database;

    opens spring.boot.stock.trade.ddd.infrastructure;
    opens spring.boot.stock.trade.ddd.infrastructure.entities;
    opens spring.boot.stock.trade.ddd.infrastructure.configuration;
}