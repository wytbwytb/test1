package com.example.zsgc;

import com.example.zsgc.controller.Association_Controller;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    private Association_Controller controller;
    @Test
    void test() {
        controller.selectAll();
    }

}
