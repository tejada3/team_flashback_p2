package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.Threads;
import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import com.revature.flash_back_api.util.exceptions.DataSourceException;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
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
    private final ThreadCommentService commentService;

    @Autowired
    ForumService(SubforumRepository subforumRepo, ThreadRepository threadRepo, ThreadCommentService commentService) { this.subforumRepo = subforumRepo; this.threadRepo = threadRepo; this.commentService = commentService; }

    public List<SubforumDTO> findAllSubforums() {
        return subforumRepo.findAll()
                .stream()
                .map(SubforumDTO::new)
                .collect(Collectors.toList());
    }

    public List<ThreadDTO> findAllThreads(String subforumId) {
        return threadRepo.findBySubforumId(subforumId)
                .stream()
                .map(ThreadDTO::new)
                .collect(Collectors.toList());
    }

    public Threads saveNewThread(Threads newThread) {
        System.out.println(newThread);
        if (!isThreadValid(newThread)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }
        return threadRepo.save(newThread);
    }

    public void deleteOldThread(String threadId) {
        if(commentService.deleteAllByThreadId(threadId)) {
            threadRepo.deleteById(threadId);
        } else {
            System.out.println("Deletion of all thread comments failed! aborting request...");
        }
    }

    //TODO Implement proper validation checking for threads!
    public static boolean isThreadValid(Threads thread) {
        System.out.println(thread);
        if ((thread == null) ||
                (thread.getThreadTitle() == null || thread.getThreadTitle().trim().equals("")) ||
                (thread.getThreadContent() == null || thread.getThreadContent().trim().equals("")) ||
                (thread.getUserId() == null)) {
            return false;
        } else {
            return true;
        }
    }
}
