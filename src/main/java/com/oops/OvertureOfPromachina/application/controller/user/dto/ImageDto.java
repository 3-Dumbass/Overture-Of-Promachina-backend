package com.oops.OvertureOfPromachina.application.controller.user.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ImageDto {

    private Long user_id;
    private String user_image_url;
}
