package org.example.service;

import org.example.dtos.ModelDto;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    List<ModelDto> getAllModels();

    ModelDto registerModel(ModelDto modelDto);

    void deleteModel(UUID modelID);

    ModelDto updateModel(UUID modelID, ModelDto updateModel);
}
