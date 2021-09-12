package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.ThreadComment;
import com.revature.flash_back_api.services.ThreadCommentService;
import com.revature.flash_back_api.web.dtos.ThreadCommentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ThreadCommentController {
    //For creating new cards

    private ThreadCommentService ThreadCommentService;

    public ThreadCommentController(ThreadCommentService ThreadCommentService){
        this.ThreadCommentService = ThreadCommentService;
    }




    @PostMapping("/" )
    @ResponseStatus(HttpStatus.CREATED)
    public ThreadCommentDTO createNewComment(@RequestBody ThreadComment comment) {
        return new ThreadCommentDTO(ThreadCommentService.saveNewComment(comment));

    }


    @GetMapping(produces = "application/json",path = "/")
    public List<ThreadCommentDTO> getAllComments(){
        return ThreadCommentService.findAll();
    }

}