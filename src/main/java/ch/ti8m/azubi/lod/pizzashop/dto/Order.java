package ch.ti8m.azubi.lod.pizzashop.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private int id;
    private String phone;
    private String address;

    private List<PizzaBestellung> bestellungen = new LinkedList<>();


    @JsonCreator
    public Order(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("bestellungen")
    public List<PizzaBestellung> getBestellungen() {
        return bestellungen;
    }

    public void setBestellungen(List<PizzaBestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }


    /*
    @Override
    public String toString() {
        return phone + ", " + address;
    }
    */
}
