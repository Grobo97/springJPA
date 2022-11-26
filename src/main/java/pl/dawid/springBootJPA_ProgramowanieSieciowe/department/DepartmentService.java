package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAllDepartments(){
        return departmentRepository.findAll();
    };
    public Department findDepartmentManagedByUser(String firstName, String lastName){
        return departmentRepository.findByManager_FirstNameAndManager_LastName(firstName, lastName);
    };
    public Department findDepartmentWithMaxNumberOfEmployees(){
        return departmentRepository.findFirstByOrderByUsersDesc();
    };
    public Department findDepartmentWithMaxUsersSalary(){
        List<Department> departments = departmentRepository.findAll();
        float maxCost = 0f;
        Department depMax = null;
        for (Department dep : departments){
            if (dep.getDepartmentCost() > maxCost){
                maxCost = dep.getDepartmentCost();
                depMax = dep;
            }
        }
        return depMax;
    };
    public DepartmentDTO createOrUpdateDepartment(DepartmentDTO departmentDTO){
        Department department = departmentRepository.save(departmentDTO.toEntity());
        return departmentDTO.buildDTO(department);
    }

    public float getCompanyTax(float taxRate){
        List<Department> departments = departmentRepository.findAll();
        float maxCost = 0f;
        for (Department dep : departments){
                maxCost += dep.getDepartmentCost();
        }
        return maxCost*taxRate/100;
    };

    public float getDepartmentYearSalary(String name) {
        return departmentRepository.findFirstByName(name).getDepartmentCost()*12;
    }
}
