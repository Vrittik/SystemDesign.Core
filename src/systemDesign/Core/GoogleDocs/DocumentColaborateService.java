package systemDesign.Core.GoogleDocs;

public class DocumentColaborateService {
	
	public Document document;
	
	public DocumentColaborateService(Document document)
	{
		System.out.println("Document created");
		this.document = document;
	}
	
	public void addCollaborator(User user)
	{
		document.addCollaborator(user);
		System.out.println("Added " + user.userName + " as a collaborator");
	}
	
	public void removeCollaborator(User user)
	{
		document.removeCollaborator(user);
		System.out.println("Removed " + user.userName + " from collaborators");
	}
	
	public void editDocument(String newText)
	{
		document.editDocument(newText);
		System.out.println("Document has been edited");
	}
	
	public void changeCursorPosition(User user, int newPosition)
	{
		document.updateCursorPosition(user, newPosition);
	}
	
	public void printDocument()
	{
		System.out.println("Current state of document : " + document.content);
	}
}
