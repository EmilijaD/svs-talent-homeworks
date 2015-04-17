import java.util.Date;

public class TimePeriod {
	private Date start;
	private Date end;

	public TimePeriod(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public boolean overlapsWith(TimePeriod timePeriod) {
		// testAcontainsB()
		if ((this.start.before(timePeriod.start))
				&& (this.end.after(timePeriod.end))) {
			return true;
		}
		// testBcontainsA()

		if ((this.start.after(timePeriod.start))
				&& (this.end.before(timePeriod.end))) {
			return true;
		}
		// testBinteractA()
		if ((this.start.after(timePeriod.start))
				&& (this.end.after(timePeriod.end))) {
			return true;
		}
		// testAinteractB()
		if ((this.start.before(timePeriod.start))
				&& (this.end.before(timePeriod.end))) {
			return true;
		}
		// testAequalsB()
		if ((this.start.equals(timePeriod.start))
				&& (this.end.equals(timePeriod.end))) {
			return true;
		}
		// testAendEqualToBstart()
		if (this.end.equals(timePeriod.start)) {
			return true;
		}
		return false;
	}
}
