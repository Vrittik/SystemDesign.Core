package systemDesign.Core.ProxyDesignPattern;

public class DataRepositoryProxy implements IDataRepository{
	
	private DataRepository dataRepository;
	
	public DataRepositoryProxy() {
		dataRepository = new DataRepository();
	}
	
	@Override
	public String add(String role, String data) throws Exception {
		if(role == "ADMIN")
		{
			return dataRepository.add(role, data);
		}
		else {
			throw new Exception("Unauthorized");
		}
	}

	@Override
	public String remove(String role, int id) throws Exception {
		if(role == "ADMIN")
		{
			return dataRepository.remove(role, id);
		}
		else {
			throw new Exception("Unauthorized");
		}
	}

	@Override
	public Employee getData(String role, int id) throws Exception {
		if(role == "ADMIN" || role == "USER")
		{
			return dataRepository.getData(role, id);
		}
		else {
			throw new Exception("Unauthorized");
		}
	}
}
