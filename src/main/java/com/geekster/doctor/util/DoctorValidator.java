package com.geekster.doctor.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorValidator {

    public static List<String> docValidate(JSONObject json) {
        List<String> list = new ArrayList<>();

        if(!json.has("doctorId")){
            list.add("doctorId");
        }
        if (!json.has("docName")){
            list.add("docName");
        }
        if(!json.has("specializedIn")){
            list.add("specializedIn");
        }

        return list;
    }



}
