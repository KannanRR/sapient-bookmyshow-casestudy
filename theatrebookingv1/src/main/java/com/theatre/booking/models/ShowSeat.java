package com.theatre.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theatre.booking.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnore
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus status;

}