package badhabits.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="lamp")
public class Lamp {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "lamp_status")
	private int lampStatus;
	
	@Column(name = "lamp_date")
	private Date lampDate;
	
	@Column(name = "lamp_time" )
	private Date lampTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLampStatus() {
		return lampStatus;
	}

	public void setLampStatus(int lampStatus) {
		this.lampStatus = lampStatus;
	}

	public Date getLampDate() {
		return lampDate;
	}

	public void setLampDate(Date lampDate) {
		this.lampDate = lampDate;
	}

	public Date getLampTime() {
		return lampTime;
	}

	public void setLampTime(Date lampTime) {
		this.lampTime = lampTime;
	}

}
