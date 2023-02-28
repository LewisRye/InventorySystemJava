package com.lewis.inventory;

import java.math.*;
import java.util.*;
import java.sql.*;

public class Product {
    private int productId;
    private String name;
    private String description;
    private int categoryId;
    private int quantity;
    private BigDecimal price;

    public Product(int productId, String name, String description, int categoryId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
    }

    protected int getProductId() {
        return productId;
    }

    protected String getName() {
        return name;
    }

    protected String getDescription() {
        return description;
    }

    protected int getCategoryId() {
        return categoryId;
    }

    protected int getQuantity() {
        return quantity;
    }

    protected BigDecimal getPrice() {
        return price;
    }

    protected ArrayList<Product> allProducts() {
        ArrayList<Product> listOfProducts = new ArrayList<Product>(0);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT", "root", "");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Products;");

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int category_id = rs.getInt("category_id");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");

                Product currentProduct = new Product(product_id, name, description, category_id, quantity, price);
                listOfProducts.add(currentProduct);
            }
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return listOfProducts;
    }
}
