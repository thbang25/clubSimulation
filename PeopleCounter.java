package clubSimulation;
import java.util.concurrent.atomic.*;

public class PeopleCounter {
	private AtomicInteger peopleOutSide; //counter for people arrived but not yet in the building
	private AtomicInteger peopleInside; //counter for patrons inside club
	private AtomicInteger peopleLeft; //counter for patrons who have left the club
	private AtomicInteger maxPeople; //maximum patrons allowed in the club at one time
   private Object pleaseWait = new Object(); //create objecta and use synchronization to try and make threads wait
	
	PeopleCounter(int max) {
		peopleOutSide= new AtomicInteger(0);
		peopleInside=new AtomicInteger(0);
		peopleLeft=new AtomicInteger(0);
		maxPeople=new AtomicInteger(max);
	}
		
	public int getWaiting() {
		return peopleOutSide.get();
	}

	public int getInside() {
		return peopleInside.get();
	}
	
	public int getTotal() {
		return (peopleOutSide.get()+peopleInside.get()+peopleLeft.get());
	}

	public int getLeft() {
		return peopleLeft.get();
	}
	
	public int getMax() {
		return maxPeople.get();
	}
	
	//someone arrived outside
	public void personArrived() {
		   synchronized (pleaseWait) {
            while (overCapacity()) {
                try {
                    pleaseWait.wait(); // please wait until there is availability
                } catch (InterruptedException e) {}
            }
            peopleOutSide.getAndIncrement();//amount of people waiting
        }
	}
	
	//someone got inside
	synchronized public void personEntered() {
        peopleOutSide.getAndDecrement();
        peopleInside.getAndIncrement();
        synchronized (pleaseWait) {
            pleaseWait.notify(); // Notify waiting people that there is availability
        }
	}

	//someone left
	synchronized public void personLeft() {
		peopleInside.getAndDecrement();
		peopleLeft.getAndIncrement();
		
	}
	//too many people inside
	synchronized public boolean overCapacity() {
		return (peopleInside.get()>=maxPeople.get());//check capacity condition
	}
	
	//not used
	synchronized public void resetScore() {
		peopleInside.set(0);
		peopleOutSide.set(0);
		peopleLeft.set(0);
	}
}
