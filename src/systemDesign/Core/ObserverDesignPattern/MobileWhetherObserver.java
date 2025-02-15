package systemDesign.Core.ObserverDesignPattern;

public class MobileWhetherObserver implements IObserver {
	private IObservable observable;
	public MobileWhetherObserver(IObservable _observable)
	{
		observable = _observable;
	}
	@Override
	public void update() {
		System.out.print("Observed via mobile ");
		observable.getData();
	}
}
