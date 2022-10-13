package com.trilochan.pasal.serviceimpl;

import com.trilochan.pasal.dto.ProductDto;
import com.trilochan.pasal.mapper.ProductMapper;
import com.trilochan.pasal.repository.ProductRepository;
import com.trilochan.pasal.service.ProductService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class ProductServiceimpl implements ProductService {

    @Inject
    ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var data = ProductMapper.toEntity(productDto);
        return ProductMapper.toDto(productRepository.save(data));
    }

    @Override
    public List<ProductDto> getAllProduct() {

        return ProductMapper.listOfProductDto(productRepository.findAll());
    }

@Override
    public ProductDto findById(UUID id){
    return productRepository.findById(id)
            .map(ProductMapper::toDto)
            .orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteById(UUID id) {
        return productRepository.deleteById(id);
                .map(ProductMapper::toDto)
                .orElseThrow(RuntimeException::new);

    }



    }

