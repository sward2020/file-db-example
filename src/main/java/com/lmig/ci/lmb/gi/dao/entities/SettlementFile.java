package com.lmig.ci.lmb.gi.dao.entities;



import javax.persistence.*;

/**
 * Created by n0050370 on 5/24/17.
 */
@Entity
@Table(name = "SettlementFile")
public class SettlementFile {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Lob
@Column(nullable=false)
private String inboundfile;

public SettlementFile(){};

public String getInboundfile() {
    return inboundfile;
}

public void setInboundfile(String inboundfile) {
    this.inboundfile = inboundfile;
}
}
