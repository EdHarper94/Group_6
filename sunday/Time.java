import java.util.concurrent.TimeUnit;

public class Time {

	private long m_StartTime;
	private long m_TimeElapsed;
	
	public Time(){
		m_StartTime = System.currentTimeMillis();
		m_TimeElapsed = 0;
	}
	
	/*
	public String getTimeElapsed(){
	
		m_TimeElapsed = System.currentTimeMillis() - m_StartTime;
		return String.format("%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(m_TimeElapsed), TimeUnit.MILLISECONDS.toMinutes(m_TimeElapsed), TimeUnit.MILLISECONDS.toSeconds(m_TimeElapsed));
	
	}
	*/

	/*public long setCurrentTime(){
		m_StartTime = System.currentTimeMillis();
		return m_StartTime;
	}*/
	
	public long setTimeElapsed(){
		m_TimeElapsed = System.currentTimeMillis() - m_StartTime;
		return m_TimeElapsed;
		//return new
		//return String.format("%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(this.m_TimeElapsed), TimeUnit.MILLISECONDS.toMinutes(this.m_TimeElapsed), TimeUnit.MILLISECONDS.toSeconds(this.m_TimeElapsed));
	}
	
	public String getTimeElapsed(){
		long hours = TimeUnit.MILLISECONDS.toHours(setTimeElapsed());
		long minutes = TimeUnit.MILLISECONDS.toMinutes(setTimeElapsed());
		long seconds = TimeUnit.MILLISECONDS.toSeconds(setTimeElapsed()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(setTimeElapsed()));
		return String.format("%02d : %02d : %02d", hours, minutes, seconds);
	}
	
}
