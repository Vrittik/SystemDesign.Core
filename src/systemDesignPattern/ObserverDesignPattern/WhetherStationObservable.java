package systemDesignPattern.ObserverDesignPattern;

import java.util.*;

public class WhetherStationObservable implements IObservable{
	List<IObserver> observers = new ArrayList<>();
	int weather = 0;
	
	@Override
	public void add(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void setData(int newWeather) {
		System.out.println("whether is being updated");
		weather = newWeather;
		for(IObserver observer : observers)
		{
			observer.update();
		}
	}

	@Override
	public void getData() {
		System.out.println("new weather = " + weather + " degree");
	}
}
