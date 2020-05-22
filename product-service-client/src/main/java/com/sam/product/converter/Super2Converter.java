package com.sam.product.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <D>
 * @param <E>
 * @author locld
 */
public abstract class Super2Converter<Request, Response, E> {
    public List<Response> convertEntitiesToResponseDTOs(final List<E> entities) {
        if (entities.isEmpty()) {
            return new ArrayList<>();
        }
        return entities.stream().map(entity -> convertToResponseDTO(entity)).collect(Collectors.toList());
    }

    public List<Request> convertEntitiestoDTOs(final List<E> entities) {
        if (entities.isEmpty()) {
            return new ArrayList<>();
        }
        return entities.stream().map(entity -> convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    public List<Request> convertEntitiestoDTOsByUserId(final String contactId, final List<E> entities) {
        if (entities.isEmpty()) {
            return new ArrayList<>();
        }
        return entities.stream().map(entity -> convertEntityToDTOByUserId(contactId, entity)).collect(Collectors.toList());
    }


    public abstract Request convertEntityToDTO(final E entity);

    public List<E> convertRequestDTOsToEntities(final List<Request> dtos) {
        if (dtos.isEmpty()) {
            return new ArrayList<>();
        }
        return dtos.stream().map(dto -> convertRequestToEntity(dto)).collect(Collectors.toList());
    }

    public abstract Response convertToResponseDTO(final E entity);

    public abstract E convertRequestToEntity(final Request dto);

    public abstract Request convertEntityToDTOByUserId(final String contactId, final E entity);

}