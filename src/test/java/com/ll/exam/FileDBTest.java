package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDBTest {
    @Test
    void 파일에_있는_JSON을_맵으로_변환() {
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Util.saveToFile("test_data/1.json", wiseSaying.toJson());

        String rs = Util.readFromFile("test_data/1.json");
        Map<String, Object> map = Util.jsonToMap(rs);

        assertEquals(1, map.get("id"));
        assertEquals("내 사전에 불가능은 없다.", map.get("content"));
        assertEquals("나폴레옹", map.get("author"));
    }
    @Test
    void 파일에_객체를_저장() {
        Util.deleteDir("test_data");
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Util.saveToFile("test_data/1.json", wiseSaying.toJson());

        String rs = Util.readFromFile("test_data/1.json");
        assertEquals(wiseSaying.toJson(), rs);
    }



    @Test
    void 파일에_내용쓰기() {
        Util.deleteDir("test_data");
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용\n내용");

        String rs = Util.readFromFile("test_data/1.json");
        assertEquals("내용\n내용", rs);

    }


    @Test
    void 파일에_저장된_내용_가져오기() {
        Util.deleteDir("test_data");
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");

        String body = Util.readFromFile("test_data/1.json");
        System.out.println(body);
    }
}
