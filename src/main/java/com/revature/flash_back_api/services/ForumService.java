package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.web.dtos.SubforumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumService {

    private final SubforumRepository subforumRepo;

    @Autowired
    ForumService(SubforumRepository subforumRepo) { this.subforumRepo = subforumRepo; }

    public List<SubforumDTO> findAllSubforums() {
        return subforumRepo.findAll()
                .stream()
                .map(SubforumDTO::new)
                .collect(Collectors.toList());
    }
}
