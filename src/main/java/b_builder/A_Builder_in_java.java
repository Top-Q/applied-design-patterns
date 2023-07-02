package b_builder;

class BuilderDemo {

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");

        String[] words = {"hello", "world"};

        StringBuilder sb = new StringBuilder();
        /**
         * <ul>
         *     <li>hello</li>
         *     <li>world</li>
         * </ul>
         */

        sb.append("<ul>\n");
        for (String word : words) {
            sb.append(String.format("  <li>%s</li>" + System.lineSeparator(), word));
        }
        sb.append("</ul>");
        System.out.println(sb);
    }

}