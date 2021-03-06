package com.revature.flash_back_api.services;


import com.revature.flash_back_api.models.documents.ThreadComment;
import com.revature.flash_back_api.models.repos.ThreadCommentRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.web.dtos.ThreadCommentDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        if (!isCommentValid(newComment)) {
            throw new InvalidRequestException("Invalid Comment!");
        }
        newComment.setTimestamp(LocalDate.now());
        return ThreadCommentRepository.save(newComment);

    }

    public boolean deleteAllByThreadId(String threadId) {
        ThreadCommentRepository.deleteByThreadId(threadId);
        return true;
    }

    //#TODO implement own validation checking
    public boolean isCommentValid(ThreadComment comment) {
        if ((comment == null) || comment.getContent().trim().equals("")){
            return false;
        } else {
            return true;
        }
    }
}

