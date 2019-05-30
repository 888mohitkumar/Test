public class Interview2 {

	public static void main(final String[] args) {
		final Turn turn = new Turn();
		final My my = new My(turn);
		final Name name = new Name(turn);
		final Is is = new Is(turn);
		final Mohit mohit = new Mohit(turn);

		my.start();
		name.start();
		is.start();
		mohit.start();
	}

}

class Is extends Thread {
	Turn turn;

	Is(final Turn turn) {
		this.turn = turn;
	}

	@Override
	public void run() {
		synchronized (turn) {
			while (turn.count < 10) {
				while (turn.i != 3) {
					try {
						turn.wait();
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Is ");
				turn.i = 4;
				turn.notifyAll();
			}
		}
	}
}

class Mohit extends Thread {
	Turn turn;

	Mohit(final Turn turn) {
		this.turn = turn;
	}

	@Override
	public void run() {
		synchronized (turn) {
			while (turn.count <= 10) {

				while (turn.i != 4) {
					try {
						turn.wait();
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Mohit ");
				turn.i = 1;
				turn.count++;
				turn.notifyAll();
			}
		}
	}
}

class My extends Thread {
	Turn turn;

	My(final Turn turn) {
		this.turn = turn;
	}

	@Override
	public void run() {
		synchronized (turn) {
			while (turn.count < 10) {
				while (turn.i != 1) {
					try {
						turn.wait();
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("MY ");
				turn.i = 2;
				turn.notifyAll();
			}
		}
	}
}

class Name extends Thread {
	Turn turn;

	Name(final Turn turn) {
		this.turn = turn;
	}

	@Override
	public void run() {
		synchronized (turn) {
			while (turn.count < 10) {
				while (turn.i != 2) {
					try {
						turn.wait();
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Name ");
				turn.i = 3;
				turn.notifyAll();
			}
		}
	}
}

class Turn {
	int i = 1;
	int count = 1;
}
