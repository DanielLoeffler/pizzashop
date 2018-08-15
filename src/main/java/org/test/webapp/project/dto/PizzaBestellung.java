package org.test.webapp.project.dto;

public class PizzaBestellung {

    private Integer id;
    private Integer bestellung_id;
    private Integer pizza_id;
    private Integer anzahl;

    public PizzaBestellung(Integer id, Integer bestellung_id, Integer pizza_id, Integer anzahl) {
        this.id = id;
        this.bestellung_id = bestellung_id;
        this.pizza_id = pizza_id;
        this.anzahl = anzahl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBestellung_id() {
        return bestellung_id;
    }

    public void setBestellung_id(Integer bestellung_id) {
        this.bestellung_id = bestellung_id;
    }

    public Integer getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(Integer pizza_id) {
        this.pizza_id = pizza_id;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }
}
