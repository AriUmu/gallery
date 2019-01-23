package com.example.gallery.validationTest;

import com.example.gallery.dto.ProfileDTO;
import com.example.gallery.dto.UserDTO;
import com.example.gallery.dto.validation.UserValidation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.DataBinder;

import java.sql.Timestamp;

@SpringBootTest
public class ValidationTest {

  private static final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

  static {
    messageSource.setBasename("message");
  }

  UserValidation userValidation;

  @Test
  public void validationUserDAOTestFalse() {
    userValidation = new UserValidation();

    UserDTO userDTO = new UserDTO();
    userDTO.setId(123456789L);
    userDTO.setLogin("UserDTO");
    userDTO.setPassword("1");
    userDTO.setLastLoginTime(new Timestamp(1984332234));
    userDTO.setSessionId(2345566L);
    userDTO.setName("Lukas");
    userDTO.setProfile(new ProfileDTO());
    final DataBinder dataBinder = new DataBinder(userDTO);
    dataBinder.addValidators(userValidation);
    dataBinder.validate();

    Assert.assertTrue(dataBinder.getBindingResult().hasErrors());

//    if (dataBinder.getBindingResult().hasErrors()) {
//      dataBinder.getBindingResult().getAllErrors().stream().
//              forEach(e -> System.out.println(messageSource.getMessage(e, new Locale("ru"))));
//    }

  }

  @Test
  public void validationUserDAOTestTrue() {
    userValidation = new UserValidation();
    UserDTO userDTO = new UserDTO();
    userDTO.setId(123456789L);
    userDTO.setLogin("UserDTO");
    userDTO.setPassword("1234567");
    userDTO.setLastLoginTime(new Timestamp(1984332234));
    userDTO.setSessionId(2345566L);
    userDTO.setName("Lukas");
    userDTO.setProfile(new ProfileDTO());

    final DataBinder dataBinder = new DataBinder(userDTO);
    dataBinder.addValidators(userValidation);
    dataBinder.validate();
    Assert.assertFalse(dataBinder.getBindingResult().hasErrors());
  }
}
