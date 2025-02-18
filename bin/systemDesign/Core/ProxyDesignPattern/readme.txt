Proxy design pattern	
------------------------

Problem ->
----------
Whenever direct calls to a resource is to be avoided, the call should be
done through a middleware.
So that the middleware can handle
1. Preprocessing and post processing of the request
2. Caching of certain data
3. Access Restriction


Pattern ->
----------
In this small example, we define a repository which has certain methods
for adding, deleting and getting the data.

such that
Only ADMIN role is allowed to add data
Only ADMIN role is allowed to remove data
only USER AND ADMIN can get the data.

In this, we define an interface for the repository and we implements that
interface using a proxy class as well.

and that proxy class has a repository object to call the actual implementation.

i.e - Proxy class "is a" implementation of the interface and "has a" dependency of the actual repository.
-----------------------