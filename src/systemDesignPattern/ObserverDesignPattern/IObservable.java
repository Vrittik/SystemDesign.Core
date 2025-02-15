package systemDesignPattern.ObserverDesignPattern;

public interface IObservable {
	void add(IObserver observer);
	void remove(IObserver observer);
	void setData(int data);
	void getData();
}
