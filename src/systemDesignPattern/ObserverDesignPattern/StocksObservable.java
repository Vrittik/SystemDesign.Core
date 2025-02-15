package systemDesignPattern.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class StocksObservable implements IObservable{
	List<IObserver> observers = new ArrayList<>();
	int stockCount = 0;
	
	@Override
	public void add(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void setData(int newStockCount) {
		System.out.println("Stocks are updated from " + stockCount + " to " + newStockCount);
		
		int previousStockCount = stockCount;
		stockCount = newStockCount;
		
		if(previousStockCount == 0 && newStockCount != 0)
		{
			for(IObserver observer : observers)
			{
				observer.update();
			}
		}
	}

	@Override
	public void getData() {
		System.out.println("Stock has updated to " + stockCount + " pieces");
	}
}
