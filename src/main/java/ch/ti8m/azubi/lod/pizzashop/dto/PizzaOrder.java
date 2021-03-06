package ch.ti8m.azubi.lod.pizzashop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * A PizzaOrder witch connects Pizza and Order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PizzaOrder {

    @JsonProperty("pizza_id")
    private Integer pizza_id;

    @JsonProperty("anzahl")
    private Integer anzahl;

    @JsonProperty("preis")
    private double preis;

    public PizzaOrder() {

    }

    public PizzaOrder(Integer pizza_id, Integer anzahl, double preis) {
        this.pizza_id = pizza_id;
        this.anzahl = anzahl;
        this.preis = preis;
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

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
