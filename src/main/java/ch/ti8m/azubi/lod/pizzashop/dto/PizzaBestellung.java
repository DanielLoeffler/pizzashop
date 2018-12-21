package ch.ti8m.azubi.lod.pizzashop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PizzaBestellung {


    private Integer bestellung_id;
    private Integer pizza_id;
    private Integer anzahl;
    private double preis;

    @JsonCreator
    public PizzaBestellung(Integer bestellung_id, Integer pizza_id, Integer anzahl, double preis) {
        this.bestellung_id = bestellung_id;
        this.pizza_id = pizza_id;
        this.anzahl = anzahl;
        this.preis = preis;
    }


    @JsonProperty("bestell-id")
    public Integer getBestellung_id() {
        return bestellung_id;
    }

    public void setBestellung_id(Integer bestellung_id) {
        this.bestellung_id = bestellung_id;
    }

    @JsonProperty("pizza-id")
    public Integer getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(Integer pizza_id) {
        this.pizza_id = pizza_id;
    }

    @JsonProperty("anzahl")
    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    @JsonProperty("preis")
    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
