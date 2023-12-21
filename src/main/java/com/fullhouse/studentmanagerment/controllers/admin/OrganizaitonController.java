package com.fullhouse.studentmanagerment.controllers.admin;

import com.fullhouse.studentmanagerment.common.constants.OrganizationType;
import com.fullhouse.studentmanagerment.models.Organization;
import com.fullhouse.studentmanagerment.models.User;
import com.fullhouse.studentmanagerment.services.OrganizationService;
import com.fullhouse.studentmanagerment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class OrganizaitonController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;
    @GetMapping("/organization")
    public String showOrg(Model model){
        List<User> userList = userService.findUsersWithoutRelations();
        model.addAttribute("userList", userList);
        List<Organization> listO = organizationService.findAll();
        model.addAttribute("listO",listO);
        return "organization-admin";
    }
    @PostMapping("/addorganization")
    public String addOrg(@RequestParam("head_of_org") String id, @RequestParam("name") String name,
                         Model model){
        Organization organization = new Organization();
        organization.setName(name);
        organization.setHeadOfOrg(id);
//        organization.setOrgType(OrganizationType.valueOf(orgType));
        organizationService.save(organization);
        List<User> userList = userService.findUsersWithoutRelations();
        model.addAttribute("userList", userList);
        List<Organization> listO = organizationService.findAll();
        model.addAttribute("listO",listO);
        List<Object[]> listOU = organizationService.findUserNameEmailAndOrgType();
        model.addAttribute("listOU",listOU);
        return "redirect:/admin/organization";
    }

    @GetMapping("/organization-parent/{orgId}")
    public String showOrgParent(@PathVariable("orgId") String id,Model model){
        List<Organization> listOrg = organizationService.findOrganizationById(id);
        List<User> userList = userService.findUsersWithoutRelations();
        model.addAttribute("userList", userList);
        model.addAttribute("listOrg",listOrg);
        return "organization-parent-admin";
    }
    @PostMapping("/addorgparent")
    public String addOrgParent(@RequestParam("name") String parentName,@RequestParam("head_of_org") String hId,
                               @RequestParam("org") String orgId,
                                Model model){
        Organization organization = new Organization();
        organization.setId(orgId);
        organization.setParentName(parentName);
        organization.setName("Sở giáo dục và đào tạo TP Nghệ An");
        organization.setHeadOfOrg(hId);
        organizationService.save(organization);
        List<User> userList = userService.findUsersWithoutRelations();
        model.addAttribute("userList", userList);
        return "redirect:/admin/organization-parent/{orgId}";
    }
}
