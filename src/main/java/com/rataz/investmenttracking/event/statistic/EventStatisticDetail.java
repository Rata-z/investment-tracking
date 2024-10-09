package com.rataz.investmenttracking.event.statistic;


import com.rataz.investmenttracking.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="event_statistic_detail")
public class EventStatisticDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statistic_type_id",nullable = false)
    private EventStatisticType eventStatisticType;

    private BigDecimal amount;
    private boolean under;


}
