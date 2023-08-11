package in.stpi.coe.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coe")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class coe {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coe_id")
    @JsonProperty("coe_id")
    private int coeId;
    @Column(name = "coe_name")
    @JsonProperty("coe_name")
    private String coeName;
}
