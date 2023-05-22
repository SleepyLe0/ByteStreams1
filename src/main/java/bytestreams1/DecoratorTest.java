package bytestreams1;

public class DecoratorTest {

    public static void main(String[] args) {
        RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        RedShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        redCircle.draw();
        redRectangle.draw();
    }
}
