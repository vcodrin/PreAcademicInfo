package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.model.Group;
import com.example.preAcademicInfo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class GroupService {


    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void saveGroup(Group group, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            groupRepository.save(group);
        }
    }
}
