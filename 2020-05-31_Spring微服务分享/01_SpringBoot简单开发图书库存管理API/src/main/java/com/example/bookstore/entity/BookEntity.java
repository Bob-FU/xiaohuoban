package com.example.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookEntity extends AbstractEntity {

    @Id
    @GenericGenerator(name = "UuidGenerator", strategy = "com.example.bookstore.misc.UUIDGenerator")
    @GeneratedValue(generator = "UuidGenerator")
    @JsonProperty
    private String bookid;
    @JsonProperty
    private String bookname;
    @JsonProperty
    private BigDecimal price;
    @JsonProperty
    private Integer stock;

}
