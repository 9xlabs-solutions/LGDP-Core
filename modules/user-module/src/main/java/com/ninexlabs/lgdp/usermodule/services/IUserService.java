package com.ninexlabs.lgdp.usermodule.services;

import com.ninexlabs.lgdp.commons.models.UserModelDetails;

public interface IUserService
{
	
	Iterable<UserModelDetails> all();
	
	UserModelDetails get(long id);
	
	UserModelDetails store(UserModelDetails user);
	
	UserModelDetails update(UserModelDetails user);
	
	void delete(long id);

}
