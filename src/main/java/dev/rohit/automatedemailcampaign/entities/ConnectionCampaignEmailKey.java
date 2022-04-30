package dev.rohit.automatedemailcampaign.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ConnectionCampaignEmailKey implements Serializable{

  @Column(name = "connection_id")
  private Long connectionId;

  @Column(name = "campaign_id")
  private Long campaignId;

  @Column(name = "email_id")
  private Long emailId;
}
