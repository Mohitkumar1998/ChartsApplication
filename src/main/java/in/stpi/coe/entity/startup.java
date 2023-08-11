package in.stpi.coe.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "startup")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class startup {
    @Id
    @NotNull
    @Column(name = "startup_id")
    private int startupId;
    @Column(name = "brief")
    private String brief;
    @Column(name = "contact_mobile")
    private String contactMobile;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "dpiit")
    private Long dpiit;
    @Column(name = "email")
    private String email;
    @Column(name = "employment")
    private Long employment;
    @Column(name = "founder")
    private String founder;
    @Column(name = "fund_raised")
    private Long fundRaised;
    @OneToMany(mappedBy = "startup", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<incentive> fundingList;
    @Column(name = "incubatee_type")
    private String incubateeType;
    @OneToMany(mappedBy = "startup", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<innovation> iprsList;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "startup", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<product> productsList;
    @Column(name = "revenue")
    private Double revenue;
    @Column(name = "valuation")
    private Double valuation;
    @Column(name = "website")
    private String website;
    @Column(name = "women_led")
    private Boolean womenLed;
}
