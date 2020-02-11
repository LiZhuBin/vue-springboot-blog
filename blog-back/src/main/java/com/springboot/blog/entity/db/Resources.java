package com.springboot.blog.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 资源类-mongo
 * @author: LiZhuBin
 * @create: 2020-02-11 18:33
 **/

@Document(collection="resource_qiniu")//集合名
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Resources {

    /**
     * _id : 5e427ead7fe56577ba8f73a9
     * account_id : 1
     * url_head : http://q47oxiycu.bkt.clouddn.com/1/
     * resources : {"images":[{"description":"用于博客列表的图片集","classify":"东京食尸鬼","view":12,"power":"public","detail":[{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/526889.jpg","description":"图片","date":"2020-02-01 11:25:01","view":3},{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/559200.jpg","description":"图片","date":"2020-02-01 11:25:10","view":3},{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/767225.jpg","description":"图片","date":"2020-02-01 11:26:01","view":3},{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/969352.jpg","description":"图片","date":"2020-02-01 11:27:01","view":3}]}],"videos":[{"description":"自然视频","classify":"自然","view":12,"power":"public","detail":[{"url":"http://q47oxiycu.bkt.clouddn.com/1/video/sea.mp4","date":"2020-02-01 11:25:01","description":"sea","view":3}]}],"files":[{"description":"wordTest","classify":"test","view":12,"power":"public","detail":[{"url":"http://q47oxiycu.bkt.clouddn.com/1/file/word1.doc","date":"2020-02-01 11:25:01","description":"word","view":3}]}]}
     */

    private String id;
    private int accountId;
    private String urlHead;
    private ResourcesBean resources;

    @NoArgsConstructor
    @Data
    public static class ResourcesBean {
        private List<ImagesBean> images;
        private List<VideosBean> videos;
        private List<FilesBean> files;

        @NoArgsConstructor
        @Data
        public static class ImagesBean {
            /**
             * description : 用于博客列表的图片集
             * classify : 东京食尸鬼
             * view : 12
             * power : public
             * detail : [{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/526889.jpg","description":"图片","date":"2020-02-01 11:25:01","view":3},{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/559200.jpg","description":"图片","date":"2020-02-01 11:25:10","view":3},{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/767225.jpg","description":"图片","date":"2020-02-01 11:26:01","view":3},{"url":"http://q47oxiycu.bkt.clouddn.com/1/images/969352.jpg","description":"图片","date":"2020-02-01 11:27:01","view":3}]
             */

            private String description;
            private String classify;
            private int view;
            private String power;
            private List<DetailBean> detail;

            @NoArgsConstructor
            @Data
            public static class DetailBean {
                /**
                 * url : http://q47oxiycu.bkt.clouddn.com/1/images/526889.jpg
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

        @NoArgsConstructor
        @Data
        public static class VideosBean {
            /**
             * description : 自然视频
             * classify : 自然
             * view : 12
             * power : public
             * detail : [{"url":"http://q47oxiycu.bkt.clouddn.com/1/video/sea.mp4","date":"2020-02-01 11:25:01","description":"sea","view":3}]
             */

            private String description;
            private String classify;
            private int view;
            private String power;
            private List<DetailBeanX> detail;

            @NoArgsConstructor
            @Data
            public static class DetailBeanX {
                /**
                 * url : http://q47oxiycu.bkt.clouddn.com/1/video/sea.mp4
                 * date : 2020-02-01 11:25:01
                 * description : sea
                 * view : 3
                 */

                private String url;
                private String date;
                private String description;
                private int view;
            }
        }

        @NoArgsConstructor
        @Data
        public static class FilesBean {
            /**
             * description : wordTest
             * classify : test
             * view : 12
             * power : public
             * detail : [{"url":"http://q47oxiycu.bkt.clouddn.com/1/file/word1.doc","date":"2020-02-01 11:25:01","description":"word","view":3}]
             */

            private String description;
            private String classify;
            private int view;
            private String power;
            private List<DetailBeanXX> detail;

            @NoArgsConstructor
            @Data
            public static class DetailBeanXX {
                /**
                 * url : http://q47oxiycu.bkt.clouddn.com/1/file/word1.doc
                 * date : 2020-02-01 11:25:01
                 * description : word
                 * view : 3
                 */

                private String url;
                private String date;
                private String description;
                private int view;
            }
        }
    }
}
