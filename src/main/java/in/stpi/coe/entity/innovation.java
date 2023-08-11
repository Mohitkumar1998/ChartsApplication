package in.stpi.coe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "innovation")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class innovation {
    @Id
    @NotNull
    @Column(name = "ipr_id")
    private String iprId;
    @Column(name = "description")
    private String description;
    @Column(name = "issuing_authority")
    private String issuingAuthority;
    @Column(name = "type")
    private String type;
    @ManyToOne(fetch = FetchType.LAZY)
    private startup startup;
}
