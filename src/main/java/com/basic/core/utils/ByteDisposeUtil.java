package com.basic.core.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * �ֽڴ���Ĺ�����
 * 
 * @author wq
 *
 */
public class ByteDisposeUtil {
	/**
	 * ���ַ���ת��Ϊ�ֽ����飨ֻ�ʺ�16���ƣ�
	 * 
	 * @param zhiling
	 * @return
	 */
	public static byte[] conversionStringToBytes(String zhiling) {
		List<byte[]> bytes = new ArrayList<byte[]>();
		for (int i = 0; i < zhiling.length(); i += 2) {
			String hex = zhiling.substring(i, i + 2);
			byte[] bnew = hexStringToBytes(hex);
			bytes.add(bnew);
		}
		byte[] newByte = sysCopy(bytes);
		return newByte;
	}

	/**
	 * ��data�д�off��ʼ�� length���ַ�ת����ʮ������
	 * 
	 * @param data
	 * @param off
	 * @param length
	 * @return
	 */
	public static final StringBuffer toHex(byte[] data, int off, int length) {
		StringBuffer buf = new StringBuffer(data.length * 2);
		for (int i = off; i < length; i++) {
			if (((int) data[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) data[i] & 0xff, 16));
		}
		return buf;
	}

	/**
	 * �ַ�ת��Ϊ�ֽڣ���10����ת��Ϊ16���ƺ��ٱ�Ϊ�ֽڣ�
	 * 
	 * @param c
	 * @return
	 */
	public static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/**
	 * ʮ������ת��Ϊ�ֽ�
	 * 
	 * @param hexString
	 * @return
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	/**
	 * �ϲ�����
	 * 
	 * @param srcArrays
	 * @return
	 */
	public static byte[] sysCopy(List<byte[]> srcArrays) {
		int len = 0;
		for (byte[] srcArray : srcArrays) {
			len += srcArray.length;
		}
		byte[] destArray = new byte[len];
		int destLen = 0;
		for (byte[] srcArray : srcArrays) {
			System.arraycopy(srcArray, 0, destArray, destLen, srcArray.length);
			destLen += srcArray.length;
		}
		return destArray;
	}

	/**
	 * ��һ��int����תΪ��С��˳�����е��ֽ�����
	 * 
	 * @param data
	 *            int����
	 * @return ��С��˳�����е��ֽ�����
	 */
	public static byte[] changeByte(int data) {
		byte b4 = (byte) ((data) >> 24);
		byte b3 = (byte) (((data) << 8) >> 24);
		byte b2 = (byte) (((data) << 16) >> 24);
		byte b1 = (byte) (((data) << 24) >> 24);
		byte[] bytes = { b1, b2, b3, b4 };
		return bytes;
	}

	/**
	 * ʮ����ת��Ϊʮ������
	 * 
	 */
	public static String dtoh(int a) {
		String bb = "";
		while ((a / 16) != 0) {
			int b = a % 16;
			String s = "" + b;
			if (b == 10) {
				s = "A";
			}
			if (b == 11) {
				s = "B";
			}
			if (b == 12) {
				s = "C";
			}
			if (b == 13) {
				s = "D";
			}
			if (b == 14) {
				s = "E";
			}
			if (b == 15) {
				s = "F";
			}
			a = a / 16;
			bb += s;
		}
		int k = a % 16;
		if (k >= 10) {
			if (k == 10) {
				bb += "A";
			}
			if (k == 11) {
				bb += "B";
			}
			if (k == 12) {
				bb += "C";
			}
			if (k == 13) {
				bb += "D";
			}
			if (k == 14) {
				bb += "E";
			}
			if (k == 15) {
				bb += "F";
			}
		} else {
			bb += k;
		}
		String result = new StringBuffer(bb).reverse().toString();
		int length = result.length();
		for (int j = 0; j < 4 - length; j++) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * 16����ת10����(8λ)
	 */
	public static String htod(String a) {
		StringBuffer icid = new StringBuffer(a);
		String fanzhuan = icid.reverse().toString().toUpperCase();
		int zhengshuka = 0;
		for (int i = 0; i < fanzhuan.length(); i++) {
			int num = "0123456789ABCDEF".indexOf(fanzhuan.charAt(i));
			zhengshuka += (num * Math.pow(16, i));
		}
		String zhengshu = "" + zhengshuka;
		for (int j = 0; j < 8 - (zhengshuka + "").length(); j++) {
			zhengshu = ("0" + zhengshu);
		}
		return zhengshu;
	}
}