package quincaillerieuserservice.quincaillerieuserservice.Helper;

import quincaillerieuserservice.quincaillerieuserservice.Entity.User;
import quincaillerieuserservice.quincaillerieuserservice.Entity.UserDetail;
import quincaillerieuserservice.quincaillerieuserservice.dto.RegisterRequest;
import quincaillerieuserservice.quincaillerieuserservice.dto.UpdateRequest;
import quincaillerieuserservice.quincaillerieuserservice.dto.UserDetailDto;
import quincaillerieuserservice.quincaillerieuserservice.enums.Gender;

public class UserDetailsMapper {


    public static UserDetail registerToUserDetails(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .role("user")
                .build();
        return   UserDetail.builder()
                .user(user)
                .address(registerRequest.getAddress())
                .email(registerRequest.getEmailI())
                .nom(registerRequest.getNom())
                .prenom(registerRequest.getPrenom())
                .telephone(registerRequest.getTelephone())
                .dob(registerRequest.getDob())
                .gender(Gender.valueOf(registerRequest.getGender()))
                .build();
    }

    public static UserDetailDto userDetailsToDto(UserDetail userDetails){
        return   UserDetailDto.builder()
                .userId(userDetails.getUserDetailsId())
                .nom(userDetails.getNom())
                .prenom(userDetails.getPrenom())
                .role(userDetails.getUser().getRole())
                .email(userDetails.getEmail())
                .dob(userDetails.getDob())
                .gender(userDetails.getGender().toString())
                .telephone(userDetails.getTelephone())
                .build();
    }

    public static UserDetail updateRequestToUserDetails(UpdateRequest updateRequest) {
        return UserDetail.builder()
                .userDetailsId(updateRequest.getUserId())
                .nom(updateRequest.getNom())
                .prenom(updateRequest.getPrenom())
                .email(updateRequest.getEmail())
                .telephone(updateRequest.getTelephone())
                .gender(Gender.valueOf(updateRequest.getGender()))
                .dob(updateRequest.getDob())
                .build();

    }
}
