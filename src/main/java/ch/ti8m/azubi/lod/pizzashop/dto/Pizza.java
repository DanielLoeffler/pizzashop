package ch.ti8m.azubi.lod.pizzashop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pizza {

    private Integer id;
    private String name;
    private Double price;

    @JsonCreator
    public Pizza() {
    }

    @JsonCreator
    public Pizza(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @JsonCreator
    public Pizza(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
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


