package in.stpi.coe.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "contest")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class contest {
    @Id
    @NotNull
    @Column(name = "cohort_id")
    @JsonProperty("cohort_id")
    private int cohortId;
    @Column(name = "coe_id")
    @JsonProperty("coe_id")
    private int coeId;
    @Column(name = "cohort")
    @JsonProperty("cohort")
    private String cohort;
    @Column(name = "cohort_start")
    @JsonProperty("cohort_start")
    private Date cohortStart;
    @Column(name = "cohort_end")
    @JsonProperty("cohort_end")
    private Date cohortEnd;
    @Column(name = "applicant")
    @JsonProperty("applicant")
    private int applicant;
    @Column(name = "short_listed")
    @JsonProperty("short_listed")
    private int shortListed;
    @Column(name = "selected")
    @JsonProperty("selected")
    private int selected;
}
