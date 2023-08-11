package in.stpi.coe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "incentive")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class incentive {
    @Id
    @NotNull
    @Column(name = "funding_id")
    private String fundingId;
    @Column(name = "amount")
    private long amount;
    @Column(name = "date")
    private Date date;
    @Column(name = "funding_type")
    private String fundingType;
    @Column(name = "name_of_org")
    private String nameOfOrg;
    @ManyToOne(fetch = FetchType.LAZY)
    private startup startup;
}
