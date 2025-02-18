package systemDesign.Core.ProxyDesignPattern;

public interface IDataRepository {
	String add(String role, String data) throws Exception;
	String remove(String role, int id) throws Exception;
	Employee getData(String role, int id) throws Exception; 
}
