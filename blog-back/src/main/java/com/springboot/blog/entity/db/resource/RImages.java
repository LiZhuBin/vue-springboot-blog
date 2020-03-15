package com.springboot.blog.entity.db.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-13 03:10
 **/


@Document(collection="resources_images")//集合名
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RImages {

    /**
     * _id : 5e6a899034ce5d12f4031b57
     * account_id : 1
     * url_head : http://q47oxiycu.bkt.clouddn.com/1/
     * name : images
     * detail : [{"classify":"动漫","view":122,"power":"public","detail":[{"classify":"东京食尸鬼","view":23,"power":"public","detail":[{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/526889.jpg","description":"图片","date":"2020-02-01 11:25:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/559200.jpg","description":"图片","date":"2020-02-01 11:25:10","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/767225.jpg","description":"图片","date":"2020-02-01 11:26:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/969352.jpg","description":"图片","date":"2020-02-01 11:27:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/999668.png","description":"图片","date":"2020-02-01 11:29:01","view":3}]}]},{"classify":"动漫","view":12,"power":"public","detail":[{"classify":"火影","view":23,"power":"public","detail":[{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/58e4513dd8aeb_270_185.jpg","description":"图片","date":"2020-02-01 11:25:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/5d89e5cb5c48e_270_185.jpg","description":"图片","date":"2020-02-01 11:25:10","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/5e048082c6765.jpg","description":"图片","date":"2020-02-01 11:26:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/5e0480884078a_270_185.jpg","description":"图片","date":"2020-02-01 11:27:01","view":3}]}]}]
     */

    private String id;
    private int accountId;
    private String urlHead;
    private String name;
    private List<DetailBeanXX> detail;

    @NoArgsConstructor
    @Data
    public static class DetailBeanXX {
        /**
         * classify : 动漫
         * view : 122
         * power : public
         * detail : [{"classify":"东京食尸鬼","view":23,"power":"public","detail":[{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/526889.jpg","description":"图片","date":"2020-02-01 11:25:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/559200.jpg","description":"图片","date":"2020-02-01 11:25:10","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/767225.jpg","description":"图片","date":"2020-02-01 11:26:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/969352.jpg","description":"图片","date":"2020-02-01 11:27:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/999668.png","description":"图片","date":"2020-02-01 11:29:01","view":3}]}]
         */

        private String classify;
        private int view;
        private String power;
        private List<DetailBeanX> detail;

        @NoArgsConstructor
        @Data
        public static class DetailBeanX {
            /**
             * classify : 东京食尸鬼
             * view : 23
             * power : public
             * detail : [{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/526889.jpg","description":"图片","date":"2020-02-01 11:25:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/559200.jpg","description":"图片","date":"2020-02-01 11:25:10","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/767225.jpg","description":"图片","date":"2020-02-01 11:26:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/969352.jpg","description":"图片","date":"2020-02-01 11:27:01","view":3},{"url":"https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/999668.png","description":"图片","date":"2020-02-01 11:29:01","view":3}]
             */

            private String classify;
            private int view;
            private String power;
            private List<DetailBean> detail;

            @NoArgsConstructor
            @Data
            public static class DetailBean {
                /**
                 * url : https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/images/%E5%8A%A8%E6%BC%AB/%E4%B8%9C%E4%BA%AC%E9%A3%9F%E5%B0%B8%E9%AC%BC/526889.jpg
                 * description : 图片
                 * date : 2020-02-01 11:25:01
                 * view : 3
                 */

                private String url;
                private String description;
                private String date;
                private int view;
            }
        }
    }
}
