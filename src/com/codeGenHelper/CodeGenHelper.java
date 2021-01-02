package com.codeGenHelper;

import java.io.File;
import java.io.IOException;

import com.base.FileUtils;
import com.codeGen.base.BSCodeGener;
import com.codeGen.base.TempCodeGener;

public class CodeGenHelper {
	
	
	private File inputDir;
	private File tempDir;
	private File outputDir;
	
	public static CodeGenHelper newInstance(File inputDir, File tempDir, File outputDir){
		CodeGenHelper target = new CodeGenHelper();
		target.inputDir = inputDir;
		target.tempDir = tempDir;
		target.outputDir = outputDir;
		return target;
	}
	
	private String bs_pojoClass = "CourseLesson";
	private String bs_pojo = "courseLesson";
	
	public CodeGenHelper withBsClass(String bsClassPojo,String bsPojo){
		
		this.bs_pojoClass = bsClassPojo;
		this.bs_pojo = bsPojo;
		
		return this;
	}
	
	private String temp_pojoClass = "";
	private String temp_pojo = "";
	
	public CodeGenHelper withTempClass(String tempPojoClass,String tempPojo){
		
		this.temp_pojoClass = tempPojoClass;
		this.temp_pojo = tempPojo;
		
		return this;
	}
	
	private void doGenTemp() throws IOException {
		String input = inputDir.getAbsolutePath();
		String output = tempDir.getAbsolutePath();
		TempCodeGener.newInstance(input, output, temp_pojo, temp_pojoClass).doGen();
		
	}
	

	public void doGenBS() throws IOException {
		this.doGenTemp();
		String input = tempDir.getAbsolutePath();
		String output = outputDir.getAbsolutePath();
		BSCodeGener.newInstance(input, output, bs_pojo, bs_pojoClass).doGen();
		
		FileUtils.openFolder(output);
		
	}

	



	
	
}
