package systemDesignPattern.ObserverDesignPattern;

public class TvWhetherObserver implements IObserver{
	private IObservable observable;
	public TvWhetherObserver(IObservable _observable)
	{
		observable = _observable;
	}
	@Override
	public void update() {
		System.out.print("Observed via tv ");
		observable.getData();
	}
}
