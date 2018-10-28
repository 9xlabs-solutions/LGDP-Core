package com.ninexlabs.lgdp.usermodule.controllers;

import com.ninexlabs.lgdp.usermodule.Version;
import com.ninexlabs.lgdp.usermodule.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api/users")
public class VersionController
{
	
	private VersionService versionService;
	
	@Autowired
	public VersionController(VersionService versionService)
	{
		this.versionService = versionService;
	}
	
	/**
	 * Get the version information of the module
	 *
	 * @return Version
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/version")
	public Version index()
	{
		return this.versionService.getVersion();
	}
}
