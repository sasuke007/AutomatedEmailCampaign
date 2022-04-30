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
@Table(name = "companies")
public class Company{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  private String logo;

  private String description;

  @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "company")
  private List<Recruiter> recruiters;

  @OneToMany(mappedBy = "company")
  private List<Template> templates;
}
