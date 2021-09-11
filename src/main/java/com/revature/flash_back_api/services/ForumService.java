package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import com.revature.flash_back_api.web.dtos.SubforumDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumService {

    private final SubforumRepository subforumRepo;
    private final ThreadRepository threadRepo;

    @Autowired
    ForumService(SubforumRepository subforumRepo, ThreadRepository threadRepo) { this.subforumRepo = subforumRepo; this.threadRepo = threadRepo; }

    public List<SubforumDTO> findAllSubforums() {
        return subforumRepo.findAll()
                .stream()
                .map(SubforumDTO::new)
                .collect(Collectors.toList());
    }

    public List<ThreadDTO> findAllThreads(String subforumId) {
        return threadRepo.findThreadsBySubforumId(subforumId)
                .stream()
                .map(ThreadDTO::new)
                .collect(Collectors.toList());
    }
}
