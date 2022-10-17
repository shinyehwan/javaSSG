package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * String rs = """
 *== 명언 SSG ==
 * 명령) 등록
 * 명언 : aa
 * 작가 : bb
 * WiseSaying{id=1, content='aa', author='bb'}
 * 1번 명언이 등록되었습니다.
 * 명령)
 * """
 *
 * rs.contaion("1번 명언이 등록되었습니다.");
 * TUI 프로그램의 통합테스트를 위해, 입출력을 문자열로 다루는 작업이 필요하다
 * - 입력을 문장화
 * - 출력을 문장화
 */
<<<<<<< HEAD
=======
public class AppTest {

    @Test
    void 파일에_객체를_저장() {
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Util.saveToFile("test_data/1.json", wiseSaying.toJson());

        String rs = Util.readFromFile("test_data/1.json");
        assertEquals(wiseSaying.toJson(), rs);
    }



    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용\n내용");

        String rs = Util.readFromFile("test_data/1.json");
        assertEquals("내용\n내용", rs);

    }


    @Test
    void 파일에_저장된_내용_가져오기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");

        String body = Util.readFromFile("test_data/1.json");
        System.out.println(body);
    }
>>>>>>> 761efac9a5366910f584efb9d2d824fbb463cade

/**
 * 객체 => 한방에 => 문장
 * 문장(JSON) => 맵 => 객체
 */
public class AppTest {

    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }

    @Test
    public void 문자열을_스캐너의_입력으로_설정() {
        String input = """
                등록
                명언1
                작가1           
                """.stripIndent();

        InputStream in =new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }

    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);

    }
}
