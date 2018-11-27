package com.ninexlabs.lgdp.commons.exceptions;

import com.ninexlabs.lgdp.commons.LGDPException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        return (response.getStatusCode().series() == CLIENT_ERROR
                || response.getStatusCode().series() == SERVER_ERROR);

    }

    @Override
    public void handleError(ClientHttpResponse response) {
        String error = response.getHeaders().get("error-description").toString();

        throw new LGDPException(LGDPException.ExceptionType.INVALID_DATA_EXCEPTION, error);
    }
}
