package models;

import play.data.validation.Required;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by couretn on 19/05/16.
 */
@Entity
public class Sale extends Resource {

    public static enum State {
        CREATED,
        VALIDATED,
        COMPLETED,
        CLOSED
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name="SELLER_ID", nullable = false)
    @Required
    private User seller;

    @Column(nullable = false,updatable = false)
    private Date startDate;

    @Column
    private Date expireDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Beer.class)
    @Required
    private Beer product;

    @Column(nullable = false)
    @Required
    private int quantity;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void setExpireDate(Date expireDate) {

        this.expireDate = expireDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Beer getProduct() {
        return product;
    }

    public void setProduct(Beer product) {
        this.product = product;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public State getState() {
        return state;
    }

    public String toString() {
        return seller + " "+state;
    }
}
