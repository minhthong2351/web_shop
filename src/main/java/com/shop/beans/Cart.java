package com.shop.beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
   private Map<String,Products> productsMap;
   private  static Cart instance;
   private Cart(){
       productsMap = new HashMap<>();
   }

    public Map<String, Products> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(Map<String, Products> productsMap) {
        this.productsMap = productsMap;
    }

    public static Cart getInstance(){
       if(instance== null){
           instance = new Cart();
       }
       return instance;
   }

   public Products get(String id){
       return productsMap.get(id);
   }
   public void put(Products product){
       productsMap.put(product.getId(),product);
   }
   public Products remove(String id){
       return productsMap.remove(id);
   }


   private void upQuantity(String id){
       Products products=productsMap.get(id);
       products.setQuantitySold(products.getQuantitySold()+1);

   }
   public double getTotal(){
       double totalPrice=0;
       for(Products p: productsMap.values()){
           totalPrice += p.getTotal();
       }
       return totalPrice;
   }
   public int getTotalQuantity(){
       int totalQuantity =0;
       for(Products p: productsMap.values()){
           totalQuantity+=p.getQuantitySold();
       }
       return totalQuantity;
   }
   public Collection<Products> getProducts(){
       return productsMap.values();
   }
}
