package com.yedam.app.mybatis.common;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.mybatis.mapper.EmpMapper;
import com.yedam.app.mybatis.mapper.EmpMapperImpl;
import com.yedam.app.mybatis.service.EmpVO;

public class MybatisExample {
	private static EmpMapper empMap = new EmpMapperImpl();

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
		List<EmpVO> list = empMap.selectAll();
		for (EmpVO emp : list) {
			System.out.println(emp);
		}
	}

	public static void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(214);

		EmpVO findVO = empMap.selectInfo(emp);
		System.out.println(findVO);

	}

	public static void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@google.com");
		empVO.setJobId("IT_PROG");

		int result = empMap.insertInfo(empVO);
		System.out.println(result);
	}

	public static void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setFirstName("Kil-dong");
		empVO.setSalary(1000);
		empVO.setEmployeeId(214);

		int result = empMap.updateInfo(empVO);
		System.out.println(result);
	}

	public static void deleteInfo() {
		int result = empMap.deleteInfo(214);
		System.out.println(result);
	}
}
