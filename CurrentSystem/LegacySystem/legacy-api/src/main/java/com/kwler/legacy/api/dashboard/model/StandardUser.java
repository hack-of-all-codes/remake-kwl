package com.kwler.legacy.api.dashboard.model;

import com.kwler.legacy.api.masterdata.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user")
@NoArgsConstructor @AllArgsConstructor
public class StandardUser {

    @Id
    String id;

    UserAccount userAccount;
    UserProfile userProfile;

    @Data @NoArgsConstructor
    public static class UserAccount {

        String hashedPassword;
        List<PersistentToken> persistentTokens;
        List<Role> roles;
        String passwordResetCode;
        Long passwordResetCodeExpiry;
        Type type;

        @Data @NoArgsConstructor
        public class Role {
            RoleName roleName;
        }

        @Data @NoArgsConstructor
        public class PersistentToken {
            String id;
            Long expiry;
        }

        enum Type {
            STANDARD, INTERNAL
        }

        enum RoleName {
            ADMIN, SELF, DEFAULT, SERVER
        }
    }

    @Data @NoArgsConstructor
    public static class UserProfile {
        String fullName;
        String email;
        String name;
        Gender gender;
        Country country;
        List<String> recentlyViewedArtists;
        String facebookId;
        String linkedInId;
        String customerId;
        List<String> viewedReleaseUpdate = new ArrayList<>();
        Boolean enabled;
        Boolean onBoarded = false;
        Boolean needsVerification;
        String verificationCode;
        Long verificationCodeExpiry;
        String industryRole;

        enum Gender {
            M, F
        }
    }
}
