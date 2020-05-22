package com.test.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

import net.coobird.thumbnailator.Thumbnails;

public class UploadFileUtils {
	
	static final int THUMB_WIDTH = 300;
	static final int THUMB_HEIGHT = 300;
	
	public static String fileUpload(String uploadPath, 
			String fileName, 
			byte[] fileData, String ymdPath) throws Exception {
		
		UUID uid = UUID.randomUUID();
		//랜덤 문자생성(객체로써) 출력할때 toString 해줘야함
		
		String newFileName = uid + "_" + fileName; 
		//랜덤 변수 + 파일이름(고유값됨)
		String imgPath = uploadPath + ymdPath; 
		
		File target = new File(imgPath , newFileName);
		//새로운 파일 생성
		FileCopyUtils.copy(fileData,target);
		//스프링프레임워크 유틸 패키지 에 속한 클래스.copy메소드(byte타입배열을,File에 복사)
		
		String thumbFileName = "s_" + newFileName;
		File image = new File(imgPath + File.separator + newFileName);
		//File.separator : 경로를 구분하는 \,/
		
		File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbFileName);
		
		if(image.exists()) {
			thumbnail.getParentFile().mkdirs();
			//부모 폴더를 File의 형태로 리턴한다.,존재하지 않는 부모 폴더까지 포함하여 해당 경로에 폴더를 만든다.
			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail);
			//thumbnailator 사용법
		}
		return newFileName;
	}
	
	public static String calcPath(String uploadPath) {		
		Calendar cal = Calendar.getInstance();
		//cal은 new 연산자로 생성 X
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) +1);
		//10 이하의 값을 0X 로 변환 , calendar의 month 는 0 이 1월
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		makeDir(uploadPath, yearPath, monthPath, datePath + "\\s");
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String ... paths) {
	
		if (new File(paths[paths.length -1]).exists()) {return;}
		// 날짜에 대한 중복 찾기(?)
		
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
		
	}
}
