package Bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-6.
 */
public class ToBean  {


    /**
     * totalpage : 856
     */

    private TotalpageBean totalpage;
    /**
     * title : 跳过新手期 你应该知道的9个低光下拍摄的小技巧
     * pic_url : http://img2.fengniao.com/product/157_580x280/202/ceDDxwFkENvs6.jpg
     * date : 2016-09-06 06:56:01
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338593&isPad=1
     * doc_id : 5338593
     * web_url : http://academy.fengniao.com/533/5338593.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338593&isPad=1
     */

    private OneBean One;
    /**
     * title : 让我们看见那片海 涠洲岛+德天瀑布纪行
     * pic_url : http://img2.fengniao.com/product/157_280x280/85/cettKnCohwLug.jpg
     * date : 2016-09-06 06:00:00
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338161&isPad=1
     * doc_id : 5338161
     * web_url : http://qicai.fengniao.com/533/5338161.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338161&isPad=1
     */

    private List<SecondBean> Second;
    /**
     * title : 性价比爆表 永诺35mm F2尼康版正式发货
     * pic_url : http://img2.fengniao.com/product/157_160x120/353/cerGtgxUn04w.jpg
     * date : 2016-09-06 06:00:00
     * author : 王超1
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338611&isPad=1
     * doc_id : 5338611
     * web_url : http://qicai.fengniao.com/533/5338611.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338611&isPad=1
     */

    private List<ThirdBean> Third;

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public OneBean getOne() {
        return One;
    }

    public void setOne(OneBean One) {
        this.One = One;
    }

    public List<SecondBean> getSecond() {
        return Second;
    }

    public void setSecond(List<SecondBean> Second) {
        this.Second = Second;
    }

    public List<ThirdBean> getThird() {
        return Third;
    }

    public void setThird(List<ThirdBean> Third) {
        this.Third = Third;
    }

    public static class TotalpageBean {
        private int totalpage;

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }
    }

    public static class OneBean {
        private String title;
        private String pic_url;
        private String date;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }

    public static class SecondBean {
        private String title;
        private String pic_url;
        private String date;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }

    public static class ThirdBean {
        private String title;
        private String pic_url;
        private String date;
        private String author;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }
}
