package com.fullhouse.studentmanagerment.controllers.admin;

import com.fullhouse.studentmanagerment.models.Subject;
import com.fullhouse.studentmanagerment.models.User;
import com.fullhouse.studentmanagerment.models.UserSubject;
import com.fullhouse.studentmanagerment.services.SubjectService;
import com.fullhouse.studentmanagerment.services.UserService;
import com.fullhouse.studentmanagerment.services.UserSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserSubjectController {
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UserSubjectService userSubjectService;
    @GetMapping("/usersubject")
    public String showUserSubject(Model model){
        List<User> listU = userService.findAll();
        List<Subject> listS = subjectService.findAll();
        List<Object[]> listUS = userSubjectService.getSubjectDetails();
        model.addAttribute("listU",listU);
        model.addAttribute("listS",listS);
        model.addAttribute("listUS",listUS);
        return "user-subject-admin";
    }
    @PostMapping("/addusersubject")
    public String addUserSubject(@RequestParam("score") Double score, @RequestParam("subject") String subjectId,
                                 @RequestParam("student") String studentId, Model model){

        UserSubject userSubject = new UserSubject();
        userSubject.setScore(score);
        userSubject.setSubjectId(subjectId);
        userSubject.setUserId(studentId);
        userSubjectService.save(userSubject);
        List<User> listU = userService.findAll();
        List<Subject> listS = subjectService.findAll();
        List<Object[]> listUS = userSubjectService.getSubjectDetails();
        model.addAttribute("listU",listU);
        model.addAttribute("listS",listS);
        model.addAttribute("listUS",listUS);
        return "redirect:/admin/usersubject";
    }
}
