/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author jadg13
 * Clase Product correspondiente a la tabla Products
 */
public class Product {
    private String idProduct;
    private String nombreProduct;
    private double priceProduct;
    private LocalDate dueDate;
    private Category categoryProduct;

    public Product() {
    }

    public Product(int aInt, String idProduct) {
        this.idProduct = idProduct;
        this.nombreProduct = nombreProduct;
        this.priceProduct = priceProduct;
        this.dueDate = dueDate;
        this.categoryProduct = categoryProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNombreProduct() {
        return nombreProduct;
    }

    public void setNombreProduct(String nombreProduct) {
        this.nombreProduct = nombreProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Category getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(Category categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", nombreProduct=" + nombreProduct + ", priceProduct=" + priceProduct + ", dueDate=" + dueDate + ", categoryProduct=" + categoryProduct + '}';
    }
    
    
}
