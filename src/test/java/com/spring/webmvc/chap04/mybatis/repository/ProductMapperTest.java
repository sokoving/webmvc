package com.spring.webmvc.chap04.mybatis.repository;

import com.spring.webmvc.chap04.mybatis.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

    @Autowired // 객체 생성과 빈 등록까지 알아서 해줌
    ProductMapper mapper;

    @Test
    @DisplayName("제품 정보를 등록해야 한다")
    void saveTest(){
        for (int i = 1; i < 10; i++) {
            Product pro = new Product();
            pro.setProductName("좋은제품" + i);
            pro.setPrice(1000 + 100 * i);

            mapper.save(pro);
        }
    }

    @Test
    @DisplayName("제품이 DB에서 삭제돼야 한다")
    void removeTest(){
        boolean flag = mapper.remove("202207200007");
        assertTrue(flag);
    }

    @Test
    @DisplayName("제품 정보가 DB에서 수정돼야 한다")
    void modifyTest(){
        Product pro = new Product();
        pro.setSerialNo("202207200005");
        pro.setProductName("수정 제품");
        pro.setPrice(999);

        boolean flag = mapper.modify(pro);

        assertTrue(flag);
    }

    @Test
    @DisplayName("DB의 제품 전체 정보가 조회돼야 한다")
    void findAllTest(){
        List<Product> productList = mapper.findAll();

        for (Product product : productList) {
            System.out.println(product);
        }
    }


    @Test
    @DisplayName("특정 제품의 정보가 DB에서 조회돼야 한다")
    void findOneTest(){
        String sn = "202207200018";
        Product one = mapper.findOne(sn);

    }


}