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
@Table(name = "mentor")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class mentor {
    @Id
    @NotNull
    @Column(name = "mentor_id")
    @JsonProperty("mentor_id")
    private int mentorId;
    @Column(name = "category")
    @JsonProperty("category")
    private String category;
    @Column(name = "email")
    @JsonProperty("email")
    private String email;
    @Column(name = "mobile")
    @JsonProperty("mobile")
    private Boolean mobile;
    @Column(name = "name")
    @JsonProperty("name")
    private String name;
    @Column(name = "partner_type")
    @JsonProperty("partner_type")
    private Boolean partnerType;
}
