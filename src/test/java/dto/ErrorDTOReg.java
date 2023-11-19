package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ErrorDTOReg {
    String timestamp;
    int status;
    String error;
    Object message;
    String path;
}