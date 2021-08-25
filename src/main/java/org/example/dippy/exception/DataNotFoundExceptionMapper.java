package org.example.dippy.exception;

import org.example.dippy.models.Error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {


    @Override
    public Response toResponse(DataNotFoundException e) {
        Error error = new Error(e.getMessage(),1111,"Something Wrong");
        return Response.status(Response.Status.NOT_FOUND)
                        .entity(error)
                        .build();
    }
}
