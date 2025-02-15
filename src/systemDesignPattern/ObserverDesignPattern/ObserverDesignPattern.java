package systemDesignPattern.ObserverDesignPattern;

import java.util.*;

public class ObserverDesignPattern {
	public static void main(String[] args)
	{
		IObservable iphoneStocksObservable = new StocksObservable();
		IObservable whetherStationObservable = new WhetherStationObservable();
		
		IObserver mobileIphoneObserver = new IphoneObserver(iphoneStocksObservable, NotificationType.Mobile , "9988998898");
		IObserver emailIphoneObserver = new IphoneObserver(iphoneStocksObservable, NotificationType.Email, "v@v.com");
		
		
		IObserver tvWhetherObserver = new TvWhetherObserver(whetherStationObservable);
		IObserver mobileWhetherObserver = new MobileWhetherObserver(whetherStationObservable);
		
		// register observers to the stocks observable
		iphoneStocksObservable.add(mobileIphoneObserver);
		iphoneStocksObservable.add(emailIphoneObserver);
		
		// register observers to whether station observable
		whetherStationObservable.add(tvWhetherObserver);
		whetherStationObservable.add(mobileWhetherObserver);
		
		// notify when stocks are increased from 0 to 25
		iphoneStocksObservable.setData(25);
		
		// don't notify when product goes out of stock
		iphoneStocksObservable.setData(0);
		
		// notify when new stock comes
		iphoneStocksObservable.setData(60);
		
		
		// for each 10 seconds, temperature updates and is notified to each observer
		Random random = new Random();
		
		System.out.println("\n");
		
		for(int i = 0; i<6; i++)
		{
			int newWhether = random.nextInt(100);
			whetherStationObservable.setData(newWhether);
			
			if(i == 3)
			{
				// at 8th second, tv observer is detached
				whetherStationObservable.remove(mobileWhetherObserver);
			}
			try {
			Thread.sleep(2000);
			System.out.println("\n");
			}
			catch(Exception e)
			{
				
			}
		}
	}
}
