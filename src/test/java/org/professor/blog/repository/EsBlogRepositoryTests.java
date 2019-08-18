package org.professor.blog.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.professor.blog.model.EsBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;



/**
 * EsBlogRepository 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTests {

    @Autowired
    private EsBlogRepository mEsBlogRepository;

    @Before
    public void initRepositoryData() {
        // 清除所有数据,避免脏数据
        mEsBlogRepository.deleteAll();
        mEsBlogRepository.save(new EsBlog("Java 入坑之路", "Java Spring Boot", "Java Spring Boot 入坑之路"));
        mEsBlogRepository.save(new EsBlog("Android 入坑之路", "Android Data", "Android Data 入坑之路"));
        mEsBlogRepository.save(new EsBlog("GoLang 入坑之路", "GoLang Net", "GoLang Net 入坑之路"));
    }

    @Test
    public void testFindByTitleLikeOrContentLike() {
        Pageable pageable = PageRequest.of(0, 20);
        String title = "Java";
        String summery = "Java";
        String content = "Java";
        Page<EsBlog> byTitleLikeOrContentLikePage = mEsBlogRepository.findByTitleLikeOrContentLike(title, summery, content, pageable);
        assertThat(byTitleLikeOrContentLikePage.getTotalElements()).isEqualTo(1);
    }
}
