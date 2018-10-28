package com.ninexlabs.lgdp.commons.exceptions;

public class ModelNotFoundException extends Exception
{
	@Override
	public String getMessage()
	{
		return "MODEL_NOT_FOUND";
	}
}
