package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class NewContactDto {
    String address;
    String description;
    String email;
    String id; // always 0 need for API
    String lastName;
    String name;
    String phone;
}