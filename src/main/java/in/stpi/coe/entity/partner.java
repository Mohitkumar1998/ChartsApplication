package in.stpi.coe.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partner")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class partner {
    @Id
    @NotNull
    @Column(name = "partner_id")
    @JsonProperty("partner_id")
    private int partnerId;
    @Column(name = "agreement_type")
    @JsonProperty("agreement_type")
    private String agreementType;
    @Column(name = "email")
    @JsonProperty("email")
    private String email;
    @Column(name = "mobile")
    @JsonProperty("mobile")
    private String mobile;
    @Column(name = "name")
    @JsonProperty("name")
    private String name;
    @Column(name = "partner_type")
    @JsonProperty("partner_type")
    private String partnerType;
}
