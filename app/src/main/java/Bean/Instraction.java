package Bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-7.
 */
public class Instraction  {


    /**
     * totalpage : 3549
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":3549}
     * cid : 296
     * list : [{"title":"光学防抖玩法多 索尼夏季酷拍新品动手玩","pic_url":"http://img2.fengniao.com/article/12_280x210/868/li3a5CTSKm1gQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=4154802&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=4154802&isPad=1","doc_id":"4154802","web_url":"http://qicai.fengniao.com/415/4154802.html"},{"title":"让你更了解酷拍 索尼酷拍新品高层访谈录","pic_url":"http://img2.fengniao.com/article/12_280x210/11/liti8CxbSKDog.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338683&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338683&isPad=1","doc_id":"5338683","web_url":"http://qicai.fengniao.com/533/5338683.html"},{"title":"扩展手动镜头 蔡司将发布三枚Milvus镜头","pic_url":"http://img2.fengniao.com/article/12_280x210/997/liKHyNPOU3uQw.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338663&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338663&isPad=1","doc_id":"5338663","web_url":"http://qicai.fengniao.com/533/5338663.html"},{"title":"全画幅广角镜头 蔡司T*28mm f2 ZE售5899元","pic_url":"http://img2.fengniao.com/article/12_280x210/985/liy5QWZEKJ7TQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338649&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338649&isPad=1","doc_id":"5338649","web_url":"http://qicai.fengniao.com/533/5338649.html"},{"title":"标变镜皇 佳能24-70mm F2.8II售10699元","pic_url":"http://img2.fengniao.com/article/12_280x210/982/liJBHTJqMkcqw.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338646&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338646&isPad=1","doc_id":"5338646","web_url":"http://qicai.fengniao.com/533/5338646.html"},{"title":"金属复古造型 富士X-T10银色套机售4799元","pic_url":"http://img2.fengniao.com/article/12_280x210/977/liARjA9ywjeuQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338639&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338639&isPad=1","doc_id":"5338639","web_url":"http://qicai.fengniao.com/533/5338639.html"}]
     */

    private int cid;
    /**
     * title : 光学防抖玩法多 索尼夏季酷拍新品动手玩
     * pic_url : http://img2.fengniao.com/article/12_280x210/868/li3a5CTSKm1gQ.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=4154802&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=4154802&isPad=1
     * doc_id : 4154802
     * web_url : http://qicai.fengniao.com/415/4154802.html
     */

    private List<ListBean> list;

    public TotalpageBean getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(TotalpageBean totalpage) {
        this.totalpage = totalpage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
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

    public static class ListBean {
        private String title;
        private String pic_url;
        private String doc_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;
        private String doc_id;
        private String web_url;

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

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
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
    }
}
