package com.example.orgs.dao

import com.example.orgs.model.Product

class ProductDAO {

    fun addProduct(product: Product) {
        products.add(product)
    }


    fun getProducts(): List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }

}