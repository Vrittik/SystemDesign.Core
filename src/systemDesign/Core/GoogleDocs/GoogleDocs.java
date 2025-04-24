package systemDesign.Core.GoogleDocs;

public class GoogleDocs {
	public static void main(String[] args)
	{
		
		Document doc = new Document();
		
		DocumentColaborateService docService = new DocumentColaborateService(doc);
		
		User u1 = new User("Vrittik", "v@gmail.com", 1);
		User u2 = new User("Vaibhav", "vs@gmail.com", 2);
		User u3 = new User("Hardik", "h@gmail.com", 3);
		User u4 = new User("Ashwami", "a@gmail.com", 4);
		
		docService.addCollaborator(u1);
		docService.addCollaborator(u2);
		docService.addCollaborator(u3);
		docService.addCollaborator(u4);
		
		docService.editDocument("Hey this is a new docs in google docs");
		docService.printDocument();
		docService.changeCursorPosition(u4, 23);
		docService.changeCursorPosition(u2, 20);
		docService.changeCursorPosition(u3, 21);
		docService.changeCursorPosition(u1, 19);
		
		docService.editDocument("Hey this is an updated new docs in google docs");
		
		docService.removeCollaborator(u2);
	}
}
