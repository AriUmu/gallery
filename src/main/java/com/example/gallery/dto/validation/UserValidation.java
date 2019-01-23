package com.example.gallery.dto.validation;

import com.example.gallery.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class UserValidation implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return UserDTO.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors errors) {
    //TODO add for all fields
      UserDTO userDTO = (UserDTO) obj;
      if(userDTO.getPassword().length() < 6){
        errors.rejectValue("password", "minLengthIs6");
      }
      if(userDTO.getName().isEmpty()){
        errors.rejectValue("name", "value.empty");
      }
  }
}
