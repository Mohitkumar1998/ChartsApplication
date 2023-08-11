package in.stpi.coe.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class event {
    @Id
    @Column(name = "event_id")
    @JsonProperty("event_id")
    private int eventId;
    @Column(name = "end_date")
    @JsonProperty("end_date")
    private String endDate;
    @Column(name = "name")
    @JsonProperty("name")
    private String name;
    @Column(name = "outcome")
    @JsonProperty("outcome")
    private String outcome;
    @Column(name = "outreach_name")
    @JsonProperty("outreach_name")
    private Boolean outreachName;
    @Column(name = "outreach_startups")
    @JsonProperty("outreach_startups")
    private Long outreachStartups;
    @Column(name = "outside_attendee")
    @JsonProperty("outside_attendee")
    private Long outsideAttendee;
    @Column(name = "start_date")
    @JsonProperty("start_date")
    private String startDate;
    @Column(name = "stpi_attendee")
    @JsonProperty("stpi_attendee")
    private Long stpiAttendee;
    @Column(name = "type")
    @JsonProperty("type")
    private String type;
}
