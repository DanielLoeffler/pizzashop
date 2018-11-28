package ch.ti8m.azubi.lod.pizzashop.dto;


import java.util.LinkedList;
import java.util.List;

public class Order {

    private int id;
    private String phone;
    private String address;

    private List<PizzaBestellung> bestellungen = new LinkedList<>();


    public Order(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
