package com.basic.data.type;

import java.util.Arrays;

import com.basic.core.utils.ByteDisposeUtil;
import com.basic.core.utils.BytesUtils;

public class TypeMain {
   
	public static void main(String[] args) {
		System.out.println("------------------------");
		
		String name="20name";
//	    System.out.println("�ֽڣ�"+Arrays.toString(ByteDisposeUtil.conversionStringToBytes(name)));
//	    System.out.println("ʮ�������ַ�����"+ByteDisposeUtil.toHex(BytesUtils.getBytes(name), 0, 6));
	
	    
	    System.out.println("�ֽڣ�"+Arrays.toString(BytesUtils.getBytes(name)));
	    System.out.println("ʮ�������ַ�����"+BytesUtils.bytesToHex(BytesUtils.getBytes(name)));
	    System.out.println("ʮ�������ַ�����"+BytesUtils.bytesToHex(BytesUtils.getBytes(name),2,4));
	    
	    int num=20;//�ĸ��ֽ�
	    
	    System.out.println("�ֽڣ�"+Arrays.toString(BytesUtils.intToBytes(num)));
	    
	    System.out.println("ʮ�������ַ�����"+BytesUtils.bytesToHex(BytesUtils.intToBytes(num)));
	
	}
}
