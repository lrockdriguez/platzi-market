package com.example.demo.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.domain.dto.Category;
import com.example.demo.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	@Mappings({
		@Mapping(source = "idCategoria", target = "categoryId"), //revisar / pendiente el target idCategoria
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active"),
		
	})
	Category toCategory(Categoria categoria);
	
	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true)
	Categoria toCategoria(Category category);

}
