package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.ThreadComment;
import com.revature.flash_back_api.models.documents.Threads;
import com.revature.flash_back_api.services.ThreadCommentService;
import com.revature.flash_back_api.web.dtos.ThreadCommentDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/threads")
public class ThreadCommentController {
    //For creating new comments

    private ThreadCommentService ThreadCommentService;

    public ThreadCommentController(ThreadCommentService ThreadCommentService){
        this.ThreadCommentService = ThreadCommentService;
    }

    @PostMapping("/comment" )
    @ResponseStatus(HttpStatus.CREATED)
    public ThreadCommentDTO createNewComment(@RequestBody ThreadComment comment) {
        return new ThreadCommentDTO(ThreadCommentService.saveNewComment(comment));

    }

    @PostMapping(path="/get-comments", produces = "application/json", consumes = "application/json")
    public List<ThreadCommentDTO> getThreadById(@RequestBody ThreadComment threadId) { return ThreadCommentService.findAll(threadId.getThreadId()); }

    @PostMapping(path="/remove-comment", produces="application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@RequestBody ThreadComment comment) {
        ThreadCommentService.deleteById(comment.getId());
    }
}