package org.professor.blog.repository;

import org.professor.blog.model.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Es Blog 接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 根据用户名分页查询用户列表（去重复）
     *
     * @param title    标题
     * @param summery  摘要
     * @param content  内容
     * @param pageable 是否分页
     * @return 分页数据
     */
    Page<EsBlog> findByTitleLikeOrContentLike(String title, String summery, String content, Pageable pageable);

}
