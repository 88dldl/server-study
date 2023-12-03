package umc.spring.converter;


import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;


public class StoreConverter {
    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }
    public static StoreResponseDTO.CreateReviewDTO toCreateReviewDTO(Review review){
        return StoreResponseDTO.CreateReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(StoreRequestDTO.JoinDTO request){
        return Store.builder()
                .name(request.getTitle())
                .address(request.getAddress())
                .build();
    }
    public static StoreResponseDTO.JoinStoreDTO toCreateStoreDTO(Store store){
        return StoreResponseDTO.JoinStoreDTO.builder()
                .storeId(store.getId())
                .build();
    }

}
