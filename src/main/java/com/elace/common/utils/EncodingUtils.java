package com.elace.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 编码/解码工具类. 主要作用在于消除{@link java.net.URLDecoder} 和 {@link java.net.URLEncoder}
 * 相应方法中的受检异常. 以及des加密解密
 * 
 * @author shixiaolei
 * 
 */
public class EncodingUtils {
	private static final String KEY = "6678912345678906";
	/**
	 * 定义 加密算法,可用 DES,DESede,Blowfish
	 */
	private static String Algorithm = "DES";
	private static final String DEFAULT_ENCODING = "UTF8";
	private static final Logger logger = LoggerFactory.getLogger(EncodingUtils.class);
	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}

	/**
	 * 按默认编码解码.
	 * 
	 * @param src
	 * @return
	 */
	public static String decode(String src) {
		return decode(src, DEFAULT_ENCODING);
	}

	/**
	 * 按encoding解码.
	 * 
	 * @param src
	 * @param encoding
	 * @return
	 */
	public static String decode(String src, String encoding) {
		try {
			return URLDecoder.decode(src, encoding);
		} catch (UnsupportedEncodingException e) {
			logger.warn("no such encoding {}", encoding);
			return "";
		}
	}

	/**
	 * 按默认编码编码.
	 * 
	 * @param src
	 * @return
	 */
	public static String encode(String src) {
		return encode(src, DEFAULT_ENCODING);
	}

	/**
	 * 按encoding编码.
	 * 
	 * @param src
	 * @return
	 */
	public static String encode(String src, String encoding) {
		try {
			return URLEncoder.encode(src, encoding);
		} catch (UnsupportedEncodingException e) {
			logger.warn("no such encoding {}", encoding);
			return "";
		}
	}

	// 获得密钥
	public  static SecretKey getKey(String key) throws Exception {
		char[] ss = key.toCharArray();
		String sss = "";
		for (int i = 0; i < ss.length; i = i + 2) {
			sss = sss + ss[i];
		}
		SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
		DESKeySpec ks = new DESKeySpec(sss.substring(0, 8).getBytes());
		SecretKey kd = kf.generateSecret(ks);
		return kd;
	}

	// 返回加密后的字符串
	// input是要加密的字符串
	public static String getEncryptedString(String input) {
		String base64 = "";
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, getKey(KEY));
			byte[] inputBytes = input.getBytes(DEFAULT_ENCODING);
			byte[] outputBytes = cipher.doFinal(inputBytes);
			BASE64Encoder encoder = new BASE64Encoder();
			base64 = encode(encoder.encode(outputBytes));
		} catch (Exception e) {
			base64 = e.getMessage();
		}
		return base64;
	}

	// --------------------------------------------------------------------------------------------------
	// 返回解密后的字符串
	// input是要解密的字符串
	public static String getDecryptedString(String input) {
		input=decode(input);
		String result = null;
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, getKey(KEY));
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] raw = decoder.decodeBuffer(input);
			byte[] stringBytes = cipher.doFinal(raw);
			result = new String(stringBytes, DEFAULT_ENCODING);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	public static void main(String args[]) {
       String tmp=getEncryptedString("guoyuanli");
       System.out.println(tmp);
       System.out.println(getDecryptedString(tmp));
       System.out.println(encode("VVVAMDhU6%2B0jNqKjhFUsiH2Hg%3D%3D"));
	}
}
