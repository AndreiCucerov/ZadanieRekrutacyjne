import java.util.ArrayList;
import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
//nazwa interfejsu i ten fakt ze ma metode ktora zwraca lista blokow ,
// wkazuja ze CompositeBlock bedzie sie sklada ze zwyklych blokow.
//Wzorzec "composite" wygl?da najlepsz? opcj?
