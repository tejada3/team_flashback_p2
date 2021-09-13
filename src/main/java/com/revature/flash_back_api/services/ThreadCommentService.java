package com.revature.flash_back_api.services;


import com.revature.flash_back_api.models.documents.ThreadComment;
import com.revature.flash_back_api.models.repos.ThreadCommentRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.web.dtos.ThreadCommentDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThreadCommentService {

    private final ThreadCommentRepository ThreadCommentRepository;

    @Autowired
    ThreadCommentService(ThreadCommentRepository ThreadCommentRepository) {
        this.ThreadCommentRepository = ThreadCommentRepository;
    }

    public List<ThreadCommentDTO> findAll(String subforumId){
        return ThreadCommentRepository.findByThreadId(subforumId)
                .stream()
                .map(ThreadCommentDTO::new)
                .collect(Collectors.toList());
    }

    public ThreadComment saveNewComment(ThreadComment newComment) {
        System.out.println(newComment);
        if (!isCommentValid(newComment)) {
            throw new InvalidRequestException("Invalid Comment!");
        }

        System.out.println(newComment);
        return ThreadCommentRepository.save(newComment);

    }

    public boolean deleteAllByThreadId(String threadId) {
        ThreadCommentRepository.deleteByThreadId(threadId);
        return true;
    }

    //#TODO implement own validation checking
    public static boolean isCommentValid(ThreadComment comment) {
        System.out.println(comment);
        if ((comment == null) || comment.getContent() == ""){
            return false;
        } else {
            return true;
        }
    }
}

