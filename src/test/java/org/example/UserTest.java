package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UserTest {
    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("login", "login@mail.com"));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void UserConstructor(String login, String email) {
        User user = new User(login, email);
        Assertions.assertEquals(login, user.getLogin());
        Assertions.assertEquals(email, user.getEmail());
    }

    @Test
    public void UserNoConstructor() {
        User user = new User();
        Assertions.assertNotNull(user);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void userEmailTest(String login, String email) {
        User user = new User(login, email);
        boolean condition = user.getEmail().contains("@") || user.getEmail().contains(".");
        Assertions.assertTrue(condition);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void userLoginEqualsEmail(String login, String email) {
        User user = new User(login, email);
        Assertions.assertNotEquals(user.getLogin(), user.getEmail());
    }
}