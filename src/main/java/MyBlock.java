public class MyBlock implements Block {
    String color;
    String material;

    public MyBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "{ color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
