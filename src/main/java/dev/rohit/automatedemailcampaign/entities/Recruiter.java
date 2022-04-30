package dev.rohit.automatedemailcampaign.entities;

import dev.rohit.automatedemailcampaign.enums.Gender;
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
@Table(name="recruiters")
public class Recruiter{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer age;

  @Column(nullable = false)
  private Gender gender;

  @ManyToOne
  @JoinColumn(name="company_id",referencedColumnName = "id")
  private Company company;

  @OneToMany(mappedBy = "recruiter",cascade = CascadeType.REMOVE)
  private List<Campaign> campaigns;
}
