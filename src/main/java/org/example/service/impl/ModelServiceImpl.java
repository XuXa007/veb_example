package org.example.service.impl;

import org.example.dtos.ModelDto;
import org.example.exception.NotFoundException;
import org.example.models.Brand;
import org.example.models.Model;
import org.example.repo.ModelRepository;
import org.example.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelMapper modelMapper;

    private String model = "model";

    @Override
    public List<ModelDto> getAllModels() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }
    @Override
    public ModelDto registerModel(ModelDto modelDto) {
        Model b = modelMapper.map(modelDto, Model.class);
        return modelMapper.map(modelRepository.save(b), ModelDto.class);
    }

    @Override
    public void deleteModel(UUID modelID) {
        Model model = modelRepository.findById(modelID)
                .orElseThrow(() -> new NotFoundException("Could not find user by id: " + modelID));
        modelRepository.delete(model);
    }

    @Override
    public ModelDto updateModel(UUID modelID, ModelDto updateModel) {
        Model existingModel = modelRepository.findById(modelID).orElseThrow(() -> new NotFoundException("Could not find" + model + " by id: " + modelID));

        Brand existingBrand = modelMapper.map(updateModel.getBrand(), Brand.class);

        existingModel.setBrand(existingBrand);

        existingModel.setId(updateModel.getId());
        existingModel.setName(updateModel.getName());
        existingModel.setImageUrl(updateModel.getImageURL());
        existingModel.setStartYear(updateModel.getStartYear());
        existingModel.setEndYear(updateModel.getEndYear());
        existingModel.setCreated(updateModel.getCreated());
        existingModel.setModified(updateModel.getModified());

        Model savedModel = modelRepository.save(existingModel);
        return modelMapper.map(savedModel, ModelDto.class);
    }

}
