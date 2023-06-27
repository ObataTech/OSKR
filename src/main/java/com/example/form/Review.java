package com.example.form;

import java.time.LocalDateTime;

public class Review {

	private String content;

	private Integer rate;

	private LocalDateTime posttime;

	private Long userId;

	private Long filmworkId;


    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return this.rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public LocalDateTime getPosttime() {
        return this.posttime;
    }
    public void setPosttime(LocalDateTime posttime) {
        this.posttime = posttime;
    }

    public Long getUserid() {
        return this.userId;
    }
    public void setUserid(Long userId) {
        this.userId = userId;
    }

    public Long getFilmworkid() {
        return this.filmworkId;
    }
    public void setFilmworkid(Long filmworkId) {
        this.filmworkId = filmworkId;
    }

}