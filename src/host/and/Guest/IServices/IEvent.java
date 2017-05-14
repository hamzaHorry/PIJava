/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.IServices;

import host.and.Guest.entities.Event;
import java.util.List;

/**
 *
 * @author bali
 */
public interface IEvent extends Iservice<Event, Integer>{
    
    public void Update (Event e);
    
   List<Event> findEventByName(String nom,int userId);
    
}
