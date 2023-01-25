package org.ec;

import org.ec.proxy.MessageProxy;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {

    @RestClient
    MessageProxy proxy;

    @GET
    @Timeout(200)
//    @CircuitBreaker(
//	    requestVolumeThreshold = 4,
//	    failureRatio = 0.5,
//	    delay = 8000,
//	    successThreshold = 2
//    )
    @Retry(maxRetries = 1)
    @Fallback(fallbackMethod = "fallbackMessage")
    public String hello() {
        return proxy.get();
    }

    private String fallbackMessage() {
        return "Fallback Message";
    }
}