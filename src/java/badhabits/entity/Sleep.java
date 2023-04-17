package badhabits.entity;

import java.util.Date;
import java.util.Timer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sleep")
public class Sleep {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time_sleep")
	private Date timeSleep;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time_wake")
	private Date timeWake;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeSleep() {
		return timeSleep;
	}

	public void setTimeSleep(Date timeSleep) {
		this.timeSleep = timeSleep;
	}

	public Date getTimeWake() {
		return timeWake;
	}

	public void setTimeWake(Date timeWake) {
		this.timeWake = timeWake;
	}

	
}
