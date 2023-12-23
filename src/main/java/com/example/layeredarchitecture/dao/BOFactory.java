package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.bo.custom.SuperBo;
import com.example.layeredarchitecture.bo.custom.impl.CustomerBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.PlaceOrderBoImpl;
import com.example.layeredarchitecture.dao.custom.CustomerDao;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public static SuperBo getBo(BOType boType){
        switch (boType){
            case CUSTOM:return new CustomerBoImpl();
            case ITEM:return  new ItemBoImpl();
            case PLACEORDER:return  new PlaceOrderBoImpl();
            default: return null;
        }

    }
    public enum BOType{
    CUSTOM,ITEM,PLACEORDER
    }
}
