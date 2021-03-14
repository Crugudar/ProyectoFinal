package com.ironhack.userservice.service.interfaces;

import com.ironhack.userservice.controller.dtos.*;


import java.util.*;

public interface IUserService {


    UserDTO getUserByUserName(String userName);
}
