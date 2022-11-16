package com.example.javaSpringBoot.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAllUserWithBorrowedBooks();
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    // public void lendBook(long bookId, long userId) throws NameNotFoundException {
    // Book book = bookRepository.getReferenceById(bookId);
    // User user = userRepository.getReferenceById(userId);
    // if (book == null && user == null) {
    // throw new NameNotFoundException("Book and/or User does not exist");
    // } else {
    // if (user != null) {
    // user.setBook(book);
    // userRepository.save(user);
    // }
    // }
    // }

}
