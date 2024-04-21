package com.todo.auth.services;

public class UserContext {
	private static ThreadLocal<Long> USER_ID = new ThreadLocal<Long>();
	
	public static Long getId() {
		return USER_ID.get();
	}
	
	public static void setId(Long id) {
		USER_ID.set(id);
	}
	
	public static void clear() {
		USER_ID.remove();
	}
}
