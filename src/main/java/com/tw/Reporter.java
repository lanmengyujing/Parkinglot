package com.tw;

public class Reporter {
    private int depth;
    private StringBuilder stringBuilder;

    public Reporter(int depth, StringBuilder stringBuilder) {
        this.depth = depth;
        this.stringBuilder = stringBuilder;
    }

    public StringBuilder buildReport(String information) {
        int count = depth;
        for (int i = 0; count > 0; i++) {
            stringBuilder.append("--");
            System.out.println(stringBuilder);
            count--;
        }
        return stringBuilder.append(information);
    }

    public int getDepth() {
        return depth;
    }
}
