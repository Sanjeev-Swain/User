package com.example.User.service;

import com.example.User.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService implements IUserService {

    private static List<User> users=new ArrayList<>();

    private static int userCount=0;

    static
    {
        users.add(new User(++userCount,"abc","abcd",123,"one","two"));
        users.add(new User(++userCount,"abd","abce",124,"three","four"));
        users.add(new User(++userCount,"abe","abcf",125,"five","six"));
        users.add(new User(++userCount,"abf","abcg",126,"seven","eight"));
        users.add(new User(++userCount,"abg","abch",127,"nine","ten"));
    }
    @Override
    public List<User> findAll()
    {
        return users;
    }
    @Override
    public User findById(int id)
    {
        Predicate<? super User> predicate = user -> user.getId() == id;
        User user = users.stream().filter(predicate).findFirst().get();
        return user;
    }
    @Override
    public void addUser(User user)
    {
        users.add(user);
    }
    @Override
    public void deleteUser(int id)
    {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
    @Override
    public void updateUser(int id,User newUser)
    {
        User user = findById(id);
        user.setId(newUser.getId());
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPh_no(newUser.getPh_no());
        user.setDate(newUser.getDate());
        user.setTime(newUser.getTime());
    }

}
