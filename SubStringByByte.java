package zhang.algorithm.JavaTest;

import java.io.UnsupportedEncodingException;

/**
 * 按字节截取含有中文的字符串
 * 
 * @author zhang_zack
 * 
 */
public class SubStringByByte {
	
	public static String cutStringByByte(String origin, int count){
		if(origin!=null && !"".equals(origin)){
			try {
				if(count>0 && count<origin.getBytes("GBK").length){
					
					StringBuffer sb = new StringBuffer();
					//因为如果count为小于2的数，而第一个字符为中文，那么就全被截取掉了,也就是不能第一次就添加了！
					//这个地方会有问题！！
					if(count<2 && isChinese(origin.charAt(0))){
						return sb.toString();
					}
					//题中如果是中文count自减的思想很不错，值得学习！
					for(int i=0; i<count; i++){
						char c = origin.charAt(i);
						sb.append(c);
						if(isChinese(c)){
							--count;
						}
					}
					return sb.toString();
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 判断一个字符是不是中文 <br/>
	 * @param c
	 * @return
	 */
	private static boolean isChinese(char c) {
		//由char类型转换成String类型，然后通过String类型计算器byte字节数来判断是否为中文
		if(String.valueOf(c).getBytes().length>1){
			return true;
		}
		return false;
	}

	public static void main(String[] args){
		String s = "我zhang是Chinese";
//		System.out.println(SubStringByByte.cutStringByByte(s, 1));
//		System.out.println(SubStringByByte.cutStringByByte(s, 2));
		System.out.println(SubStringByByte.cutStringByByte(s, 1));
		System.out.println(SubStringByByte.cutStringByByte(s, 7));
		
		try {
			System.out.println("我".getBytes().length);//mac下默认"utf-8"编码，3
			System.out.println("我".getBytes("utf-8").length);//3
//			大部分情况下可以认为UTF-8对非英文字符是占用3个字节
			System.out.println("我".getBytes("GBK").length);//2
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
