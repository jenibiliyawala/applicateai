package com.spring.assignments.applicateai.models.dto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatalogDto {
    @NotBlank
    String skuCode;
    String skuName;
    String skuDescription;
    String brand;
    String brandDescription;
    @NotBlank
    String supplierName;
}