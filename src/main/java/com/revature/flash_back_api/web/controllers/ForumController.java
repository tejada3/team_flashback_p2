package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.Subforum;
import com.revature.flash_back_api.models.documents.Threads;
import com.revature.flash_back_api.services.ForumService;
import com.revature.flash_back_api.web.dtos.SubforumDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping(path = "/get-subforum", produces = "application/json")
    public List<SubforumDTO> getAllSubforums() { return forumService.findAllSubforums(); }

    @PostMapping(path = "/create-subforum", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubforum(@RequestBody Subforum subforum) { forumService.saveNewSubforum(subforum); }

    @PostMapping(path = "/remove-subforum", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSubforum(@RequestBody Subforum subforum) { forumService.deleteOldSubforum(subforum.getId()); }

    @PostMapping(path="/get-threads", produces = "application/json", consumes = "application/json")
    public List<ThreadDTO> getThreadsBySubforumId(@RequestBody Threads subforumId) { return forumService.findAllThreads(subforumId.getSubforumId()); }

    @PostMapping(path = "/create-thread", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ThreadDTO createThread(@RequestBody Threads thread) {
        return new ThreadDTO(forumService.saveNewThread(thread));
    }

    @PostMapping(path = "/remove-thread", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteThread(@RequestBody Threads thread) {
        forumService.deleteOldThread(thread.getId());
    }


}
