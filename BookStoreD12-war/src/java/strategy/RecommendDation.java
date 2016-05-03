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
public class RecommendDation {

    RecommendInterface recommendInterface;

    public void setRecommendInterface(RecommendInterface recommendInterface) {
        this.recommendInterface = recommendInterface;
    }

    public List<Book> execute() {
        return recommendInterface.suggest();
    }
}
