package com.example.humanmobility;

import com.example.humanmobility.dao.impl.FlowDataImpl;
import com.example.humanmobility.dao.impl.FlowMatrixImpl;
import com.example.humanmobility.dao.impl.HierariachalFlowImpl;
import com.example.humanmobility.dao.impl.MobilityDaoImpl;
import com.example.humanmobility.pojo.PopulationResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/mobility")
public class Controller {

    @GET
    @Path("/viewByDefault")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PopulationResponse> getDefaultView(@QueryParam("state") String state,@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate){
        List<PopulationResponse> responses=null;
        try{
            responses=new MobilityDaoImpl().viewPopulationTimeSeries(state,fromDate,toDate);
        }catch(Exception e){
            e.printStackTrace();
        }
        return responses;
    }

    @GET
    @Path("/viewHierariachalFlow")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSunburstView(@QueryParam("state") String state,@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate){
        String response=null;
        try{
            response=new HierariachalFlowImpl().viewHierariachalFlow(state,fromDate,toDate);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @GET
    @Path("/viewFlowMap")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlowMapView(@QueryParam("state") String state,@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate){
        String response=null;
        try{
            response=new FlowDataImpl().getFlowConnectors(state,fromDate,toDate);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
    @GET
    @Path("/viewMatrixMap")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMatrixMapView(@QueryParam("state") String state,@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate){
        String response=null;
        try{
            response=new FlowMatrixImpl().getFlowMatrix(state,fromDate,toDate);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

}
