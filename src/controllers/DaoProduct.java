/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import models.Category;
import models.Product;

/**
 *
 * @author carlo
 */
public class DaoProduct {

    Conexion conexion = new Conexion();
    Connection conne;
    private ArrayList<Product> listProducts;
    private PreparedStatement selectAllProduct;
    private PreparedStatement selectProductById;
    private PreparedStatement selectProductByName;
    private PreparedStatement selectProductByPrice;
    private PreparedStatement selectProductByDDate;
    private PreparedStatement selectProductByCategory;
    private PreparedStatement selectLastProduct;
    private PreparedStatement insterProduct;
    private PreparedStatement updateProduct;
    private PreparedStatement deleteProduct;

    public DaoProduct() {
        try {
            conne = conexion.obtenerConexion();
            selectAllProduct = conne.prepareStatement("select * From Products");
            selectProductById = conne.prepareStatement("select * From Products where IDproducto = ?");
            selectProductByName = conne.prepareStatement("select * from Products where NameProduct like ?");
            selectProductByPrice = conne.prepareStatement("select * from Products where PriceProduct = ?");
            selectProductByDDate = conne.prepareStatement("select * from Products where DDate= ?");
            selectProductByCategory = conne.prepareStatement("select * from Products where CategoryProduct like ?");
            selectLastProduct = conne.prepareStatement("select top 1 * From Products order by IDproducto desc");
            insterProduct = conne.prepareStatement("insert into Products (NameProduct) values(?)");
            updateProduct = conne.prepareStatement("update Products set NameProduct = ? where IDproducto = ?");
            deleteProduct = conne.prepareStatement("delete from Products where IDproducto = ?");

        } catch (SQLException e) {
            System.out.println("Error al instanciar el producto: " + e.getMessage());
        }
    }

    public void getAllProducts() {
        ResultSet rs = null;
        listProducts = new ArrayList<>();
        try {
            rs = selectAllProduct.executeQuery();

            while (rs.next()) {
                listProducts.add(new Product();
            }

        } catch (SQLException e) {
        }
    }
}
