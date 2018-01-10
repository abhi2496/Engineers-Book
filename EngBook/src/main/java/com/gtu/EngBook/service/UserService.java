package com.gtu.EngBook.service;

import com.gtu.EngBook.model.StudentModel;
import com.gtu.EngBook.model.UserModel;
import com.gtu.EngBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean studentRegister(StudentModel st)
    {
        //userRepository.find()
        return false;
    }

    public boolean login(UserModel st)
    {

       // String enroll = st.getEmail();
       // String pass = st.getPassword();

        userRepository.findOne();

        if(enroll.equals("140410107024"))
        {
            if(pass.equals("abhishek"))
            {
                st.setLogin_status(true);
            }
            else
            {
                st.setLogin_status(false);
            }
        }
        else
        {
            st.setLogin_status(false);
        }
        return false;
    }
}
