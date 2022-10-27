import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> fromCompositeBlocks = blocks.stream().filter(block -> block instanceof MyCompositeBlock)
                .flatMap(block -> ((MyCompositeBlock) block).getBlocks().stream())
                .filter(block -> block.getColor() == color).findAny();
        if (fromCompositeBlocks.isPresent()) {
            return fromCompositeBlocks;
        }
        return blocks.stream().filter(block -> block.getColor() == color).findAny();
    }
    //W tej metodzie za pomoc? flatMap filtruje bloki wewn?trz CompositeBlocks
    // i za pomoc? findAny zapisuj? jako Optional. Sprawdzam czy optional jest pusty
    //je?eli nie jest pusty to zwracam go , je?eli jest pusty to filtruje pozostale bloki i zwracam wynik

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> fromCompositeBlocks = blocks.stream().filter(block -> block instanceof MyCompositeBlock)
                .flatMap(block -> ((MyCompositeBlock) block).getBlocks().stream())
                .filter(block -> block.getMaterial() == material)
                .collect(Collectors.toList());
        List<Block> result = blocks.stream()
                .filter(block -> block.getMaterial() == material)
                .collect(Collectors.toList());
        result.addAll(fromCompositeBlocks);
        return result;
    }
    //W metodzie findBlockByMaterial na pocz?tku za pomoc? .flatMap filtruje bloki wewn?trz CompositeBlocks i zapisuje ich jako list?
    //Po?niej filtruje wszytkie inne bloki i zapisuje jako liste
    //Na koncu l?cz? dwie listy w jedn? i zwracam

    @Override
    public int count() {
        int fromCompositeBlocks = (int) blocks.stream().filter(block -> block instanceof MyCompositeBlock).flatMap(block -> ((MyCompositeBlock) block).getBlocks().stream()).count();
        int singleBlocks = (int) blocks.stream().count();
        return fromCompositeBlocks + singleBlocks;
    }
    //w metodzie count, na pocz?tku sprawdzam ile jest blokow wewn?trz CompositeBlocks
    //A po?nej dodaje do nich wszystkie inne bloki ( compositeblocks te? sie licz?)
}
