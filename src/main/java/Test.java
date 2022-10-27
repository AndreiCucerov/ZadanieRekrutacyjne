import java.util.List;

public class Test {
    public static void main(String[] args) {
        Wall wall = new Wall();
        wall.setBlocks(List.of(new MyBlock("black","stone"),
                new MyBlock("red","stone"),
                new MyCompositeBlock(List.of( new MyBlock("white","stone"), new MyBlock("black","plastic")))));
        System.out.println("wall.count() => "+wall.count());
        System.out.println("wall.findBlockByColor(\"black\") => "+wall.findBlockByColor("black"));        System.out.println("wall.findBlockByColor(\"black\") => "+wall.findBlockByColor("black"));
        System.out.println("wall.findBlockByColor(\"red\") => "+wall.findBlockByColor("red"));
        System.out.println("wall.findBlocksByMaterial(\"plastic\") => "+wall.findBlocksByMaterial("plastic"));
        System.out.println("wall.findBlocksByMaterial(\"stone\") => "+wall.findBlocksByMaterial("stone"));
    }
}
