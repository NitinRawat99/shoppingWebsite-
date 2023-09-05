package com.shopping.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="db_sequence")
public class DbSequence 
{
	@Id
	private String id;
	private int seqno;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public DbSequence(String id, int seqno) {
		super();
		this.id = id;
		this.seqno = seqno;
	}
	public DbSequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
