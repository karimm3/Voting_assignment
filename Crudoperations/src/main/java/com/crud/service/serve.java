package com.crud.service;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ent.register;
import com.crud.respo.resgisterRespo;

@Service
public class serve {

	@Autowired
	private resgisterRespo respo;

	public void saver(register register) {
		// TODO Auto-generated method stub
		respo.save(register);
	}
	
	
	
}
