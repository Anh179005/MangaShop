/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Manga {
    private int id;
    private String name, image;
    private double price;
    private String description;
    private String author_name;
    private String category_name;

    public Manga() {
    }

    public Manga(int id, String name, String image, double price, String description, String author_name, String category_name) {
        this.id=id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.author_name = author_name;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Manga{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", description=" + description + ", author_name=" + author_name + ", category_name=" + category_name + '}';
    }


    
    
}
