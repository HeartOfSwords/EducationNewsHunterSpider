import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.hunter.util.JsoupUtils;

public class TestHandMovementJsoupUtils {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(JsoupUtils.getArticleTitle("http://edu.qq.com/a/20160726/012024.htm"));
		System.out.println(JsoupUtils.getArticleContent("http://edu.qq.com/a/20160726/012024.htm"));
	}

}
