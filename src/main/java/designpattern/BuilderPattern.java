package designpattern;

class Builder implements IBuilder {
    private Product p = new Product();

    @Override
    public void buildPart1() {
        p.setPart1("a");
    }

    @Override
    public void buildPart2() {
        p.setPart2("b");
    }

    @Override
    public Product retrieve() {
        return p;
    }
}


class Product {
    //定义一些产品的部件
    private String part1;
    private String part2;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }
}


interface IBuilder {
    public void buildPart1();

    public void buildPart2();

    public Product retrieve();
}

class Director {
    private IBuilder builder;

    public Director(IBuilder builder) {
        this.builder = builder;
    }

    public void Construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}

public class BuilderPattern {
    public void main(String[] args) {
        IBuilder builder = new Builder();
        Director director = new Director(builder);
        director.Construct();
        Product product = builder.retrieve();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}