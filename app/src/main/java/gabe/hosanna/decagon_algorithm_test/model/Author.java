package gabe.hosanna.decagon_algorithm_test.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Author: Hosanna Gabe-Oji
 * Project: Decagon_Algorithm_Test
 * Date: 6/10/2020
 */
public class Author {

    private long id;
    private String username;
    private int submitted;
    @SerializedName("submission_count")
    private int submissionCount;
    @SerializedName("comment_count")
    private int commentCount;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
    private String about;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSubmitted() {
        return submitted;
    }

    public void setSubmitted(int submitted) {
        this.submitted = submitted;
    }

    public int getSubmissionCount() {
        return submissionCount;
    }

    public void setSubmissionCount(int submissionCount) {
        this.submissionCount = submissionCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
