package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.Subforum;
import com.revature.flash_back_api.models.documents.Threads;
import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.web.dtos.SubforumDTO;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Subforum saveNewSubforum(Subforum subforum) {
        System.out.println(subforum);
        if (!isSubforumValid(subforum)) {
            throw new InvalidRequestException("Invalid Subforum provided!");
        }
        return subforumRepo.save(subforum);
    }

    public void deleteOldSubforum(String subforumId) {
        if(!subforumId.trim().equals("")) {
            List<ThreadDTO> threadList;
            threadList = findAllThreads(subforumId);
            if (threadList.size() > 0) {
                for (ThreadDTO thread : threadList) {
                    deleteOldThread(thread.getId());
                }
                System.out.println("All Subforums successfully deleted! Good work!");
            } else {
                System.out.println("Subforum has no associated threads! Deleting subforum...");
            }

            subforumRepo.deleteById(subforumId);

        } else {
            throw new InvalidRequestException("That subforumId is null!");
        }
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


    public boolean isSubforumValid(Subforum subforum) {
        System.out.println(subforum);
        return (subforum != null) &&
                (subforum.getSubforumTitle() != null) && !subforum.getSubforumTitle().trim().equals("") &&
                (subforum.getThreadCount() >= 0) && (subforum.getId() == null);
    }

    //TODO Implement proper validation checking for threads!
    public boolean isThreadValid(Threads thread) {
        System.out.println(thread);
        return (thread != null) &&
                (thread.getThreadTitle() != null && !thread.getThreadTitle().trim().equals("")) &&
                (thread.getThreadContent() != null && !thread.getThreadContent().trim().equals("")) &&
                (thread.getUserId() != null);
    }
}
