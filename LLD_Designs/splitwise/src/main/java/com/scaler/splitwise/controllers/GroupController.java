package com.scaler.splitwise.controllers;

import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public Group createGroup(String name, List<User> participants, List<User> admins, User createdBy) {
        return groupService.createGroup(name, participants, admins, createdBy);
    }
}
