package com.kousenit.testcontainers.entities.classicmodels;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "productlines", schema = "classicmodels")
public class Productline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productLine")
    private String productLine;

    @Column(name = "textDescription")
    private String textDescription;

    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Column(name = "image")
    private byte[] image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productline that = (Productline) o;
        return Objects.equals(productLine, that.productLine) && Objects.equals(textDescription, that.textDescription) && Objects.equals(htmlDescription, that.htmlDescription) && Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productLine, textDescription, htmlDescription);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Productline{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
