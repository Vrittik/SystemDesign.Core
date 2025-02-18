package systemDesign.Core.ProxyDesignPattern;

public class DataRepository implements IDataRepository{

	@Override
	public String add(String role, String data) throws Exception {
		return "added the data";
	}

	@Override
	public String remove(String role, int id) throws Exception {
		return "deleted the data";
	}

	@Override
	public Employee getData(String role, int id) throws Exception {
		Employee emp = new Employee();
		emp.id = 1;
		emp.name = "test";
		return emp;
	}

}
