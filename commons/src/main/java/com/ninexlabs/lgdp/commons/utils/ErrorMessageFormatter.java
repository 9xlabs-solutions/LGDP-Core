package com.ninexlabs.lgdp.commons.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessageFormatter
{
	
	public static List<String> getFormattedErrorMessage(Errors errors)
	{
		
		List<String> errorList = new ArrayList<>();
		
		for(ObjectError error: errors.getAllErrors())
		{
			
			String constructedError = error.getCode();
			
			if (error.getDefaultMessage() != null && constructedError != null)
			{
				constructedError.concat(" " + error.getDefaultMessage());
			}
			
			errorList.add(constructedError);
			
		}
		
		return errorList;
	}
	
}
