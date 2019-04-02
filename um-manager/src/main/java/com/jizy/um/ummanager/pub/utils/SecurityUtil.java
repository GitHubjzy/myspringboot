package com.jizy.um.ummanager.pub.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;


/**
 * RSA加密工具类
 * 
 * @author jizy
 *
 */
public class SecurityUtil {
	private static final String ALGORITHM_RSA = "RSA";

	/** RSA-charset */
	private static final String RSA_CHARSET = "UTF-8";

	/**
	 * 
	 * 描述：将字符串通过RSA算法公钥加密
	 * 
	 * @author mao2080@sina.com
	 * @created 2017年4月9日 上午09:18:51
	 * @since
	 * @param content 需要加密的内容
	 * @param pubKey  公钥
	 * @return 加密后字符串
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static String EncryptByRSAPubKey(String content, String pubKey) throws Exception {
		try {
			PublicKey publicKey = SecurityUtil.getRSAPubKey(pubKey);
			Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			cipher.update(content.getBytes(SecurityUtil.RSA_CHARSET));
			return SecurityUtil.encodeBase64(cipher.doFinal());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * 
	 * 描述：将字符串通过RSA算法公钥解密
	 * 
	 * @author mao2080@sina.com
	 * @created 2017年4月9日 上午09:18:51
	 * @since
	 * @param content 需要解密的内容
	 * @param pubKey  公钥
	 * @return 解密后字符串
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static String DecryptByRSAPubKey(String content, String pubKey) throws Exception {
		try {
			PublicKey publicKey = SecurityUtil.getRSAPubKey(pubKey);
			Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			cipher.update(SecurityUtil.decodeBase64(content));
			return new String(cipher.doFinal(), RSA_CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * 
	 * 描述：将字符串通过RSA算法私钥加密
	 * 
	 * @author mao2080@sina.com
	 * @created 2017年4月9日 上午09:18:51
	 * @since
	 * @param content 需要加密的内容
	 * @param priKey  私钥
	 * @return 加密后字符串
	 * @throws Exception
	 */
	public static String EncryptByRSAPriKey(String content, String priKey) throws Exception {
		try {
			PrivateKey privateKey = SecurityUtil.getRSAPriKey(priKey);
			Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			cipher.update(content.getBytes(SecurityUtil.RSA_CHARSET));
			return SecurityUtil.encodeBase64(cipher.doFinal());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * 
	 * 描述：将字符串通过RSA算法私钥解密
	 * 
	 * @author mao2080@sina.com
	 * @created 2017年4月9日 上午09:18:51
	 * @since
	 * @param content 需要解密的内容
	 * @param priKey  私钥
	 * @return 解密后字符串
	 * @throws Exception
	 */
	public static String DecryptByRSAPriKey(String content, String priKey) throws Exception {
		try {
			PrivateKey privateKey = SecurityUtil.getRSAPriKey(priKey);
			Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			cipher.update(SecurityUtil.decodeBase64(content));
			return new String(cipher.doFinal(), SecurityUtil.RSA_CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * 
	 * 描述：获取RSA公钥
	 * 
	 * @author mao2080@sina.com
	 * @created 2017年4月9日 上午09:18:51
	 * @since
	 * @param pubKey 私钥
	 * @return PublicKey
	 * @throws Exception
	 */
	private static PublicKey getRSAPubKey(String pubKey) throws Exception {
		try {
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(SecurityUtil.decodeBase64(pubKey));
			KeyFactory keyFactory = KeyFactory.getInstance(SecurityUtil.ALGORITHM_RSA);
			return keyFactory.generatePublic(publicKeySpec);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * 
	 * 描述：获取RSA私钥
	 * 
	 * @author mao2080@sina.com
	 * @created 2017年4月9日 上午09:18:51
	 * @since
	 * @param priKey 私钥
	 * @return PrivateKey
	 * @throws Exception
	 */
	private static PrivateKey getRSAPriKey(String priKey) throws Exception {
		try {
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(SecurityUtil.decodeBase64(priKey));
			KeyFactory keyFactory = KeyFactory.getInstance(SecurityUtil.ALGORITHM_RSA);
			return keyFactory.generatePrivate(privateKeySpec);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	/**
	 * base64编码
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String encodeBase64(byte[] source) throws Exception {
		return new String(Base64.encodeBase64(source), "UTF-8");
	}

	/**
	 * Base64解码
	 * 
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public static byte[] decodeBase64(String target) throws Exception {
		return Base64.decodeBase64(target.getBytes("UTF-8"));
	}
}
