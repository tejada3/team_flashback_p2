package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.services.ForumService;
import com.revature.flash_back_api.web.dtos.SubforumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
