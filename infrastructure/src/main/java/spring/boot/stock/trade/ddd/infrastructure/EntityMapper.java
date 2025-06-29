package spring.boot.stock.trade.ddd.infrastructure;

public interface EntityMapper<T,S> {

    T convertToEntity(S domainModel);

    S convertFromEntity(T entity);
}
