/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.IServices;

import host.and.Guest.entities.experiences;
import java.util.List;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author esprit
 */
public interface IexperiencesServices {
    public void add(experiences e);
    public void remove(experiences p);
     public void update (experiences p);
     public List<experiences> getAll();
     public ObservableList<experiences>displayAll();
     public ObservableList<experiences> ExperiencesLiked(String id);

}
