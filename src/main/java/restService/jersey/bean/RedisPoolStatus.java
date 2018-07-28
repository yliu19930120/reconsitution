package restService.jersey.bean;

public class RedisPoolStatus {
	
	private int actives;
	private int idle;
	private int waiters;
	
	public int getActives() {
		return actives;
	}
	public void setActives(int actives) {
		this.actives = actives;
	}
	public int getIdle() {
		return idle;
	}
	public void setIdle(int idle) {
		this.idle = idle;
	}
	public int getWaiters() {
		return waiters;
	}
	public void setWaiters(int waiters) {
		this.waiters = waiters;
	}
	
}
