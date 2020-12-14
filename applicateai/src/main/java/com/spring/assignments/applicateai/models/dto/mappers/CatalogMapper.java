package com.spring.assignments.applicateai.models.dto.mappers;

import com.spring.assignments.applicateai.models.dto.CatalogDto;
import com.spring.assignments.applicateai.models.entity.Catalog;
import org.modelmapper.ModelMapper;

public class CatalogMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static CatalogDto toCatalogDto(Catalog catalog) {

        return modelMapper.map(catalog, CatalogDto.class);
    }

    public static Catalog toCatalog(CatalogDto dto) {
        return modelMapper.map(dto, Catalog.class);
    }
}
