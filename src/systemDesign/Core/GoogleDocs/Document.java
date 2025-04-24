package systemDesign.Core.GoogleDocs;

import java.util.*;

public class Document {
	public String content;
	public List<User> collaborators;
	public Map<User, Integer> cursorPositions;
	public List<CurrentPositionObserver> observers;
	
	public Document() {
		content = "";
		collaborators = new ArrayList<>();
		cursorPositions = new HashMap<>();
		observers = new ArrayList<>();
	}
	public void editDocument(String text)
	{
		content = text;
		notifyObservers();
	}
	
	public void updateCursorPosition(User user, int newPosition)
	{
		cursorPositions.put(user, newPosition);
	}
	
	public void addCollaborator(User user)
	{
		collaborators.add(user);
		cursorPositions.put(user, 0);
		
		addObserver(user);
	}
	
	public void removeCollaborator(User user)
	{
		int collaboratorIndex = -1;
		int i = 0;
		for(var collaborator : collaborators)
		{
			if(collaborator.id == user.id)
			{
				collaboratorIndex = i;
				break;
			}
			i++;
		}
		collaborators.remove(collaboratorIndex);
		removeObserver(user);
	}
	
	public void notifyObservers() {
		for(var observer : observers)
		{
			observer.update(this);
		}
	}
	
	public void addObserver(User user)
	{
		CurrentPositionObserver currentPosObsevrer = new CurrentPositionObserver(user);
		observers.add(currentPosObsevrer);
		
	}
	
	public void removeObserver(User user)
	{
		int observerPos = -1;
		int k = 0;
		for(var observer : observers)
		{
			if(observer.user.id == user.id)
			{
				observerPos = k;
				break;
			}
			k++;
		}
		observers.remove(observerPos);
	}
	
	public int getCursorPosition(User user)
	{
		return cursorPositions.getOrDefault(user, 0);
	}
}
