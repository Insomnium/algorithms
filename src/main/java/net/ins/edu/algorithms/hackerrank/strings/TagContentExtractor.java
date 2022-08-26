package net.ins.edu.algorithms.hackerrank.strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class TagContentExtractor {

    private static void extract(String s) {
        s = s.trim();
        if (s.isEmpty()) return;

        char[] chars = s.toCharArray();
        String currTag = null;
        var resultBuilder = new StringBuilder();
        var tagStack = new Stack<Tag>();
        boolean lineHasContent = false;
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            int tagEndIndex = s.indexOf('>', i);
            if (tagEndIndex < 0) {
                break;
            }
            if (c == '<' && chars.length-1 >= i+1 && chars[i+1] != '/') { // tag opened -> goto value
                currTag = s.substring(i+1, tagEndIndex);
                i += currTag.length() + 2;
                tagStack.push(new Tag(currTag, true));
                var lastTag = tagStack.lastElement();
                if (lastTag != null && lastTag.opening) {
                    resultBuilder = new StringBuilder();
                }
            } else if (c == '<' && chars.length-1 >= i+1 && chars[i + 1] == '/') { // tag closed -> print/flush buffer
                if (chars.length-1 >= i+currTag.length()) {
                    String enclosingTag = new String(Arrays.copyOfRange(chars, i+2, tagEndIndex));
                    var lastTag = tagStack.lastElement();
                    if (!enclosingTag.equals(lastTag.tag)) {
                        tagStack.pop();
                        resultBuilder = new StringBuilder();
                    } else {
                        if (!resultBuilder.isEmpty()) {
                            lineHasContent = true;
                            System.out.println(resultBuilder);
                            resultBuilder = new StringBuilder();
                        }
                    }
                    if (chars.length - 1 >= i + 2 + enclosingTag.length()) {
                        i += 2 + enclosingTag.length();
                    }
                }
                i++;
            } else {
                if (currTag != null && !currTag.isEmpty()) {
                    resultBuilder.append(c);
                }
                i++;
            }
        }
        if (!lineHasContent) {
            System.out.println("None");
        }
    }

    private static class Tag {
        public final String tag;
        public final boolean opening;

        private Tag(String tag, boolean opening) {
            this.tag = tag;
            this.opening = opening;
        }
    }

    private static void driver(String[] args) {
        for (int i = 1; i < args.length; i++) {
            extract(args[i]);
        }
    }

    public static void main(String[] args) throws IOException {
//        var reader = new BufferedReader(new InputStreamReader(System.in));
//        var inputLines = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < inputLines; i++) {
//            extract(reader.readLine());
//        }

        TagContentExtractor.extract("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        TagContentExtractor.extract("<h1>had<h1>public</h1515></h1>");
        TagContentExtractor.extract("<h1>Hey#0</h1>");
        TagContentExtractor.extract("<a><h1>Hey#1</h1></a>");
        TagContentExtractor.extract("<pre><h1>Hey#2</h1></pre>");
        TagContentExtractor.extract("<h1><h1>Hey#3</h1></h1>");
        TagContentExtractor.extract("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");
        TagContentExtractor.extract("<h1>had<h1>public</h1></h1>");
        TagContentExtractor.extract("<h1>had<h1></h1></h1>");
        TagContentExtractor.extract("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        TagContentExtractor.extract(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
