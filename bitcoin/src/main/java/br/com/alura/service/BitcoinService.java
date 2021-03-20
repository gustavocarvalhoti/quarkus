package br.com.alura.service;

import br.com.alura.model.Bitcoin;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * configKey = "bitcoin-api" <- Utilizada no application.properties
 * @Path("/bitcoins") <- Da API que vou chamar - https://alura-bitcoin.herokuapp.com/bitcoins
 */
@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
public interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar();
}