/**
 * This class file was automatically generated by jASN1 v1.10.0 (http://www.openmuc.org)
 */

package ru.cwt.asn1.ericsson.sgw_r9;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class IPTextRepresentedAddress implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	private BerIA5String iPTextV4Address = null;
	private BerIA5String iPTextV6Address = null;
	
	public IPTextRepresentedAddress() {
	}

	public IPTextRepresentedAddress(byte[] code) {
		this.code = code;
	}

	public void setIPTextV4Address(BerIA5String iPTextV4Address) {
		this.iPTextV4Address = iPTextV4Address;
	}

	public BerIA5String getIPTextV4Address() {
		return iPTextV4Address;
	}

	public void setIPTextV6Address(BerIA5String iPTextV6Address) {
		this.iPTextV6Address = iPTextV6Address;
	}

	public BerIA5String getIPTextV6Address() {
		return iPTextV6Address;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		if (iPTextV6Address != null) {
			sublength = iPTextV6Address.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
			return codeLength;
		}
		
		if (iPTextV4Address != null) {
			sublength = iPTextV4Address.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			reverseOS.write(0xA2);
			codeLength += 1;
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
			codeLength += BerLength.skip(is);
			iPTextV4Address = new BerIA5String();
			codeLength += iPTextV4Address.decode(is, true);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			codeLength += BerLength.skip(is);
			iPTextV6Address = new BerIA5String();
			codeLength += iPTextV6Address.decode(is, true);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (iPTextV4Address != null) {
			sb.append("iPTextV4Address: ").append(iPTextV4Address);
			return;
		}

		if (iPTextV6Address != null) {
			sb.append("iPTextV6Address: ").append(iPTextV6Address);
			return;
		}

		sb.append("<none>");
	}

}
