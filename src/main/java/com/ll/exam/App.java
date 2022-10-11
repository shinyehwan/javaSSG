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
    private List<WiseSaying> wiseSayings;
    // 가장 마지막 명언 글의 번호
    private int wiseSayingLastId;

    App() {
        sc = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");


        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    write(rq);
                    break;

                case "삭제":
                    remove(rq);
                    break;

                case "목록":
                    list(rq);
                    break;
                case "종료":
                    break outer;

            }
        }

        sc.close();
    }

    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.author, wiseSaying_.content);
        }
    }

    private void remove(Rq rq) {
        // 삭제?id=523
        // URL에 입력된 id 얻기
        int paramId = rq.getIntparam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = findById(paramId);



        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayings.remove(foundWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    private WiseSaying findById(int paramId) {

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }

        return null;
    }

    private void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingLastId; // 명언 글 번호 증가

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);


        System.out.println(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }
}
