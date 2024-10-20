package com.rataz.investmenttracking.event.details.statistic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event_statistic_type")
public class EventStatisticType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "statistic_type", unique = true, nullable = false)
    private String statisticType;

    @OneToMany(mappedBy = "eventStatisticType", fetch = FetchType.LAZY)
    private List<EventStatistic> statisticDetails;
}
