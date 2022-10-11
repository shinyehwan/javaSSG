package com.ll.exam;

/*import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("수정?id=10?하하".split("\\?", 2)));
    }
}*/


public class Rq {
    String url;
    public Rq(String url) {
        this.url = url;
    }
    public int getIntparam(String paramName, int defaultValue) {
        String[] urlBits = url.split("\\?", 2);
        urlBits = urlBits[1].split("&", 2);

        for (String urlBit : urlBits) {
            String[] paramNameAndValue = urlBit.split("=", 2);
            String paramName_ = paramNameAndValue[0];
            String paramValue = paramNameAndValue[1];

            if (paramName.equals(paramName_)) {
                return Integer.parseInt(paramValue);
            }

        }

        return defaultValue;
    }
}
