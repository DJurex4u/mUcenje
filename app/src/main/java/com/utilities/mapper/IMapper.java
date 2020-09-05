package com.utilities.mapper;

public interface IMapper <From,To> {
    public To map(From objectToMap);
}
