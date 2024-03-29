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
                listProducts.add(new Product(rs.getInt("IDProduct"),
                        rs.getString("NameProduct")));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las categorias");
        }
    }

    public void getProductByID(int id) {
        ResultSet rs = null;

        listProducts = new ArrayList<>();
        try {
            selectProductById.setInt(1, id);
            rs = selectProductById.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("IDProduct"),
                        rs.getString("NameProduct")));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el registro por el id: " + id + "El error fue: " + e.getMessage());
        }
    }

    public DefaultTableModel getProductByName(String name) {
        DefaultTableModel tbl = new DefaultTableModel();
        ResultSet rs = null;
        String titulos[] = {"CODIGO", "Categoria"};
        tbl.setColumnIdentifiers(titulos);
        try {
            selectProductByName.setString(1, name);
            rs = selectProductByName.executeQuery();
            while (rs.next()) {
                Object datos[] = new Object[2];
                datos[0] = rs.getInt("IDProduct");
                datos[1] = rs.getString("NameProduct");
                tbl.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el registro por nombre: " + name + "El error fue: " + e.getMessage());
        }
        return tbl;
    }

    public int getLastProduct() {
        int id = 0;
        ResultSet rs = null;
        try {
            rs = selectLastProduct.executeQuery();
            if (rs.next()) {
                id = rs.getInt("IDProduct");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ultimo id: " + e.getMessage());
        }
        return id + 1;

    }

    public int addProduct(String nameProduct) {
        int result = 0;
        try {
            insterProduct.setString(1, nameProduct);
            result = insterProduct.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
        return result;
    }

    public int updateProduct(String nameProduct, int idProduct) {
        int result = 0;
        try {
            updateProduct.setString(1, nameProduct);
            updateProduct.setInt(2, idProduct);
            result = updateProduct.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        }
        return result;
    }

    public int deleteProduct(int idProduct) {
        int result = 0;
        try {
            deleteProduct.setInt(1, idProduct);
            result = deleteProduct.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
        return result;
    }

    public ArrayList<Product> getListProduct() {
        return listProducts;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProducts = listProduct;
    }

}
