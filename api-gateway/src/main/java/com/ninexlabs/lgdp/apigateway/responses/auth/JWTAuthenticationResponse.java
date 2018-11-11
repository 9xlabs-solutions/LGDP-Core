package com.ninexlabs.lgdp.apigateway.responses.auth;

import java.util.Date;

public class JWTAuthenticationResponse {

    private String accessToken;

    private String tokenType = "Bearer";

    private Date date = new Date();

    public JWTAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
