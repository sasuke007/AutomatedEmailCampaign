package dev.rohit.automatedemailcampaign.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "connections")
public class Connection{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  private Long phoneNumber;

  private String address;

  private String resumeLink;

  private String college;

  private String techStack;

  @OneToMany(mappedBy = "connection")
  private List<ConnectionCampaignEmail> connectionCampaignEmails;

  @ManyToMany(cascade = CascadeType.REMOVE)
  @JoinTable(name = "student_campaign",
      joinColumns = {@JoinColumn(name = "connection_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "campaign_id", referencedColumnName = "id")})
  private List<Campaign> campaigns;

}
