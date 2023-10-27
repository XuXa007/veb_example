package org.example.service;

import org.example.dtos.BrandDto;
import org.example.models.Brand;
import org.example.models.Offer;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<BrandDto> getAllBrand();

    BrandDto registerBrand(BrandDto brandDto);

    void deleteBrand(UUID brandID);

    BrandDto updateBrand(UUID brandID, BrandDto updateBrand);

//    List<Brand> findBrandsByYear(int year);
}
