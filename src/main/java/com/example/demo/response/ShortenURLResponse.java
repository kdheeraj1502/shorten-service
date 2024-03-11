package com.example.demo.response;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShortenURLResponse {
    private String shortURL;
    private String status;
    private int errorCode;

}
