package in.stpi.coe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "timeline")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class timeline {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeline_id")
    private int timelineId;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;
    @Column(name = "row_name")
    private String rowName;
    @Column(name = "is_quarter")
    private boolean isQuarter;
}
