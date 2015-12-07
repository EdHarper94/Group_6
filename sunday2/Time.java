import java.util.concurrent.TimeUnit;

/**
 * @file Time.java
 * @author XIAO WANG
 * @date 2nd November
 * @see Game.java
 */


public class Time {

	private long m_StartTime;
	private long m_TimeElapsed;
	
	public Time(){
		m_StartTime = System.currentTimeMillis();
		m_TimeElapsed = 0;
	}
	
	/**
	* Setting time elapsed.
	* Current time - start time
	* @return m_TimeElapsed int
	*/
	public long setTimeElapsed(){
		m_TimeElapsed = System.currentTimeMillis() - m_StartTime;
		return m_TimeElapsed;
	}
	
	
	/**
	* Converts Milliseconds into hours, minutes, seconds.
	* Displays in correct format.
	*/
	public String getTimeElapsed(){
		long hours = TimeUnit.MILLISECONDS.toHours(setTimeElapsed());
		long minutes = TimeUnit.MILLISECONDS.toMinutes(setTimeElapsed());
		long seconds = TimeUnit.MILLISECONDS.toSeconds(setTimeElapsed()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(setTimeElapsed()));
		return String.format("%02d : %02d : %02d", hours, minutes, seconds);
	}
	
}
