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
@Table(name="templates")
public class Template{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  private Integer preferredOrder;
  @ManyToOne
  @JoinColumn(name="company_id",referencedColumnName = "id")
  private Company company;
  @OneToOne
  @JoinColumn(name = "campaign_id", referencedColumnName = "id")
  private Campaign campaign;

  @ManyToMany(mappedBy = "templates",cascade = CascadeType.REMOVE)
  private List<Email> emails;
}
