package lk.ijse.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String uid;
    private String email;
    private String given_name;
    private String middle_name;
    private String name;
    private String family_name;
    private String nickname;
    private String  phone_number;
    private String  comment;
    private String picture;
    private String  directory;
    private Object  metadata;
    private String  tags;
    private boolean is_suspended;
    private boolean is_bot;
}
