package org.example.controllers;

import org.example.dtos.BrandDto;
import org.example.dtos.ModelDto;
import org.example.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/models")
    Iterable<ModelDto> all() {
        return modelService.getAllModels();
    }

    @PostMapping("/model")
    ModelDto newModel(@RequestBody ModelDto newModel) {
        return modelService.registerModel(newModel);
    }

    @DeleteMapping("/model/{modelID}")
    void deleteModel(@PathVariable("modelID") ModelDto modelID) {
        modelService.registerModel(modelID);
    }

    @PutMapping("/model/{modelID}")
    public ModelDto updateModel(@PathVariable("modelID") UUID modelID, @RequestBody ModelDto updateModel) {
        return modelService.updateModel(modelID, updateModel);
    }
}
