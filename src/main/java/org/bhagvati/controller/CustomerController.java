package org.bhagvati.controller;

import org.bhagvati.model.Customer;
import org.bhagvati.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/cust-info")
@ApplicationScoped
public class CustomerController {


    @Inject
    CustomerRepository customerRepository;

    @GET
    @Path("get/{id}")
    public Response getCustomer(@QueryParam("id")Integer id){
        Customer customer = customerRepository.findCustomer(id);
        return Response.ok(customer).build();
    }

    @PUT
    @Path("put")
    public Response putCustomer(Customer customer){
    customerRepository.editCustomer(customer);
    return Response.ok().build();
    }

    @POST
    @Path("post")
    public Response postCustomer(Customer customer){
        customerRepository.addCustomer(customer);
        return Response.ok().build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response detleteCustomer(@QueryParam("id")Integer id){
        customerRepository.removeCustomer(id);
        return Response.ok().build();
    }

}
