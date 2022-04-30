package dev.rohit.automatedemailcampaign.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "connection_campaign_email")
public class ConnectionCampaignEmail{

  @EmbeddedId
  private ConnectionCampaignEmailKey id;

  @Column(name = "email_order", nullable = false)
  private Integer order;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @MapsId("connectionId")
  @JoinColumn(name = "connection_id")
  private Connection connection;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @MapsId("campaignId")
  @JoinColumn(name = "campaign_id")
  private Campaign campaign;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @MapsId("emailId")
  @JoinColumn(name = "email_id")
  private Email email;
}
