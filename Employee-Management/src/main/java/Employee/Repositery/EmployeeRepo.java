package Employee.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Employee.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
