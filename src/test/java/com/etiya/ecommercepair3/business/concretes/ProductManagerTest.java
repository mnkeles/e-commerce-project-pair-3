package com.etiya.ecommercepair3.business.concretes;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import com.etiya.ecommercepair3.business.abstracts.ProductService;
import com.etiya.ecommercepair3.business.constants.Messages;
import com.etiya.ecommercepair3.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.product.UpdateProductRequest;
import com.etiya.ecommercepair3.core.internationalization.MessageService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.entities.concretes.*;
import com.etiya.ecommercepair3.repositories.abstracts.ProductDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductDao productDao;
    MessageService messageService;
    ModelMapperService modelMapperService;
    ProductManager productManager;

    @BeforeEach
    void setUp() {
        productDao = mock(ProductDao.class);
        messageService = mock(MessageService.class);
        modelMapperService = mock(ModelMapperService.class);
        productManager = new ProductManager(productDao,modelMapperService,messageService);
    }

    @Test
    void testUpdateProduct() {
        // prepare test data
        UpdateProductRequest request = new UpdateProductRequest();
        request.setId(1);
        request.setProductName("New Product");
        request.setUnitPrice(1.0);
        request.setUnitsInStock(10);
        request.setProductAttributeId(1);

        Product product = new Product();
        product.setId(1);
        product.setProductName("Old Product");
        product.setUnitPrice(1.0);
        product.setUnitsInStock(10);
        ProductAttribute productAttribute = new ProductAttribute(1,GenderType.Female,SizeType.Medium,ColorType.Black);
        product.setProductAttribute(productAttribute);

        UpdateProductResponse response = new UpdateProductResponse();
        response.setId(1);
        response.setProductName("New Product");
        response.setUnitPrice(1.0);
        response.setUnitsInStock(1);
        response.setProductAttributeId(1);

        // configure mock objects
        when(modelMapperService.forResponse().map(request, Product.class)).thenReturn(product);
        when(productDao.save(product)).thenReturn(product);
        when(modelMapperService.forRequest().map(product, UpdateProductResponse.class)).thenReturn(response);
        when(messageService.getMessage(Messages.Product.ProductUpdated)).thenReturn("Product updated successfully");

        // call method under test
        DataResult<UpdateProductResponse> result = productManager.updateProduct(request);

        // assert result
        assertNotNull(result.getData());
        assertEquals(response.getId(), result.getData().getId());
        assertEquals(response.getProductName(), result.getData().getProductName());
        assertEquals(response.getUnitPrice(), result.getData().getUnitPrice());

        assertEquals("Product updated successfully", result.getMessage());
    }
}

