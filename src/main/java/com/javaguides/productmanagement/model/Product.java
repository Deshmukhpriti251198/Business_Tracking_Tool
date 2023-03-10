package com.javaguides.productmanagement.model;

import javax.servlet.http.Part;

import com.mysql.cj.jdbc.Blob;

public class Product {

		protected int ID;
		protected String PRODUCT_CODE;
	    protected String PRODUCT_NAME;
		protected String GRADE;
		protected String UNIT_OF_MEASUREMENT;
		protected int HS_CODE;
		protected String MANUFACTURER;
		protected String COUNTRY;
		protected byte[] TDS;
		protected byte[] MSDS;
		protected byte[] FREE_TRADE_AGREEMENT;
		protected byte[] IMAGE;
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getPRODUCT_CODE() {
			return PRODUCT_CODE;
		}
		public void setPRODUCT_CODE(String pRODUCT_CODE) {
			PRODUCT_CODE = pRODUCT_CODE;
		}
		public String getPRODUCT_NAME() {
			return PRODUCT_NAME;
		}
		public void setPRODUCT_NAME(String pRODUCT_NAME) {
			PRODUCT_NAME = pRODUCT_NAME;
		}
		public String getGRADE() {
			return GRADE;
		}
		public void setGRADE(String gRADE) {
			GRADE = gRADE;
		}
		public String getUNIT_OF_MEASUREMENT() {
			return UNIT_OF_MEASUREMENT;
		}
		public void setUNIT_OF_MEASUREMENT(String uNIT_OF_MEASUREMENT) {
			UNIT_OF_MEASUREMENT = uNIT_OF_MEASUREMENT;
		}
		public int getHS_CODE() {
			return HS_CODE;
		}
		public void setHS_CODE(int hS_CODE) {
			HS_CODE = hS_CODE;
		}
		public String getMANUFACTURER() {
			return MANUFACTURER;
		}
		public void setMANUFACTURER(String mANUFACTURER) {
			MANUFACTURER = mANUFACTURER;
		}
		public String getCOUNTRY() {
			return COUNTRY;
		}
		public void setCOUNTRY(String cOUNTRY) {
			COUNTRY = cOUNTRY;
		}
		public byte[] getTDS() {
			return TDS;
		}
		public void setTDS(byte[] tDS) {
			TDS = tDS;
		}
		public byte[] getMSDS() {
			return MSDS;
		}
		public void setMSDS(byte[] mSDS) {
			MSDS = mSDS;
		}
		public byte[] getFREE_TRADE_AGREEMENT() {
			return FREE_TRADE_AGREEMENT;
		}
		public void setFREE_TRADE_AGREEMENT(byte[] fREE_TRADE_AGREEMENT) {
			FREE_TRADE_AGREEMENT = fREE_TRADE_AGREEMENT;
		}
		public byte[] getIMAGE() {
			return IMAGE;
		}
		public void setIMAGE(byte[] iMAGE) {
			IMAGE = iMAGE;
		}
		public Product(int iD, String pRODUCT_CODE, String pRODUCT_NAME, String gRADE, String uNIT_OF_MEASUREMENT,
				int hS_CODE, String mANUFACTURER, String cOUNTRY, byte[] tDS2, byte[] mSDS2, byte[] fREE_TRADE_AGREEMENT2,
				byte[] iMAGE2) {
			super();
			ID = iD;
			PRODUCT_CODE = pRODUCT_CODE;
			PRODUCT_NAME = pRODUCT_NAME;
			GRADE = gRADE;
			UNIT_OF_MEASUREMENT = uNIT_OF_MEASUREMENT;
			HS_CODE = hS_CODE;
			MANUFACTURER = mANUFACTURER;
			COUNTRY = cOUNTRY;
			TDS = tDS2;
			MSDS = mSDS2;
			FREE_TRADE_AGREEMENT = fREE_TRADE_AGREEMENT2;
			IMAGE = iMAGE2;
		}
		public Product() {
			super();
		}
		public Product(int iD2, String pRODUCT_CODE2, String pRODUCT_NAME2, String gRADE2, String uNIT_OF_MEASUREMENT2,
				int hS_CODE2, String mANUFACTURER2, String cOUNTRY2, java.sql.Blob tDS2, java.sql.Blob mSDS2,
				java.sql.Blob fREE_TRADE_AGREEMENT2, java.sql.Blob iMAGE2) {
			// TODO Auto-generated constructor stub
		}
		public Product(int iD2, String pRODUCT_CODE2, String pRODUCT_NAME2, String gRADE2, String uNIT_OF_MEASUREMENT2,
				int hS_CODE2, String mANUFACTURER2, String cOUNTRY2, Part tDS2, java.sql.Blob mSDS2,
				java.sql.Blob fREE_TRADE_AGREEMENT2, java.sql.Blob iMAGE2) {
			// TODO Auto-generated constructor stub
		}
		public Product(int iD2, String pRODUCT_CODE2, String pRODUCT_NAME2, String gRADE2, String uNIT_OF_MEASUREMENT2,
				int hS_CODE2, String mANUFACTURER2, String cOUNTRY2, Part tDS2, Part mSDS2, Part fREE_TRADE_AGREEMENT2,
				Part iMAGE2) {
			// TODO Auto-generated constructor stub
		}
		public Product(String pRODUCT_NAME2, String gRADE2, String uNIT_OF_MEASUREMENT2, int hS_CODE2,
				String mANUFACTURER2, String cOUNTRY2, Part tDS2, Part mSDS2, Part fREE_TRADE_AGREEMENT2, Part iMAGE2) {
			// TODO Auto-generated constructor stub
		}
		
		}
		