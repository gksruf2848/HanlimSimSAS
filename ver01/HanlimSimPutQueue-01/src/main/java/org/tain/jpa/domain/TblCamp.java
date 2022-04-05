package org.tain.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_camp")
@Data
public class TblCamp {

	@Id
	private Long id;
	
	@Column(name = "camp_code")
	private String campCode;
	
	@Column(name = "camp_content")
	private String campContent;
}
