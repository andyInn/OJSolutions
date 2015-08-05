package alibaba;

public interface Animal<V, T> {
	public V getName();
	public T getSpeed();
	public void run();
}
