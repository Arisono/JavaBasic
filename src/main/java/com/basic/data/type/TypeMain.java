package com.basic.data.type;

import java.util.Arrays;

import com.basic.core.utils.ByteDisposeUtil;
import com.basic.core.utils.BytesUtils;

public class TypeMain {
   
	public static void main(String[] args) {
		System.out.println("------------------------");
		
		String name="20name";
//	    System.out.println("字节："+Arrays.toString(ByteDisposeUtil.conversionStringToBytes(name)));
//	    System.out.println("十六进制字符串："+ByteDisposeUtil.toHex(BytesUtils.getBytes(name), 0, 6));
	
	    
	    System.out.println("字节："+Arrays.toString(BytesUtils.getBytes(name)));
	    System.out.println("十六进制字符串："+BytesUtils.bytesToHex(BytesUtils.getBytes(name)));
	    System.out.println("十六进制字符串："+BytesUtils.bytesToHex(BytesUtils.getBytes(name),2,4));
	    
	    int num=20;//四个字节
	    
	    System.out.println("字节："+Arrays.toString(BytesUtils.intToBytes(num)));
	    
	    System.out.println("十六进制字符串："+BytesUtils.bytesToHex(BytesUtils.intToBytes(num)));
	
	}
}
