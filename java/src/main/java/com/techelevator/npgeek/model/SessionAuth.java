package com.techelevator.npgeek.model;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


	
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionAuth {

    public static final String USER_KEY = "appCurrentUser";
    
    private HttpSession session;
    private User user;
    
    public SessionAuth(HttpSession session) {
    	this.session = session;
    }
    
    public boolean isLoggedIn() {
        return session.getAttribute(USER_KEY) != null;
    }
    
    public boolean signIn(String username, String password) {
    	user = new User(username, password);
       
        session.setAttribute(USER_KEY, user);
        return true;   
    }
    
    public void logOff() {
        session.removeAttribute(USER_KEY);
        session.invalidate();
    }

}
