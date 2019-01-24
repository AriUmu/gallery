package com.example.gallery.validationTest;

import com.example.gallery.domain.Profile;
import com.example.gallery.domain.User;
import com.example.gallery.dto.ProfileDTO;
import com.example.gallery.dto.UserDTO;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ModelMapperTest {

  @Test
  public void getMapperTest(){
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

  @Test
  public void mapperListTest(){
    List<User> listUsers =new ArrayList<>();
    User user = new User();
    user.setId(123456789L);
    user.setLogin("UserDTO");
    user.setPassword("1");
    user.setLastLoginTime(new Timestamp(1984332234));
    user.setSessionId(2345566L);
    user.setName("Lukas");
    user.setProfile(new Profile());

    listUsers.add(user);
    listUsers.add(user);

    ModelMapper modelMapper = new ModelMapper();

    Type type = new TypeToken<List<UserDTO>>() {
    }.getType();

    ArrayList<UserDTO> map = modelMapper.map(listUsers, type);
    System.out.println( map.get(0).getName());
    System.out.println( map.get(0).getLogin());

    Assert.assertEquals("Lukas", map.get(0).getName());
  }
}
