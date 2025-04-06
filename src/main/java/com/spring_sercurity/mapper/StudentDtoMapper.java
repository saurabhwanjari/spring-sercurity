package com.spring_sercurity.mapper;

import com.spring_sercurity.dto.StudentDTO;
import com.spring_sercurity.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentDtoMapper {

    @Mapping(source = "createdBy.id", target = "createdByUserId")
    @Mapping(source = "updatedBy.id", target = "updatedByUserId")
    StudentDTO toDto(Student student);

    // If you want reverse mapping (optional, usually DTO to Entity on POST/PUT)
    @Mapping(source = "createdByUserId", target = "createdBy.id")
    @Mapping(source = "updatedByUserId", target = "updatedBy.id")
    Student toEntity(StudentDTO dto);
}
