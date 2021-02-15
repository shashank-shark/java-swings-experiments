import model.AgeCategory;
import model.Database;
import model.EmployeeCategory;
import model.Gender;
import model.Person;

public class TestDatabase {
	
	public static void main(String[] args) {
		System.out.println("Running Database Tests");
		Database db = new Database();
		try {
			db.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		db.addPerson(new Person("Shashank J","Software Engineer", AgeCategory.adult, EmployeeCategory.employed, Gender.male, "IDAU021", true));
		db.addPerson(new Person("Shashank J","Software Engineer", AgeCategory.adult, EmployeeCategory.employed, Gender.male, null, false));
		
		db.save();
		db.disconnect();
	}
}
