package org.example.service.impl;

import org.example.dtos.BrandDto;
import org.example.exception.NotFoundException;
import org.example.models.Brand;
import org.example.repo.BrandRepository;
import org.example.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;

    private String brand = "brand";

    @Override
    public List<BrandDto> getAllBrand() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }
    @Override
    public BrandDto registerBrand(BrandDto brandDTO) {
        Brand b = modelMapper.map(brandDTO, Brand.class);
        return modelMapper.map(brandRepository.save(b), BrandDto.class);
    }

    @Override
    public void deleteBrand(UUID brandID) {
        Brand brand = brandRepository.findById(brandID)
                .orElseThrow(() -> new NotFoundException("Could not find user by id: " + brandID));

        brandRepository.delete(brand);
    }


    @Override
    public BrandDto updateBrand(UUID brandID, BrandDto updateBrand) {
        Brand existingBrand = brandRepository.findById(brandID).orElseThrow(() -> new NotFoundException("Could not find" + brand + " by id: " + brandID));

        existingBrand.setId(updateBrand.getId());
        existingBrand.setName(updateBrand.getName());
        existingBrand.setCreated(updateBrand.getCreated());
        existingBrand.setModified(updateBrand.getModified());

        Brand savedBrand = brandRepository.save(existingBrand);
        return modelMapper.map(savedBrand, BrandDto.class);
    }

//    @Override
//    public List<Brand> findBrandsByYear(int year) {
//        return brandRepository.findBrandsByYear(year);
//    }
}
