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
        return appUserRepository.findAllUsers();
    }

    public AppUser findUser(String firstName, String lastName, String departmentName) {
        return appUserRepository.findUser(firstName, lastName, departmentName);
    }

    public List<AppUser> findUsersFromDepartment(String departmentName) {
        return appUserRepository.findUsersFromDepartment(departmentName);
    }

    public List<AppUser> findUsersWithPaymentIsHigher(float payment) {
        return appUserRepository.findUsersWithPaymentIsHigher(payment);
    }
}
