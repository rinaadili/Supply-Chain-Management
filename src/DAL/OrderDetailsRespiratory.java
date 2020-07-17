/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.OrderDetails;
import BLL.Orders;
import BLL.Products;
import java.util.List;

/**
 *
 * @author RA
 */
public class OrderDetailsRespiratory extends EntMngClass implements OrderDetailsInterface{

    @Override
    public void create(OrderDetails o) throws SCHMException {
      try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception es) {
            if(es.getMessage().contains("2627")){
                throw new SCHMException("Kjo e dhene ekziton!");
            }
            else{
                throw new SCHMException(es.getMessage());
            }
            
        }
    }
    @Override
    public void edit(OrderDetails o) throws SCHMException {
           try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(OrderDetails o) throws SCHMException {
         try {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception es) {
            if(es.getMessage().contains("547")){
                throw new SCHMException("Kjo e dhene nuk mund te fshihet!");
            }
            else{
                throw new SCHMException(es.getMessage());
            }
        }
    }

    @Override
    public List<OrderDetails> findAll() throws SCHMException {
         try {
            return (List<OrderDetails>) em.createNamedQuery("OrderDetails.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public OrderDetails findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetails> findByOrderID(int id) throws SCHMException {
        try {
            return (List<OrderDetails>) em.createNamedQuery("OrderDetails.findByOrderID").setParameter("orderID", new Orders(id)).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public List<OrderDetails> findByOrderIDProductID(Orders o, Products p) throws SCHMException {
        try {
            return (List<OrderDetails>) em.createNamedQuery("OrderDetails.findByOrderIDProductID").setParameter("orderID", o).setParameter("productID", p).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    
}


