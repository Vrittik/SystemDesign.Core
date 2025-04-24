package systemDesign.Core.GoogleDocs;

public class CurrentPositionObserver implements IDocumentObserver {
	User user;
	
	public CurrentPositionObserver(User user)
	{
		this.user = user;
	}
	
	@Override
	public void update(Document document) {
		System.out.println("Due to change in doc, cursor position of cursor for " + user.userName + " has been updated to " + document.getCursorPosition(user));
	}
}
