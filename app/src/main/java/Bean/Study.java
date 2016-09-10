package Bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-8.
 */
public class Study {


    /**
     * totalpage : 882
     */

    private TotalpageBean totalpage;
    /**
     * totalpage : {"totalpage":882}
     * cid : 190
     * list : [{"title":"初学摄影的同学们 别说你没犯过这几个错误","pic_url":"http://img2.fengniao.com/article/12_280x210/4/liQeljOl5MEY.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338679&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338679&isPad=1","doc_id":"5338679","web_url":"http://academy.fengniao.com/533/5338679.html"},{"title":"照片拍清楚是基本功 快门速度越慢越不容易拍清晰","pic_url":"http://img2.fengniao.com/article/12_280x210/2/liV6kdHYrtRE.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338674&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338674&isPad=1","doc_id":"5338674","web_url":"http://academy.fengniao.com/533/5338674.html"},{"title":"如果你再把我拍成丑八怪 以后就甭一起旅游了","pic_url":"http://img2.fengniao.com/article/12_280x210/973/liEMl23yrTtQ.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338627&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338627&isPad=1","doc_id":"5338627","web_url":"http://academy.fengniao.com/533/5338627.html"},{"title":"5个秘诀 让你在秋天拍出超级美的宝宝照","pic_url":"http://img2.fengniao.com/article/12_280x210/980/liPx1W6nngDo.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338641&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338641&isPad=1","doc_id":"5338641","web_url":"http://academy.fengniao.com/533/5338641.html"},{"title":"海鲜游艇大别墅！豪华拍星免费送！","pic_url":"http://img2.fengniao.com/article/12_280x210/996/liobRLQxBU6Y.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338662&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338662&isPad=1","doc_id":"5338662","web_url":"http://academy.fengniao.com/533/5338662.html"},{"title":"跳过新手期 你应该知道的9个低光下拍摄的小技巧","pic_url":"http://img2.fengniao.com/article/12_280x210/927/liPnPYvxZUJU.jpg","doc_url":"http://api.fengniao.com/app_ipad/news_doc.php?docid=5338593&isPad=1","comment_page_num":0,"comments_num":"0","more_comment_url":"http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338593&isPad=1","doc_id":"5338593","web_url":"http://academy.fengniao.com/533/5338593.html"}]
     */

    private int cid;
    /**
     * title : 初学摄影的同学们 别说你没犯过这几个错误
     * pic_url : http://img2.fengniao.com/article/12_280x210/4/liQeljOl5MEY.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338679&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338679&isPad=1
     * doc_id : 5338679
     * web_url : http://academy.fengniao.com/533/5338679.html
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
