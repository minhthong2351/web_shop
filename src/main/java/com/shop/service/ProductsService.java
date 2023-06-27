package com.shop.service;

import com.shop.beans.Products;
import com.shop.dao.ProductsDao;

import java.util.List;

public class ProductsService {
    private static ProductsService instance;

    private ProductsService(){}

    public static ProductsService getInstance(){
        if(instance==null){
            instance= new ProductsService();
        }
        return instance;
    }
    public List<Products> getAll(){
        return ProductsDao.getInstance().getAll();
    }


    public Products getById(String id) {
        return ProductsDao.getInstance().getById(id);
    }
}
