package alibaba;

public class Horse<V, T> implements Animal<V, T>{
	
	public V name;
	public T speed;
	
	public Horse(V name, T speed){
		this.name = name;
		this.speed = speed;
	}

	@Override
	public void run() {
	}

	@Override
	public V getName() {
		return this.name;
	}
	
	@Override
	public T getSpeed() {
		return this.speed;
	}

}
