import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Test;

import com.hunter.auto.pipeline.DBPersistencePipeline;
import com.hunter.auto.processor.TencentNewsProcessor;

import us.codecraft.webmagic.Spider;

public class TestAutoModule {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TencentNewsProcessor tencentNewsProcessor = new TencentNewsProcessor();
		String url = "http://edu.qq.com/a/20160726/022356.htm";
		try {
			Spider.create(tencentNewsProcessor)
			.addUrl(url)
			//.addPipeline(new ConsolePipeline())
			.addPipeline(new DBPersistencePipeline())
			.thread(3)
			.run();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("未发现内容");
		}
		for (int i = 1; i < 4; i++) {
			for (int j = 700; j <= 9999; j++) {
				//开启一个新的解析实例
				tencentNewsProcessor = new TencentNewsProcessor();

				String url1 = "http://edu.qq.com/a/"
						+ new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis())
						+ "/0"
						+ i
						+ TencentNewsProcessor.IntegerFomatterUtil(j)
						+".htm";
				System.out.println(url1);
				try {
					Spider.create(tencentNewsProcessor)
					.addUrl(url1)
					.addPipeline(new DBPersistencePipeline())
					.thread(3)
					.run();
				} catch (Exception e) {
					System.out.println("未发现内容");
				}

			}
		}
		
		
	}
}
