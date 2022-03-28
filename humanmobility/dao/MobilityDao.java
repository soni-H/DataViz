package com.example.humanmobility.dao;

import com.example.humanmobility.pojo.PopulationResponse;

import java.util.List;

public interface MobilityDao {

public List<PopulationResponse> viewPopulationTimeSeries(String state,String fromDate,String toDate);
}
