package com.ninexlabs.lgdp.commons.utils;

import com.ninexlabs.lgdp.commons.exceptions.ModelNotFoundException;

public class RestPreconditions
{
	
	public static <T> T checkFound(T resource) throws ModelNotFoundException
	{
		if (resource == null) {
			throw new ModelNotFoundException();
		}
		return resource;
	}
	
}
