package spring.boot.stock.trade.ddd.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ModelMapper<Q,R,S> {

    R convertToModel(S model) throws JsonProcessingException;

    S convertFromModel(Q entity);
}
