public class StopwatcherTask implements Runnable {
	volatile int state = 0;
	public final static int STOP = 0;
	public final static int START = 1;
	public final static int PAUSE = 2;
	volatile int vreme;
	volatile int ms;

	public StopwatcherTask() {
		super();
		this.vreme = 0;
		this.ms = 0;
	}

	public void start() {
		synchronized (this) {
			vreme = 0;
			ms = 0;
			state = START;
		}
		
	}

	public void stop() {
		synchronized (this) {
			state = STOP;
		}
		
	}

	public void pause() {
		synchronized (this) {
			if (state == START) {
				state = PAUSE;
			}	
		}
		
	}

	public void resume() {
		synchronized (this) {
			if (state == PAUSE) {
				state = START;
			}
		}
		
	}

	@Override
	public void run() {
		int s;
		while (true) {
			synchronized (this) {
				s=state;//za da se izbegne povikuvanje na sleep vo synchronized block
			}
			if (s == START) {
				try {
					Thread.sleep(50);

					ms += 50;
					if (ms >= 1000) {
						vreme++;
						System.out.println(vreme);
						ms -= 1000;

					}
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			} else if (s != START) {
				try {
					Thread.sleep(50);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
