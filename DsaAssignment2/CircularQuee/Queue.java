package get2019.dsaAssingment2;

public interface Queue {

	public void enqueue(int data);
	public int dequeue();
	public boolean isFull();
	public boolean isEmpty();
	public int isSize();
}
