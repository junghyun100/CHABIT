package backend.domain.review;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ReviewDto {
    private Long reviewId;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private int coolCount;
    private boolean pressCool;
    private int commentCount;
    private Long userId;
    private Long challengeId;
    private List<String> reviewImages = new ArrayList<>();

    public ReviewDto(Review review){
        this.reviewId = review.getReviewId();
        this.reviewContent = review.getReviewContent();
        this.reviewDate = review.getReviewDate();
        this.coolCount = review.getCoolCount();
        this.commentCount = review.getCommentCount();
        this.userId = review.getUserId().getUserId();
        this.challengeId = review.getChallengeId().getChallengeId();
    }

    public void addReviewImage(ReviewImage reviewImage){
        this.reviewImages.add(reviewImage.getReviewImage());
    }

    public void setPressCool(boolean pressCool) {
        this.pressCool = pressCool;
    }
}