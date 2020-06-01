package edu.utn.utnphones.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer billId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "id_telephone_line")
    private PhoneLine phoneLine;

    @Column(name = "count_calls")
    private Integer countCalls;

    @Column(name = "cost_price")
    private double costPrice;

    @Column(name = "price")
    private double price;

    @Column(name = "date_bill")
    private Date date;

    @Column(name = "expirate_date")
    private Date expirateDate;

    @OneToMany(mappedBy = "bill")
    private List<Call> calls;


}
