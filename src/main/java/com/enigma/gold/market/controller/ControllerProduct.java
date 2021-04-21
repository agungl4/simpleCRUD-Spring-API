package com.enigma.gold.market.controller;

import com.enigma.gold.market.entity.EntityProduct;
import com.enigma.gold.market.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/product")
public class ControllerProduct {

    @Autowired
    RepositoryProduct product;

    @GetMapping(value = "")
    public String Welcome() {
        return "API connected. Welcome";
    }

    @PostMapping(value = "add-product", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public EntityProduct addNewProduct(EntityProduct data) {
        data.setCreated_at(new Date());
        data.setUpdated_at(new Date());
        product.save(data);
        return data;
    }

    @GetMapping(value = "get-all")
    public List<EntityProduct> getAllProduct() {
        return product.findAll();
    }

    @GetMapping(value = "get-product/{id}")
    public EntityProduct getProductById(@PathVariable("id") String id){
        return product.findById(id).orElse(null);
    }

    @PatchMapping(value = "update-product/{id}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public EntityProduct updateProduct(@PathVariable("id") String id, EntityProduct data){
        EntityProduct temp = product.findById(id).get();
        data.setProduct_id(id);
        if(data.getProduct_image()==null){
            data.setProduct_image(temp.getProduct_image());
        }
        if(data.getProduct_name()==null){
            data.setProduct_name(temp.getProduct_name());
        }
        if(data.getProduct_price_buy()==null){
            data.setProduct_price_buy(temp.getProduct_price_buy());
        }
        if(data.getProduct_price_sell()==null){
            data.setProduct_price_sell(temp.getProduct_price_sell());
        }
        if(data.getCreated_at()==null){
            data.setCreated_at(temp.getCreated_at());
        }
        if(data.getProduct_status()==null){
            data.setProduct_status(temp.getProduct_status());
        }
        data.setUpdated_at(new Date());
        product.save(data);
        return data;
    }

    @DeleteMapping(value = "delete-product/{id}")
    public String deleteProduct(@PathVariable("id") String id){
        product.deleteById(id);
        return "Data berhasil dihapus pada id " + id;
    }
}
