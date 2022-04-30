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
@Table(name = "emails")
public class Email{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String subject;

  @Column(nullable = false)
  private String content;

  @ManyToMany(cascade = CascadeType.REMOVE)
  @JoinTable(name = "template_email",
      joinColumns = {@JoinColumn(name = "email_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "template_id", referencedColumnName = "id")})
  private List<Template> templates;

  @OneToMany(mappedBy = "email")
  private List<ConnectionCampaignEmail> connectionCampaignEmails;
}
