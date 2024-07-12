package com.callor.iolist.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.iolist.models.IolistVo;
import com.callor.iolist.service.IolistService;
import com.callor.iolist.utils.Contract;
import com.callor.iolist.utils.Line;

public class IolistServiceImplV1 implements IolistService {
	
	protected final String iolistDataFile;
	protected final List<IolistVo> iolistList;
	protected final Scanner fileReader;
	protected String[] iolistTitle;

	public IolistServiceImplV1(String iolistDataFile) throws FileNotFoundException {
		super();
		this.iolistDataFile = iolistDataFile;
		this.iolistList = new ArrayList<>();
		InputStream in = new FileInputStream(this.iolistDataFile);
		this.fileReader = new Scanner(in);
	}

	@Override
	public void loadIolistData() {
		iolistTitle = fileReader.nextLine().split(",");
		while(fileReader.hasNext()) {
			String line = fileReader.nextLine();
			String[] lines = line.split(",");
			IolistVo vo = new IolistVo();
			vo.io_date = lines[Contract.IOLIST.거래일자];
			
			iolistList.add(vo);
		}
		
	}

	@Override
	public void printIolistList() {
		int[] subjectTotal = new int[iolistTitle.length];
		
		System.out.println(Line.dLine(70));
		for(String title : iolistTitle) {
			System.out.println(title + "\t");
		}
		System.out.println(Line.sLine(70));
		for(IolistVo vo : iolistList) {
			System.out.printf("%10s\n",vo.io_date);
		}
		
	}

}
