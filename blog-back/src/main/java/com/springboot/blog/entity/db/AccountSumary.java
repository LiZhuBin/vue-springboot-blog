package com.springboot.blog.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;



@Document(collection="account_sumary")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component

public class AccountSumary  implements Serializable {
    /**
     * _id : 5e39aaeba3d8424345f8f72a
     * account_id : 1
     * article_num : 40
     * label_num : 1
     * read_num : 44
     * classify_num : 2
     * article_date : [{"year":2020,"month":1,"num":1},{"year":2020,"month":2,"num":1}]
     * labels : [{"name":"picgo","num":1},{"name":"markdown","num":1}]
     * classify : [{"name":"前端","num":1},{"name":"工具","num":1}]
     */

    private String id;
    private int accountId;
    private int articleNum;
    private int labelNum;
    private int readNum;
    private int classifyNum;
    private List<ArticleDateBean> articleDate;
    private List<LabelsBean> labels;
    private List<ClassifyBean> classify;

    @NoArgsConstructor
    @Data
    public static class ArticleDateBean {
        /**
         * year : 2020
         * month : 1
         * num : 1
         */

        private int year;
        private int month;
        private int num;
    }

    @NoArgsConstructor
    @Data
    public static class LabelsBean {
        /**
         * name : picgo
         * num : 1
         */

        private String name;
        private int num;
    }

    @NoArgsConstructor
    @Data
    public static class ClassifyBean {
        /**
         * name : 前端
         * num : 1
         */

        private String name;
        private int num;
    }
}
