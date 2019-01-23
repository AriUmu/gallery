package com.example.gallery.validationTest;

import com.example.gallery.domain.User;
import com.example.gallery.dto.ProfileDTO;
import com.example.gallery.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import java.sql.Timestamp;

@SpringBootTest
public class ModelMapperTest {

  @Test
  public void getMappertTest(){
    ModelMapper modelMapper = new ModelMapper();
    UserDTO userDTO = new UserDTO();
    userDTO.setId(123456789L);
    userDTO.setLogin("UserDTO");
    userDTO.setPassword("1");
    userDTO.setLastLoginTime(new Timestamp(1984332234));
    userDTO.setSessionId(2345566L);
    userDTO.setName("Lukas");
    userDTO.setProfile(new ProfileDTO());

    User user = modelMapper.map(userDTO, User.class);
    Assert.assertEquals("UserDTO", user.getLogin());
  }
}
