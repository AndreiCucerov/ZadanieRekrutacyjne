import java.util.List;

//implementacja CompositeBlock
public class MyCompositeBlock implements CompositeBlock {
    List<Block> blocks;

    public MyCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    //CompositeBlock sklada sie z blokow wi?c nie b?dzie mial wlasnego koloru/materialu
    //Czyli getColor/getMaterial bedzie zwracala null
    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }
}
