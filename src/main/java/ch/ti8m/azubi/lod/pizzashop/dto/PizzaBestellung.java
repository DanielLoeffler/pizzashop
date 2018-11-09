package ch.ti8m.azubi.lod.pizzashop.dto;

public class PizzaBestellung {


    private Integer bestellung_id;
    private Integer pizza_id;
    private Integer anzahl;

    public PizzaBestellung(Integer bestellung_id, Integer pizza_id, Integer anzahl) {
        this.bestellung_id = bestellung_id;
        this.pizza_id = pizza_id;
        this.anzahl = anzahl;
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
