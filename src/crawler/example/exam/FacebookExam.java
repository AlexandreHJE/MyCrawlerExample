package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6"
				+ "/crazyck101/posts?fields=id,link,message,created_time,likes.limit(0).summary(true),reactions.type(HAHA).limit(0).summary(total_count)&since=1480849200&until=1480895999"
				+ "&access_token=EAACEdEose0cBABZB5BRdO1wsill15dk0JNZBlv1TcRApXUOq2OaV26GFhgxAFCEoUM2WzKvhphJXmtNwzj4GZCZAVoV7GZC4PQmCGUt5KDWlZAZAZADtDm9ZATsZBN21ZAU0Lu7l4DXvX1jXR6hC34VRA8PVzlHbdf5LfDHLuuhaJFAOwZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id  likes reactions(HAHA) created_time"+"\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String created_time = data.select("created_time").text();
			String reactions = data.select("reactions").text();
			String likes = data.select("like").text();
			// FIXIT
//			String reactions = data.select("reactions").text();


			output += id + "_" + likes +"_" + reactions+ "_" + created_time + "\n";
		}

		System.out.println( output );
	} 
}
