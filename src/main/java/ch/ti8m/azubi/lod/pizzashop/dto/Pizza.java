package ch.ti8m.azubi.lod.pizzashop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * A Pizza
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pizza {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double price;

    public Pizza() {
    }

    public Pizza(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Pizza(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "#" + id + ": " + name + ", price: " + price;
    }
}


