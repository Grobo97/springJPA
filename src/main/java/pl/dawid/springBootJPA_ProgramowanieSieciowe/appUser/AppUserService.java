package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    @Autowired
    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser findUser(String firstName, String lastName, String departmentName) {
        return appUserRepository.findAllByFirstNameAndLastNameAndDepartmentName(firstName, lastName, departmentName);
    }

    public List<AppUser> findUsersFromDepartment(String departmentName) {
        return appUserRepository.findByDepartmentName(departmentName);
    }

    public List<AppUser> findUsersWithPaymentIsHigher(float payment) {
        return appUserRepository.findByPaymentGreaterThan(payment);
    }

    public AppUserDTO createOrUpdateUser(AppUserDTO appUserDTO) {
        AppUser appUser = appUserRepository.save(appUserDTO.toEntity());
        return appUserDTO.buildDTO(appUser);
    }


    public float getUserYearlySalary(String lastName) {
        AppUser appUser = appUserRepository.findFirstByLastName(lastName);
        float monthlySalary = appUser.getPayment() + appUser.getBonus();
        return monthlySalary * 12;
    }
}
