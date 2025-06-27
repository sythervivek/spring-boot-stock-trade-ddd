module spring.boot.stock.trade.ddd.application {
    requires java.sql;
    requires spring.boot.starter.web;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.boot;
    requires spring.boot.stock.trade.ddd.domain;
    requires spring.context;
    requires com.fasterxml.jackson.annotation;
    requires spring.boot.stock.trade.ddd.infrastructure;
    requires spring.data.jpa;
    requires static lombok;
    requires com.fasterxml.jackson.databind;

    exports spring.boot.stock.trade.ddd.application.rest;
    exports spring.boot.stock.trade.ddd.application.services;
    exports spring.boot.stock.trade.ddd.application;
}