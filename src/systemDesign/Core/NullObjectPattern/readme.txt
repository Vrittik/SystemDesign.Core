Null object pattern		
------------------------

Objects can be null, and because of that this pattern is defined
			
		Vehicle car = null;
		// null pointer  exception
		System.out.println(car.getEngineHorsePower());
		// need to write if(car != null), has be to be done everywhere
		// which is not feasible, that's why return NULL object from
		// factory rather than creating object directly
		
It avoids != null check everywhere in the code as there can be many 
object creation and deletion

-A null object replaces a null return type
-No need to check if not equal null
-Null object always return default behaviour, for str return type
functions - return null
for int return type functions return 0.

-----------------------