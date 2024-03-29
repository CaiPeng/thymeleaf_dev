package org.professor.blog.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * ES Blog 文档
 */
// 索引名称 类型
@Document(indexName = "blog", type = "blog") // 标识文档
@XmlRootElement
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String title; // 标题

    private String summary; // 摘要

    private String content; // 内容


    protected EsBlog() { // JPA 规范要求，防止直接使用
    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, title='%s',summery='%s', content='%s']",
                id, title, summary, content);
    }
}
