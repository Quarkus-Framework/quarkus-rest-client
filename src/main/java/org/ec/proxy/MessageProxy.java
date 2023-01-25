package org.ec.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("message")
@RegisterRestClient
public interface MessageProxy {

    @GET
    String get();
}
