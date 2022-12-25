package com.scaler.splitwise.services;

import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(String name, List<User> participants, List<User> admins, User createdBy) {
        Group group = new Group();
        group.setName(name);
        group.setAdmins(admins);
        group.setParticipants(participants);
        group.setCreatedBy(createdBy);
        group.setCreatedAt(new Date());

        return groupRepository.save(group);
    }

}
