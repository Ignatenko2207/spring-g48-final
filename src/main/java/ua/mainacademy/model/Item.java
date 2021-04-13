package ua.mainacademy.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
@Entity
public class Item extends BaseEntity {

    @Column(name = "item_code", nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private String name;

    private Integer price;

    @Column(name = "init_price")
    private Integer initPrice;

    public Item(Integer id, String itemCode, String name, Integer price, Integer initPrice) {
        super.setId(id);
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.initPrice = initPrice;
    }
}
