package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.services.dtos.input.ModelDTO;
import org.example.models.entities.Brand;
import org.example.models.entities.Model;
import org.example.repositories.BrandRepository;
import org.example.repositories.ModelRepository;
import org.example.services.ModelService;
import org.example.services.dtos.output.ModelOutputDTO;
import org.example.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class ModelServiceImpl implements ModelService {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final Object validationUtil;

    @Autowired
    public ModelServiceImpl(ValidationUtil validationUtil, BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "models", allEntries = true)
    public ModelDTO createCarModel(ModelDTO modelDTO) {

        Brand brand = brandRepository.findById(modelDTO.getBrand_id())
                .orElseThrow(() -> new EntityNotFoundException("CarBrand not found: " + modelDTO.getBrand_id()));

        Model model = modelMapper.map(modelDTO, Model.class);
        model.setBrand(brand);

//        if (!this.validationUtil.isValid(carBrandDTO)) {
//            this.validationUtil
//                    .violations(carBrandDTO)
//                    .stream()
//                    .map(ConstraintViolation::getMessage)
//                    .forEach(System.out::println);
//
//        } else {
//            try {
//                carBrandDTO.setId(this.carBrandRepository
//                        .saveAndFlush(this.modelMapper.map(carBrandDTO, CarBrand.class)).getId());
//            } catch (Exception e) {
//                System.out.println("Some thing went wrong!");
//            }
//        }

        Model savedModel = modelRepository.save(model);
        return modelMapper.map(savedModel, ModelDTO.class);
    }

    @Override
    @Cacheable("models")
    public ModelDTO getCarModelById(String id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car model not found: " + id));
        return modelMapper.map(model, ModelDTO.class);
    }

    @Override
    @Cacheable("models")
    public List<ModelDTO> getAllCarModels() {
        List<Model> models = modelRepository.findAll();
        return models.stream()
                .map(carModel -> modelMapper.map(carModel, ModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"models", "offers"}, allEntries = true)
    public void deleteCarModel(String id) {
        modelRepository.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"models", "offers"}, allEntries = true)
    public void deleteCarModelByBrandId(String id) {
        modelRepository.deleteByBrand_Id(id);
    }

    @Override
    @Cacheable("models")
    public List<ModelOutputDTO> findAll() {
        return modelRepository.findAll().stream().map(e -> modelMapper.map(e, ModelOutputDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("models")
    public ModelOutputDTO getModelOutputDTOById(String id) {
        return modelMapper.map(modelRepository.findById(id), ModelOutputDTO.class);
    }

}

