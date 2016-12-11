package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class PttExample {
	// commit test
	public static void main(String[] args) {

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481211255.A.FCD.html";

	Elements getElements =
				CrawlerPack.start()
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
			    .getFromHtml(uri)
				.select("div#main-content");
		for(Element push:getElements.select("div.push")){
			String sign = push.select("span:containsOwn(噓)").text();
			String id = push.select("span:containsOwn(噓)~span.f3.hl.push-userid").text();
			String comment = push.select("span:containsOwn(噓)~span.f3.push-content").text();

			if(sign .equals("噓")){
				System.out.println(sign + ">>" +id +">>"+comment);
			}else{

		}

	}
}}
