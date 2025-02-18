package systemDesign.Core.ProxyDesignPattern;

public class ProxyDesignPattern{
	public static void main(String[] args)
	{
		IDataRepository dataRepository = new DataRepositoryProxy();
		
		try {
			var res = dataRepository.add("USER", "test");
		}
		catch(Exception ex)
		{
			// user is access restricted to perform this action
			System.out.println(ex.toString());
		}
		
		try {
			var res = dataRepository.add("ADMIN", "test");
			System.out.println(res);
		}
		catch(Exception ex)
		{
			// admin is authorized to perform this action
			System.out.println(ex.toString());
		}
	}
}
