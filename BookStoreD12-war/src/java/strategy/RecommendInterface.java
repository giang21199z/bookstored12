/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import entity.Book;
import java.util.List;

/**
 *
 * @author GIANGND-SVMC
 */
public interface RecommendInterface {

    public List<Book> suggest();
}
