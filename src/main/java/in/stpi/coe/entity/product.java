package in.stpi.coe.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class product {
    @Id
    @Column(name = "product_id")
    @JsonProperty("product_id")
    private String productId;
    @Column(name = "description")
    @JsonProperty("description")
    private String description;
    @Column(name = "domain")
    @JsonProperty("domain")
    private String domain;
    @Column(name = "phase")
    @JsonProperty("phase")
    private String phase;
    @Column(name = "product_name")
    @JsonProperty("product_name")
    private String productName;
    @Column(name = "sector")
    @JsonProperty("sector")
    private String sector;
    @Column(name = "technology")
    @JsonProperty("technology")
    private Boolean technology;
    @ManyToOne(fetch = FetchType.LAZY)
    private startup startup;
}
