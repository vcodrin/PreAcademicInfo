package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.model.Bracket;
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

    public void saveGroup(Bracket bracket, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            groupRepository.save(bracket);
        }
    }
}
