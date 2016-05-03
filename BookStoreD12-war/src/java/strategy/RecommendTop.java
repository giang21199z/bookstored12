/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import entity.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIANGND-SVMC
 */
public class RecommendTop implements RecommendInterface {

    @Override
    public List<Book> suggest() {
        return new ArrayList<>();
    }

}
