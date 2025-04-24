Google Docs Design	
------------------------

Problem ->
----------
Design a collaborative editing service google docs


Design ->
----------
Features Required : 
1. Real time collaboration - Multiple users should be able to collaborate and
work on a document
2. Add new collaborators
3. Remove existing collaborators
4. Changes made by one user should be reflected to every other user
5. Cursor position tracking - Cursor position of each user should 
be tracked


Design:
Using observer design pattern to notify each user about their new position
in the document whenever the document is updated.

In the document, created a list of collaborators as well as observers
Whenever registering a collaborator, register an observer as well

Whenever state of the document is changed, notify other users that the state 
has been changed for their cursors.
-----------------------