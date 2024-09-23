package org.example.lk.ijse.BO;
import org.example.lk.ijse.BO.BoImpl.ItemBOImpl;
import org.example.lk.ijse.BO.BoImpl.customerBoImp;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM
    }

    //Object creation logic for BO objects
    public SuperBo getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new customerBoImp();
            case ITEM:
                return new ItemBOImpl();
        }
        return null;
    }
}
