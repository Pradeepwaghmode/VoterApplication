package com.nt.module;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	private Integer c1;
	private Integer c2;
	private Integer c3;
	private Integer c4;
	
}
