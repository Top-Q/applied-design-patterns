package b_builder;

import java.util.ArrayList;

class HtmlElement {
    public String name, text;

    public ArrayList<HtmlElement> elements = new ArrayList<>();

    private final static int INDENT_SIZE = 2;
    private final static String NEW_LINE = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String indentation = String.join("", java.util.Collections.nCopies(indent * INDENT_SIZE, " "));
        sb.append(String.format("%s<%s>%s", indentation, name, NEW_LINE));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", java.util.Collections.nCopies(INDENT_SIZE * (indent + 1), " ")))
                    .append(text)
                    .append(NEW_LINE);
        }

        for (HtmlElement e : elements)
            sb.append(e.toStringImpl(indent + 1));

        sb.append(String.format("%s</%s>%s", indentation, name, NEW_LINE));
        return sb.toString();
    }

    public String toString() {
        return toStringImpl(0);
    }


}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public void addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

    // Fluent API
    public HtmlBuilder addChildFluent(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    public String toString() {
        return root.toString();
    }
}

class Builder2Demo {

    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);

        builder.clear();
        // Fluent API

        builder
                .addChildFluent("li","hellO")
                .addChildFluent("li", "world");

    }

}




