package com.crud.respo;

import org.springframework.data.repository.CrudRepository;

import com.crud.ent.register;
import java.util.List;


public interface resgisterRespo extends CrudRepository<register, Integer> {

	 register findByUserName(String userName);

}
