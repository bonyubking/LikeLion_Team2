package com.exam;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class UserScope implements Scope {
	
	private final ThreadLocal<Map<String, Object>> userScope = ThreadLocal.withInitial(HashMap::new);

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map<String, Object> scope = userScope.get();
		
		return scope.computeIfAbsent(name,k -> objectFactory.getObject());
	}

	@Override
	public Object remove(String name) {
		Map<String, Object> scope = userScope.get();

		return scope.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConversationId() {

		return Thread.currentThread().getName();
	}

}
