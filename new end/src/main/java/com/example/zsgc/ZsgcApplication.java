package com.example.zsgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@SpringBootApplication
@MapperScan("com.example.zsgc.mapper")
public class ZsgcApplication {
    //static String driver = "com.mysql.cj.jdbc.Driver";
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //static String url = "jdbc:mysql://localhost:3306/FigureHub?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
    static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=bigHomework";
    //static String username = "FigureHub";
    static String username = "sa";
    //static String password = "123456";
    static String password = "wtbnb";

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet result = null;

    public static void main(String[] args) {
        //创建并初始化数据库
        initDataBase();

        SpringApplication.run(ZsgcApplication.class, args);
    }

    private static void initDataBase() {
        try {
            //注册jdbc驱动
            Class.forName(driver);
            //打开连接
            System.out.println("//开始连接数据库");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("//数据库连接成功");
            //执行创建表
            System.out.println("//创建并初始化表");
            stmt = conn.createStatement();

            /*initStyle();
            createFigure();
            initFigure();
            createRole();
            initRole();
            createF2R();
            createManufacturer();
            initManufacturer();
            initF2R();
            createTrigger();*/
            //result = stmt.executeQuery("select * from student");

            stmt.close();
            conn.close();
            System.out.println("//初始化完毕");
        }

        catch (Exception e) {
            System.out.println("//表初始化失败");
            e.printStackTrace();
        }
    }

    static String CreateFigure = "CREATE TABLE `figure`  (\n" +
            "  `figureId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '手办编号',\n" +
            "  `figureName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手办名称',\n" +
            "  `figureType` tinyint(1) NULL DEFAULT NULL COMMENT '手办类型\\r\\n0-未知\\r\\n1-GK手办\\r\\n2-PVC手办\\r\\n3-可动手办\\r\\n4-景品手办\\r\\n5-粘土人',\n" +
            "  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '售价',\n" +
            "  `prop` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '比例',\n" +
            "  PRIMARY KEY (`figureId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '手办' ROW_FORMAT = DYNAMIC;";

    static String CreateRole = "CREATE TABLE `role`  (\n" +
            "  `roleId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色编号',\n" +
            "  `roleName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',\n" +
            "  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别0-未知1-男2-女',\n" +
            "  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',\n" +
            "  PRIMARY KEY (`roleId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = DYNAMIC;";

    static String CreateF2R = "CREATE TABLE `figuretorole`  (\n" +
            "  `ftrId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '联系编号',\n" +
            "  `figureId` int(10) NULL DEFAULT NULL COMMENT '手办编号',\n" +
            "  `roleId` int(10) NULL DEFAULT NULL COMMENT '角色编号',\n" +
            "  PRIMARY KEY (`ftrId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;";

    static String CreateManufacturer = "CREATE TABLE `manufacturer`  (\n" +
            "  `manuId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '厂商编号',\n" +
            "  `manuName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商名称',\n" +
            "  `manuLink` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '官网链接',\n" +
            "  PRIMARY KEY (`manuId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '手办厂商' ROW_FORMAT = DYNAMIC;";

    static String CreateFigureTrigger = "CREATE TRIGGER triggerDeleteFigure BEFORE DELETE \n" +
            "ON figure FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM figuretorole WHERE figureId = old.figureId; \n" +
            "END;";

    static String CreateRoleTriger = "CREATE TRIGGER triggerDeleteRole BEFORE DELETE \n" +
            "ON role FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM figuretorole WHERE roleId = old.roleId; \n" +
            "END;";

    private static void createTrigger() throws SQLException {
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteFigure");
        stmt.execute(CreateFigureTrigger);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteRole");
        stmt.execute(CreateRoleTriger);
    }

    private static void initManufacturer() throws SQLException {
        stmt.execute("INSERT INTO `manufacturer` VALUES (1, 'ALTER', 'alter-web.jp');");
        stmt.execute("INSERT INTO `manufacturer` VALUES (2, 'GSC', 'https://www.goodsmile.info');");
        stmt.execute("INSERT INTO `manufacturer` VALUES (3, 'MaxFactory', 'www.maxfactory.jp');");

        stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
    }

    private static void initF2R() throws SQLException {
        stmt.execute("INSERT INTO `figuretorole` VALUES (1, 1, 2);");
        stmt.execute("INSERT INTO `figuretorole` VALUES (2, 2, 1);");
        stmt.execute("INSERT INTO `figuretorole` VALUES (3, 3, 3);");
        stmt.execute("INSERT INTO `figuretorole` VALUES (4, 3, 5);");
        stmt.execute("INSERT INTO `figuretorole` VALUES (5, 4, 4);");
        stmt.execute("INSERT INTO `figuretorole` VALUES (6, 5, 4);");

        stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
    }

    private static void initRole() throws SQLException {
        stmt.execute("INSERT INTO `role` VALUES (1, '阿尔托莉雅', 2, '骑士王');");
        stmt.execute("INSERT INTO `role` VALUES (2, '阿尔托莉雅Alter', 2, '骑士王反转');");
        stmt.execute("INSERT INTO `role` VALUES (3, '贞德', 2, '圣女贞德');");
        stmt.execute("INSERT INTO `role` VALUES (4, '贞德Alter', 2, '圣女贞德反转');");
        stmt.execute("INSERT INTO `role` VALUES (5, '莫德雷德', 2, '叛逆的骑士');");

        stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
    }

    private static void initFigure() throws SQLException {
        stmt.execute("INSERT INTO `figure` VALUES (1, 'FGO Saber【Alter】礼服', 2, 988, '1:7');");
        stmt.execute("INSERT INTO `figure` VALUES (2, 'FSN SABER TYPE-MOON RACING ver.', 2, 799, '1:7');");
        stmt.execute("INSERT INTO `figure` VALUES (3, 'FA 莫德雷德&贞德 Type-Moon Racing ver.', 2, 1739, '1:7');");
        stmt.execute("INSERT INTO `figure` VALUES (4, 'FGO 贞德【Alter】', 5, 278, 'non');");
        stmt.execute("INSERT INTO `figure` VALUES (5, 'FGO 贞德【Alter】第一再临', 2, 1677, '1:7');");

        stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
    }

    private static void createManufacturer() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS `manufacturer`");
        stmt.execute(CreateManufacturer);
    }

    private static void createF2R() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS figuretorole");
        stmt.execute(CreateF2R);
    }

    private static void createRole() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS role");
        stmt.execute(CreateRole);
    }

    private static void createFigure() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS figure");
        stmt.execute(CreateFigure);
    }

    private static void initStyle() throws SQLException {
        stmt.execute("SET NAMES utf8mb4");
        stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
    }

}
