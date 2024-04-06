package com.example.application;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SignedUserHelper {

    /**
     * get user id of signed user from spring security context
     * @return user id of signed user
     */
    public static UserDetails user() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // try-catch is a workaround for handling user while running tests
        // it only gives ClassCastException when running tests
        try {

            return ((User) auth.getPrincipal());

        } catch (ClassCastException e) {
            return null;
        }

    }

    public static String userId() {
        return user().getUsername();
    }
}
