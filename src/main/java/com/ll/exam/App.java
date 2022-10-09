package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 생각의 전개 과정
 *
 * 첫번째, 글 쓸 때 마다 번호가 증가하네?
 * 기억력이 필요하다 => 변수
 * 변수는 수명이 있다. => 수명이 긴변수
 *
 * 명언이나 작가를 저장해야할 텐데 어떻게 저장해야지? => 클래스 따로 뽑아서 저장
 * 
 */

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);

        List<WiseSaying> wiseSayings = new ArrayList<>();
        // 가장 마지막 명언 글의 번호
        int wiseSayingLastId = 0;


        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId; // 명언 글 번호 증가

                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    wiseSayings.add(wiseSaying);


                    System.out.println(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("------------------");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.author, wiseSaying_.content);
                    }
                    break;
                case "종료":
                    break outer;

            }
        }

        sc.close();
    }
}
