package sezun.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import sezun.work.domain.Admin;
import sezun.work.service.AdminService;

@Controller
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/signup")
    public String signup(){
        return "Admin/SignupForm";}

    @PostMapping(value = "/signup")
    public String register(AdminForm form, BindingResult bindingResult){
        Admin admin = new Admin();
        admin.setUserName(form.getUserName());
        if(!form.getPassword1().equals(form.getPassword2())){
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "패스워드 불일치");
            return "Admin/SignupForm";
        }
        admin.setPassword(form.getPassword1());
        adminService.register(admin);
        return "redirect:/";
    }
}
