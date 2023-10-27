package org.example.controllers;

import org.example.dtos.BrandDto;
import org.example.models.Brand;
import org.example.models.Offer;
import org.example.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    Iterable<BrandDto> all() {
        return brandService.getAllBrand();
    }

    @PostMapping("/brand")
    BrandDto newBrand(@RequestBody BrandDto newBrand) {
        return brandService.registerBrand(newBrand);
    }

    @DeleteMapping("/brand/{brandID}")
    void deleteBrand(@PathVariable("brandID") BrandDto brandID) {
        brandService.registerBrand(brandID);
    }

    @PutMapping("/brand/{brandID}")
    public BrandDto updateBrand(@PathVariable("brandID") UUID brandID, @RequestBody BrandDto updateBrand) {
        return brandService.updateBrand(brandID, updateBrand);
    }

//    @GetMapping("/brand_find_by_year")
//    public List<Brand> findBrandsByYear(@RequestParam("year") int year) {
//        return brandService.findBrandsByYear(year);
//    }
}
