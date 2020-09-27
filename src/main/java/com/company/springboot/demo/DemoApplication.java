package com.company.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.company.springboot.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(" ......................我佛慈悲......................");
        System.out.println("                       _oo0oo_                      ");
        System.out.println("                      o8888888o                     ");
        System.out.println("                      88\" . \"88                     ");
        System.out.println("                      (| -_- |)                     ");
        System.out.println("                      0\\  =  /0                     ");
        System.out.println("                    ___/‘---’\\___                   ");
        System.out.println("                  .' \\|       |/ '.                 ");
        System.out.println("                 / \\\\|||  :  |||// \\                ");
        System.out.println("                / _||||| -卍-|||||_ \\               ");
        System.out.println("               |   | \\\\\\  -  /// |   |              ");
        System.out.println("               | \\_|  ''\\---/''  |_/ |              ");
        System.out.println("               \\  .-\\__  '-'  ___/-. /              ");
        System.out.println("             ___'. .'  /--.--\\  '. .'___            ");
        System.out.println("          .\"\" ‘<  ‘.___\\_<|>_/___.’ >’ \"\".          ");
        System.out.println("         | | :  ‘- \\‘.;‘\\ _ /’;.’/ - ’ : | |        ");
        System.out.println("         \\  \\ ‘_.   \\_ __\\ /__ _/   .-’ /  /        ");
        System.out.println("     =====‘-.____‘.___ \\_____/___.-’___.-’=====     ");
        System.out.println("                       ‘=---=’                      ");
        System.out.println("                                                    ");
        System.out.println("....................佛祖开光 ,永无BUG...................");
        System.out.println("写字楼里写字间，写字间里程序员；\n" +
                "程序人员写程序，又拿程序换酒钱。\n" +
                "酒醒只在网上坐，酒醉还来网下眠；\n" +
                "酒醉酒醒日复日，网上网下年复年。\n" +
                "但愿老死电脑间，不愿鞠躬老板前；\n" +
                "奔驰宝马贵者趣，公交自行程序员。\n" +
                "别人笑我忒疯癫，我笑自己命太贱；\n" +
                "不见满街漂亮妹，哪个归得程序员。");
    }

}
