package com.lima.battleofmyeongnyang;

import com.lima.battleofmyeongnyang.setting.BattleApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BattleofMyeongnyangApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BattleofMyeongnyangApplication.class);
        app.addListeners(new BattleApplicationListener());
        app.run(args);
        // 서버 살아있는지 체크 하는거 알아보기
        monitoringService();
    }

    private static void monitoringService() {
        
    }

}
