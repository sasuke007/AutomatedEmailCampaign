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
@Table(name = "campaigns")
public class Campaign{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToOne(mappedBy = "campaign")
  private Template template;
  @ManyToOne
  @JoinColumn(name = "recruiter_id", referencedColumnName = "id")
  private Recruiter recruiter;

  @ManyToMany(mappedBy = "campaigns", cascade = CascadeType.REMOVE)
  private List<Connection> connections;

  @OneToMany(mappedBy = "campaign")
  private List<ConnectionCampaignEmail> connectionCampaignEmails;
}
