package com.example.humanmobility.dao;

import com.example.humanmobility.pojo.FlowData;

import java.util.List;

public interface FlowDataConnection {
    public String getFlowConnectors(String state,String fromDate,String toDate);
}
