package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.ThreadComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ThreadCommentRepository extends MongoRepository<ThreadComment, String> {

    List<ThreadComment> findByThreadId(String threadId);
}
