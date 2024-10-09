package com.rataz.investmenttracking.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="event_type")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_type",unique = true)
    private String eventType;

    @OneToMany(mappedBy = "eventType",fetch = FetchType.LAZY)
    private List<Event> events;
}
