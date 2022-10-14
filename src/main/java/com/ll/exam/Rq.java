package com.ll.exam;

/*import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("수정?id=10?하하".split("\\?", 2)));
    }
}*/

//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * cmd == URL
// * <p>
// * 등록
// * 목록
// * 종료
// * 수정?id=1
// * 삭제?id=1
// * 검색?searchKeywordType=content&searchKeyword=아침
// * <p>
// * <p>
// * URL에 대해서 내가 해야하는 것
// * - ? 기준으로 나눈다.
// * - path를 얻는다.
// * - queryStr을 얻는다.
// * - queryStr을 & 기준으로 나눈다.
// * - params를 사용하기 좋게 map 형태로 관리한다.
// */
//
//class Main {
//    public static void main(String[] args) {
////        sol1();
////        sol2();
////        sol3();
//        sol4();
//    }
//
//    private static void sol4() {
//        Map<String, String> params = queryStrParams("name=홍길동&age=22&no=1");
//        println(params);
//    }
//
//    private static void sol3() {
//        Map<String, String> params = new HashMap<>();
//
//        String queryStr = "name=홍길동&age=22&no=1"; // 원본
//        String[] queryBits = queryStr.split("&");
//        for (String queryBit : queryBits) {
//            String[] paramNameAndValue = queryBit.split("=", 2);
//            String paramName = paramNameAndValue[0];
//            String paramValue = paramNameAndValue[1];
//
//            params.put(paramName, paramValue);
//        }
//        System.out.println(params);
//    }
//
//    private static void sol2() {
//        Map<String, String> params = new HashMap<>();
//        params.put("name", "홍길동");
//        params.put("age", "22");
//        params.put("no", "1");
//        println(params); // 최종형태
//
//        println(params.get("name"));
//        println(params.get("age"));
//        println(params.get("no"));
//        println(params.containsKey("id"));
//        println(params.containsKey("name"));
//
//    }
//
//    private static void sol1() {
//        String queryStr = "name=홍길동&age=22&no=1"; // 원본
//        String[] queryBits = queryStr.split("&");
//        for (String queryBit : queryBits) {
//            String[] paramNameAndValue = queryBit.split("=", 2);
//            String paramName = paramNameAndValue[0];
//            String paramValue = paramNameAndValue[1];
//            println(paramName);
//            println(paramValue);
//
//        }
//    }
//
//    private static Map<String, String> queryStrParams(String queryStr) {
//        Map<String, String> params = new HashMap<>();
//
//        String[] queryBits = queryStr.split("&");
//
//        for (String queryBit : queryBits) {
//            String[] paramNameAndValue = queryBit.split("=", 2);
//
//            if (paramNameAndValue.length == 1) {
//                continue;
//            }
//
//            String paramName = paramNameAndValue[0].trim();
//            String paramValue = paramNameAndValue[1].trim();
//
//            params.put(paramName, paramValue);
//        }
//        return params;
//    }
//
//    private static void printArr(String[] arr) {
//        System.out.println(Arrays.toString(arr));
//    }
//
//    private static void println(Object o) {
//        System.out.println(o);
//    }
//
//}
/**
 * import java.util.Map;
 * import java.util.HashMap;
 *
 * class Main {
 *     public static void main(String[] args) {
 *         Rq rq = new Rq("/search.naver?where=nexearch&sm=top_hty&fbm=110&ie=utf8&query=사과&query2=ㅋㅋ");
 *
 *         System.out.println(rq.getPath()); // /search.naver?
 *
 *         System.out.println(rq.getParam("where", "")); // "nexearch"
 *         System.out.println(rq.getParam("sm", "")); // "top_hty"
 *         System.out.println(rq.getIntParam("fbm", 0) + 20); // 130
 *         System.out.println(rq.getParam("query", "")); // "사과"
 *         System.out.println(rq.getParam("query2", "메롱")); // "메롱"
 *     }
 * }
 *
 * class Rq {
 *     private String path;
 *     private Map<String, String> params;
 *
 *     Rq(String url) {
 *         String[] pathAndQueryStr = url.split("\\?");
 *         this.path = pathAndQueryStr[0];
 *
 *         if (pathAndQueryStr.length == 1) {
 *             this.params = new HashMap<>();
 *             return;
 *         }
 *
 *         String queryStr = pathAndQueryStr[1];
 *         this.params = queryStrToParams(queryStr);
 *     }
 *
 *     public String getPath() {
 *         return path;
 *     }
 *
 *     public String getParam(String parmName, String defaultValue) {
 *         if (params.containsKey(parmName) == false) {
 *             return defaultValue;
 *         }
 *
 *         String value = params.get(parmName);
 *
 *         if (value.length() == 0) {
 *             return defaultValue;
 *         }
 *
 *         return value;
 *     }
 *
 *     public int getIntParam(String parmName, int defaultValue) {
 *         if (params.containsKey(parmName) == false) {
 *             return defaultValue;
 *         }
 *
 *         String value = params.get(parmName);
 *
 *         if (value.length() == 0) {
 *             return defaultValue;
 *         }
 *
 *         return Integer.parseInt(value);
 *     }
 *
 *     private static Map<String, String> queryStrToParams(String queryStr) {
 *         Map<String, String> params = new HashMap<>();
 *
 *         String[] queryStrBits = queryStr.split("&");
 *
 *         for (String queryStrBit : queryStrBits) {
 *             String[] paramNameAndValue = queryStrBit.split("=", 2);
 *
 *             if (paramNameAndValue.length == 1) {
 *                 continue;
 *             }
 *
 *             String paramName = paramNameAndValue[0].trim();
 *             String paramValue = paramNameAndValue[1].trim();
 *
 *             params.put(paramName, paramValue);
 *         }
 *
 *         return params;
 *     }
 * }
 */



import java.util.HashMap;
import java.util.Map;

public class Rq {
    String url;
    String path;
    Map<String, String> queryParams;
    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        queryParams = new HashMap<>();

        if (urlBits.length == 2) {

            String queryStr = urlBits[1];
            String[] paramBits = queryStr.split("&");

            for (String paramBit : paramBits) {
                String[] paramNameAndValue = paramBit.split("=", 2);
                if (paramNameAndValue.length == 1) {
                    continue;
                }
                String paramName = paramNameAndValue[0].trim();
                String paramValue = paramNameAndValue[1].trim();

                queryParams.put(paramName, paramValue);


            }
        }


    }
    public int getIntParam(String paramName, int defaultValue) {
        if (queryParams.containsKey(paramName) == false) {
            return defaultValue;
        }
            String paramValue = queryParams.get(paramName);
            if (paramValue.length() == 0) {
                return defaultValue;
            }

            return Integer.parseInt(paramValue);
        }


    public String getPath() {
        return path;
    }
}
