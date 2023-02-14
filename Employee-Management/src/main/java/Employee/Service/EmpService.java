package Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Employee.Model.Employee;
import Employee.Repositery.EmployeeRepo;

@Service
public class EmpService {

	@Autowired
	private EmployeeRepo eRepo;
	
	public void addEmployee(Employee emp) {
		eRepo.save(emp);
	}
	
	public List<Employee> getAllEmployeeDetails() {
		return eRepo.findAll();
	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> e = eRepo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmployeeById(int id) {
		eRepo.deleteById(id);
	}

	public Page<Employee> getEmployeeByPaginate(int currentPage, int size) {
		Pageable page = PageRequest.of(currentPage, size);
		return eRepo.findAll(page);
	}

	
}
