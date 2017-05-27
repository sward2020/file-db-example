package com.lmig.ci.lmb.gi.dao.entities;


import javax.persistence.*;


/**
 * Created by n0050370 on 5/24/17.
 */
@Entity
@Table(name = "MopCodeRef")
public class MopCodeRef {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable=false)
private String code;

@Column(nullable=false)
private String codeDescription;

public MopCodeRef() {}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public String getCodeDescription() {
    return codeDescription;
}

public void setCodeDescription(String codeDescription) {
    this.codeDescription = codeDescription;
}
}
