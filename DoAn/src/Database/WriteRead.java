///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Database;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//
///**
// *
// * @author LeThanhLoi
// */
//public class WriteRead {
//
//	public static Vector<String> read(String fileName) {
//		Workbook workbook;
//		Vector<String> result = new Vector<String>(100);
//		try {
//			workbook = Workbook.getWorkbook(new File(fileName));
//			Sheet sheet = workbook.getSheet(0);
//
//			int rows = sheet.getRows();
//			int cols = sheet.getColumns();
//
//			for (int row = 0; row < rows; row++) {
//				String s = new String();
//				int dem = 0;
//				for (int col = 0; col < cols; col++) {
//					Cell cell = sheet.getCell(col, row);
//					s += cell.getContents();
//					if (dem == cols - 1) {
//						break;
//					} else {
//						s += "\t";
//						dem++;
//					}
//				}
//				result.add(new String(s));
//			}
//			workbook.close();
//		} catch (IOException ex) {
//			Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (BiffException ex) {
//			Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return result;
//
//	}
//
//	public static void write(Vector<String> vector, String table, String fileName) {
//		WritableWorkbook workbook;
//
//		String[][] str = new String[vector.size()][];
//		for (int i = 0; i < vector.size(); i++) {
//			str[i] = vector.get(i).split("\t");
//		}
//
//		try {
//
//			workbook = Workbook.createWorkbook(new File(fileName));
//			WritableSheet sheet1 = workbook.createSheet("Sheet1", 0);
//			sheet1.addCell(new Label(0, 0, "Th??ng tin b???ng  " + table.toUpperCase()));
//
//			int row = 3;
//			int col = 0;
//
//			String[] lableP = {"M?? Ph??ng", "Lo???i ph??ng", "M???c gi??", "Tr???ng th??i"};
//			String[] lableNV = {"M?? Nh??n vi??n", "T??n nh??n vi??n", "Ng??y sinh", "Gi???i t??nh", "S??? CMND", "?????a ch???", "S??T", "Ch???c v???"};
//			String[] lableKH = {"M?? kh??ch h??ng", "T??n Kh??ch h??ng", "S??? CMTND", "Gi???i t??nh", "?????a ch???", "Qu???c t???ch", "S??T"};
//			String[] lableHD = {"M?? H??a ????n", "M?? ?????t ph??ng", "Th???i gian thanh to??n", "Ti???n ph??ng", "Ti???n d???ch v???"};
//			String[] lableDV = {"M?? d???ch v???", "T??n d???ch v???", "????n gi??", "M?? NV ph??? tr??ch"};
//			String[] lableDP = {"M?? ?????t ph??ng", "M?? kh??ch h??ng", "Th???i gian nh???n", "Th???i gian tr???", "S??? ph??ng ?????t", "Ti???n ?????t c???c", "M?? nh??n vi??n"};
//			String[] lableCTDV = {"M?? ph??ng", "M?? dich v???", "S??? l?????ng", "Th??nh ti???n"};
//			String[] lableCTDP = {"M?? ?????t ph??ng", "M?? ph??ng"};
//
//			if (table.equals("phong")) {
//				for (int i = 0; i < lableP.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableP[i]));
//				}
//			} else if (table.equals("nhanvien")) {
//				for (int i = 0; i < lableNV.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableNV[i]));
//				}
//			}
//			if (table.equals("khachhang")) {
//				for (int i = 0; i < lableKH.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableKH[i]));
//				}
//			}
//			if (table.equals("hoadon")) {
//				for (int i = 0; i < lableHD.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableHD[i]));
//				}
//			}
//			if (table.equals("dichvu")) {
//				for (int i = 0; i < lableDV.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableDV[i]));
//				}
//			}
//			if (table.equals("datphong")) {
//				for (int i = 0; i < lableDP.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableDP[i]));
//				}
//			}
//			if (table.equals("chitietdichvu")) {
//				for (int i = 0; i < lableCTDV.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableCTDV[i]));
//				}
//			}
//			if (table.equals("chitietdatphong")) {
//				for (int i = 0; i < lableCTDP.length; i++) {
//					sheet1.addCell(new Label(i, row - 1, lableCTDP[i]));
//				}
//			}
//
//			for (int r = row, i = 0; r < str.length + row; r++, i++) {
//				for (int c = col, j = 0; c < str[i].length + col; c++, j++) {
//					String obj = str[i][j];
//					sheet1.addCell(new Label(c, r, str[i][j]));
//				}
//			}
//			workbook.write();
//			workbook.close();
//
//		} catch (IOException ex) {
//			Logger.getLogger("ERROR create file" + ex);
//		} catch (WriteException ex) {
//			Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
//
//	public static void main(String[] args) {
//		WriteRead wr = new WriteRead();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Nhap ten table : ");
//		String table = scan.nextLine();
//		//wr.write(table);
//		//wr.read();
//	}
//}
