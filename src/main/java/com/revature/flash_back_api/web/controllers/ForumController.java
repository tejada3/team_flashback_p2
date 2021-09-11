package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.services.ForumService;
import com.revature.flash_back_api.web.dtos.SubforumDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    private ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping(path = "/get-subforum", produces = "application/json")
    public List<SubforumDTO> getAllSubforums() { return forumService.findAllSubforums(); }

    @PostMapping(path="/get-threads", produces = "application/json", consumes = "application/json")
    public List<ThreadDTO> getThreadsBySubforumId(@RequestBody String subforumId) { return forumService.findAllThreads(subforumId); }
}
