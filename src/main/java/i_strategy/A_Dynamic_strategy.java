package i_strategy;

enum OutputFormat {
    MARKDOWN, HTML
}

// In HTML we need for list <ul><li>first</li><li>second</li></ul>
// While markdown is simpler,
// * first
// * second

interface ListStrategy {
    default void start(StringBuilder sb) {
    }

    void addListItem(StringBuilder sb, String item);

    default void end(StringBuilder sb) {
    }
}

class MarkdownListStrategy implements ListStrategy {

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ").append(item)
                .append(System.lineSeparator());
    }
}

class HtmlListStrategy implements  ListStrategy {

    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("  <li>")
                .append(item)
                .append("</li>")
                .append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());
    }
}

class TextProcessor {

    private StringBuilder sb = new StringBuilder();

    private ListStrategy listStrategy;

    public TextProcessor(OutputFormat format) {
        setOutputFormat(format);
    }

    public void setOutputFormat(OutputFormat format) {
        switch(format) {
            case MARKDOWN:
                listStrategy = new MarkdownListStrategy();
                break;
            case HTML:
                listStrategy = new HtmlListStrategy();
                break;
        }
    }

    public void appendList(String[] items) {
        listStrategy.start(sb);
        for (String item : items) {
            listStrategy.addListItem(sb, item);
        }
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    public String toString() {
        return sb.toString();
    }

}

class StrategyDemo {
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor(OutputFormat.MARKDOWN);
        tp.appendList(new String[] {"alpha", "beta", "gamma"});
        System.out.println(tp);
        System.out.println("");
        System.out.println("And now HTML");
        tp.clear();
        tp.setOutputFormat(OutputFormat.HTML);
        tp.appendList(new String[] {"alpha", "beta", "gamma"});
        System.out.println(tp);
    }
}