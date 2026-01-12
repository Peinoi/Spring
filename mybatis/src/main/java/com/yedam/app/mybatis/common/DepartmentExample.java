package com.yedam.app.mybatis.common;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.mybatis.mapper.DpmMapper;
import com.yedam.app.mybatis.mapper.DpmMapperlmpl;
import com.yedam.app.mybatis.service.DpmVO;
import com.yedam.app.mybatis.service.EmpVO;

public class DepartmentExample {
	private static DpmMapper dpmMap = new DpmMapperlmpl();

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("---------------------------");
			System.out.println("1.전체조회 2.단건 3.등록 4.수정 5.삭제 6.종료");
			System.out.print("입력> ");
			int type = Integer.parseInt(sc.nextLine());
			if (type == 1) {
				selectAll();
			} else if (type == 2) {
				selectInfo();
			} else if (type == 3) {
				insertInfo();
			} else if (type == 4) {
				updateInfo();
			} else if (type == 5) {
				deleteInfo();
			} else {
				run = false;
				System.out.println("종료");
			}

		}
		sc.close();
	}
	
	public static void selectAll() {
		List<DpmVO> list = dpmMap.dselectAll();
		for(DpmVO dpm : list) {
			System.out.println(dpm);
		}
	}
	
	public static void selectInfo() {
		DpmVO dmp = new DpmVO();
		dmp.setDepartmentId(470);
		DpmVO findVO = dpmMap.dselectInfo(dmp);
		System.out.println(findVO);
		
	}
	public static void insertInfo() {
		DpmVO dmp = new DpmVO();
		dmp.setDepartmentName("Hong");
		dmp.setManagerId(200);
		dmp.setLocationId(1700);

		int result = dpmMap.dinsertInfo(dmp);
		System.out.println(result);
	}

	public static void updateInfo() {
		DpmVO dmp = new DpmVO();
		dmp.setDepartmentName("Kil-dong");
		dmp.setDepartmentId(470);
		int result = dpmMap.dupdateInfo(dmp);
		System.out.println(result);
	}

	public static void deleteInfo() {
		int result = dpmMap.ddeleteInfo(470);
		System.out.println(result);
	}
}
