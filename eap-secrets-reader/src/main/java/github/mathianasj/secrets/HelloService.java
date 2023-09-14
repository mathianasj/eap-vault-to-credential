package github.mathianasj.secrets;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
    @Inject
    SecretsBean secretsBean;

    @GET
    public String hello() {
        return "Hello with password: " + secretsBean.getPassword();
    }
}