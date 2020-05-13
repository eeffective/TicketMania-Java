package TicketMania.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "musicevent_id")
    private Long musicEventId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
