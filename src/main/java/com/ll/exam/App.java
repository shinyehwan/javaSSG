package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 생각의 전개 과정
 * <p>
 * 첫번째, 글 쓸 때 마다 번호가 증가하네?
 * 기억력이 필요하다 => 변수
 * 변수는 수명이 있다. => 수명이 긴변수
 * <p>
 * 명언이나 작가를 저장해야할 텐데 어떻게 저장해야지? => 클래스 따로 뽑아서 저장
 */

public class App {
    private Scanner sc;
    App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.write(rq);
                    break;

                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                    
                case "수정":
                    wiseSayingController.modify(rq);
                    break;

                case "목록":
                    wiseSayingController.list(rq);
                    break;
                case "종료":
                    break outer;

            }
        }

        sc.close();
    }


}
