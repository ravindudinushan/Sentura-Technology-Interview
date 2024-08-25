package lk.ijse.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        @Id
        private String uid;
        private String email;
        private String given_name;
        private String middle_name;
        private String name;
        private String family_name;
        private String nickname;
        private String  phone_number;
        private String  comment;
        @Column(columnDefinition = "LONGTEXT")
        private String picture;
        private String  directory;
        private String  metadata;
        private String  tags;
        private boolean is_suspended;
        private boolean is_bot;
}
