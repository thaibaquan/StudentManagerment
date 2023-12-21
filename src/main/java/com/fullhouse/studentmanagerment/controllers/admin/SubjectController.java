package com.fullhouse.studentmanagerment.controllers.admin;


import com.fullhouse.studentmanagerment.models.Organization;
import com.fullhouse.studentmanagerment.models.Subject;
import com.fullhouse.studentmanagerment.models.User;
import com.fullhouse.studentmanagerment.services.OrganizationService;
import com.fullhouse.studentmanagerment.services.SubjectService;
import com.fullhouse.studentmanagerment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("admin")
public class SubjectController {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @GetMapping("subject")
    public String showSubject(Model model){
        List<Organization> listO = organizationService.findAll();
        List<User> listU = userService.findAll();
        List<Object[]> list = subjectService.getSubjectDetails();
        model.addAttribute("listU",listU);
        model.addAttribute("listO",listO);
        model.addAttribute("list",list);
        return "subject-admin";
    }
    @PostMapping("addsubject")
    public String addSubject(@RequestParam("org") String id, @RequestParam("name") String name,
                         @RequestParam("teacher") String teacherId, Model model){
        Subject subject = new Subject();
        subject.setName(name);
        subject.setTeacherId(teacherId);
        subject.setOrganizationId(id);
        subjectService.save(subject);
        List<Organization> listO = organizationService.findAll();
        List<User> listU = userService.findAll();
        List<Object[]> list = subjectService.getSubjectDetails();
        model.addAttribute("listU",listU);
        model.addAttribute("listO",listO);
        model.addAttribute("list",list);
    return "redirect:/admin/subject";
    }

}
