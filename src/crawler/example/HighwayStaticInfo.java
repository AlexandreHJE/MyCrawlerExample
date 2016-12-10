package crawler.example;

import com.github.abola.crawler.CrawlerPack;

/**
 * 練習 高公局即時路況資料
 * 
 * @author Abola Lee
 *
 */
public class HighwayStaticInfo {

	public static void main(String[] args) {
		
		// 遠端資料路徑
		//String uri = "gz:http://tisvcloud.freeway.gov.tw/cms_value.xml.gz";
		String uri = "http://tisvcloud.freeway.gov.tw/history/TDCS/M03A/";
		System.out.println(
				CrawlerPack.start()
			    	.getFromXml(uri)
			    
		);
	}
}
