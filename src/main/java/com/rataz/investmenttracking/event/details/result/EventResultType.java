package com.rataz.investmenttracking.event.details.result;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_result_type")
public class EventResultType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "result_type", unique = true)
    private String resultType;
    @OneToMany(mappedBy = "eventResultType", fetch = FetchType.LAZY)
    private List<EventResultDetail> eventResults;
}
