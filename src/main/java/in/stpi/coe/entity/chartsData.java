package in.stpi.coe.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "charts_data")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class chartsData {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private int Id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private coe coe;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private timeline timeline;
    @Column(name = "startups_participated")
    @JsonProperty("startups_participated")
    private int startupsParticipatedInCoEActivities;
    @Column(name = "startups_selected")
    @JsonProperty("startups_selected")
    private int startupsSelected;
    @Column(name = "startups_targeted")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int startupsTargeted;
    @Column(name = "academic_partners")
    @JsonProperty("academic_partners")
    private int academicPartners;
    @Column(name = "all_partners")
    @JsonProperty("all_partners")
    private int allPartners;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "chart_partner_rel", joinColumns = {@JoinColumn(name = "chart_id")}, inverseJoinColumns = {@JoinColumn(name = "partner_id")})
    @JsonProperty("all_partners_list")
    private Set<partner> partners = new HashSet<>();
    @Column(name = "contests_conducted")
    @JsonProperty("contests_conducted")
    private int contestsConducted;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "chart_contest_rel", joinColumns = {@JoinColumn(name = "chart_id")}, inverseJoinColumns = {@JoinColumn(name = "contest_id")})
    @JsonProperty("contest_details_list")
    private Set<contest> contests;
    @Column(name = "employment_generation")
    @JsonProperty("employment_generation")
    private int employmentGeneration;
    @Column(name = "five_lakhs_to_fifteen_lakhs")
    @JsonProperty("five_lakhs_to_fifteen_lakhs")
    private int fiveLakhsToFifteenLakhs;
    @Column(name = "fund_raised")
    @JsonProperty("fund_raised")
    private Double fundRaised;
    @Column(name = "funding_investment_agencies")
    @JsonProperty("funding_investment_agencies")
    private int fundingInvestmentAgencies;
    @Column(name = "industry_associations_partners")
    @JsonProperty("industry_associations_partners")
    private int industryAssociationsPartners;
    @Column(name = "ipr")
    @JsonProperty("ipr")
    private int ipr;
    @Column(name = "knowledge_partners")
    @JsonProperty("knowledge_partners")
    private int knowledgePartners;
    @Column(name = "less_than_five_lakhs")
    @JsonProperty("less_than_five_lakhs")
    private int lessThanFiveLakhs;
    @Column(name = "mentors_enrolled")
    @JsonProperty("mentors_enrolled")
    private int mentorsEnrolled;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "chart_mentor_rel", joinColumns = {@JoinColumn(name = "chart_id")}, inverseJoinColumns = {@JoinColumn(name = "mentor_id")})
    @JsonProperty("mentors_enrolled_list")
    private Set<mentor> mentors;
    @Column(name = "more_then_fifteen_lakhs")
    @JsonProperty("more_then_fifteen_lakhs")
    private int moreThenFifteenLakhs;
    @Column(name = "outreach_programs_conducted")
    @JsonProperty("outreach_programs_conducted")
    private int outreachProgramsConducted;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "chart_event_rel", joinColumns = {@JoinColumn(name = "chart_id")}, inverseJoinColumns = {@JoinColumn(name = "event_id")})
    @JsonProperty("activities_list")
    private Set<event> events;
    @Column(name = "product")
    @JsonProperty("product")
    private int product;
    @Column(name = "prototype")
    @JsonProperty("prototype")
    private int prototype;
    @Column(name = "research_organizations")
    @JsonProperty("research_organizations")
    private int researchOrganizations;
    @Column(name = "revenue_generated")
    @JsonProperty("revenue_generated")
    private Double revenueGenerated;
    @Column(name = "startup_valuation")
    @JsonProperty("startup_valuation")
    private Double startupValuation;
    @Column(name = "startups_onboarded")
    @JsonProperty("startups_onboarded")
    private int startupsOnboarded;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "chart_startup_rel", joinColumns = {@JoinColumn(name = "chart_id")}, inverseJoinColumns = {@JoinColumn(name = "startup_id")})
    @JsonProperty("startups_onboarded_list")
    private Set<startup> startups;
    @Column(name = "state_central_government_agencies_onboarded")
    @JsonProperty("state_central_government_agencies_onboarded")
    private int stateCentralGovernmentAgenciesOnboarded;
    @Column(name = "training_mentoring_programs_conducted")
    @JsonProperty("training_mentoring_programs_conducted")
    private int trainingMentoringProgramsConducted;
}
