package com.jojoldu.book.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //setter는 절대 만들지 않는다
@NoArgsConstructor
@Entity //테이블과 링크될 클래스임을 나타냄

public class Posts extends BaseTimeEntity {
    @Id //테이블의 pk(primary key) 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
