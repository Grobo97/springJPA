package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping()
    public List<Department> findAllDepartments(){
        return departmentService.findAllDepartments();
    };
    @GetMapping("/find")
    public Department findDepartmentManagedByUser(@RequestParam(name = "firstName") String firstName,
                                                  @RequestParam(name = "lastName") String lastName){
        return departmentService.findDepartmentManagedByUser(firstName, lastName);
    };
    @GetMapping("/findByMaxEmployees")
    public Department findDepartmentWithMaxNumberOfEmployees(){
        return departmentService.findDepartmentWithMaxNumberOfEmployees();
    };
    @GetMapping("/findByMaxSalary")
    public Department findDepartmentWithMaxUsersSalary(){
        return departmentService.findDepartmentWithMaxUsersSalary();
    };

    @GetMapping("/getDepartmentYearSalary")
    public float getDepartmentYearSalary(@RequestParam(value = "departmentName") String departmentName){
        return departmentService.getDepartmentYearSalary(departmentName);
    };

    @GetMapping("/getCompanyTax")
    public float getCompanyTax(@RequestParam(value= "taxRate") float taxRate){
        return departmentService.getCompanyTax(taxRate);
    }

    @PostMapping
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.createOrUpdateDepartment(departmentDTO);
    }

    @PostMapping("/update")
    public DepartmentDTO updateDepartment(@RequestParam(name="id") Long id, @RequestBody DepartmentDTO departmentDTO){
        departmentDTO.setId(id);
        return departmentService.createOrUpdateDepartment(departmentDTO);
    }

}
