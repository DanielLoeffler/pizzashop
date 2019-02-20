package ch.ti8m.azubi.lod.pizzashop.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("bestellungen")
    private List<PizzaOrder> bestellungen = new LinkedList<>();


    public Order() {

    }

    public Order(Integer id, String phone, String address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    public Order(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PizzaOrder> getBestellungen() {
        return bestellungen;
    }

    public void setBestellungen(List<PizzaOrder> bestellungen) {
        this.bestellungen = bestellungen;
    }

}
