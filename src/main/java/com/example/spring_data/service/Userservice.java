package com.example.spring_data.service;

import com.example.spring_data.Dao.UserDao;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Dto.UserDto;
import com.example.spring_data.Repository.UserRepository;
import com.example.spring_data.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor

public class Userservice {

    private final UserRepository userRepository;

    public ResponseDto<List<UserDto>> getUser() {
        List<UserDao> userDaos = userRepository.findAll();
        if (userDaos.size() > 0) {
            List<UserDto> userDtos = new ArrayList<>();
            for (UserDao userDao : userDaos) {
                userDtos.add(UserMapping.toDto(userDao));
                return new ResponseDto<>(true, 0, "ok", userDtos);
            }
        }
        return new ResponseDto<>(false, -1, "xatolik", null);
    }

    public ResponseDto<UserDto> getById(Integer id) {
        Optional<UserDao> userDao = userRepository.findById(id);
        if(!userDao.isEmpty()){
            return new ResponseDto<>(true,0,"ok",UserMapping.toDto(userDao.get()));
        }
        return new ResponseDto<>(false,-1,"id topilmadi",UserMapping.toDto(userDao.get()));
    }

    public ResponseDto<UserDto> updateId(Integer id, String password) {
     UserDao userDao = userRepository.getById(id);
        if(userDao.getId() != null){
            userDao.setPassword(password);
            userRepository.save(userDao);
            return new ResponseDto<>(true,0,"update",UserMapping.toDto(userDao));
        }
        return new ResponseDto<>(false,-1,"id topilmadi",null);
    }

    public ResponseDto<UserDto> delete(Integer id) {
        Optional<UserDao> userDao = userRepository.findById(id);
        if(!userDao.isEmpty()){
            userRepository.delete(userDao.get());
            return new ResponseDto<>(true,0,"delete",UserMapping.toDto(userDao.get()));
        }
        return new ResponseDto<>(false,-1,"xatolik",null);
    }

    public ResponseDto<UserDto> addUser(UserDto userDto) {
        UserDao userDao = UserMapping.toDao(userDto);
        Pattern pattern = Pattern.compile("\\+998 [[3][7-9]][0-9] [0-9]{3} [0-9]{2} [0-9]{2}");
        if(pattern.matcher(userDao.getPhonenumber()).matches()) {
            List<UserDao> userDaos = userRepository.findAll();
            int son = userDaos.size();
            for (UserDao userDao1 : userDaos) {
                if (userDao.getUsername() != userDao1.getUsername()) {
                    son--;
                }
                if (son == 0) {
                    userRepository.save(userDao);
                    return new ResponseDto<>(true, 0, "ok", userDto);
                }
                return new ResponseDto<>(false, -1, "Bunday username mavjud", userDto);
            }
        }
        return new ResponseDto<>(false,-1," nomerni +998 33 998 08 16 korinishida kiriting",userDto);
    }
}
