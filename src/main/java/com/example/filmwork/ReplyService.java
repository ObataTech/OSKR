package com.example.filmwork;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Reply;
import com.example.login.LoginUser;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public List<Reply> findReplies(Long id) {
    	return this.replyRepository.findReplies(id);
    }

    // リプライ保存用のメソッドです
    public Reply save(FilmworkForm filmworkForm, LoginUser loginUser) {
        // Entityクラスのインスタンスを生成します
        Reply reply = new Reply();
        // フィールドのセットを行います
        reply.setContent(filmworkForm.getReplyContent());
        LocalDateTime now = LocalDateTime.now();
        reply.setPosttime(now);
//        reply.setReviewId(1L);
        reply.setReviewId(filmworkForm.getReviewId());
        if(loginUser.getUser() != null) {
        	reply.setUserId(loginUser.getUser().getId());
        }
        else {
        	reply.setUserId(1L);
        }
        // repository.saveメソッドを利用してデータの保存を行います
        return this.replyRepository.save(reply);
    }
}

