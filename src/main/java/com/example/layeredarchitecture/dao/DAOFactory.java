package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.*;

public class DAOFactory {
   private static DAOFactory dadFactory;
    private DAOFactory(){}
        public static DAOFactory getDADFactory (){
            return (dadFactory==null) ? dadFactory=new DAOFactory():dadFactory;
    }
    public enum DADType{
        CUSTOMER,ITEM,ORDER,ORDERDETAIL,QUARY
    }
    public SuperDao getDao(DADType dadType) {
        switch (dadType) {
            case CUSTOMER: return new CustomerDaoImpl();
            case  ITEM:return new ItemDaoImpl();
            case ORDER:return new OrderDaoImpl();
            case ORDERDETAIL:return new OrderDetailDaoImpl();
            case QUARY:return new QueryDaoImpl();
            default:return null;
        }
    }
}
