package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ErrorDTO {
    String timestamp;
    int status;
    String error;
    String message;
    String path;
}