package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.ThreadComment;
import com.revature.flash_back_api.services.ThreadCommentService;
import com.revature.flash_back_api.web.dtos.ThreadCommentDTO;
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

    //TODO find a way to get the correct mapping for specific thread
    @PostMapping("/comment" )
    @ResponseStatus(HttpStatus.CREATED)
    public ThreadCommentDTO createNewComment(@RequestBody ThreadComment comment) {
        return new ThreadCommentDTO(ThreadCommentService.saveNewComment(comment));

    }
}