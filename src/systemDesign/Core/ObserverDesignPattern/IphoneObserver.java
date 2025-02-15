package systemDesign.Core.ObserverDesignPattern;

public class IphoneObserver implements IObserver{

	private IObservable observable;
	private NotificationType notifyMethod;
	private String notifyContact;
	
	public IphoneObserver(IObservable _observable, NotificationType _notifyMethod, String _notifyContact)
	{
		observable = _observable;
		notifyMethod = _notifyMethod;
		notifyContact = _notifyContact;
	}
	@Override
	public void update() {
		System.out.print("Notified via " + notifyMethod.name() + " to " + notifyContact + " ");
		observable.getData();
	}

}
