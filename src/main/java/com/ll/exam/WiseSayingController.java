package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    private WiseSayingService wiseSayingService;

    WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();

    }

    public void modify(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);


        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        System.out.printf("명언(기존) : %s\n", foundWiseSaying.content);
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", foundWiseSaying.author);
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(paramId, content, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);

    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.author, wiseSaying_.content);
        }
    }

    public void remove(Rq rq) {
        // 삭제?id=523
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);


        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingService.remove(paramId);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }



    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.println(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }
}
